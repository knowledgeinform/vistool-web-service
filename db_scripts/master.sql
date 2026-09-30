CREATE DATABASE IF NOT EXISTS vistool;

USE `vistool`;

SOURCE schema_001.sql
SELECT
  "CUR VERSION" AS "",
  v.*
FROM version v;

-- Insert new scripts after this line
SOURCE schema_002.sql
SOURCE schema_003.sql
SOURCE data_001.sql
SOURCE data_002.sql
SOURCE data_003.sql
SOURCE schema_004.sql
SOURCE schema_005.sql
SOURCE data_004.sql
SOURCE data_005.sql
SOURCE schema_006.sql
SOURCE schema_007.sql
SOURCE schema_008.sql



-- Make sure this line is always last in the file
SELECT
  "NEW VERSION" AS "",
  v.*
FROM version v;
