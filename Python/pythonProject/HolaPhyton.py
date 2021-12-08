lista_variada = ["primero", "segundo", 10, 20, [2.5, 5.5, 8.5], True, False]
lista_num = [10, 20, 30, 40, 60]
lista_nueva = []
tupla = ("datos", "llaves", 1, 2)
print(lista_variada)
'''imprimir una lista
xD'''
print(f"el numero de elementosm de la lista variada es {len(lista_variada)}")

# obtener los elementos  de la sublista solamente
for subelemento in lista_variada:
    if isinstance(subelemento, list):
        print(f"son elementos de la sublista {subelemento}")

# concatenar 2 listas en una nueva
lista_nueva= lista_variada + lista_num
print(f"lista concatenada {lista_nueva}")

#añadir un elemento a la lista
lista_num.extend(lista_variada)
print(f"se añadieron mas elementos {lista_num}")

#borrar elementos
print(f"longitud despues de añadir es {len(lista_num)}")
del lista_num[6:13]
print(f"la lista queda despues de borrar los elementos como: {lista_num}")

# verifivar si un elemento esta en la lista
print ("primero" in lista_nueva)

#ordenar la lista ascentemente
#lista_num.sort()
print(f"lista ordenada decendentes es: {lista_num}")

# convertir una tupla en lista
lista_variada= list(tupla)

print(f"convercion de tupla a lista {lista_variada}")
print(list("python"))