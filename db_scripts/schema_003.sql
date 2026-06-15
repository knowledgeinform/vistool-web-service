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

    IF majVersion = 2 AND minVersion = 0 THEN

    -- column_layout table
    CREATE TABLE IF NOT EXISTS  `column_layout`
    (
        `id`                    int(20) NOT NULL AUTO_INCREMENT,
        `user_id`               varchar(100) NOT NULL,
        `name`                  varchar(255) NOT NULL,
        `column_layout_json`    BLOB NOT NULL,
        `is_visible`            BOOLEAN DEFAULT 0,
        `date_created`          timestamp NULL DEFAULT NULL,
        PRIMARY KEY (`id`)
    );
    -- update the schema version to 3.0
    SET majVersion = 3;
    SET minVersion = 0;
    UPDATE version SET major = majVersion, minor = minVersion WHERE type = 'DATABASE';

  END IF;

  -- DO NOT ADD ANYTHING AFTER THIS
END//
delimiter ;
CALL execute();
DROP PROCEDURE execute;
