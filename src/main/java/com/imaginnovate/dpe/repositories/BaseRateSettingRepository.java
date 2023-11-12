package com.imaginnovate.dpe.repositories;

import com.imaginnovate.dpe.entities.BaseRateSetting;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;
@ApplicationScoped
public class BaseRateSettingRepository implements PanacheRepositoryBase<BaseRateSetting, Long> {

    // TODO: mark their valid_to_date instead
    @Transactional
    public void deleteAllByBaseRateConfigId(long baseRateConfigId){
        Query query=getEntityManager().createNativeQuery("delete from base_rate_setting where base_rate_config_id = :baseRateConfigId")
                .setParameter("baseRateConfigId",baseRateConfigId);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<BaseRateSetting> findAllByBaseRateConfigId(long baseRateConfigId){
        Query query=getEntityManager().createNativeQuery("select * from base_rate_setting where base_rate_config_id = :baseRateConfigId")
                .setParameter("baseRateConfigId",baseRateConfigId);
        return query.getResultList();
    }

}