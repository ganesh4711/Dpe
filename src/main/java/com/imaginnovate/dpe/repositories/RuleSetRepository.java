package com.imaginnovate.dpe.repositories;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;
import com.imaginnovate.dpe.common.Enums.RuleStatus;
import com.imaginnovate.dpe.entities.RuleSet;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@ApplicationScoped
public class RuleSetRepository implements PanacheRepositoryBase<RuleSet, Long> {

    Optional<RuleSet> findByIdAndStatus(long ruleSetId, RuleStatus ruleStatus){
       return find("ruleSetId = ?1 and status = ?2",ruleSetId,ruleStatus).singleResultOptional();
    }

    List<RuleSet> findByAllActiveRuleSets(){
       return list("status = ?1",1);
    }

    List<RuleSet> findByRuleSets(){
        return list("status in ?1", Arrays.asList(1,2));
    }

}
