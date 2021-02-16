from django.db import models
import os

class Bird(models.Model):
    nombre = models.CharField(max_length=100, unique=True)
    codigo_pais = models.CharField(max_length=2,null=False)

