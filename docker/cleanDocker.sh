#!/bin/bash

sudo su
docker rm -f $(docker ps -a -q)
docker rmi $(docker images -q)
