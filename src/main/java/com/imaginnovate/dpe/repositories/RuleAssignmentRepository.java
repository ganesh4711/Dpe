package com.imaginnovate.dpe.repositories;

import com.imaginnovate.dpe.entities.RuleAssignment;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;

import java.util.List;

@ApplicationScoped
public class RuleAssignmentRepository implements PanacheRepositoryBase<RuleAssignment,Long> {

    @SuppressWarnings("unchecked")
    public List<RuleAssignment> findAllByRuleSetIdAndRuleCode(long ruleSetId,String ruleCode){
        Query query=getEntityManager().createNativeQuery("""
                                                             SELECT ra.* from rule_assignment ra
                                                             left join rules r\s
                                                             on ra.rule_id = r.id\s
                                                             left join rule_set rs\s
                                                             on rs.id = ra.rule_set_id\s
                                                             where r.code = :ruleCode and rs.id = :ruleSetID
                                                             """, RuleAssignment.class);
                query.setParameter("ruleCode",ruleCode)
                        .setParameter("ruleSetID",ruleSetId);
                return  query.getResultList();
    }


}
