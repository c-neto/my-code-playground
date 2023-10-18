from django.db import models


class Car(models.Model):
    name = models.CharField(max_length=64)
    color = models.CharField(max_length=64)
    description = models.TextField(max_length=64)
    type = models.IntegerField(choices=[
        (1, "Sedan"),
        (2, "Truck"),
        (4, "SUV"),
    ])
