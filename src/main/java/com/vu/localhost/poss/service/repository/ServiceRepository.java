package com.vu.localhost.poss.service.repository;

import com.vu.localhost.poss.service.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    @Query("SELECT s.id FROM Service s WHERE s.tenantId = :tenantId")
    List<Long> findServiceIdsByTenantId(Long tenantId);


}

