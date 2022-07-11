# 💠 Lista Encadeada

- This content is available in [American English 🇺🇸](linkedlist_en-us.md).

![Ilustração de uma lista encadeada com 4 elementos, onde cada elemento aponta para o próximo](../images/linkedlist.png "Representação gráfica de uma lista encadeada")

### 📝 Breve descrição

Esta é uma estrutura de dados onde a ordem dos elementos não é ditada pela ordem física dos mesmos na
memória do computador. Ao invés disso, cada elemento "aponta" para o próximo. Chamamos cada elemento dessa estrutura de
dados de "nó", pois ele possui o valor do elemento em si, e um ponteiro para o próximo nó.

O ponto forte dessa estrutura de dados é a velocidade para adicionar/remover elementos, uma vez que eles não precisam
ser realocados fisicamente na memória ou no disco.

Por outro lado, como os elementos não são armazenados fisicamente em ordem, inserir um elemento no meio da estrutura
ou até mesmo o simples ato de buscar um elemento através do seu respectivo índice requer uma iteração pela maioria,
senão todos, os elementos da lista.

## ♨️️ Métodos disponíveis no código fonte

- ### `size()`

Retorna o tamanho atual da lista.

- ### `get(index)`

Recupera um elemento da lista a partir de um índice.

- ### `insert(index, element)`

Insere um elemento na lista em um determinado índice.

- ### `remove(index)`

Remove o elemento do determinado índice e retorna o mesmo.

- ### `replace(index, element)`

Substitui o elemento de um determinado índice por outro elemento e retorna o elemento que foi substituído.

- ### `append(element)`

Adiciona um elemento no fim da lista.

- ### `prepend(element)`

Adiciona um elemento no começo da lista.

- ### `removeLast()`

Remove o último elemento da lista e retorna o mesmo.

- ### `removeFirst()`

Remove o primeiro elemento da lista e retorna o mesmo.

- ### `reverse()`

Inverte a ordem da lista. O primeiro elemento se torna o último, e o último elemento se torna o primeiro.