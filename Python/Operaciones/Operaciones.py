class Operaciones:
    def __init__(self, parametros):
        self.paametros = parametros
    def realizarOperacion(self, parametros):
        respuesta = 0
        for num in parametros:
            respuesta += num
        if(respuesta != 0):
            return respuesta
        else:
            return 0