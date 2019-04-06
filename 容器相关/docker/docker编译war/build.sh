#!/usr/bin/env bash

#mvn clean package -Dmaven.test.skip=true -U

docker login -u 15138067756 -p zhaoyao123 hub.c.163.com

docker build -t hub.c.163.com/only19/zhiqu .

docker push hub.c.163.com/only19/zhiqu