package com.imaginnovate.dpe.repositories;

import com.imaginnovate.dpe.entities.AccessorialType;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.jboss.logging.annotations.Param;


import java.util.List;
import java.util.stream.Collectors;
@ApplicationScoped
public class AccessorialTypeRepository implements PanacheRepository<AccessorialType> {

  //  @Query(value = "SELECT * from accessorial_type at where config_id = :configId and rule_id = :ruleId",nativeQuery = true)
    List<AccessorialType> findAllByConfigId(Long configId,Long ruleId){
        return list("config_id = ?1 and rule_id = ?2",configId,ruleId);
    }

    @Transactional
    public  void deleteAllByConfigIdAndRuleId(Long configId, Long ruleId) {
        delete("configId = ?1 and ruleId = ?2",configId,ruleId);
    }


  //  @Query(value = "select accessorial_id  from accessorial_type WHERE config_id =:configId",nativeQuery = true)
    List<Long> findAccessorialIdsByConfigId(Long configId){
        return find("config_id = ?1",configId)
                .stream()
                .map(AccessorialType::getId)
                .collect(Collectors.toList());
    }

}


