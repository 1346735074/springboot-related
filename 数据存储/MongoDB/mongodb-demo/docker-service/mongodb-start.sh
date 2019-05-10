#!/usr/bin/env bash
docker run  \
    --name mongodb_server \
    -p 27017:27017  \
    -v $PWD/mysoft/mongodb/configdb:/data/configdb/ \
    -v $PWD/mysoft/mongodb/db/:/data/db/ \
    -d mongo --auth

sleep 2s