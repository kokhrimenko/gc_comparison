# Description
Basic idea here - compare **G1** (default garbage colletor since Java 7) and **ZGC** (as experimental was added to Java 11 and, since Java 17 - default garbage collector) under high load.  

# Details
To simulate some real load **Spring boot** web was build with 3 exposed endpoints:  
- ``/get-version``, method **GET** - return used garbage collector and statistics about RAM usage (available, free and so on)  
- ``/generate``, method **POST** - simulate payload, simply adding 1 000 000 UUID to a static list
- ``/soft-ref-generate``, method **POST** - same as above but, instead of List - using ``SoftReference<List<UUID>>``  

**JConcole** can be used to check/demonstrate Garbage Collection:  
- for **G1** port: **8500**  
- for **ZGC** port: **9500**

# How to run
1 build docker image:
>> ``docker build -t g1_gc_web -f src/main/resources/docker/g1_gc/Dockerfile .``- for G1 web  
>> ``docker build -t zgc_gc_web -f src/main/resources/docker/zgc_gc/Dockerfile .`` - for ZGC  
>> ``docker build -t g1_tester -f src/main/resources/docker/shell_g1/Dockerfile .`` - for G1 tester  
>> ``docker build -t zgc_tester -f src/main/resources/docker/shell_zgc/Dockerfile .`` - ZGC tester  

2 build as a maven project:  
>> ``mvn clean install``  

3 start docker-compose  
>> ``docker-compose up -d --remove-orphans``