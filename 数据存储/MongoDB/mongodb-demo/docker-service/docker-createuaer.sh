#!/usr/bin/env bash

# 进入容器内部
#docker exec -it mongodb_server mongo admin
#docker exec -i mongodb_server mongo admin
#docker exec mongodb_server mongo admin
#docker exec -t mongodb_server mongo admin
#docker exec -i mongodb_server mongo admin

docker exec -t mongodb_server mongo admin
<<EOF
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

#exit
EOF


# docker exec [选项] 容器 命令 [ARG...]

# -d :分离模式: 在后台运行
#
# -i :即使没有附加也保持STDIN 打开
#
# -t :分配一个伪终端