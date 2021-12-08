from FiguraGeometrica import FiguraGeometrica

class Triangulo(FiguraGeometrica):

    def __init__(self, Area, Perimetro, Base, Altura, Lados):
        FiguraGeometrica.__init__(self, Area, Perimetro)
        self.Base = Base
        self.Altura= Altura
        self.Lados= Lados

    def setBase(self, Base):
        self.Base = Base

    def getBase(self):
        return self.Base

    def setAltura(self, Altura):
        self.Altura = Altura

    def getAltura(self):
        return self.Altura

    def setLados(self, Lados):
        self.Lados = Lados

    def getLados(self):
        return self.Lados

    def CalcularArea(self):
        self.setArea(((self.getBase() * self.getAltura())/2))
        return self.getArea()

    def CalcuLarPerimetro(self):
        resultado=0
        for item in self.getLados():
            resultado += item
        self.setPerimetro(resultado)
        return self.getPerimetro()
