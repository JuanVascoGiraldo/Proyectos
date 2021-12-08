import AñadirFactura as añadir
import PagarFactura as Pagar
import Terminar as ter
facturas={}
pagadas={}
def iniciarPrograma():
    print("bienvenido que quiere realizar el dia de Hoy Pagar, Añadir, Terminar")
    accion= input()
    while accion.lower() != "terminar":
        if accion.lower() == "añadir":
            try:
                numerodefactura = int(input("Ingrese El numero de la factura"))
            except Exception:
                print("introduce Solo numeros")
                coste=-1
            while numerodefactura<0:
                try:
                    numerodefactura = int(input("Ingrese El numero de la factura"))
                except Exception:
                    print("introduce Solo numeros")
            try:
                coste = float(input("ingrese el costo"))
            except Exception:
                print("introduce Solo numeros")
                coste=-1
            while coste<0:
                try:
                    coste = float(input("ingrese el costo"))
                except Exception:
                    print("introduce Solo numeros")
                    coste = -1
            resultado= añadir.Añadir(facturas, numerodefactura, coste)

            for item in resultado.keys():
                facturas[item] = resultado.get(item)

        if accion.lower() == "pagar":
            try:
                numerodefacturas = int(input("Ingrese El numero de la factura"))
            except Exception:
                print("introduce Solo numeros")
                coste = -1
            while numerodefacturas < 0:
                try:
                    numerodefacturas = int(input("Ingrese El numero de la factura"))
                except Exception:
                    print("introduce Solo numeros")
            resultado= Pagar.Pagar(facturas, pagadas, numerodefacturas)
            re1= resultado[0]
            re2= resultado[1]
            for item in re1:
                facturas[item] = re1.get(item)
            for item in re2:
                pagadas[item] = re2.get(item)

        print("Quiere realizar una de as siguientes acciones Pagar, Añadir, Terminar")
        accion = input()
    print(f"Total Pendiente {ter.pendiente(facturas)}$")
    print(f"Total pagado {ter.pagado(pagadas)}")

iniciarPrograma()