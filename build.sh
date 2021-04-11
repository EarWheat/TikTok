#!/bin/bash
#export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.65-3.b17.el7.x86_64
#export PATH=$JAVA_HOME/bin:$PATH
#线上路径/usr/local/jdk1.8.0_65
#本地路径/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-12.0.2.jdk/Contents/Home
export PATH=$JAVA_HOME/bin:$PATH
#线上路径/home/liuzhaolu/tomcat/tomcat8/webapps/
export TOMCAT_HOME=/usr/local/Cellar/apache-tomcat-8.5.46

dir=`dirname $0`
path=`cd ${dir} && pwd`
echo $path

# 部署tiktok-base
cd ${path}/tiktok-base
mvn clean package -Dmaven.test.skip=true
ret=$?
if [ $ret -ne 0 ];then
    echo "===== tiktok-base maven build failure ====="
    exit $ret
else
    echo -n "===== tiktok-base maven build successfully! ====="
fi
cd ${path}/tiktok-base
rm -rf ${TOMCAT_HOME}/tiktok-base-1.0-RELEASE.war
mv ${path}/tiktok-base/target/tiktok-base-1.0.0-RELEASE.war ${TOMCAT_HOME}/webapps  #拷贝目标war包或者jar包等至output目录下

# 部署tiktok-back
cd ${path}/tiktok-back
mvn clean package -Dmaven.test.skip=true
ret=$?
if [ $ret -ne 0 ];then
    echo "===== tiktok-back maven build failure ====="
    exit $ret
else
    echo -n "===== tiktok-back maven build successfully! ====="
fi
cd ${path}/tiktok-back
rm -rf ${TOMCAT_HOME}/tiktok-back-1.0.0-RELEASE.war
mv ${path}/tiktok-back/target/tiktok-back-1.0.0-RELEASE.war ${TOMCAT_HOME}/webapps  #拷贝目标war包或者jar包等至output目录下

# 修改配置
rm -rf ${TOMCAT_HOME}/conf/server.xml
cp ${path}/tomcat-server.xml ${TOMCAT_HOME}/conf/server.xml

# 重启tomcat
sh ${TOMCAT_HOME}/bin/shutdown.sh
if [ $ret -ne 0 ];then
    echo "===== tomcat shutdown failure ====="
    exit $ret
else
    echo -n "===== tomcat shutdown successfully! ====="
fi
sh ${TOMCAT_HOME}/bin/startup.sh
if [ $ret -ne 0 ];then
    echo "===== tomcat start failure ====="
    exit $ret
else
    echo -n "===== tomcat start successfully! ====="
fi