
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

df_archivo=pd.read_csv("Datos.csv")


def frecuenciaa():
    vel = pd.crosstab(index=(df_archivo["Altura"]).round(),columns="frecuencia")
    val= pd.crosstab(index=df_archivo["Altura"],columns="frecuencia")

    plt.bar(val.index,val["frecuencia"])
    plt.xlabel("Altura")
    plt.ylabel("Frecuencia")
    plt.yticks(val["frecuencia"],val["frecuencia"])
    plt.subplots_adjust(top=0.61, bottom=0.33)
    plt.savefig("Altura_Frecuencia_Absoluta.png")
    print(vel)
    plt.show()





def frecuenciar():
    vel = pd.crosstab(index=df_archivo["Altura"],columns="frecuencia",normalize=True)
    plt.pie(vel["frecuencia"],labels=vel.index,autopct="%0.1f %%",textprops={'fontsize': 8})
    plt.ylabel("Altura")
    plt.subplots_adjust(0,0,1,1)
    plt.savefig("Altura_Frecuencia_Relativa.png")
    plt.show()




def estadistica():
    media = df_archivo["Altura"].mean()
    mediana = df_archivo["Altura"].median()
    moda = df_archivo["Altura"].mode()
    std = df_archivo["Altura"].std(ddof=0)
    var = df_archivo["Altura"].var(ddof=0)
    assert (np.sqrt(var) == std)
    print(f"La Media es: {media}")
    print(f"La Mediana es: {mediana}")
    print(f"La Moda es: {moda.to_string(index=False)}")
    print(f"La Desviacion Estandar es: {std}")
    print(f"La Varianza es: {var}")




