#!/bin/bash

function create() {
  docker network create back

  docker image build -t client -f client/Dockerfile client/

  docker container run --name client -p 80:80 -d client

  docker container run --name db -d --network back --network-alias db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=db mysql

  docker image build -t api -f api/Dockerfile api/

  docker container run --name api -d --network back -p 8080:8080 api
}

function destroy() {
  docker container rm -f api client db 2>/dev/null

  docker network rm back 2>/dev/null

  docker image rm -f client api 2>/dev/null
}

case $1 in
  create)   create;;
  destroy)  destroy;;
  *)        printf "\r\nUnknown command $1. Valid commands are: create | destroy\r\n" 1>&2;;
esac
