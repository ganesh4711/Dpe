package com.imaginnovate.dpe.services;

import com.imaginnovate.dpe.common.Enums;
import com.imaginnovate.dpe.data.domain.RuleSetValidationDTO;
import com.imaginnovate.dpe.data.requests.BaseRequest;
import com.imaginnovate.dpe.data.response.BaseRateConstraintDTO;
import com.imaginnovate.dpe.entities.BaseRateConstraintConfig;
import com.imaginnovate.dpe.entities.RateEquipmentType;
import com.imaginnovate.dpe.entities.RuleAssignment;
import com.imaginnovate.dpe.entities.RuleSet;
import com.imaginnovate.dpe.exceptions.InvalidConfigurationException;
import com.imaginnovate.dpe.exceptions.NotFoundException;
import com.imaginnovate.dpe.repositories.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.apache.commons.collections4.CollectionUtils;


import java.beans.Transient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class BaseRateConstrainService {

    @Inject
    private BaseConfigurationService baseConfigurationService;

    @Inject
    private RuleSetRepository ruleSetRepository;

    @Inject
    private RuleAssignmentRepository ruleAssignmentRepository;

    @Inject
    private GeoCityRepository geoCityRepository;

    @Inject
    private RuleRepository ruleRepository;

    @Inject
    private BaseRateSettingRepository baseRateSettingRepository;

    @Inject
    private BaseRateConstrainRepository baseRateConstrainRepository;

    @Inject
    private RateEquipmentTypeRepository rateEquipmentTypeRepository;


    @Transactional
    public List<BaseRateConstraintDTO> getBaseRateConstrain(Long ruleSetId) throws NotFoundException {
        RuleSet ruleSet = ruleSetRepository.findById(ruleSetId);
        try {
            RuleSetValidationDTO ruleSetValidationDTO = baseConfigurationService.validateAndGetRuleAssignmentDataForEditing(ruleSetId,
                    "BaseRateConstraint", false);
            if (ruleSetValidationDTO.getRuleAssignment() == null) {
                RuleAssignment ruleAssignment = new RuleAssignment(ruleSetValidationDTO.getRule(), ruleSetValidationDTO.getRuleSet());
                 ruleAssignmentRepository.persist(ruleAssignment);
                RuleAssignment newRuleAssignment =ruleAssignmentRepository.findById(ruleAssignment.getId());
                ruleSetValidationDTO.setRuleAssignment(newRuleAssignment);
            }
            List<BaseRateConstraintConfig> primaryBaseRateConfigurations = baseRateConstrainRepository.
                    findAllByRuleAssignment(ruleSetValidationDTO.getRuleAssignment().getId());
            List<BaseRateConstraintDTO> globalBaseRateDTOS = new ArrayList<>();
            primaryBaseRateConfigurations.forEach(baseRateConstraintConfig -> {
                List<RateEquipmentType> equipmentTypes = rateEquipmentTypeRepository.findAllByRateConfigId(baseRateConstraintConfig.getId(),
                        baseRateConstraintConfig.getRuleAssignment().getRule().getId());
                List<Integer> existingEquipmentTypes = equipmentTypes.stream()
                        .map(rateEquipmentType -> rateEquipmentType.getEquipmentType().getValue())
                        .collect(Collectors.toList());
                baseRateConstraintConfig.setEquipments(existingEquipmentTypes);
                globalBaseRateDTOS.add(new BaseRateConstraintDTO(baseRateConstraintConfig));
            });
            return globalBaseRateDTOS;
        } catch (NotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    @Transactional
    public BaseRateConstraintDTO addConfiguration(long ruleSetId, BaseRequest baseRequest) throws NotFoundException {
        try {
            RuleSetValidationDTO ruleSetValidationDTO = baseConfigurationService.validateAndGetRuleAssignmentDataForEditing(ruleSetId,
                    "BaseRateConstraint", false);
            if (ruleSetValidationDTO.getRuleAssignment() == null) {
                RuleAssignment ruleAssignment = new RuleAssignment(ruleSetValidationDTO.getRule(), ruleSetValidationDTO.getRuleSet());
                 ruleAssignmentRepository.persist(ruleAssignment);
                RuleAssignment newRuleAssignment =ruleAssignmentRepository.findById(ruleAssignment.getId());
                ruleSetValidationDTO.setRuleAssignment(newRuleAssignment);
            }
            BaseRateConstraintConfig baseRateConstraintConfig = new BaseRateConstraintConfig();
            if(baseRequest.getId() != null){
                baseRateConstraintConfig= baseRateConstrainRepository.findById(baseRequest.getId());
                List<RateEquipmentType> rateEquipmentTypes =  rateEquipmentTypeRepository.findAllByRateConfigId(baseRateConstraintConfig.getId(), ruleSetValidationDTO.getRule().getId());
                Set<Integer> incomingEquipmentTypes = new HashSet<>(baseRequest.getEquipmentTypes());
                Set<Integer> existingEquipmentTypes = new HashSet<>(
                        rateEquipmentTypes.stream().map(
                                rateEquipmentType -> rateEquipmentType.getEquipmentType().getValue()
                        ).collect(Collectors.toList())
                );
                List<Long> equipmentTypeRecordIdsToDelete = new ArrayList<>();
                rateEquipmentTypes.forEach(rateEquipmentType -> {
                    int equipType = rateEquipmentType.getEquipmentType().getValue();
                    if (!incomingEquipmentTypes.contains(equipType)) {
                        equipmentTypeRecordIdsToDelete.add(rateEquipmentType.getId());
                    }
                });
                List<RateEquipmentType> rateEquipmentTypesToInsert = new ArrayList<>();
                long baseRateConstraintId= baseRateConstraintConfig.getId();
                baseRequest.getEquipmentTypes().forEach( rateEquipmentType -> {
                    if (!existingEquipmentTypes.contains(rateEquipmentType)) {
                        RateEquipmentType equipmentType = new RateEquipmentType();
                        equipmentType.setRateConfigId(baseRateConstraintId);
                        equipmentType.setRule(ruleSetValidationDTO.getRule());
                        equipmentType.setEquipmentType(Enums.EquipmentType.getByValue(rateEquipmentType));
                        rateEquipmentTypesToInsert.add(equipmentType);
                    }
                });
                rateEquipmentTypeRepository.persist(rateEquipmentTypesToInsert);
                rateEquipmentTypeRepository.deleteAllById(equipmentTypeRecordIdsToDelete);
                List<RateEquipmentType> equipmentTypes = rateEquipmentTypeRepository.findAllByRateConfigId(baseRateConstraintConfig.getId(), ruleSetValidationDTO.getRule().getId());
                List<Integer> collected = equipmentTypes.stream()
                        .map(rateEquipmentType -> rateEquipmentType.getEquipmentType().getValue())
                        .collect(Collectors.toList());
                baseRateConstraintConfig.setEquipments(collected);
                baseRateConstraintConfig.setMaxBuy(baseRequest.getMaxPay());
                baseRateConstraintConfig.setTargetPay(baseRequest.getTargetPay());
                baseRateConstrainRepository.persist(baseRateConstraintConfig);
                return new BaseRateConstraintDTO(baseRateConstraintConfig);
            }
            List<BaseRateConstraintConfig> primaryBaseRateConfigurations = baseRateConstrainRepository.findAllByRuleAssignment(ruleSetValidationDTO.getRuleAssignment().getId());
            Set<Integer> incomingEquipmentTypeIds = new HashSet<>(baseRequest.getEquipmentTypes());
            Set<Integer> existingEquipmentTypeIds = new HashSet<>();
            primaryBaseRateConfigurations.forEach(config -> {
                List<RateEquipmentType> rateEquipmentTypes = rateEquipmentTypeRepository.findAllByRateConfigId(config.getId(), ruleSetValidationDTO.getRule().getId());
                List<Integer> equipTypes = rateEquipmentTypes.stream()
                        .map(rateEquipmentType -> rateEquipmentType.getEquipmentType().getValue())
                        .collect(Collectors.toList());
                existingEquipmentTypeIds.addAll(equipTypes);
            });
            Set<Integer> commonEquipmentTypes = new HashSet<>(CollectionUtils.intersection(incomingEquipmentTypeIds, existingEquipmentTypeIds));
            if (!commonEquipmentTypes.isEmpty()) {
                throw new InvalidConfigurationException("invalid configuration: equipment types have been already configured");
            }
            baseRateConstraintConfig.setMaxBuy(baseRequest.getMaxPay());
            baseRateConstraintConfig.setTargetPay(baseRequest.getTargetPay());
            baseRateConstraintConfig.setRuleAssignment(ruleSetValidationDTO.getRuleAssignment());
            baseRateConstrainRepository.persist(baseRateConstraintConfig);
            List<RateEquipmentType> rateEquipmentTypes = new ArrayList<>();
            for (int equipmentId: baseRequest.getEquipmentTypes()) {
                RateEquipmentType rateEquipmentType = new RateEquipmentType();
                rateEquipmentType.setRateConfigId(baseRateConstraintConfig.getId());
                rateEquipmentType.setEquipmentType(Enums.EquipmentType.getByValue(equipmentId));
                rateEquipmentType.setRule(ruleSetValidationDTO.getRule());
                rateEquipmentTypes.add(rateEquipmentType);
            }
            rateEquipmentTypeRepository.persist(rateEquipmentTypes);
            List<Integer> collected = rateEquipmentTypes.stream()
                    .map(rateEquipmentType -> rateEquipmentType.getEquipmentType().getValue())
                    .collect(Collectors.toList());
            baseRateConstraintConfig.setEquipments(collected);
            return new BaseRateConstraintDTO(baseRateConstraintConfig);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Transactional
    public BaseRateConstraintDTO deleteBaseRateConfiguration(Long ruleSetId, Long baseRateConstraintId) throws NotFoundException {
        BaseRateConstraintConfig baseRateConstraintConfig = baseRateConstrainRepository.findById(baseRateConstraintId);
        if (baseRateConstraintConfig == null) {
            throw new NotFoundException("Base rate configuration not found");
        }
        rateEquipmentTypeRepository.deleteAllByBaseRateConfigId(baseRateConstraintConfig.getId(), ruleSetId);
        baseRateSettingRepository.deleteAllByBaseRateConfigId(baseRateConstraintConfig.getId());
        baseRateConstrainRepository.delete(baseRateConstraintConfig);
        return null;
    }
}
