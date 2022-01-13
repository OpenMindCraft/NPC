#!/bin/bash

FILE_LIST=$(ls ./src/main/java/idk/plugin/npc/entities) 

echo "----------------"
echo "Register entry's"
echo "----------------"

for FILE in ${FILE_LIST[@]}
do
    STRIPPED=${FILE:0:-5}
    echo "Entity.registerEntity(${STRIPPED}.class.getSimpleName(), ${STRIPPED}.class);"
done 

echo "----------------"
echo "String array"
echo "----------------"

for FILE in ${FILE_LIST[@]}
do
    STRIPPED=${FILE:4:-5}
    printf "\"${STRIPPED}\", "
done 
printf "\n"

echo "----------------"
echo "ReadMe.md entity list"
echo "----------------"

for FILE in ${FILE_LIST[@]}
do
    STRIPPED=${FILE:4:-5}
    printf "\`${STRIPPED}\`, "
done 
printf "\n"
echo "----------------"
