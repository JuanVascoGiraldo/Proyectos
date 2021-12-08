import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

df_archivo=pd.read_csv("Datos.csv")


def frecuenciaa():
    vel = pd.crosstab(index=(df_archivo["Peso"]).round(),columns="frecuencia")
    val= pd.crosstab(index=df_archivo["Peso"],columns="frecuencia")

    plt.bar(val.index,val["frecuencia"])
    plt.xlabel("Peso")
    plt.ylabel("Frecuencia")
    plt.yticks(val["frecuencia"],val["frecuencia"])
    plt.subplots_adjust(top=0.61, bottom=0.33)
    plt.savefig("Peso_Frecuencia_Absoluta.png")
    print(vel)
    plt.show()





def frecuenciar():
    vel = pd.crosstab(index=df_archivo["Peso"],columns="frecuencia",normalize=True)
    plt.pie(vel["frecuencia"],labels=vel.index,autopct="%0.1f %%",textprops={'fontsize': 8})
    plt.ylabel("Peso")
    plt.subplots_adjust(0,0,1,1)
    plt.savefig("Peso_Frecuencia_Relativa.png")
    plt.show()




def estadistica():
    media=df_archivo["Peso"].mean()
    mediana = df_archivo["Peso"].median()
    moda = df_archivo["Peso"].mode()
    std = df_archivo["Peso"].std(ddof=0)
    var = df_archivo["Peso"].var(ddof=0)
    assert (np.sqrt(var) == std)



    print(f"La Media es: {media}")
    print(f"La Mediana es: {mediana}")
    print(f"La Moda es: {moda.to_string(index=False)}")
    print(f"La Desviacion Estandar es: {std}")
    print(f"La Varianza es: {var}")


