#!/bin/bash

export TOMCAT_HOME=/home/liuzhaolu/tomcat/tomcat8/webapps/

dir=`dirname $0`
path=`cd ${dir} && pwd`
echo $path
cd ${path}
mvn clean package -Dmaven.test.skip=true
ret=$?
if [ $ret -ne 0 ];then
    echo "===== maven build failure ====="
    exit $ret
else
    echo -n "===== maven build successfully! ====="
fi
cd ${path}
rm -rf ${TOMCAT_HOME}/TikTokPlayer-1.0-SNAPSHOT.war

#mv ${path}/target/TikTokPlayer-1.0-SNAPSHOT.war ${TOMCAT_HOME}  #拷贝目标war包或者jar包等至output目录下
scp -r ${path}/target/TikTokPlayer-1.0-SNAPSHOT.war root@106.54.76.130:${TOMCAT_HOME}