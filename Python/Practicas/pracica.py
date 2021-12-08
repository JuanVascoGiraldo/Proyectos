Pagar = float(input("Ingrese El Total a Pagar"))
mes= input("ingrese el Mes en que se hizo la compra")
descuento= ["octubre", "Octubre"]
if mes in descuento:
    Pagar *= 0.85
    print(f"Si Aplica para descuento")
    print(f"El total a pagar es {Pagar}$")
else:
    print(f"No aplica para Descuento")
    print(f"El total a pagar es {Pagar}$")