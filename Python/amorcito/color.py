import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

def color():
    df = pd.read_csv("dproblematica.csv")
    tab = pd.crosstab(index=df["color"], columns="Frecuencia")
    plt.bar(tab.index, tab["Frecuencia"])
    plt.xlabel("Colores (frecuencia absoluta)")
    plt.show()
    plt.pie(tab["Frecuencia"], labels=tab.index, autopct="%1.1f%%")
    plt.xlabel("Colores(frecuencia relativa)")
    plt.show()
    repeticiones = tab["Frecuencia"]
    num= np.amax(repeticiones)
    temporal = 0
    for var in range(len(repeticiones)):
        if repeticiones[var] == num:
            temporal = var
    moda = tab.index[temporal]
    print(f"La moda de colores es \t {moda}")