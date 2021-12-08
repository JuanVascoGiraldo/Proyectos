def ingresarnumero():
    n= int(input("ingrese el numero a multiplicar"))
    while n<0:
        print(f"no se puede introducir numeros negativos")
        n = int(input("ingrese el numero a multiplicar"))

    n2 = int(input("ingrese el numero de veces a multiplicar"))
    while n2 < 0:
        print(f"no se puede introducir numeros negativos")
        n2 = int(input("ingrese el numero de veces a multiplicar"))

    return [n , n2]

def multiplicar(multiplicado, cantidad):
    if (cantidad==0 or multiplicado==0):
        return 0
    else:
        return multiplicado + multiplicar(multiplicado, cantidad-1)

n = ingresarnumero()
print(f"El resultado de la mutiplicacion es: {multiplicar(*n)}")