#!/bin/bash

while ping -c 1 $1; do
  echo "Waiting on vistool-db-updater to finish"
  sleep 5
done

echo "vistool-db-updater finished"
