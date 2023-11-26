#!/bin/bash
rm -f server2.jks
echo -e "$(hostname -f)\nDEI\nISEP\nPORTO\nPORTO\nPT\nyes" | keytool -genkey -v -alias server2 -keyalg RSA -keysize 2048 \
	-validity 365 -keystore server2.jks -storepass forgotten
####
#keytool -list -v -keystore server2.jks -storepass forgotten
####
