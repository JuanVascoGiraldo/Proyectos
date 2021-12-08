from sklearn import linear_model
from sklearn.metrics import mean_squared_error, r2_score
import mysql.connector
from mysql.connector import errorcode
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
def conectar():
    host = '127.0.0.1'
    password = '03042021'
    user = 'root'
    nombrebd = 'fitracker'
    try:
        miconexion = mysql.connector.connect(user=user, password=password, host=host,
                                             database=nombrebd)
        print("la base de datos se conectó satisfactoriamente")
        return miconexion
    except mysql.connector.Error as err:
        if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
            print("Error con el usuario o password")
        elif err.errno == errorcode.ER_BAD_DB_ERROR:
            print("La base de datos no existe")
        else:
            print(err)
        return None


try:
    con = conectar()
    cursor = con.cursor()
    cursor.execute("Select dia, cantidad from cantidadcaloria where id_usu = %s", (2,))
    data = cursor.fetchall()
    if len(data) >= 10:
        lista1 = []
        lista2 = []
        for i in data:
            lista1.append(((i[0]).split("/"))[0])
            lista2.append(i[1])
        plt.rcParams['figure.figsize'] = (10, 5)
        plt.style.use('ggplot')
        tamanios = [30, 31]
        plt.scatter(lista1, lista2,  s=tamanios[0])
        df = pd.DataFrame()
        df ["dia"] = lista1
        df ["cantidad"] = lista2
        dataX = df[["dia"]]
        X_train = np.array(dataX)
        y_train = df['cantidad'].values
        regr = linear_model.LinearRegression()
        regr.fit(X_train, y_train)
        y_pred = regr.predict(X_train)
        print('Coefficients: \n', regr.coef_)
        print('Independent term: \n', regr.intercept_)
        x = range(0, 31)
        lista3 = []
        for i in x:
            lista3.append(regr.coef_ * i + regr.intercept_)
        plt.plot(x, lista3)
        plt.axhline(0, color="black")
        plt.axvline(0, color="black")
        plt.xlim(0, 31)
        plt.xlabel("Dias")
        plt.ylabel("Cantidad de Calorias")
        plt.show()
        y_t = regr.predict([[30]])
        print("Si sigues con este ritmo en 30 dias quemaras ", y_t [0], " Calorias")


except mysql.connector.Error as err:
    if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
        print("Error con el usuario o password")
    elif err.errno == errorcode.ER_BAD_DB_ERROR:
        print("La base de datos no existe")
    else:
        print(err)
