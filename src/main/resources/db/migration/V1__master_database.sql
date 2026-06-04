CREATE TABLE tenant_registry
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    created_by BIGINT NULL,
    created_at DATETIME NULL,
    updated_by BIGINT NULL,
    updated_at DATETIME NULL,
    is_deleted BOOLEAN DEFAULT FALSE,
    version BIGINT DEFAULT 0,
    tenant_code VARCHAR(50) NOT NULL UNIQUE,
    tenant_name VARCHAR(200) NOT NULL,
    database_name VARCHAR(100) NOT NULL,
    database_host VARCHAR(100) NOT NULL,
    database_port INT NOT NULL,
    database_username VARCHAR(100) NOT NULL,
    database_password VARCHAR(500) NOT NULL,
    status VARCHAR(20) DEFAULT 'ACTIVE'
);
