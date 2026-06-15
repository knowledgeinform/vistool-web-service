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

    IF majVersion = 6 AND minVersion = 0 THEN

        -- add columns to line_item table
        create table wa_changes
        (
            work_authorization_id     varchar(50) not null,
            part_id                   varchar(50) not null,
            line_item                 varchar(50) null,
            change_line_part_id       varchar(50) null,
            change_line_flow          varchar(50) null,
            change_comment            longtext    null,
            change_line_item_number   varchar(50) null,
            change_line_part_revision varchar(50) null,
            change_line_needed_date   timestamp   null,
            change_line_quantity      int         null,
            change_ta                 varchar(50) null,
            change_work_area_name     varchar(50) null,
            customer                  varchar(50) null,
            department_id             varchar(50) null,
            originator                varchar(50) null,
            status                    varchar(50) null,
            apl_groups_id             varchar(50) null,
            description               longtext    null,
            flow                      varchar(50) null,
            in_plm                    varchar(50) null,
            parent_lot                varchar(50) null,
            original_work_order       varchar(50) null,
            parent_operation          varchar(50) null,
            parent_split_id           varchar(50) null,
            parent_work_order         varchar(50) null,
            redd_flow_id              varchar(50) null,
            requestor                 varchar(50) null,
            sub_id                    varchar(50) null,

            PRIMARY KEY (work_authorization_id, part_id)
        );
        -- update the schema version
        SET majVersion = 7;
        SET minVersion = 0;
        UPDATE version SET major = majVersion, minor = minVersion WHERE type = 'DATABASE';

    END IF;

    -- DO NOT ADD ANYTHING AFTER THIS
END//
delimiter ;
CALL execute();
DROP PROCEDURE execute;
