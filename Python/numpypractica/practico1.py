import numpy as np
import matplotlib.pyplot as plt
lenguajes = ['Python', 'C++', 'Java', 'Perl', 'Scala', 'Lisp']
y_pos = np.arange(len(lenguajes))
cantidad_usos = [10,8,6,4,2,1]
plt.barh(y_pos, cantidad_usos, align='center', alpha=0.5)
plt.yticks(y_pos, lenguajes)
plt.xlabel('Usuarios')
plt.title('Lenguajes Mas Usados En El Año')
plt.savefig('barras_horizontal.png')
plt.show()
