#!/usr/bin/env bash
mvn clean compile exec:java -Dexec.mainClass="com.kzn.itis.ExampleMain" -Pprod -Dexec.cleanupDaemonThreads=false
