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
        lista3=[]
        for item in lista1:
            if item in lista2:
                lista3.append(item)
        if(len(lista3) == len(lista2)):
            return "las Listas son iguales"
        else:
            return "las Listas No son iguales"
    else:
        return "Las listas no tienen la misma cantidad de elemento, por lo tanto no son iguales"
n=ingresar()
print(igualar(*n))