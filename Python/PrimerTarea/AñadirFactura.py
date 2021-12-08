def Añadir(Diccionario, clave, pagar):
    n=1
    for item in Diccionario.keys():
        if (item == clave):
            n=0
            break
    if(n != 0):
        Diccionario [clave]= pagar
        print("Se agrego un nuevo pedido")
        return Diccionario

    else:
        print("No se agrego un nuevo pedido")
        return Diccionario