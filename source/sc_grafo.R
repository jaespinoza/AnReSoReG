#---------------------------------------------------------------
# carga libreria y datos de dropbox 
library(igraph)
datos <- read.csv("C:/Twitter_network_R.csv")
 
#---------------------------------------------------------------
# crea objeto de grafo con solo 50 observaciones de ejemplo
grafo <- graph.data.frame(datos[1:50,])
 
#---------------------------------------------------------------
# grafica objeto de grafo como ejemplo
plot(grafo,layout=layout.fruchterman.reingold, vertex.size=8, vertex.label.dist=0.4, vertex.color="red", edge.arrow.size=0.5)
 
#---------------------------------------------------------------
# calcula page rank
pr.tmp <- data.frame(pr.value= page.rank(grafo)$vector)
pr     <- data.frame(pr.desc=row.names(pr.tmp), pr.val = pr.tmp[,1])
head(pr[order(pr$pr.val,decreasing = T),]) #imprime los 6 usuarios mas relevantes
 
#---------------------------------------------------------------
# grafica interacciones usando valor page.rank para tamaños en grafico
V(grafo)$label.cex =  0.6 + pr$pr.val*3 # tamaño de letra segun page.rank
plot(grafo,layout=layout.fruchterman.reingold, vertex.size=pr$pr.val*100, vertex.label.dist=0.4, vertex.color="red", edge.arrow.size=0.3)