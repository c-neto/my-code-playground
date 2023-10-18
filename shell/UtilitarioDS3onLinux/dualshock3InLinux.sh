#!/bin/bash

sudo echo "Facilitator for connecting dualshock3 on Linux, ceated by Carlos Neto (github: @augustoliks)"

echo ""

dpkg --get-selections | grep -i "xboxdrv"
if [ $? != 0 ]; then
	echo "you dont have installed a package: xboxdrv"
	echo "maybe this a resolution for your problem: apt-get install xboxdrv"
	exit
fi

lsusb | grep "PlayStation 3 Controller"
if [ $? != 0 ]; then
	echo "You dont connected you Dualshock3"
	exit

else
	echo -n "Set LED number for you DualShock3: ";  read led;
	
	while [ $led -gt 4 ] || [ $led -lt 1 ]
	do
		echo -n "Set valid LED number! [1][2][3][4]: " ; read led;
	done

	led=$((led+1))
	echo led number this $led	
	sudo xboxdrv --detach-kernel-driver --led $led
fi
