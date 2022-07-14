# 💠 Lista Duplamente Encadeada

- This content is available in [American English 🇺🇸](doublylinkedlist_en-us.md).

![Ilustração de uma lista duplamente encadeada com 4 elementos, onde cada elemento possui dois ponteiros, apontando para o elemento anterior e para o próximo](../images/doublylinkedlist.wepb "Representação gráfica de uma lista duplamente encadeada")

### 📝 Breve descrição

Esta estrutura de dados é basicamente a mesma quando comparada a uma [Lista Encadeada](linkedlist_pt-br), com a
principal diferença sendo os ponteiros dos nós: agora cada nó aponta para o nó anterior também, ao invés de apontar
apenas para o próximo.

Essa diferença traz imensas melhorias de eficiência: adicionar/remover um elemento do começo/final da lista se torna uma
operação de tempo constante (O¹), pois não é necessário iterar sobre os elementos da lista.

Também há uma imensa melhoria quanto a recuperação de um elemento a partir de seu índice. Como os nós apontam para o nó
anterior, é possível determinar a melhor maneira de percorrer a lista na busca de um elemento: começando pelo começo da
lista (head), ou pelo final da lista (tail), baseado no índice do elemento.

Para ilustrar essa diferença de eficiência, considere uma Lista Duplamente Encadeada com 1.000.000 elementos. Para
recuperar o penúltimo elemento dessa lista, apenas 2 iterações seriam necessárias. Para recuperar esse mesmo elemento em
uma [Lista Encadeada](linkedlist_pt-br), seriam necessárias 999.998 iterações.

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