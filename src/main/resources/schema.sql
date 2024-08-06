CREATE TABLE IF NOT EXISTS translation_requests (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ip_address VARCHAR(255) NOT NULL,
    original_text TEXT NOT NULL,
    translated_text TEXT NOT NULL
);
