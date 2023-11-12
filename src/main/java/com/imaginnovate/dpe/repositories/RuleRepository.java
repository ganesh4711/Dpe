package com.imaginnovate.dpe.repositories;

import com.imaginnovate.dpe.entities.Rule;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;


import static io.quarkus.hibernate.orm.panache.Panache.getEntityManager;

@ApplicationScoped
public class RuleRepository implements PanacheRepositoryBase<Rule, Long> {

    public Rule findByCode(String code){
        return find("code = ?1",code).singleResult();
    }

    Rule findRuleByRuleAssignmentIdAndRuleSetId(long ruleAssignmentId,long ruleSetId){
        Query query=getEntityManager().createNativeQuery("""
                                                                SELECT r.* FROM rule_assignment ra
                                                                LEFT JOIN rules r ON ra.rule_id = r.id
                                                                WHERE ra.id = :ruleAssignmentId AND ra.rule_set_id = :ruleSetId
                                                                """);
        query.setParameter("ruleAssignmentId",ruleAssignmentId)
                .setParameter("ruleSetId",ruleSetId);
        return (Rule) query.getResultList().get(0);
    }

    long findByRuleType(int ruleTypeId){
       return find("rule_type =?1",ruleTypeId).singleResult().getId();
    }
}
