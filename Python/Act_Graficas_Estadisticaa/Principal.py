import Velocidad as  v
import Peso as p
import Altura as a
import Color as c
def menu():
    f = input("Seleccione los Datos a Visualisar"
                  "\n1. Peso\n2. Altura\n3. Velocidad"
                  "\n4. Color\n5. Salir")
    if f == "1":
         Peso()
    elif f == "2":
        Altura()
    elif f == "3":
        Velocidad()
    elif f == "4":
        Color()
    elif f == "5":
        exits()
    else:
        print("Error escriba alguno de los numeros disponibles")
        menu()

def Color():
    f = input("Seleccione la Estadistica a Visualisar"
              "\n1. Frecuencia Absoluta\n2. Frecuencia Relativa\n3. Moda y Mediana."
              "\n4. Regresar al menu principal"
              )
    if f == "1":
        c.frecuenciaa()
        Color()
    elif f == "2":
        c.frecuenciar()
        Color()
    elif f == "3":
        c.estadistica()
        Color()
    elif f == "4":
        menu()
    else:
        print("Error escriba alguno de los numeros disponibles")
        Velocidad()


def Velocidad():
    f = input("Seleccione la Estadistica a Visualisar"
              "\n1. Frecuencia Absoluta\n2. Frecuencia Relativa\n3. Moda,Media,Mediana,Varianza,Desviación Estándar."
              "\n4. Regresar al menu principal"
              )
    if f == "1":
        v.frecuenciaa()
        Velocidad()
    elif f == "2":
        v.frecuenciar()
        Velocidad()
    elif f == "3":
        v.estadistica()
        Velocidad()
    elif f == "4":
        menu()
    else:
        print("Error escriba alguno de los numeros disponibles")
        Velocidad()

def Altura():
    f = input("Seleccione la Estadistica a Visualisar"
              "\n1. Frecuencia Absoluta\n2. Frecuencia Relativa\n3. Moda,Media,Mediana,Varianza,Desviación Estándar."
              "\n4. Regresar al menu principal"
              )
    if f == "1":
        a.frecuenciaa()
        Altura()
    elif f == "2":
        a.frecuenciar()
        Altura()
    elif f == "3":
        a.estadistica()
        Altura()
    elif f == "4":
        menu()
    else:
        print("Error escriba alguno de los numeros disponibles")
        Peso()


def Peso():
    f = input("Seleccione la Estadistica a Visualisar"
              "\n1. Frecuencia Absoluta\n2. Frecuencia Relativa\n3. Moda,Media,Mediana,Varianza,Desviación Estándar."
              "\n4. Regresar al menu principal"
              )
    if f == "1":
        p.frecuenciaa()
        Peso()
    elif f == "2":
        p.frecuenciar()
        Peso()
    elif f == "3":
        p.estadistica()
        Peso()
    elif f == "4":
        menu()
    else:
        print("Error escriba alguno de los numeros disponibles")
        Peso()

def exits():
    f=input("Seguro que desea salir (SI = 1/NO = 0)")
    if f=="1":
        exit()
    if f=="0" :
        menu()
    else:
        print("Error escriba alguno de los numeros pedidos disponibles")
        menu()

menu()