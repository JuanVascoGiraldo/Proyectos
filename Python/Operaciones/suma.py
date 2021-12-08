import Operaciones as Operaciones
class Suma(Operaciones):
    def __init__(self, parametros):
        Operaciones.__init__(parametros)

    def realizarOperacion(self, parametros):
        respuesta = 0
        for num in parametros:
            respuesta += num
        return respuesta
