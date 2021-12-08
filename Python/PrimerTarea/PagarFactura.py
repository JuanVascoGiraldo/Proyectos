def Pagar(Diccionario, Pagado, Clave):
    i=0
    for item in Diccionario:
        if item == Clave:
            Pagado[item]= Diccionario.get(item)
            del Diccionario[item]
            i=1
            break
    if(i!=0):
        print(f"Se ha pagado la factura con numero {Clave}")
        return [Diccionario, Pagado]
    else:
        print(f"No Se ha pagado la factura con numero {Clave}")
        return [Diccionario, Pagado]