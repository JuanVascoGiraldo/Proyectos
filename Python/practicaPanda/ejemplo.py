import pandas as pd

import xlwt
#Elizalde Hernández Alan
#García García Aram Jesua
#Gutiérrez Bueno Elizabeth Andrea
#Hernández Martínez Brian Arturo
#Vasco Giraldo Juan Esteban
#Zamudio López Leonardo

df_archivo_1=pd.read_csv("titanic.csv")
print("Las dimensiones del archivo es; \n", df_archivo_1.shape)

print("el numero de datos es; \n", len(df_archivo_1.index)+1)
print("Las columnas son: \n", df_archivo_1.columns)
print("tipos de datos del dataframe\n", df_archivo_1.dtypes)
print("primeros 5 elementos del dataframe \n", df_archivo_1.head(10))
print("los últimos elementos del data frame\n", df_archivo_1.tail(10))
id= 148
print("FILTRADO EN LA CONSULTA DEL DATAFRAME \n", df_archivo_1.query("PassengerId==@id"))

for owo in df_archivo_1.index:
    if((owo+1) %2 == 0):
        uwu= owo+1
        print("Las Filas Pares son \n", df_archivo_1.query("index == @uwu"))

p = 1

print("Los Pasajeros en primera clase son \n", df_archivo_1.sort_values(by="Name",ascending=True).query("Pclass==@p"))
print( df_archivo_1['Survived'].value_counts()/ df_archivo_1['Survived'].count() * 100)
print( df_archivo_1.groupby('Pclass')['Survived'].value_counts(normalize=True))
df_archivo_1.dropna(subset=['Age'])
print( df_archivo_1.groupby(['Pclass','Sex'])['Age'].mean().unstack()['female'])
df_archivo_1['Young'] =  df_archivo_1['Age'] < 18
print( df_archivo_1.groupby(['Pclass', 'Young'])['Survived'].value_counts(normalize = True) * 100)
df_archivo_1.to_excel("titanic_excel.xls", sheet_name="titanic")












