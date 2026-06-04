package com.nexuserp.nexuserp_backend.modules.tenant.entity;

import com.nexuserp.nexuserp_backend.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tenant_registry")
@Getter
@Setter
public class TenantRegistryEntity extends BaseEntity {

    @Column(name = "tenant_code", unique = true, nullable = false)
    private String tenantCode;

    @Column(name = "tenant_name", nullable = false)
    private String tenantName;

    @Column(name = "database_name", nullable = false)
    private String databaseName;

    @Column(name = "database_host", nullable = false)
    private String databaseHost;

    @Column(name = "database_port", nullable = false)
    private Integer databasePort;

    @Column(name = "database_username", nullable = false)
    private String databaseUsername;

    @Column(name = "database_password", nullable = false)
    private String databasePassword;

    @Column(name = "status")
    private String status;

	public String getTenantCode() {
		return tenantCode;
	}

	public void setTenantCode(String tenantCode) {
		this.tenantCode = tenantCode;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getDatabaseHost() {
		return databaseHost;
	}

	public void setDatabaseHost(String databaseHost) {
		this.databaseHost = databaseHost;
	}

	public Integer getDatabasePort() {
		return databasePort;
	}

	public void setDatabasePort(Integer databasePort) {
		this.databasePort = databasePort;
	}

	public String getDatabaseUsername() {
		return databaseUsername;
	}

	public void setDatabaseUsername(String databaseUsername) {
		this.databaseUsername = databaseUsername;
	}

	public String getDatabasePassword() {
		return databasePassword;
	}

	public void setDatabasePassword(String databasePassword) {
		this.databasePassword = databasePassword;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    
    
}
