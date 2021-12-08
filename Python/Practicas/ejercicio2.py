meses= {"Enero": 0.95 , "Febrero": 0.9, "Marzo":0.95, "Abril": 0.85, "Mayo": 0.9, "Junio": 0.8,
         "Julio": 0.75, "Agosto": 0.8, "Septiembre": 0.75, "Octubre": 0.8, "Noviembre": 0.7, "Diciembre": 0.7}

def recibirdatos():
    mes = input("ingrese el mes de la compra")
    while (not(mes in meses.keys())):
        print("no se encuentra el mes, vuelve a intentarlo, escribe la primera letra del nombre en mayuscula")
        mes = input("ingrese el mes de la compra")
    importe = float(input("ingresa la cantidad del importe"))
    while (importe<0):
        importe = float(input("ingresa la cantidad del importe"))

    return [mes, importe]

def aplicardescuento(mes, importe):

    return meses.get(mes) * importe

n= recibirdatos()

print(f"el total a pagar es {aplicardescuento(*n)}$")