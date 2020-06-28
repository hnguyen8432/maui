#!/bin/sh

BASEDIR=$(dirname $(which $0))/..

CP=$BASEDIR/resources
for file in $BASEDIR/lib/*.jar; do
	CP="${CP}:$file"
done

exec java $JAVA_OPTS -cp "$CP" com.solers.container.apps.sample.Application