from django.db import models


class OperationSystem(models.Model):
    name = models.CharField(max_length=64, help_text="nome do sistema operacional")


class Equipment(models.Model):
    operation_system = models.ForeignKey(OperationSystem, on_delete=models.CASCADE)
    fqdn = models.CharField(max_length=64)
