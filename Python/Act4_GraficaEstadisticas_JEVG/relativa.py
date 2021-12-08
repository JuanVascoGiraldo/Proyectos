import pandas as pd
import matplotlib.pyplot as plt

def mRelativa(parametro):
    df = pd.read_csv("datos.csv")
    if parametro == "color":
        tab = pd.crosstab(index=df["color"], columns="Frecuencia")
        print(tab)
        plt.pie(tab["Frecuencia"], labels=tab.index, autopct="%1.1f%%")
        plt.xlabel("colores")
        plt.show()
    if parametro == "peso":
        tab = pd.crosstab(index=df["peso"], columns="Frecuencia")
        print(tab)
        plt.pie(tab["Frecuencia"], labels=tab.index, autopct="%1.1f%%")
        plt.xlabel("Pesos")
        plt.show()
    if parametro == "altura":
        tab = pd.crosstab(index=df["altura"], columns="Frecuencia")
        print(tab)
        plt.pie(tab["Frecuencia"], labels=tab.index, autopct="%1.1f%%")
        plt.xlabel("Alturas")
        plt.show()
    if parametro == "velocidad":
        tab = pd.crosstab(index=df["velocidad"], columns="Frecuencia")
        print(tab)
        plt.pie(tab["Frecuencia"], labels=tab.index, autopct="%1.1f%%")
        plt.xlabel("Velocidad")
        plt.show()