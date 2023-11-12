package com.imaginnovate.dpe.repositories;

import com.imaginnovate.dpe.entities.RateSource;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class RateSourceRepository implements PanacheRepositoryBase<RateSource, Long> {
}
