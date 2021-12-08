def ingresar():
    clave= input("ingrese la clave para acabar el registo de datos")
    lista1 = []
    lista2 = []
    print("Primer Lista")
    agregar = input("ingrese el valor que quiere agregar a la lista o la clave")
    while (agregar != clave):
        agregar= input("ingrese el valor que quiere agregar a la lista o la clave")
        if(agregar!= clave):
            lista1.append(agregar)
    print("Segunda Lista")
    agregarr = input("ingrese el valor que quiere agregar a la segunda lista o la clave")
    while (agregarr != clave):
        agregarr = input("ingrese el valor que quiere agregar a la segunda lista o la clave")
        if(agregarr!= clave):
            lista2.append(agregarr)

    return lista1, lista2

def igualar(lista1, lista2):

    if(len(lista1) == len(lista2)):
        con1= set(lista1)
        con2 = set(lista2)
        if((len(con1.intersection(con2)))== len(lista1)):
            return "Las listas Son iguales"
        else:
            return "Las listas no son iguales"
    else:
        return "Las listas no tienen la misma cantidad de elemento, por lo tanto no son iguales"

n=ingresar()
print(igualar(*n))