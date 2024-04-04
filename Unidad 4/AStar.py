import networkx as nx
import matplotlib.pyplot as plt
import pandas as pd

nodos_visitados = set()
cont = 0
inicial = None
llegado = False
def a_estrella(grafo, origen, destino):
    global cont
    global inicial
    global llegado
    if llegado is True:
        return
    if cont == 0:
        inicial = origen
    cont = 1
    try:
        nodos_visitados.add(origen)
        costo_minimo = float('inf')
        nuevoVecino = None
        for vecino in grafo.neighbors(origen): #obtiene los sucesores y su costo
            costo = grafo[origen][vecino]['costo']
            if vecino in nodos_visitados:
                continue
            if costo < costo_minimo:
                costo_minimo = costo
                nuevoVecino = vecino
            if vecino == destino:
                print("De "+origen+" a "+str(vecino) + "--"+ str(costo))
                llegado = True
                return costo
        if nuevoVecino is None:
            print("no hay mas rutas, volviendo a analizar")
            a_estrella(grafo, inicial, destino)
            return
        print("De "+origen+" a "+str(nuevoVecino) + "-"+ str(costo_minimo))
        a_estrella(grafo, nuevoVecino, destino)
    except Exception as e:
        print("Ocurrió un error:", e.args)
    return 0
# Leer el archivo CSV
datos = pd.read_csv("ciudades.csv")

# Crear el grafo
grafo = nx.from_pandas_edgelist(datos, source="origen", target="destino", edge_attr="costo")
origen = input("Ingrese la ciudad de origen: ")
destino = input("Ingrese la ciudad de destino: ")
costo_total = a_estrella(grafo, origen, destino)

# Visualizar el grafo
nx.draw(grafo, with_labels=True, node_size=300)
plt.show()