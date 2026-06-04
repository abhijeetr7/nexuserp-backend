package com.nexuserp.nexuserp_backend.modules.tenant.service;

import com.nexuserp.nexuserp_backend.core.exception.ResourceNotFoundException;
import com.nexuserp.nexuserp_backend.core.security.AesEncryptionService;
import com.nexuserp.nexuserp_backend.modules.tenant.dto.CreateTenantRequest;
import com.nexuserp.nexuserp_backend.modules.tenant.entity.TenantRegistryEntity;
import com.nexuserp.nexuserp_backend.modules.tenant.repository.TenantRegistryRepository;

import com.nexuserp.nexuserp_backend.modules.tenant.dto.TenantResponse;
import com.nexuserp.nexuserp_backend.modules.tenant.dto.UpdateTenantRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantRegistryService {

	@Autowired
	TenantRegistryRepository repository;

	@Autowired
	private AesEncryptionService aesEncryptionService;

	public TenantResponse createTenant(CreateTenantRequest request) {

		if (repository.existsByTenantCode(request.getTenantCode())) {

			throw new RuntimeException("Tenant Code already exists");
		}

		TenantRegistryEntity tenant = new TenantRegistryEntity();

		tenant.setTenantCode(request.getTenantCode());

		tenant.setTenantName(request.getTenantName());

		tenant.setDatabaseName(request.getDatabaseName());

		tenant.setDatabaseHost(request.getDatabaseHost());

		tenant.setDatabasePort(request.getDatabasePort());

		tenant.setDatabaseUsername(request.getDatabaseUsername());

//        tenant.setDatabasePassword(
//                request.getDatabasePassword());

		String encryptedPassword = aesEncryptionService.encrypt(request.getDatabasePassword());

		tenant.setDatabasePassword(encryptedPassword);

		tenant.setStatus("ACTIVE");

		TenantRegistryEntity savedTenant = repository.save(tenant);

		return mapToResponse(savedTenant);
	}

	public List<TenantResponse> getAllTenants() {

		return repository.findByIsDeletedFalse().stream().map(this::mapToResponse).toList();
	}

	public TenantResponse getTenantById(Long id) {

		TenantRegistryEntity entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tenant not found"));

		return mapToResponse(entity);
	}

	private TenantResponse mapToResponse(TenantRegistryEntity entity) {

		TenantResponse response = new TenantResponse();

		response.setId(entity.getId());
		response.setTenantCode(entity.getTenantCode());
		response.setTenantName(entity.getTenantName());
		response.setDatabaseName(entity.getDatabaseName());
		response.setDatabaseHost(entity.getDatabaseHost());
		response.setDatabasePort(entity.getDatabasePort());
		response.setStatus(entity.getStatus());

		return response;
	}

	public TenantResponse updateTenant(Long id, UpdateTenantRequest request) {

		TenantRegistryEntity tenant = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tenant not found"));

		tenant.setTenantName(request.getTenantName());

		tenant.setDatabaseHost(request.getDatabaseHost());

		tenant.setDatabasePort(request.getDatabasePort());

		tenant.setDatabaseUsername(request.getDatabaseUsername());

		if (request.getDatabasePassword() != null && !request.getDatabasePassword().isBlank()) {

			tenant.setDatabasePassword(aesEncryptionService.encrypt(request.getDatabasePassword()));
		}

		tenant.setStatus(request.getStatus());

		TenantRegistryEntity updated = repository.save(tenant);

		return mapToResponse(updated);
	}

	public void deleteTenant(Long id) {

		TenantRegistryEntity tenant = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Tenant not found"));

		tenant.setIsDeleted(true);

		tenant.setStatus("INACTIVE");

		repository.save(tenant);
	}

	public TenantRegistryEntity getTenantByCode(String tenantCode) {

		return repository.findByTenantCodeAndIsDeletedFalse(tenantCode)

				.orElseThrow(() -> new ResourceNotFoundException("Tenant not found"));
	}
}
