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

    IF majVersion = 3 AND minVersion = 0 THEN

    -- add columns to work_item table
    ALTER TABLE `work_item`
        ADD COLUMN `user_id` varchar(100) NULL DEFAULT NULL
            AFTER `version`;
    ALTER TABLE `work_item`
        ADD COLUMN `modified_date` timestamp NOT NULL ON UPDATE NOW()
            AFTER `user_id`;

    -- set the modified date for all work_items to NOW.
    UPDATE `work_item` SET `modified_date` = NOW();
    
    
    -- update the schema version to 4.0
    SET majVersion = 4;
    SET minVersion = 0;
    UPDATE version SET major = majVersion, minor = minVersion WHERE type = 'DATABASE';

  END IF;

  -- DO NOT ADD ANYTHING AFTER THIS
END//
delimiter ;
CALL execute();
DROP PROCEDURE execute;
