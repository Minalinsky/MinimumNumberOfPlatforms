# MinimumNumberOfPlatforms
## Compilando
#### Windows
- Pelo terminal, compilar utilizando `javac MinimumNeededPlatforms.java`
- Executar o código utilizando `java MinimumNeededPlatforms`

## Problema
Encontre o número mínimo de plataformas necessárias em uma estação de forma a evitar qualquer
atraso da chegada de qualquer trem.  
Dada uma tabela com os tempos de chegada e partida de trens em uma estação, encontre o número
mínimo de plataformas necessárias na estação de forma que sejam evitados quaisquer atrasos na
chegada de quaisquer trens.  
Exemplo:  
Chegadas = 2:00, 2:10, 3:00, 3:20, 3:50, 5:00  
Partidas = 2:30, 3:40, 3:20, 4:30, 4:00, 5:20  
Nro mínimo de plataformas é 2.  

### Exemplo
![](./img/trainsExample.png)

## Entrada e Saída
### Formato da Entrada

### Formato da Saída

## Estratégia Utilizada
- O problema foi solucionado utilizando a estratégia gulosa
- A ideia consiste em, dados os horários de Chegada e Partida dos trens, percorrê-los cronologicamente (ou seja, por ordem de horários).  Sendo assim, adicionamos um contador `currentTrains` que mantém a contagem de quantos Trens estão na estação em determinado horário.  Se o próximo Evento for a chegada de um trem na estação, aumentamos o contador; caso contrário, o diminuimos.
- Mais informações a respeito da implementação podem ser encontrados nos comentários dentro do código-fonte

#### Informações Extras
- O código fonte encontra-se sob o diretório `./src/alyson_minimum_platforms/MinimumNeededPlatforms.java`
- Para executar o código, basta baixar o projeto, adicionar na IDE de preferência (foi desenvolvido utilizando EclipseIDE - Version: 2019-06 (4.12.0)) e executá-lo.  Outra alternativa é criar um novo projeto com a IDE de preferência, importar/copiar o código-fonte do programa e executá-lo
