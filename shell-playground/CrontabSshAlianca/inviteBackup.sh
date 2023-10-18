#!/bin/bash

tar -cvjf /var/Backup/backup.tar.bzip /var/PastaImportante/*

for k in $(ls /home); cp /var/Backup/backup.tar.bzip /home/$k/ ; done

scp /var/Backup/backup.tar.bzip lucas@192.168.1.100:/var/BackupSsh/backupFrom-`whoami`.tar.bzip
