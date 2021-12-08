import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
from scipy import stats as st

def altura():
    df = pd.read_csv("dproblematica.csv")
    tab = pd.crosstab(index=df["altura"], columns="Frecuencia")
    plt.bar(tab.index, tab["Frecuencia"])
    plt.xlabel("Alturas (frecuencia absoluta)")
    plt.show()
    plt.pie(tab["Frecuencia"], labels=tab.index, autopct="%1.1f%%")
    plt.xlabel("Alturas (frecuencia relativa)")
    plt.show()
    mediana = np.median(df["altura"])
    moda = st.mode(df["altura"])
    media = np.mean(df["altura"])
    varianza = np.var(df["altura"])
    desviacion = np.std(df["altura"])
    print(f"La Mediana es: {mediana}")
    print(f"La Moda es:  {moda}")
    print(f"La Media es: {media}")
    print(f"La Varianza es: {varianza}")
    print(f"La Desviación es: {desviacion}")