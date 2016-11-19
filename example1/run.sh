#!/bin/bash

clear; time mvn clean compile assembly:single
java -jar target/Batch01-1.0.1-jar-with-dependencies.jar

