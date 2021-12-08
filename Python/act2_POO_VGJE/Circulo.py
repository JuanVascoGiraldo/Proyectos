import math

from FiguraGeometrica import FiguraGeometrica
class Circulo(FiguraGeometrica):

    def __init__(self, Area, Perimetro, Radio):
        FiguraGeometrica.__init__(self, Area, Perimetro)
        self.Radio = Radio

    def getRadio(self):
        return self.Radio

    def setRadio(self, Radio):
        self.Radio = Radio

    def CalcularArea(self):
        self.setArea((((math.pi)*(self.getRadio()**2))))
        return self.getArea()

    def CalcuLarPerimetro(self):
        self.setPerimetro(((math.pi)* 2 * self.getRadio()))
        return self.getPerimetro()