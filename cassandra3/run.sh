#!/bin/bash

clear; mvn clean compile assembly:single
java -jar target/cassandra3-0.0.1-jar-with-dependencies.jar 192.168.128.84

