#!/bin/bash

export "ALFA_PROFILE_ENV"="local"
export "ALFA_CHAR"="?"

export "ALFA_SEGURIDAD_DATASOURCE_URL"="jdbc:oracle:thin:@//192.168.100.13/xepdb1"
export "ALFA_SEGURIDAD_DATASOURCE_USERNAME"="rrhh"
export "ALFA_SEGURIDAD_DATASOURCE_PASSWORD"="rrhh"

_APP=alfa-rrhh-api
echo -ne "\033]2;"$_APP"\007"
mvn clean install
for file in target/*.jar
do
   jarfile=$file
done
LOGS_DIR="c:/libre/devops/logs/alfa-rrhh-api/$_APP"
if [ ! -d "c:/" ]
then
	LOGS_DIR="/libre/devops/logs/alfa-rrhh-api/$_APP"
fi
mkdir -p "$LOGS_DIR"
rm -Rf $LOGS_DIR/*.*
touch -f $LOGS_DIR/stdout-$_APP.log
java -Dapp.name=$_APP -Xms128M -Xmx256M -jar $jarfile &
trap " " INT
tail -f $LOGS_DIR/stdout-$_APP.log
trap - INT
PID=`grep -a "" /proc/*/cmdline | xargs -0 | grep java | grep $_APP | awk '{print $1}' | awk -F'/' '{print $3}'`
if [ "$PID" == "" ]
then
        PID=`ps -ef | grep -v grep | grep java | grep $_APP | awk '{print $2}'`
fi
echo "Deteniendo proceso $PID..."
kill $PID
read -n1 -r -s -p $'\e[32mProceso detenido. Oprime una tecla para terminar...\e[0m'