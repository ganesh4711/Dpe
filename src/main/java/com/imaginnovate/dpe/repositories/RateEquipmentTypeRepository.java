package com.imaginnovate.dpe.repositories;

import com.imaginnovate.dpe.entities.RateEquipmentType;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class RateEquipmentTypeRepository implements PanacheRepositoryBase<RateEquipmentType, Long> {

    // TODO: mark their valid_to_date instead
    @Transactional
    public void deleteAllByBaseRateConfigId(long baseRateConfigId, long ruleId) {
        delete("rateConfigId = ?1 and rule.id = ?2", baseRateConfigId, ruleId);
    }

    public List<RateEquipmentType> findAllByRateConfigId(long rateConfigId, long ruleId) {

        Query query = getEntityManager().createNativeQuery("SELECT * from rate_equipment_type  where rate_config_id = :rateConfigId and rule_id = :ruleId", RateEquipmentType.class)
                .setParameter("rateConfigId", rateConfigId)
                .setParameter("ruleId", ruleId);

        return query.getResultList();
    }

   public List<RateEquipmentType> findByCalendarAndRuleId(long rateConfigId, long ruleId) {
        Query query = getEntityManager().createNativeQuery(" select * from rate_equipment_type where rate_config_id = ?1 and rule_id = ?2 ");
        return query.getResultList();
    }

    @Transactional
   public void deleteAllByConfigId(Long configurationId, long ruleId) {
        Query query = getEntityManager().createNativeQuery("delete from rate_equipment_type  where rate_config_id = :rateConfigId and rule_id = :ruleId")
                .setParameter("rateConfigId", configurationId)
                .setParameter("ruleId", ruleId);
        query.executeUpdate();
    }

    @Transactional
   public void deleteAllByCalenderIdAndRateConfigId(long calenderAdjId, long ruleId) {
        Query query = getEntityManager().createNativeQuery(" delete from rate_equipment_type where rate_config_id = ?1 and rule_id = ?2 ");
        query.executeUpdate();
    }

   public List<RateEquipmentType> findByRateConfigIdAndRuleId(Long id, Long id1) {
        return list("rateConfigId = ?1 and rule_id = ?2", id, id1);
    }


   public List<RateEquipmentType> findAllByRateConfigIdAndRateApplicable(long ruleId, long configId, int rateId) {
        Query query = getEntityManager().createNativeQuery("SELECT  ret.* FROM  rate_equipment_type ret " +
                        "LEFT JOIN base_rate_configuration brc on brc.id=ret.rate_config_id " +
                        "WHERE ret.rule_id = :ruleId and ret.rate_config_id= :configId " +
                        "and brc.applicable_for_rate_type = :rateId")
                .setParameter("ruleId", ruleId)
                .setParameter("configId", configId)
                .setParameter("rateId", rateId);
        return query.getResultList();
    }

   public Long findConfigIdByRuleIdAndEquipmentTypeAndAccessorialAdjustmentConfigIds(Long ruleId, Integer equipmentType, List<Long> configIds) {
        String sql = "SELECT rate_config_id FROM rate_equipment_type WHERE rule_id = :ruleId AND equipment_type = :equipmentType AND rate_config_id IN :configIds";
        Query query = getEntityManager().createNativeQuery(sql)
                .setParameter("ruleId", ruleId)
                .setParameter("equipmentType", equipmentType)
                .setParameter("configIds", configIds);
        return (Long) query.getSingleResult();
    }


   public List<RateEquipmentType> findByCcByRuleIdAndEquipmentTypeAndAssignmentId(Long ruleId, int equipmentType, long ruleAssignmentId) {

        String sql = "Select ra.*" +
                "FROM rate_equipment_type ra" +
                "LEFT JOIN calendar_adjustment_rate_configuration b ON b.id = ra.rate_config_id" +
                "WHERE ra.equipment_type = :equipmentType" +
                " AND ra.rule_id = :ruleId" +
                "AND b.rule_assignment_id = :ruleAssignmentId";
        Query query = getEntityManager().createNativeQuery(sql)
                .setParameter("equipmentType", equipmentType)
                .setParameter("ruleId", ruleId)
                .setParameter("rule_assignment_id", ruleAssignmentId);
        return query.getResultList();
    }


   public RateEquipmentType findPbrcByRuleIdAndEquipmentTypeAndRuleAssignmentId(Long ruleId, int equipmentType, Long ruleAssignmentId) {
        Query query = getEntityManager().createNativeQuery("Select ra.*" +
                "  FROM rate_equipment_type ra" +
                "    LEFT JOIN primary_base_rate_configuration b ON b.id = ra.rate_config_id" +
                "  WHERE ra.equipment_type = :equipmentType" +
                " AND ra.rule_id = :ruleId" +
                " AND b.rule_assignment_id = :ruleAssignmentId");
        query.setParameter("equipmentType", equipmentType)
                .setParameter("ruleId", ruleId)
                .setParameter("rule_assignment_id", ruleAssignmentId);
        return (RateEquipmentType) query.getResultList().get(0);

    }


   public RateEquipmentType findBrccByRuleIdAndEquipmentTypeAndRuleAssignmentId(Long ruleId,
                                                                          int equipmentType, Long ruleAssignmentId) {
        Query query = getEntityManager().createNativeQuery("Select ra.*  FROM rate_equipment_type ra" +
                        "LEFT JOIN base_rate_constraint_config b ON b.id = ra.rate_config_id" +
                        " WHERE ra.equipment_type = :equipmentType" +
                        "AND ra.rule_id = :ruleId" +
                        " AND b.rule_assignment_id = :ruleAssignmentId")
                .setParameter("equipmentType", equipmentType)
                .setParameter("ruleAssignmentId", ruleAssignmentId)
                .setParameter("ruleId", ruleId);
        return (RateEquipmentType) query.getResultList().get(0);
    }

   public RateEquipmentType findFrcByRuleIdAndEquipmentTypeAndRuleAssignmentId(Long ruleId,
                                                                         int equipmentType, Long ruleAssignmentId) {
        Query query = getEntityManager().createNativeQuery("Select ra.*" +
                        "            FROM rate_equipment_type ra" +
                        "            LEFT JOIN final_rate_constraint_config b ON b.id = ra.rate_config_id" +
                        "            WHERE ra.equipment_type = :equipmentType" +
                        "              AND ra.rule_id = :ruleId" +
                        "              AND b.rule_assignment_id = :ruleAssignmentId")
                .setParameter("equipmentType", equipmentType)
                .setParameter("ruleAssignmentId", ruleAssignmentId)
                .setParameter("ruleId", ruleId);
        return (RateEquipmentType) query.getResultList().get(0);
    }


   public RateEquipmentType findSrcByRuleIdAndEquipmentTypeAndRuleAssignmentId(Long ruleId,
                                                                         int equipmentType, Long ruleAssignmentId) {
        Query query = getEntityManager().createNativeQuery("Select ra.*" +
                        "            FROM rate_equipment_type ra" +
                        "            LEFT JOIN shipper_rate_configuration b ON b.id = ra.rate_config_id" +
                        "            WHERE ra.equipment_type = :equipmentType" +
                        "              AND ra.rule_id = :ruleId" +
                        "              AND b.rule_assignment_id = :ruleAssignmentId")
                .setParameter("equipmentType", equipmentType)
                .setParameter("ruleAssignmentId", ruleAssignmentId)
                .setParameter("ruleId", ruleId);
        return (RateEquipmentType) query.getResultList().get(0);
    }
@Transactional
    public void deleteAllById(List<Long> equipmentTypeRecordIdsToDelete) {
        delete("id in ?1",equipmentTypeRecordIdsToDelete);
    }
}
