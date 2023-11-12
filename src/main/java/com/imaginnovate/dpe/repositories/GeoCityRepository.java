package com.imaginnovate.dpe.repositories;

import com.imaginnovate.dpe.entities.GeoCity;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.annotations.Param;

import java.awt.print.Pageable;


@ApplicationScoped
public class GeoCityRepository implements PanacheRepositoryBase<GeoCity,String> {
    public Page findAllByCity(String search, Pageable pageable){
        PanacheQuery<GeoCity> query = find("name like :search", Sort.ascending("name"), Parameters.with("search", "%" + search + "%"));
        return query.page();

    }
}
