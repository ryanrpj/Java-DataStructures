# 💠 Doubly Linked List

- Este conteúdo está disponível em [português do Brasil 🇧🇷](doublylinkedlist_pt-br.md).

![Illustration of a linked list with 4 elements, where each element points both to previous and next element](../images/doublylinkedlist.wepb "Graphical representation of a doubly linked list")

### 📝 Brief overview

This data structure is basically the same as a [Singly Linked List](linkedlist_en-us.md), with a key difference: instead of
each node pointing only to the next node, now they point on both directions: to the previous node, and to the next node.

This difference brings massive efficiency changes: removing/adding an element to the beginning/end of the list no longer
requires iterating through all elements, both these operations are now constant time (O¹).

There are also massive efficiency changes as to retrieving an element by its index. As each node now points to the
previous node as well, it's possible to determine the best way to iterate through the elements: from the beginning of
the list (head), or from the end of the list (tail), depending on the provided index.

To illustrate this change, consider a Doubly Linked List with 1,000,000 elements. If you were to retrieve the
penultimate element of this list, it would only take 2 iterations to find it. This same retrieval operation would take
999,998 iterations if performed by a [Singly Linked List](linkedlist_en-us.md).

## ♨️️ Available methods on source code

- ### `size()`

Gets the current amount of elements within the list.

- ### `get(index)`

Gets the element at the specified index.

- ### `insert(index, element)`

Inserts an element at the specified index.

- ### `remove(index)`

Removes the element at the specified index and returns it.

- ### `replace(index, element)`

Replace the element at the specified index and returns it.

- ### `append(element)`

Adds an element to the end of the list.

- ### `prepend(element)`

Adds an element to the beginning of the list.

- ### `removeLast()`

Removes the last element from the list and returns it.

- ### `removeFirst()`

Removes the first element from the list and returns it.

- ### `reverse()`

Reverse the order of the elements of the list. The last element becomes the first, and the first element becomes the
last.