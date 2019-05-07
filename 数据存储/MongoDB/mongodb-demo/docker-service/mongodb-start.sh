#!/usr/bin/env bash
# 拉取镜像
# docker pull mongo:latest
# 启动
docker run -p 27017:27017 -v $PWD/db:/data/db --name mongodb -d mongo:latest



# 命令说明：
#
# -p 27017:27017 :将容器的27017 端口映射到主机的27017 端口
#
# -v $PWD/db:/data/db :将主机中当前目录下的db挂载到容器的/data/db，作为mongo数据存储目录