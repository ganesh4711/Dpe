package com.imaginnovate.dpe.repositories;

import com.imaginnovate.dpe.data.responses.RateOperatorProjection;
import com.imaginnovate.dpe.entities.RateEquipmentType;
import com.imaginnovate.dpe.entities.RateOperator;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;


import java.util.List;

@ApplicationScoped
public class RateOperatorRepository implements PanacheRepositoryBase<RateOperator, Long> {
    public List<RateOperatorProjection> getBaseRateOperator(){
        Query query=getEntityManager().createNativeQuery("SELECT id,name from rate_operator ro WHERE ro .applicable_for='1'");
        return query.getResultList();
    }
    List<RateOperatorProjection> getCalenderOperators(){
        Query query=getEntityManager().createNativeQuery("select id,name from rate_operator where applicable_for = '2'");
        return query.getResultList();
    }
}

