FROM mysql:8.0

# Set the database name argument
#ARG DB_DATABASE=$"(awk -F=\"=\" 'NR==6 { print $2 }' ./docker/.env)"

# Configure root user's PW and create a new database
#ENV MYSQL_ROOT_PASSWORD=$"(awk -F=\"=\" 'NR==1 { print $2 }' ./docker/.env)"
ARG VISTOOL_DATABASE
ARG VISTOOL_DATABASE_USER
ARG VISTOOL_DATABASE_PASSWORD
ARG MYSQL_ROOT_PWD

ENV MYSQL_DATABASE=$VISTOOL_DATABASE
ENV MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PWD

# Add the vistool user via the script and grant database access
#ARG VISTOOL_DATABASE_USER=$"(awk -F=\"=\" 'NR==2 { print $2 }' ./docker/.env)"
#ARG VISTOOL_DATABASE_PASS=$"(awk -F=\"=\" 'NR==3 { print $2 }' ./docker/.env)"
COPY ./docker/create-user.sql .
RUN sed -i -e "s/{{VISTOOL_DATABASE_USER}}/$VISTOOL_DATABASE_USER/g" create-user.sql
RUN sed -i -e "s/{{VISTOOL_DATABASE_PASSWORD}}/$VISTOOL_DATABASE_PASSWORD/g" create-user.sql
RUN mv create-user.sql /docker-entrypoint-initdb.d

# Initialize database
COPY ./db_scripts /db_scripts
RUN sed -i -e 's/SOURCE /SOURCE \/db_scripts\//g' /db_scripts/master.sql
RUN mv /db_scripts/master.sql /docker-entrypoint-initdb.d

# RUN chown -R mysql:mysql /docker-entrypoint-initdb.d/
