from FiguraGeometrica import FiguraGeometrica
class Cuadrado(FiguraGeometrica):

    def __init__(self, Area, Perimetro, Lado):
        FiguraGeometrica.__init__(self, Area, Perimetro)
        self.Lado = Lado

    def getLado(self):
        return self.Lado

    def setLado(self, Lado):
        self.Lado = Lado

    def CalcularArea(self):
        self.setArea((self.getLado() * self.getLado()))
        return self.getArea()

    def CalcuLarPerimetro(self):
        self.setPerimetro(self.getLado() * 4)
        return self.getPerimetro()