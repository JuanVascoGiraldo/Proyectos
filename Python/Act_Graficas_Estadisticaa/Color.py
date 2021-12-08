
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

df_archivo=pd.read_csv("Datos.csv")


def frecuenciaa():
    vel = pd.crosstab(index=(df_archivo["Color"]),columns="frecuencia")
    val= pd.crosstab(index=df_archivo["Color"],columns="frecuencia")

    plt.bar(val.index,val["frecuencia"])
    plt.xlabel("Colores")
    plt.ylabel("Frecuencia")

    plt.yticks(val["frecuencia"],val["frecuencia"])
    plt.subplots_adjust(top=0.61, bottom=0.33)
    plt.savefig("Color_Frecuencia_Absoluta.png")
    print(vel)
    plt.show()





def frecuenciar():
    vel = pd.crosstab(index=df_archivo["Color"],columns="frecuencia",normalize=True)
    plt.pie(vel["frecuencia"],labels=vel.index,autopct="%0.1f %%",textprops={'fontsize': 8})
    plt.ylabel("Color")
    plt.subplots_adjust(0,0,1,1)
    plt.savefig("Color_Frecuencia_Relativa.png")
    plt.show()



def estadistica():
    val = pd.crosstab(index=df_archivo["Color"], columns="frecuencia").sort_values(by="frecuencia", ascending=False)
    v=int((len(df_archivo)/2))
    a=df_archivo["Color"]
    print(f"La Mediana es: {a[v]}")
    s= a.iloc[2]
    print(f"La Moda es: {s}")







