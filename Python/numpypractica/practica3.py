import numpy as np
import matplotlib.pyplot as plt

asistencia = ['Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes']
men_means = [20, 34, 30, 35, 27]
women_means = [25, 32, 34, 20, 25]
x = np.arange(len(asistencia))
width = 0.35
fig, ax = plt.subplots()
rects1 = ax.bar(x - width / 2, men_means, width, label='Hombres')
rects2 = ax.bar(x + width / 2, women_means, width, label='Mujeres')
ax.set_ylabel('Asistencia')
ax.set_title('Asistencia de Hombres y Muejes')
ax.set_xticks(x)
ax.set_xticklabels(asistencia)
ax.legend()


def autolabel(rects):
    """Funcion para agregar una etiqueta con el valor en cada barra"""
    for rect in rects:
        height = rect.get_height()
        ax.annotate('{}'.format(height),
                    xy=(rect.get_x() + rect.get_width() / 2, height),
                    xytext=(0, 3), 
                    textcoords="offset points",
                    ha='center', va='bottom')
autolabel(rects1)
autolabel(rects2)
fig.tight_layout()
plt.savefig('doble_barra.png')
plt.show()