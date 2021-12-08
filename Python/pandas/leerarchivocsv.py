import pandas as pd

import xlwt

df_archivo_1=pd.read_csv("Sacramentorealestatetransactions.csv")
print(df_archivo_1)
# primeros 5 elementos
print("primeros 5 elementos del dataframe ", df_archivo_1.head())
# 20 elementos de la lista
print("20 elementos del dataframe ", df_archivo_1.head(20))

#Los últimos t elementos
print("los últimos elementos del data frame", df_archivo_1.tail())

#Ver los tiposy de datos
print("tipos de datos del dataframe", df_archivo_1.dtypes)

#estadísticas básicas
print(df_archivo_1.describe())
print(df_archivo_1.loc[100])
print ("CIUDAD", df_archivo_1["city"])
print("CIUDAD ES SACRAMENTO",df_archivo_1["city"]=="SACRAMENTO")
city="RIO LINDA"
print("FILTRADO EN LA CONSULTA DEL DATAFRAME", df_archivo_1.query("city==@city"))
print("ORDENAR ASCENDENTE LOS REGISTROS", df_archivo_1.sort_values(by="city",ascending=True))
df_archivo_1.to_excel("aexcel.xls", sheet_name="datos")

