-- =======================================================================================

-- !! IMPORTANT !!
-- !! Only add changes to the end of the MyProcedure.
-- !! Each change should be within an IF statement to ensure the change will only run if
-- !! the database is at the appropriate 'static data' version.

-- !! Each IF statement for a change should always evaluate its major and minor versions
-- !! to the values from the prior update.
-- !! Example:
/*
  DB maj version = 3 AND min version = 45
  Next alteration should check the following for being applied
  IF majVersion = 3 AND minVersion = 45 THEN
    ....make changes....
  END IF;

*/

-- =======================================================================================
DROP PROCEDURE IF EXISTS execute;
delimiter //
CREATE PROCEDURE execute()
BEGIN
    DECLARE db varchar(20);
    DECLARE majVersion INT;
    DECLARE minVersion INT;

    SELECT database() INTO db;
    SELECT major, minor FROM version WHERE type = 'DATABASE' INTO majVersion, minVersion;

    IF majVersion = 4 AND minVersion = 0 THEN

        -- add a line items archive table
        CREATE TABLE IF NOT EXISTS `archived_line_item`
        (
            `id`                        int(20) NOT NULL,
            `version`                   int(20) NOT NULL,
            `work_authorization_number` varchar(50) NOT NULL,
            `line_item_number`          varchar(50) NOT NULL,
            `quantity`                  int(11) NOT NULL,
            `work_authorization_change_stop_date` timestamp NULL DEFAULT NULL,
            `work_authorization_change_ta_date` timestamp NULL DEFAULT NULL,
            PRIMARY KEY (`id`, `version`)
        );

        -- add a work items archive table
        CREATE TABLE IF NOT EXISTS `archived_work_item`
        (
            `id`                        int(20) NOT NULL,
            `version`                   int(20) NOT NULL,
            `user_id`                   varchar(100) NULL DEFAULT NULL,
            `modified_date`             timestamp NOT NULL,
            `parent_line_item_id`       int(20) NOT NULL,
            `parent_line_item_version`  int(20) NOT NULL,
            `linked_work_order`         varchar(50),
            `serial_number`             varchar(50),
            `quantity`                  int(11) NOT NULL DEFAULT 1,
            `quantity_complete`         int(11),
            `balance`                   int(11),
            `expedite`                  boolean DEFAULT 0,
            `subsystem`                 varchar(50),
            `p_and_p`                   boolean DEFAULT 0,
            `loading_priorities`         varchar(50),
            `size_and_magazines`        varchar(100),
            `pick_and_place_notes`      varchar(1250),
            `target_start_date`         timestamp NULL DEFAULT NULL,
            `production_planning`       boolean DEFAULT 0,
            `production_planning_notes` varchar(1250),
            `action_items`              varchar(1250),
            `status`                    varchar(50),
            `status_comments`           varchar(1250),
            `manufacturing_engineer`    varchar(100),
            `current_technician`        varchar(100),
            `program_priority`          int(11),
            `technician_priority`       int(11),
            `polymerics_priority`       int(11),
            `inspection_priority`       int(11),
            `date_complete`             timestamp NULL DEFAULT NULL,
            `kit_part_due_date`         timestamp NULL DEFAULT NULL,
            `estimate_to_complete`      timestamp NULL DEFAULT NULL,
            `estimate_to_test`          timestamp NULL DEFAULT NULL,
            `estimate_return_to_assembly`       timestamp NULL DEFAULT NULL,
            `eee_kit`                   varchar(50),
            `mech_kit`                  varchar(50),
            `comments`                  varchar(1250),
            `work_order_exists`         varchar(50),
            PRIMARY KEY (`id`, `version`)
        );
        
        -- update the schema version to 5.0
        SET majVersion = 5;
        SET minVersion = 0;
        UPDATE version SET major = majVersion, minor = minVersion WHERE type = 'DATABASE';

    END IF;

-- DO NOT ADD ANYTHING AFTER THIS
END//
delimiter ;
CALL execute();
DROP PROCEDURE execute;
