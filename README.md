# AnReSoReG
##Análisis de Redes Sociales Representadas como Grafo

##Proyecto Electiva # 4


##Abtracto

El propósito de esta investigación, se basa en descubrir cuál es la mejor tecnología dentro de las nuevas técnicas de desarrollo  de software en  la creación de herramientas que permitan el análisis y estudio de grandes volúmenes de datos; por una parte lo tradicional o las herramientas Stand-Alone y por otra parte las herramientas con diseño para análisis de grandes volúmenes de información como Hadoop – Map and Reduce. El área a implementar este estudio es el análisis de redes sociales aplicado a la teoría de grafos, el cual nos permite predecir el comportamiento de una red social y como los nodos se relaciona entre sí mediante la graficación de estos, principalmente se los utiliza para descubrir nuevas tendencias, formas de pensamiento, afinidades, nuevos mercados o satisfacer necesidades. La muestra a utilizar en este análisis será la relación que existe dentro de los usuarios de Twitter, para este caso se ha escogido como punto focal de esta investigación a la ciudad de Guayaquil – Ecuador con el fin de que se logre confirmar las relaciones o tendencias dentro de los usuarios de esta ciudad. La metodología aplicada para el análisis de redes sociales será dividida en dos partes, la primera será un análisis básico de los datos utilizando el modelo Erdos–Renyi que busca la centralidad, la conectividad  y el agrupamiento de los nodos lo que corresponde a una graficación a gran escala de la relación de todo los usuarios aleatoriamente, y la segunda parte se basa en el cálculo del PageRank de cada uno de los datos y se grafica de nuevo para poder ver cuáles son los puntos de interés dentro de este grupo de datos. El alcance final es la comprobación sobre que herramienta facilita el análisis de datos ya sea en cantidad o volumen de información y en velocidad de análisis de la información, donde se ve una notable diferencia hacia el lado de la herramienta Hadoop y las bondades a la hora de facilitar el análisis a gran velocidad. Entre las limitaciones a este estudio fue la falta de información en el área de la herramienta Hadoop y la poca inducción sobre los temas relacionados a la investigación.

##Datos

Los datos a utilizarse en esta investigación serán provenientes de la Red Social Twitter para ello haremos uso de su API para la extracción de datos utilizando la librería Tweepy para Python. Cabe destacar que la API de Twitter tiene algunas restricciones al momento de la extracción de información, estos pueden ser que tiene un límite máximo de 5000 dataset por consulta además de un tiempo de espera de 15 minutos una vez superado el límite de dataset, la información que muestra la API son solo de las cuentas que están configuradas como públicas.
Los datos fueron tomados de Twitter de la Siguiente forma:

1.- Se procedió a tomar una muestra durante 15 días de todos los usuario que publicaban y retuitean información utilizando un     algoritmo en Python.

2.-Se procedió a clasificar por ciudades y se opta usar Guayaquil como punto focal de la investigación.

3.-La información a recolectar fue la siguiente de cada perfil:
  * Id Usuario
  * Imagen Usuario
  * Screen Name Usuario
  * User Name Usuario
  * Fecha de Creación
  * Descripción del Usuario
  * Fecha de Creación de la Cuenta
  * Amigos
  * Ubicación

4.- Se procedió a descargar los amigos de cada Usuario para utilizarlos como relación entre cada individuo a fin de realizar el grafo intepretando estas relaciones.

## Pasos a Seguir

1ro Descargar R
https://cran.r-project.org/bin/windows/base/

2do Abrir R y instalar el paquete igraph
Cargar paquete igraph en R, http://igraph.org/r/
install.packages("igraph")

3ro El archivo de datos adjunto ponerlo en la ruta C:\

4to pegar y ejecutar el codigo en R



 
