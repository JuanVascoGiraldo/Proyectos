import pandas as pd
import numpy as np
import statistics as stat

def estadistica(parametro):
    df = pd.read_csv("datos.csv")
    if parametro == "color":
        tab = pd.crosstab(index=df["color"], columns="Frecuencia")
        data = np.array(tab["Frecuencia"])
        print(data)
        lugar = np.where(data == np.amax(data))
        print(lugar)
        moda = tab.index[lugar]
        print("La moda es \t", moda[0])
    if parametro == "peso":
        mediana = np.median(df["peso"])
        media = np.mean(df["peso"])
        desviacion = np.std(df["peso"])
        varianza = np.var(df["peso"])
        moda = stat.mode(df["peso"])
        print("La Mediana es: \t", mediana)
        print("La Medio es: \t", media)
        print("La Desviación es: \t",desviacion)
        print("La Varianza es: \t",varianza)
        print("La Moda es: \t", moda)
    if parametro == "altura":
        mediana = np.median(df["altura"])
        media = np.mean(df["altura"])
        desviacion = np.std(df["altura"])
        varianza = np.var(df["altura"])
        moda = stat.mode(df["altura"])
        print("La Mediana es: \t", mediana)
        print("La Medio es: \t", media)
        print("La Desviación es: \t", desviacion)
        print("La Varianza es: \t", varianza)
        print("La Moda es: \t", moda)
    if parametro == "velocidad":
        mediana = df["velocidad"].median()
        media = np.mean(df["velocidad"])
        desviacion = np.std(df["velocidad"])
        varianza = np.var(df["velocidad"])
        moda = stat.mode(df["velocidad"])
        print("La Mediana es: \t", mediana)
        print("La Medio es: \t", media)
        print("La Desviación es: \t", desviacion)
        print("La Varianza es: \t", varianza)
        print("La Moda es: \t", moda)