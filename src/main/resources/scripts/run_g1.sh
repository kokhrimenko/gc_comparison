#!/bin/bash

echo "Ping script started and will sleep for 30 seconds!"

sleep 30

echo "Staring ping of the web endpoint for G1 garbage collector"

while true
do
        response=$(curl --write-out %{time_total} --silent --output /dev/null g1-gc-web:8080/get-version)

        if [[ "$response" > 0.1 ]] ; then
                echo "long running request, took: $response seconds"
        fi
done