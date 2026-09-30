-- =======================================================================================

-- !! IMPORTANT !!
-- !! Only add changes to the end of the MyProcedure.
-- !! Each change should be within an IF statement to ensure the change will only run if
-- !! the database is at the appropriate 'static data' version.

-- !! Each IF statement for a change should always evaluate its major and minor versions
-- !! to the values from the prior update.

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

    IF majVersion = 7 AND minVersion = 0 THEN

        CREATE TABLE IF NOT EXISTS `vistool_role`
        (
            `role` varchar(50) NOT NULL,
            PRIMARY KEY (`role`)
        );

        CREATE TABLE IF NOT EXISTS `vistool_role_field_permission`
        (
            `id` int(20) NOT NULL AUTO_INCREMENT,
            `role` varchar(50) NOT NULL,
            `field_binding` varchar(150) NOT NULL,
            PRIMARY KEY (`id`),
            UNIQUE INDEX (`role`, `field_binding`),
            CONSTRAINT `fk_vistool_role_permission_role`
                FOREIGN KEY (`role`) REFERENCES `vistool_role` (`role`)
        );

        INSERT IGNORE INTO `vistool_role` (`role`) VALUES
            ('VIEWER'),
            ('COMMENTER'),
            ('EDITOR'),
            ('ADMIN'),
            ('PPO');

        INSERT IGNORE INTO `vistool_role_field_permission` (`role`, `field_binding`) VALUES
            ('EDITOR', '*'),
            ('ADMIN', '*'),
            ('PPO', 'productionPlanning.productionPlanning'),
            ('PPO', 'productionPlanning.productionPlanningNotes'),
            ('PPO', 'estimateReturnToAssembly'),
            ('PPO', 'kitPartDueDate'),
            ('PPO', 'productionPlanning.actionItems');

        SET majVersion = 8;
        SET minVersion = 0;
        UPDATE version SET major = majVersion, minor = minVersion WHERE type = 'DATABASE';

    END IF;

    -- DO NOT ADD ANYTHING AFTER THIS
END//
delimiter ;
CALL execute();
DROP PROCEDURE execute;