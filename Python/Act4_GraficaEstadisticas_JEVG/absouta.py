import pandas as pd
import matplotlib.pyplot as plt

def mFrecuencia(parametro):
    df = pd.read_csv("datos.csv")
    if parametro == "color":
        tab = pd.crosstab(index=df["color"], columns="Frecuencia")
        print(tab)
        plt.bar(tab.index, tab["Frecuencia"])
        plt.xlabel("Colores")
        plt.show()
    if parametro == "peso":
        tab = pd.crosstab(index=df["peso"], columns="Frecuencia")
        print(tab)
        plt.bar(tab.index, tab["Frecuencia"])
        plt.xlabel("Pesos")
        plt.show()
    if parametro == "altura":
        tab = pd.crosstab(index=df["altura"], columns="Frecuencia")
        print(tab)
        plt.bar(tab.index, tab["Frecuencia"])
        plt.xlabel("Alturas")
        plt.show()
    if parametro == "velocidad":
        tab = pd.crosstab(index=df["velocidad"], columns="Frecuencia")
        print(tab)
        plt.bar(tab.index, tab["Frecuencia"])
        plt.xlabel("Velocidad")
        plt.show()