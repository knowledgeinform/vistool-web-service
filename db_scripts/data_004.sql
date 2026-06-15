-- =======================================================================================

-- !! IMPORTANT !!
-- !! Only add changes to the end of the MyProcedure.
-- !! Each change should be within an IF statement to ensure the change will only run if 
-- !! the database is at the appropriate 'static data' version.


-- =======================================================================================
DROP PROCEDURE IF EXISTS execute;
delimiter //
CREATE PROCEDURE execute()
BEGIN
  -- declare and set variable to store current db & version;
  DECLARE db varchar(20);
  DECLARE majVersion INT;
  DECLARE minVersion INT;

  SELECT database() INTO db;
  SELECT major, minor FROM version WHERE type = 'DATA' INTO majVersion, minVersion;

  IF majVersion = 3 && minVersion = 0 THEN

    INSERT INTO `archived_work_item` 
        SELECT * FROM `work_item` a 
        WHERE `version` < (
            SELECT MAX(`version`) FROM `work_item` b
                WHERE b.id = a.id
        );
    
    DELETE a FROM `work_item` a 
        JOIN `archived_work_item` b
        ON a.id = b.id AND a.version = b.version;

    INSERT INTO `archived_line_item`
        SELECT * FROM `line_item` a 
        WHERE `version` < (
            SELECT MAX(`version`) FROM `line_item` b
                WHERE b.id = a.id
        );

    UPDATE `work_item` a
        INNER JOIN `line_item` b
            ON a.parent_line_item_id = b.id
    SET a.parent_line_item_version = (
        SELECT MAX(version) FROM (
            SELECT * FROM `line_item`) l 
        WHERE l.id = b.id);
    
    DELETE a FROM `line_item` a
        JOIN `archived_line_item` b
        ON a.id = b.id AND a.version = b.version;


    SET majVersion = 4;
    SET minVersion = 0;

    UPDATE version SET major = majVersion, minor = minVersion WHERE type = 'DATA';

  END IF;

  -- DO NOT ADD ANYTHING AFTER THIS
END//
delimiter ;
CALL execute();
DROP PROCEDURE execute;
