import suma as Operaciones
class multiplicar(Operaciones.Suma):
    def __init__(self, parametros):
        Operaciones.Suma.__init__(parametros)
    def realizarOperacion(self,multiplicado, cantidad):
        num = 0
        for x in range(cantidad-1):
            num += multiplicado
        return num


