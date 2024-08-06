package com.example.demo.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@RequiredArgsConstructor

@Repository
public class TranslationRepository  {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String INSERT_QUERY = "INSERT INTO translation_requests (ip_address, original_text, translated_text) VALUES (?,?,?)";
    public void save(String ipAddress, String originalText, String translatedText) {
            jdbcTemplate.update(INSERT_QUERY, ipAddress, originalText, translatedText);
    }
}
