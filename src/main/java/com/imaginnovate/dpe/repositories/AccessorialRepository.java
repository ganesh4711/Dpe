package com.imaginnovate.dpe.repositories;

import com.arjuna.ats.internal.jdbc.drivers.modifiers.list;
import com.imaginnovate.dpe.entities.Accessorial;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.annotations.Param;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class AccessorialRepository implements PanacheRepositoryBase<Accessorial, Long> {
    //   @Query(value = "select a.* from  accessorial a where a.id = :id and a.deleted_at is null",nativeQuery = true)
    Optional<Accessorial> findByAccessorialId(long id) {
        return find("id = ?1 and deleted_at is null", id).firstResultOptional();
    }

    // @Query(value = "select * from accessorial a where a.deleted_at is null",nativeQuery = true)
    List<Accessorial> findAllAccessorials() {
        return list("deleted_at is null");
    }
    // @Query(value = "select a.* from accessorial a where id = :id and deleted_at is null",nativeQuery = true)


    // @Query(value = "select accessorial_name from accessorial a where a.id in :unmatchedAccessorialIds", nativeQuery = true)
    List<String> findAllAccessorialNamesByIdIn(List<Long> unmatchedAccessorialIds) {
        return list("id in :unmatchedAccessorialIds", Parameters.with("unmatchedAccessorialIds", unmatchedAccessorialIds))
                .stream()
                .map(Accessorial::getName)
                .collect(Collectors.toList());
    }

   // @Query(value = "select * from accessorial a where a.code=:code and a.deleted_at is null", nativeQuery = true)
    Accessorial findExistingAccessorialByCode(String code){
        return find("code = ?1 and deleted_at is null",code).firstResult();
    }

   // @Query(value = "select * from accessorial a where a.id=:id and  a.code=:code and a.deleted_at is not null", nativeQuery = true)
    Accessorial findAccessorialByCodeAndId(long id, String code){
        return find("id =?1 and code = ?2 and deleted_at is not null",id,code).firstResult();
    }
}
