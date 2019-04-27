#!/bin/bash

work_dir=`dirname $0`
cd "$work_dir"
echo " Working Directory: $work_dir"

repository=
tag=1
app_image=online-reservation-api:${tag}

case "$1" in
    "docker")
      docker-compose -f config/docker-compose.yml down
      docker-compose -f config/docker-compose.yml up -d
      ;;
      *)
      exit 0
      ;;
  esac
