package com.imaginnovate.dpe.services;

import com.imaginnovate.dpe.common.Enums;
import com.imaginnovate.dpe.data.domain.RuleSetValidationDTO;
import com.imaginnovate.dpe.data.requests.GlobalBaseRateCreateDTO;
import com.imaginnovate.dpe.data.response.GlobalBaseRateDTO;
import com.imaginnovate.dpe.entities.PrimaryBaseRateConfiguration;
import com.imaginnovate.dpe.entities.RateEquipmentType;
import com.imaginnovate.dpe.entities.RuleAssignment;
import com.imaginnovate.dpe.exceptions.InvalidConfigurationException;
import com.imaginnovate.dpe.exceptions.NotFoundException;
import com.imaginnovate.dpe.exceptions.RatingEngineDomainException;
import com.imaginnovate.dpe.repositories.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class PrimaryBaseRateAdjustmentService {

    @Inject
    private BaseConfigurationService baseConfigurationService;

    @Inject
    private RuleAssignmentRepository ruleAssignmentRepository;

    @Inject
    private RuleSetRepository ruleSetRepository;

    @Inject
    private RuleRepository ruleRepository;

    @Inject
    private PrimaryBaseRateConfigurationRepository primaryBaseRateConfigurationRepository;

    @Inject
    private RateEquipmentTypeRepository rateEquipmentTypeRepository;
//checked
    @Transactional
    public GlobalBaseRateDTO addConfiguration(long ruleSetId, GlobalBaseRateCreateDTO globalBaseRateCreateDTO) throws NotFoundException, RatingEngineDomainException, InvalidConfigurationException {

        // validate the ruleSetId and the code and rule assignment mapping
            RuleSetValidationDTO ruleSetValidationDTO = baseConfigurationService.validateAndGetRuleAssignmentDataForEditing(ruleSetId, "PrimaryBaseRateAdjustment", false);

            if (ruleSetValidationDTO.getRuleAssignment() == null) {
                RuleAssignment ruleAssignment = new RuleAssignment(ruleSetValidationDTO.getRule(), ruleSetValidationDTO.getRuleSet());
                ruleAssignmentRepository.persist(ruleAssignment);
                RuleAssignment newRuleAssignment = ruleAssignmentRepository.findById(ruleAssignment.getId());
                ruleSetValidationDTO.setRuleAssignment(newRuleAssignment);
            }
            PrimaryBaseRateConfiguration primaryBaseRateConfiguration = new PrimaryBaseRateConfiguration();
            if (globalBaseRateCreateDTO.getId() != null) {
                primaryBaseRateConfiguration = primaryBaseRateConfigurationRepository.findById(globalBaseRateCreateDTO.getId());
                if (primaryBaseRateConfiguration == null) {
                    throw new NotFoundException("Base rate configuration not found");
                }
                if (primaryBaseRateConfiguration.getAdjustmentValue() != globalBaseRateCreateDTO.getAdjustmentValue()) {
                    primaryBaseRateConfiguration.setAdjustmentValue(globalBaseRateCreateDTO.getAdjustmentValue());
                }
                if (primaryBaseRateConfiguration.getRuleAssignment().getRuleSet().getId() != ruleSetId) {

                    throw new RatingEngineDomainException("Base rate configuration doesn't belong to provided rule set id");
                }
                // handle equipment type changes, no values changed user just changed equipment types
                List<RateEquipmentType> rateEquipmentTypes = rateEquipmentTypeRepository.findAllByRateConfigId(globalBaseRateCreateDTO.getId(), ruleSetValidationDTO.getRule().getId());
                // now find out what equipment type records to delete
                Set<Integer> incomingEquipmentTypes = new HashSet<>(globalBaseRateCreateDTO.getEquipmentTypes());
                Set<Integer> existingEquipmentTypes = new HashSet<>(
                        rateEquipmentTypes.stream().map(
                                rateEquipmentType -> rateEquipmentType.getEquipmentType().getValue()
                        ).collect(Collectors.toSet())
                );
                List<Long> equipmentTypeRecordIdsToDelete = new ArrayList<>();
                rateEquipmentTypes.forEach(rateEquipmentType -> {
                    int equipType = rateEquipmentType.getEquipmentType().getValue();
                    if (!incomingEquipmentTypes.contains(equipType)) {
                        equipmentTypeRecordIdsToDelete.add(rateEquipmentType.getId());
                    }
                });
                List<RateEquipmentType> rateEquipmentTypesToInsert = new ArrayList<>();
                globalBaseRateCreateDTO.getEquipmentTypes().forEach(rateEquipmentType -> {
                    if (!existingEquipmentTypes.contains(rateEquipmentType)) {
                        RateEquipmentType equipmentType = new RateEquipmentType();
                        equipmentType.setRateConfigId(globalBaseRateCreateDTO.getId());
                        equipmentType.setRule(ruleSetValidationDTO.getRule());
                        equipmentType.setEquipmentType(Enums.EquipmentType.getByValue(rateEquipmentType));
                        rateEquipmentTypesToInsert.add(equipmentType);
                    }
                });
                rateEquipmentTypeRepository.deleteAllById(equipmentTypeRecordIdsToDelete);
                rateEquipmentTypeRepository.persist(rateEquipmentTypesToInsert);
//                List<Integer> collected = rateEquipmentTypes.stream()
//                        .map(rateEquipmentType -> rateEquipmentType.getEquipmentType().getValue())
//                        .collect(Collectors.toList());
                primaryBaseRateConfiguration.setRateEquipmentTypes(incomingEquipmentTypes.stream().toList());
                return new GlobalBaseRateDTO(primaryBaseRateConfiguration);
            }
            List<PrimaryBaseRateConfiguration> primaryBaseRateConfigurations = primaryBaseRateConfigurationRepository.findAllByRuleAssignment(ruleSetValidationDTO.getRuleAssignment());
            Set<Integer> incomingEquipmentTypeIds = new HashSet<>(globalBaseRateCreateDTO.getEquipmentTypes());
            Set<Integer> existingEquipmentTypeIds = new HashSet<>();
        primaryBaseRateConfigurations.forEach(config -> {
                List<RateEquipmentType> rateEquipmentTypes = rateEquipmentTypeRepository.findAllByRateConfigId(config.getId(), ruleSetValidationDTO.getRule().getId());
                List<Integer> equipTypes = rateEquipmentTypes.stream()
                        .map(rateEquipmentType -> rateEquipmentType.getEquipmentType().getValue())
                        .collect(Collectors.toList());
                existingEquipmentTypeIds.addAll(equipTypes);
            });
            Set<Integer> commonEquipmentTypes = new HashSet<>(CollectionUtils.intersection(incomingEquipmentTypeIds, existingEquipmentTypeIds));
            if (commonEquipmentTypes.size() > 0) {
                throw new InvalidConfigurationException("invalid configuration: equipment types have been already configured");
            }
            primaryBaseRateConfiguration.setRuleAssignment(ruleSetValidationDTO.getRuleAssignment());
            primaryBaseRateConfiguration.setAdjustmentValue(globalBaseRateCreateDTO.getAdjustmentValue());
            primaryBaseRateConfiguration.setRateEquipmentTypes(globalBaseRateCreateDTO.getEquipmentTypes());
            primaryBaseRateConfigurationRepository.persist(primaryBaseRateConfiguration);
            List<RateEquipmentType> rateEquipmentTypes = new ArrayList<>();
            for (int equipmentId : globalBaseRateCreateDTO.getEquipmentTypes()) {
                RateEquipmentType rateEquipmentType = new RateEquipmentType();
                rateEquipmentType.setRateConfigId(primaryBaseRateConfiguration.getId());
                rateEquipmentType.setEquipmentType(Enums.EquipmentType.getByValue(equipmentId));
                rateEquipmentType.setRule(ruleSetValidationDTO.getRule());
                rateEquipmentTypes.add(rateEquipmentType);
            }
            rateEquipmentTypeRepository.persist(rateEquipmentTypes);
            List<Integer> existingEquipmentTypes = rateEquipmentTypes.stream()
                    .map(rateEquipmentType -> rateEquipmentType.getEquipmentType().getValue())
                    .collect(Collectors.toList());
            primaryBaseRateConfiguration.setRateEquipmentTypes(existingEquipmentTypes);
            GlobalBaseRateDTO globalBaseRateDTO = new GlobalBaseRateDTO(primaryBaseRateConfiguration);
            return globalBaseRateDTO;
        }

        @Transactional
        public GlobalBaseRateDTO deletePrimaryBaseRateConfiguration ( long ruleSetId, long primaryRateConfigurationId) throws
        NotFoundException {
            PrimaryBaseRateConfiguration primaryBaseRateConfiguration = primaryBaseRateConfigurationRepository.findById(primaryRateConfigurationId);
            if (primaryBaseRateConfiguration == null) {
                throw new NotFoundException("Base rate configuration not found");
            }
            rateEquipmentTypeRepository.deleteAllByBaseRateConfigId(primaryBaseRateConfiguration.getId(), ruleSetId);
            //TODO the work pending
            // baseRateSettingRepository.deleteAllByBaseRateConfigId(primaryBaseRateConfiguration.getId());

            primaryBaseRateConfigurationRepository.delete(primaryBaseRateConfiguration);

            return null;
        }
        @Transactional
        public List<GlobalBaseRateDTO> getPrimaryBaseRateConfiguration (Long ruleSetId) throws NotFoundException {
            try {
                RuleSetValidationDTO ruleSetValidationDTO = baseConfigurationService.validateAndGetRuleAssignmentDataForEditing(ruleSetId,
                        "PrimaryBaseRateAdjustment", false);
                if (ruleSetValidationDTO.getRuleAssignment() == null) {
                    RuleAssignment ruleAssignment = new RuleAssignment(ruleSetValidationDTO.getRule(), ruleSetValidationDTO.getRuleSet());
                     ruleAssignmentRepository.persist(ruleAssignment);
                    RuleAssignment newRuleAssignment = ruleAssignmentRepository.findById(ruleAssignment.getId());
                    ruleSetValidationDTO.setRuleAssignment(newRuleAssignment);
                }
                List<PrimaryBaseRateConfiguration> primaryBaseRateConfigurations = primaryBaseRateConfigurationRepository.
                        findAllByRuleAssignment(ruleSetValidationDTO.getRuleAssignment());
                List<GlobalBaseRateDTO> globalBaseRateDTOS = new ArrayList<>();
                primaryBaseRateConfigurations.forEach(primaryBaseRateConfiguration -> {
                    List<RateEquipmentType> equipmentTypes = rateEquipmentTypeRepository.findAllByRateConfigId(primaryBaseRateConfiguration.getId(),
                            primaryBaseRateConfiguration.getRuleAssignment().getRule().getId());
                    List<Integer> existingEquipmentTypes = equipmentTypes.stream()
                            .map(rateEquipmentType -> rateEquipmentType.getEquipmentType().getValue())
                            .collect(Collectors.toList());
                    primaryBaseRateConfiguration.setRateEquipmentTypes(existingEquipmentTypes);
                    globalBaseRateDTOS.add(new GlobalBaseRateDTO(primaryBaseRateConfiguration));
                });
                return globalBaseRateDTOS;
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }


    }
