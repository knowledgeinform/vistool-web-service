#!/bin/bash

now=$(date)
echo "$now Updating database..."

while ! mysqladmin ping -h $VISTOOL_DATABASE_HOST --silent; do
    sleep 1
done

echo "SET GLOBAL log_bin_trust_function_creators = 1;" | mysql -u root --password=$MYSQL_ROOT_PASSWORD -h $VISTOOL_DATABASE_HOST -P $VISTOOL_DATABASE_PORT

# Run update script
mysql -u $VISTOOL_DATABASE_USER --password=$VISTOOL_DATABASE_PASSWORD -h $VISTOOL_DATABASE_HOST -P $VISTOOL_DATABASE_PORT --table < master.sql

# Run create_triggers script
mysql -u $VISTOOL_DATABASE_USER --password=$VISTOOL_DATABASE_PASSWORD -h $VISTOOL_DATABASE_HOST -P $VISTOOL_DATABASE_PORT < create_triggers.sql

now=$(date)
echo "$now Database updated."
