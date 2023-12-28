package com.vu.localhost.poss.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vu.localhost.poss.tenant.model.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

}