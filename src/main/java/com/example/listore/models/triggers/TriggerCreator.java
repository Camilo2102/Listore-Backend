package com.example.listore.models.triggers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TriggerCreator {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TriggerCreator(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void initializeTriggers() {
        createCheckRoleTrigger();
    }

    private void createCheckRoleTrigger() {
        try {
            String sql = "CREATE TRIGGER `check_role` BEFORE INSERT ON user FOR EACH ROW IF NEW.role NOT IN ('C', 'M', 'D', 'P', 'G') THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El valor del role debe ser C, M, D, P o G'; END IF;";
            jdbcTemplate.execute(sql);
        }catch (Exception e) {
            System.out.println("Trigger ya creado");
        }
    }
}