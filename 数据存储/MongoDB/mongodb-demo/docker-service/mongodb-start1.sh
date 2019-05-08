#!/usr/bin/env bash
docker run  \
    --name mongodb_server \
    -p 27017:27017  \
    -v $PWD/mysoft/mongodb/configdb:/data/configdb/ \
    -v $PWD/mysoft/mongodb/db/:/data/db/ \
    -d mongo --auth



# 进入容器内部
docker exec -it mongodb_server mongo admin


# 创建管理员账号（拥有所有权限）
db.createUser({
  user: 'root',
  pwd: 'admin',
  roles: [ { role: "userAdminAnyDatabase", db: "admin" } ]
  });
# 开启验证
db.auth("root","admin");



# 创建目标数据库（实际上切换即可）
use test

# 创建目标数据库管理用户
db.createUser({
  user: 'huafeng',
  pwd: 'huafeng123456',
  roles: [ { role: "readWrite", db: "test" } ]
  });

# 开启验证
db.auth("huafeng","huafeng123456");


exit