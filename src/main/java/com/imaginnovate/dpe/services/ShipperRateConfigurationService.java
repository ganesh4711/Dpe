package com.imaginnovate.dpe.services;

import com.imaginnovate.dpe.common.Enums.EquipmentType;
import com.imaginnovate.dpe.common.Enums.RuleType;
import com.imaginnovate.dpe.data.domain.RuleSetValidationDTO;
import com.imaginnovate.dpe.data.misc.APIResponse;
import com.imaginnovate.dpe.data.requests.ShipperRateRequest;
import com.imaginnovate.dpe.data.responses.ShipperRateConfigurationResponse;
import com.imaginnovate.dpe.entities.*;
import com.imaginnovate.dpe.exceptions.InvalidConfigurationException;
import com.imaginnovate.dpe.exceptions.NotFoundException;
import com.imaginnovate.dpe.exceptions.RatingEngineDomainException;
import com.imaginnovate.dpe.repositories.RateEquipmentTypeRepository;
import com.imaginnovate.dpe.repositories.RateOperatorRepository;
import com.imaginnovate.dpe.repositories.RuleAssignmentRepository;
import com.imaginnovate.dpe.repositories.ShipperRateConfigurationRepository;
import com.imaginnovate.dpe.utils.AuthUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.apache.commons.collections4.CollectionUtils;
import org.jboss.resteasy.reactive.RestResponse;


import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class ShipperRateConfigurationService {

    @Inject
    BaseConfigurationService baseConfigurationService;

    @Inject
    RuleAssignmentRepository ruleAssignmentRepository;

    @Inject
    AuthUtils authUtils;
    @Inject
    RateOperatorRepository rateOperatorRepository;

    @Inject
    RateEquipmentTypeRepository rateEquipmentTypeRepository;
    @Inject
    ShipperRateConfigurationRepository shipperRateConfigurationRepository;

    public Response addConfiguration(long ruleSetId, ShipperRateRequest shipperRateRequest) {
        try {
            ApplicationUser applicationUser = authUtils.getLoggedInUser();
            RuleSetValidationDTO ruleSetValidationDTO = baseConfigurationService.validateAndGetRuleAssignmentDataForEditing(ruleSetId, "SellPriceAdjustmentRate", false);
            if (ruleSetValidationDTO.getRuleAssignment() == null) {
                RuleAssignment ruleAssignment = new RuleAssignment(ruleSetValidationDTO.getRule(), ruleSetValidationDTO.getRuleSet());
                 ruleAssignmentRepository.persist(ruleAssignment);
                RuleAssignment newRuleAssignment = ruleAssignmentRepository.findById(ruleAssignment.getId());
                ruleSetValidationDTO.setRuleAssignment(newRuleAssignment);
            }
            if (shipperRateRequest.getEquipmentTypes().isEmpty()) {
                throw new RatingEngineDomainException(" equipment  type should not null");
            }
            Optional<RateOperator> rateOperator = Optional.of(rateOperatorRepository.findById(shipperRateRequest.getRateOperatorId()));
            if (rateOperator.isEmpty()) {
                throw new NotFoundException("rate operator not found exception");
            }
            Set<Integer> incomingEquipmentTypeIds = new HashSet<>(shipperRateRequest.getEquipmentTypes());
            Set<Integer> existingEquipmentTypeIds = new HashSet<>();
            long ruleAssignmentId = ruleSetValidationDTO.getRuleAssignment().getId();
            List<ShipperRateConfiguration> existingShipperRateConfigurations = shipperRateConfigurationRepository.findByRuleAssignmentIdAndRateOperator(ruleAssignmentId, rateOperator.get().getId());

            existingShipperRateConfigurations.forEach(config -> {
                List<RateEquipmentType> rateEquipmentTypes = rateEquipmentTypeRepository.findAllByRateConfigId(config.getId(), ruleSetValidationDTO.getRule().getId());
                List<Integer> equipTypes = rateEquipmentTypes.stream()
                        .map(rateEquipmentType -> rateEquipmentType.getEquipmentType().getValue())
                        .collect(Collectors.toList());
                existingEquipmentTypeIds.addAll(equipTypes);
                config.setEquipments(equipTypes);
            });

            Set<Integer> commonEquipmentTypes =new HashSet<>(CollectionUtils.intersection(incomingEquipmentTypeIds, existingEquipmentTypeIds));
            if (commonEquipmentTypes.size() > 0) {
                throw new InvalidConfigurationException("invalid configuration: equipment types have been already configured");
            }

            ShipperRateConfiguration shipperRateConfiguration = new ShipperRateConfiguration();
            shipperRateConfiguration.setRateOperator(rateOperator.get());
            shipperRateConfiguration.setRuleAssignment(ruleSetValidationDTO.getRuleAssignment());
            shipperRateConfiguration.setAdjustmentValue(shipperRateRequest.getAdjustmentValue());
            shipperRateConfiguration.setCreatedUser(applicationUser);
            shipperRateConfigurationRepository.persist(shipperRateConfiguration);

            List<RateEquipmentType> rateEquipmentTypes = new ArrayList<>();
            for (int equipmentId : shipperRateRequest.getEquipmentTypes()) {
                RateEquipmentType rateEquipmentType = new RateEquipmentType();
                rateEquipmentType.setCreatedUser(applicationUser);
                rateEquipmentType.setRateConfigId(shipperRateConfiguration.getId());
                rateEquipmentType.setEquipmentType(EquipmentType.getByValue(equipmentId));
                rateEquipmentType.setRule(ruleSetValidationDTO.getRule());
                rateEquipmentTypes.add(rateEquipmentType);
            }
            List<Integer> rateEquipments = rateEquipmentTypes.stream()
                    .map(rateEquipmentType -> rateEquipmentType.getEquipmentType().getValue())
                    .collect(Collectors.toList());
            rateEquipmentTypeRepository.persist(rateEquipmentTypes);

            shipperRateConfiguration.setEquipments(rateEquipments);
            var response = new ShipperRateConfigurationResponse(shipperRateConfiguration);
            return Response.status(Response.Status.CREATED).entity(APIResponse.success("Configuration created successfully",response)).build();
        } catch (Exception exception) {
            return APIResponse.error("Configuration failed,please update again");
        }
    }

    public Response updateConfiguration(long ruleSetId, long shipperConfigId, ShipperRateRequest shipperRateRequest) {
        try {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            ApplicationUser applicationUser = authUtils.getLoggedInUser();
            RuleSetValidationDTO ruleSetValidationDTO = baseConfigurationService.validateAndGetRuleAssignmentDataForEditing(ruleSetId, "SellPriceAdjustmentRate", false);
            if (ruleSetValidationDTO.getRuleAssignment() == null) {
                RuleAssignment ruleAssignment = new RuleAssignment(ruleSetValidationDTO.getRule(), ruleSetValidationDTO.getRuleSet());
                ruleAssignmentRepository.persist(ruleAssignment);
                ruleSetValidationDTO.setRuleAssignment(ruleAssignment);
            }

            if (shipperRateRequest.getEquipmentTypes().isEmpty()) {
                throw new RatingEngineDomainException("equipment type should not be null");
            }
            Optional<ShipperRateConfiguration> existingShipperRateConfiguration = Optional.of(shipperRateConfigurationRepository.findById(shipperConfigId));
            if (existingShipperRateConfiguration == null) {
                throw new NotFoundException("shipper rate not found");
            }
            ShipperRateConfiguration shipperRateConfiguration = existingShipperRateConfiguration.get();
            if (shipperRateConfiguration.getRuleAssignment().getRuleSet().getId() != ruleSetId) {
                throw new RatingEngineDomainException("the shipper rate configuration not found for the given rule set");
            }
//            shipperRateConfiguration.getRateOperator().setId(shipperRateRequest.getRateOperatorId());
            List<RateEquipmentType> rateEquipmentTypes =  rateEquipmentTypeRepository.findAllByRateConfigId(shipperRateConfiguration.getId(), ruleSetValidationDTO.getRule().getId());
            Set<Integer> incomingEquipmentTypes = new HashSet<>(shipperRateRequest.getEquipmentTypes());
            Set<Integer> existingEquipmentTypes = new HashSet<>(
                    rateEquipmentTypes.stream().map(
                            rateEquipmentType -> rateEquipmentType.getEquipmentType().getValue()
                    ).collect(Collectors.toList())
            );
            shipperRateConfiguration.setAdjustmentValue(shipperRateRequest.getAdjustmentValue());
            List<Long> equipmentTypeRecordIdsToDelete = new ArrayList<>();
            rateEquipmentTypes.forEach(rateEquipmentType -> {
                int equipType = rateEquipmentType.getEquipmentType().getValue();
                if (!incomingEquipmentTypes.contains(equipType)) {
                    equipmentTypeRecordIdsToDelete.add(rateEquipmentType.getId());
                }
            });
            List<RateEquipmentType> rateEquipmentTypesToInsert = new ArrayList<>();
            shipperRateRequest.getEquipmentTypes().forEach( rateEquipmentType -> {
                if (!existingEquipmentTypes.contains(rateEquipmentType)) {
                    RateEquipmentType equipmentType = new RateEquipmentType();
                    equipmentType.setRateConfigId(shipperRateConfiguration.getId());
                    equipmentType.setRule(ruleSetValidationDTO.getRule());
                    equipmentType.setEquipmentType(EquipmentType.getByValue(rateEquipmentType));
                    rateEquipmentTypesToInsert.add(equipmentType);
                }
            });
            rateEquipmentTypeRepository.persist(rateEquipmentTypesToInsert);
            rateEquipmentTypeRepository.deleteAllById(equipmentTypeRecordIdsToDelete);
            List<Integer> equipments = rateEquipmentTypes.stream()
                    .map(rateEquipmentType -> rateEquipmentType.getEquipmentType().getValue())
                    .collect(Collectors.toList());
            shipperRateConfiguration.setEquipments(equipments);
            Optional<RateOperator> rateOperator = Optional.of(rateOperatorRepository.findById(shipperRateRequest.getRateOperatorId()));
            if (rateOperator.isEmpty()){
                throw  new NotFoundException("operator not found");
            }
            shipperRateConfiguration.setRateOperator(rateOperator.get());
            shipperRateConfigurationRepository.persist(shipperRateConfiguration);
            var response = new ShipperRateConfigurationResponse(shipperRateConfiguration);
            return Response.status(Response.Status.ACCEPTED).entity(APIResponse.success("Configuration updated successfully",response)).build();
        } catch (Exception exception) {
            return APIResponse.error("Configuration failed,please update again");
        }
    }

    public Response deleteConfiguration(long ruleSetId, long shipperRateConfigId) {
        try {
            Optional<ShipperRateConfiguration> existingShipperRateConfiguration = Optional.of(shipperRateConfigurationRepository.findById(shipperRateConfigId));
            if (existingShipperRateConfiguration == null) {
                throw new RatingEngineDomainException("shipper rate  configuration is  not found");
            }
            ShipperRateConfiguration shipperRateConfiguration = existingShipperRateConfiguration.get();
            rateEquipmentTypeRepository.deleteAllByConfigId(shipperRateConfiguration.getId(), RuleType.SellPrice.getValue());
            shipperRateConfigurationRepository.delete(shipperRateConfiguration);
            return APIResponse.success("Configuration deleted successfully", null);
        } catch (Exception e) {
            return APIResponse.error("Configuration failed,please update again");
        }
    }
    @Transactional

    public List<ShipperRateConfiguration> getConfiguration(long ruleSetId) throws NotFoundException {

            RuleSetValidationDTO ruleSetValidationDTO = baseConfigurationService.validateAndGetRuleAssignmentDataForEditing(ruleSetId, "SellPriceAdjustmentRate",  false);
            if (ruleSetValidationDTO.getRuleAssignment() == null) {
                RuleAssignment ruleAssignment = new RuleAssignment(ruleSetValidationDTO.getRule(), ruleSetValidationDTO.getRuleSet());
                 ruleAssignmentRepository.persist(ruleAssignment);
                RuleAssignment newRuleAssignment  =ruleAssignmentRepository.findById(ruleAssignment.getId());
                ruleSetValidationDTO.setRuleAssignment(newRuleAssignment);
            }
            long ruleAssignmentId = ruleSetValidationDTO.getRuleAssignment().getId();
            List<ShipperRateConfiguration> shipperRateConfigurations = shipperRateConfigurationRepository.findAllByRuleAssignmentId(ruleAssignmentId);
            shipperRateConfigurations.forEach(config -> {
                List<RateEquipmentType> rateEquipmentTypes =  rateEquipmentTypeRepository.findAllByRateConfigId(config.getId(),ruleSetValidationDTO.getRule().getId());
                List<Integer> existingEquipmentTypes = rateEquipmentTypes.stream()
                        .map(rateEquipmentType -> rateEquipmentType.getEquipmentType().getValue())
                        .collect(Collectors.toList());
                config.setEquipments(existingEquipmentTypes);
            });
        return shipperRateConfigurations;

    }
}
