import numpy as np
import matplotlib.pyplot as plt
paises = ['Estados Unidos', 'España', 'Mexico', 'Rusia', 'Japon']
ventas = [25, 32, 34, 20, 25]
fig, ax = plt.subplots()
ax.set_ylabel('Ventas')
ax.set_title('Cantidad de Ventas por Pais')
plt.bar(paises, ventas)
plt.savefig('barras_simple.png')
plt.show()