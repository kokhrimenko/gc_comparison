#!/bin/bash

echo "Staring ping of the web endpoint for G1 garbage collector"

while true
do
        response=$(curl --write-out %{time_total} --silent --output /dev/null 172.20.80.1:9090/get-version)

        if [[ "$response" > 0.1 ]] ; then
                echo "long running request, took: $response seconds"
        fi
done