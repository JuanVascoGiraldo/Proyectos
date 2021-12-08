def pendiente(factura):
    if(len(factura)==0):
        return 0
    else:
        respuesta=0
        for item in factura.keys():
            respuesta += factura.get(item)
        return respuesta
def pagado(Pagadas):
    if (len(Pagadas) == 0):
        return 0
    else:
        respuesta = 0
        for item in Pagadas.keys():
            respuesta += Pagadas.get(item)
        return respuesta