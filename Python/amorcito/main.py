import peso as peso
import velocidad as velocidad
import altura as altura
import color as color

def iniciar():
    print("Elije entre los posibles opciones la opción que deseas saber sus datos estadisticos")
    print("peso\nvelocidad\naltura\ncolor\nterminar")
    opcion = input("escribe en la opcion")
    while opcion.lower() != "terminar":
        if opcion.lower() == "peso":
            peso.peso()
        if opcion.lower() == "velocidad":
            velocidad.velocidad()
        if opcion.lower() == "altura":
            altura.altura()
        if opcion.lower() == "color":
            color.color()
        print("Elije entre los posibles opciones la opción que deseas saber sus datos estadisticos")
        print("peso\nvelocidad\naltura\npeso\nterminar")
        opcion = input("escribe en la opcion")

iniciar()