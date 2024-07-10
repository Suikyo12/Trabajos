import statistics as st 
from numpy import quantile
from numpy import mean
from numpy import std
computador_por_persona= [0,2]
sted=std(computador_por_persona)
numeros = [15,16,16,17,17,18,19,19,20,21]
mean(numeros)
qa= quantile(numeros,0.25)


print(qa)
print(sted)


