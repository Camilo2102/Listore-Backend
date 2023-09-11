package com.example.listore.models.triggers;

import com.example.listore.utils.LoggerUtil;
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
        createCheckStatusTrigger();
        createSaleTrigger();
        createAfterBuyTrigger();
        createUpdateProductAmountTrigger();
        createAfterUpdateKindOfProductAmountTrigger();
    }

    private void createSaleTrigger(){
        try {
            String sql = "CREATE TRIGGER `create_sale` BEFORE INSERT ON `sale` FOR EACH ROW UPDATE product SET amount = amount - NEW.amount WHERE id = NEW.product_id;";
            jdbcTemplate.execute(sql);
        }catch (Exception e) {
            LoggerUtil.info("Trigger for sale validator already exist");
        }
    }

    private void createCheckRoleTrigger() {
        try {
            String sql = "CREATE TRIGGER `check_role` BEFORE INSERT ON user FOR EACH ROW IF NEW.role NOT IN ('C', 'M', 'D', 'P', 'G') THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El valor del role debe ser C, M, D, P o G'; END IF;";
            jdbcTemplate.execute(sql);
        }catch (Exception e) {
            LoggerUtil.info("Trigger role validator already exist");
        }
    }

    private void createCheckStatusTrigger() {
        try {
            String sql = "CREATE TRIGGER `check_status` BEFORE INSERT ON user FOR EACH ROW IF NEW.active NOT IN ('S', 'N') THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El valor del est ado debe se S, N'; END IF;";
            jdbcTemplate.execute(sql);
        }catch (Exception e) {
            LoggerUtil.info("Trigger status validator already exist");
        }
    }

    private void createUpdateProductAmountTrigger() {
        try {
            String sql = "CREATE TRIGGER `update_product_amount_trigger` AFTER INSERT ON kind_of_product FOR EACH ROW BEGIN DECLARE total_amount DECIMAL(38,2); SET total_amount = (SELECT SUM(amount) FROM kind_of_product WHERE product_id = NEW.product_id); UPDATE product SET amount = total_amount WHERE id = NEW.product_id; END;";
            jdbcTemplate.execute(sql);
        }catch (Exception e) {
            LoggerUtil.info("Trigger update product amount already exist");
        }
    }

    private void createAfterUpdateKindOfProductAmountTrigger() {
        try {
            String sql = "CREATE TRIGGER `after_update_kind_of_product_amount_trigger` AFTER UPDATE ON kind_of_product FOR EACH ROW BEGIN DECLARE total_amount DECIMAL(38,2); SET total_amount = (SELECT SUM(amount) FROM kind_of_product WHERE product_id = OLD.product_id); UPDATE product SET amount = total_amount WHERE id = OLD.product_id; END;";
            jdbcTemplate.execute(sql);
        }catch (Exception e) {
            LoggerUtil.info("Trigger after update kindOfProduct amount already exist 1");
        }
    }

    private void createAfterBuyTrigger() {
        try {
            String sql = "CREATE TRIGGER `after_buy_trigger` AFTER INSERT ON buy FOR EACH ROW BEGIN UPDATE kind_of_product SET amount = amount + NEW.amount WHERE id = NEW.kind_of_product_id; END;";
            jdbcTemplate.execute(sql);
        }catch (Exception e) {
            LoggerUtil.info("Trigger after buy already exist");
        }
    }

}