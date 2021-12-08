import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
from scipy import stats as st

def peso():
    df = pd.read_csv("dproblematica.csv")
    tab = pd.crosstab(index=df["peso"], columns="Frecuencia")
    plt.bar(tab.index, tab["Frecuencia"])
    plt.xlabel("Pesos (frecuencia absoluta)")
    plt.show()
    plt.pie(tab["Frecuencia"], labels=tab.index, autopct="%1.1f%%")
    plt.xlabel("Pesos (frecuencia relativa)")
    plt.show()
    mediana = np.median(df["peso"])
    moda = st.mode(df["peso"])
    media = np.mean(df["peso"])
    varianza = np.var(df["peso"])
    desviacion = np.std(df["peso"])
    print(f"La Mediana es: {mediana}")
    print(f"La Moda es:  {moda}")
    print(f"La Media es: {media}")
    print(f"La Varianza es: {varianza}")
    print(f"La Desviación es: {desviacion}")

