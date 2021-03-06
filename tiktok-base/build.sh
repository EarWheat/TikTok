#!/bin/bash
#export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.65-3.b17.el7.x86_64
#export PATH=$JAVA_HOME/bin:$PATH
#线上路径/usr/local/jdk1.8.0_65
#本地路径/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-12.0.2.jdk/Contents/Home
export PATH=$JAVA_HOME/bin:$PATH

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
rm -rf output
mkdir output

mv ${path}/target/pangu-1.0.0-RELEASE.jar output/  #拷贝目标war包或者jar包等至output目录下