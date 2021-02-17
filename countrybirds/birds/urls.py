from django.urls import path
from . import rest_facade

urlpatterns = [
    path('backend/1/pajaro', rest_facade.get_pajaros, name='get_pajaro'),

]
