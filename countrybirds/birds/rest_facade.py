import json
from .models import Bird

from django.http import HttpResponse,HttpResponseNotAllowed, JsonResponse

from django.views.decorators.csrf import csrf_exempt

@csrf_exempt
def get_pajaros(request):

    if request.method != 'GET':
        return HttpResponseNotAllowed(['GET'])

    lista_de_pajaros = mostrar_lista_pajaros()

    json = []
    for pajaro in lista_de_pajaros:
        json.append({'nombre': pajaro.nombre, 'pais': pajaro.codigo_pais})

    return JsonResponse(json, safe=False, status=200)
    
def mostrar_lista_pajaros():
    try:
        return Bird.objects.all()
    except Bird.DoesNotExist:
        return None