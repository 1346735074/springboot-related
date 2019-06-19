


### docker方式启动zk
```text
docker run --privileged=true --name zookeeper --publish 2181:2181 -d zookeeper:latest
```