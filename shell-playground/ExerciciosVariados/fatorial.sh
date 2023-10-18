#!/bin/bash

if [ $1 -eq 0 ]
then
	echo "1"
else
	seq -s* $1 | bc
fi
