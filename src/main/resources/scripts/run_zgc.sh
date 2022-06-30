#!/bin/bash

echo "Ping script started and will sleep for 30 seconds!"

sleep 30

echo "Staring ping of the web endpoint for ZGC garbage collector"

while true
do
        response=$(curl --write-out %{time_total} --silent --output /dev/null zgc-gc-web:8080/get-version)

        if [[ "$response" > 0.1 ]] ; then
                echo "long running request, took: $response seconds"
        fi
done