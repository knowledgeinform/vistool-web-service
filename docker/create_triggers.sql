-- IMPORTANT: This is the only file where SQL statements should happen outside a procedure.
-- SQL prohibits creating triggers within a procedure, so the triggers had to be defined outside of it
-- These statements should not be carried forward into subsequent schema files.
-- This file should not be used as a template for future schema files.

-- set database to use. Needs to match the database name in the docker/.env file.
USE vistool;


-- change the delimiter so that we can use semicolons in the BEGIN/END blocks.
delimiter //

-- add a trigger to move items from line items to archived line items
CREATE TRIGGER IF NOT EXISTS `archive_line_item_trigger`
BEFORE DELETE ON `line_item`
FOR EACH ROW
BEGIN
    INSERT INTO `archived_line_item` SELECT * FROM `line_item` WHERE `id` = OLD.id AND `version` = OLD.version;
END//


-- add a trigger to move items from work items to archived work items
CREATE TRIGGER IF NOT EXISTS `archive_work_item_trigger`
BEFORE DELETE ON `work_item`
FOR EACH ROW
BEGIN
    INSERT INTO `archived_work_item` SELECT * FROM `work_item` WHERE `id` = OLD.id AND `version` = OLD.version;
END//


-- reset the delimiter to a semicolon
delimiter ;