import absouta as ab
import relativa as re
import estadistica as es

def ingresardatos():
    print("Elije el tipo de dato estadistico que deseas consultar")
    print("1) Frecuencias Absoluta")
    print("2) Frecuencias Relativa")
    print("3) Datos Estadisticos")
    print("4) Terminar")
    try:
        y= int(input("ingresa el numero de lo deseado a consultar"))
        while y != 4:
            if y<4:
                print("Elije el parametro que deseas consultar")
                print("1) Color")
                print("2) Peso")
                print("3) Velocidad")
                print("4) Altura")
                x = int(input("ingresa el numero de lo deseado a consultar"))
                if x <5:
                    if x == 1:
                        if y == 1:
                            ab.mFrecuencia("color")
                        elif y == 2:
                            re.mRelativa("color")
                        else:
                            es.estadistica("color")
                    if x == 2:
                        if y == 1:
                            ab.mFrecuencia("peso")
                        elif y == 2:
                            re.mRelativa("peso")
                        else:
                            es.estadistica("peso")
                    if x == 3:
                        if y == 1:
                            ab.mFrecuencia("velocidad")
                        elif y == 2:
                            re.mRelativa("velocidad")
                        else:
                            es.estadistica("velocidad")
                    if x == 4:
                        if y == 1:
                            ab.mFrecuencia("altura")
                        elif y == 2:
                            re.mRelativa("altura")
                        else:
                            es.estadistica("altura")
                else:
                    print("introduce una opcion valida")
            else:
                print("introcude una opción valida")
            print("Elije el tipo de dato estadistico que deseas consultar")
            print("1) Frecuencias Absoluta")
            print("2) Frecuencias Relativa")
            print("3) Datos Estadisticos")
            print("4) Terminar")
            y = int(input("ingresa el numero de lo deseado a consultar"))
    except Exception:
        print("introduce solo numeros")
        ingresardatos()

ingresardatos()