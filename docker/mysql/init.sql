USE learn_java;

CREATE TABLE IF NOT EXISTS inventory_item (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    sku VARCHAR(64) NOT NULL UNIQUE,
    product_name VARCHAR(255) NOT NULL,
    available_quantity INT UNSIGNED NOT NULL DEFAULT 0,
    version INT UNSIGNED NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_inventory_product_name (product_name)
) ENGINE=InnoDB;

INSERT IGNORE INTO inventory_item (sku, product_name, available_quantity) VALUES
    ('JAVA-BOOK-001', 'Java 基础练习商品', 20),
    ('SPRING-BOOK-001', 'Spring Boot 练习商品', 10);
