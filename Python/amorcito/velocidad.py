import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
from scipy import stats as st

def velocidad():
    df = pd.read_csv("dproblematica.csv")
    tab = pd.crosstab(index=df["velocidad"], columns="Frecuencia")
    plt.bar(tab.index, tab["Frecuencia"])
    plt.xlabel("Velocidades (frecuencia absoluta)")
    plt.show()
    plt.pie(tab["Frecuencia"], labels=tab.index, autopct="%1.1f%%")
    plt.xlabel("Velocidades (frecuencia relativa)")
    plt.show()
    mediana = np.median(df["velocidad"])
    moda = st.mode(df["velocidad"])
    media = np.mean(df["velocidad"])
    varianza = np.var(df["velocidad"])
    desviacion = np.std(df["velocidad"])
    print(f"La Mediana es: {mediana}")
    print(f"La Moda es:  {moda}")
    print(f"La Media es: {media}")
    print(f"La Varianza es: {varianza}")
    print(f"La Desviación es: {desviacion}")