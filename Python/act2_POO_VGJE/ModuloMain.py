from Triangulo import Triangulo
from Cuadrado import Cuadrado
from Circulo import Circulo

def ingresardatos():
    fig=input("¿de que figura desea saber su area y perimetro?, circulo, triangulo, cuadrado, o ¿desea terminar?  ")
    while fig.lower() != "terminar":
        if fig.lower() == "circulo":
            try:
                radio = float(input("ingrese El radio"))
            except Exception:
                print("introduce Solo numeros")
                radio=-1
            while radio<0:
                try:
                    radio = float(input("ingrese El radio"))
                except Exception:
                    print("introduce Solo numeros")
                    radio = -1
            cir = Circulo(0, 0, radio)
            calcular(cir)
        if fig.lower() == "triangulo":
            try:
                Base = float(input("ingrese la Base"))
            except Exception:
                print("introduce Solo numeros")
                Base=-1
            while Base<=0:
                try:
                    Base = float(input("ingrese la Base"))
                except Exception:
                    print("introduce Solo numeros")
                    Base= -1
            try:
                Altura = float(input("ingrese la Altura"))
            except Exception:
                print("introduce Solo numeros")
                Altura=-1
            while Altura<=0:
                try:
                    Altura = float(input("ingrese la Altura"))
                except Exception:
                    print("introduce Solo numeros")
                    Altura = -1
            Lados=[Base]
            for i in range(0, 2):
                try:
                    Lado=float(input("ingrese un Lado"))
                except Exception:
                    print("introduce Solo numeros")
                    Lado = -1
                while Lado <= 0:
                    try:
                        Lado = float(input("ingrese un Lado"))
                    except Exception:
                        print("introduce Solo numeros")
                        Lado = -1
                Lados.append(Lado)
            tri = Triangulo(0, 0, Base, Altura, Lados)
            calcular(tri)
        if fig.lower() == "cuadrado":
            try:
                Lados = float(input("ingrese un Lado"))
            except Exception:
                print("introduce Solo numeros")
                Lados = -1
            while Lados <= 0:
                try:
                    Lados = float(input("ingrese un Lado"))
                except Exception:
                    print("introduce Solo numeros")
                    Lados = -1
            cua = Cuadrado(0, 0, Lados)
            calcular(cua)
        fig = input("¿de que figura desea saber su area y perimetro?, circulo, triangulo, cuadrado, o ¿desea terminar?  ")

def calcular(figura):
    print(f"El area es {figura.CalcularArea()}")
    print(f"El Perimetro es { figura.CalcuLarPerimetro()}")

ingresardatos()