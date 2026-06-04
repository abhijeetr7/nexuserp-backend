package com.nexuserp.nexuserp_backend.modules.tenant.repository;

import com.nexuserp.nexuserp_backend.modules.tenant.entity.TenantRegistryEntity;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRegistryRepository extends JpaRepository<TenantRegistryEntity, Long> {

	boolean existsByTenantCode(String tenantCode);

	List<TenantRegistryEntity> findByIsDeletedFalse();

	Optional<TenantRegistryEntity> findByTenantCodeAndIsDeletedFalse(String tenantCode);
}
