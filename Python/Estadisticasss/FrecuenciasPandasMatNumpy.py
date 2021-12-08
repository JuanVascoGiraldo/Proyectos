import pandas as pd
import matplotlib.pyplot as plt
import numpy as np

#Leer datos
df=pd.read_csv("calif.csv")

#Generar una tabla
tab=pd.crosstab(index=df["calificacion"],columns="Frecuencia")
print("DataFrame del CSV ", tab)

#Buscar el elemento
fila=tab.loc[tab.index==5]

#Obtendremos el valor "Frecuecia" de la fila
#Ejemplo número de alumnos que han sacado 5

x=fila["Frecuencia"]
x=int(x)
print("%d alumnos que han sacado 5" % x)

#Ejemplo Número de alumnos que han aprobado

y=tab.loc[tab.index>5]["Frecuencia"].sum()
y=int(y)
print("%d alumnos que han aprobado" % y)

# Grafica de pastel

tab=pd.crosstab(index=df["calificacion"],columns="Frecuencia")
aprobados=tab.loc[tab.index>5]["Frecuencia"].sum()
reprobados=tab.loc[tab.index<=5]["Frecuencia"].sum()
data=np.array([aprobados,reprobados])
plt.pie(data,labels=["Aprobados","Reprobados"],autopct="%1.1f%%")
plt.xlabel("Calificaciones")
plt.savefig("calificaciones.png")
 # código para graficar con barrar en lugar de pastel
'''plt.bar(tab.index,tab["Frecuencia"])
plt.xlabel("Calificaciones")
plt.savefig("calificaciones1.png")'''
plt.show()