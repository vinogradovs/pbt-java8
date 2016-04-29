#!/bin/bash

if [ "" == "$1" ]
then
	echo Provide a release
	exit -1
else
	git branch $1
	git checkout $1

	mvn versions:set -DnewVersion=$1
	mvn clean deploy
fi

