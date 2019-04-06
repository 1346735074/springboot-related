FROM tomcat
d
MAINTAINER noly 1346735074@qq.com
# 定义变量、后续会使用 ，具体路径可以先启动容器然后进入进行查看
ENV DIR_WEBAPP /usr/local/tomcat/webapps/
#删除webapp下所有文件，因为当前应用作为根应用
RUN  rm -rf $DIR_WEBAPP/*

ADD zhiqu_war.war $DIR_WEBAPP/zhiqu_war.war

RUN  unzip $DIR_WEBAPP/zhiqu_war.war  -d  $DIR_WEBAPP/ROOT/

CMD ["catalina.sh", "run"]