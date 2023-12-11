package com.solovev.dataStructures.LinkedList;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiFunction;

public class MyLinkedList<E> implements Iterable<E> {
    private final static int INT_IF_NOT_FOUND = -1;
    private LinkedListNode<E> firstLinkedListNode;
    private LinkedListNode<E> lastLinkedListNode;
    private int size;

    /**
     * Adds data to list
     *
     * @param elem to add
     */
    public void add(E elem) {
        LinkedListNode<E> linkedListNodeToAdd = new LinkedListNode<>(null, null, elem);
        if (firstLinkedListNode == null) {
            firstLinkedListNode = linkedListNodeToAdd;
        } else {
            linkedListNodeToAdd.setPrevNode(lastLinkedListNode);
            lastLinkedListNode.setNextNode(linkedListNodeToAdd);
        }
        lastLinkedListNode = linkedListNodeToAdd;
        size++;
    }

    /**
     * Adds element on the place of the index
     *
     * @param index to place element
     * @param elem  element to put
     * @throws IndexOutOfBoundsException if index is < 0 or more than size of the collection
     */
    public void add(int index, E elem) {
        if (index == size) {
            this.addLast(elem);
        } else if (index == 0) {
            this.addFirst(elem);
        } else {
            LinkedListNode<E> linkedListNodeAtPosition = getNode(index); //index is checked in this method
            LinkedListNode<E> linkedListNodeToInsert = new LinkedListNode<>(linkedListNodeAtPosition.getPrevNode(), linkedListNodeAtPosition, elem);

            linkedListNodeAtPosition.getPrevNode().setNextNode(linkedListNodeToInsert);
            linkedListNodeAtPosition.setPrevNode(linkedListNodeToInsert);
            size++;
        }
    }

    /**
     * Adds element as first element in list
     *
     * @param elem element to add
     */
    public void addFirst(E elem) {
        LinkedListNode<E> linkedListNodeToAdd = new LinkedListNode<>(null, firstLinkedListNode, elem);
        firstLinkedListNode.setPrevNode(linkedListNodeToAdd);
        firstLinkedListNode = linkedListNodeToAdd;
        size++;
    }

    /**
     * Adds element as last element in collection
     *
     * @param elem element to add
     */
    public void addLast(E elem) {
        this.add(elem);
    }

    /**
     * Adds all to the collection, in the end of the collection
     *
     * @param elements elements to add
     */
    public void addAll(Iterable<E> elements) {
        elements.forEach(this::add);
    }

    /**
     * Adds all to the collection, beggining with specified index
     *
     * @param index    to start
     * @param elements elements to add
     */
    public void addAll(int index, Iterable<E> elements) {
        if (index != size) {
            checkIndex(index);
        }
        int counter = index;
        for (E element : elements) {
            this.add(counter++, element);
        }
    }

    /**
     * Removes element with given index
     *
     * @param index to remove element
     * @return removed element
     */
    public E remove(int index) {
        checkIndex(index);
        if (index == 0) {
            return this.poll();
        } else if (index + 1 == size) { // +1 since index starts from 0
            return this.pollLast();
        } else {
            LinkedListNode<E> oldLinkedListNode = this.getNode(index);
            //rebinds prev node to next and next to prev
            oldLinkedListNode.getPrevNode().setNextNode(oldLinkedListNode.getNextNode());
            oldLinkedListNode.getNextNode().setPrevNode(oldLinkedListNode.getPrevNode());

            size--;
            return oldLinkedListNode.getData();
        }
    }

    /**
     * Removes element from the collection
     *
     * @param elem to remove
     * @return true if element was successfully removed, false if it is presented in the collection
     */
    public boolean removeObj(E elem) {
        int index = this.indexOf(elem);
        if (index != INT_IF_NOT_FOUND) {
            this.remove(index);
        }
        return index != INT_IF_NOT_FOUND;
    }

    /**
     * removes from this collection all elements found in the given collection
     *
     * @param elements to remove
     */
    public void removeAll(Iterable<E> elements) {
        elements.forEach(this::removeObj);
    }

    /**
     * return and deletes the first element in the list
     *
     * @return first element in the queue or null if collection is empty
     */
    public E poll() {
        if (size == 0) {
            return null;
        }
        LinkedListNode<E> oldElement = firstLinkedListNode;
        firstLinkedListNode = oldElement.getNextNode();
        if (firstLinkedListNode != null) {
            firstLinkedListNode.setPrevNode(null);
        }
        size--;
        return oldElement.getData();

    }

    /**
     * return and deletes the last element in the list
     *
     * @return last element in the queue or null if collection is empty
     */
    public E pollLast() {
        if (size == 0) {
            return null;
        }
        LinkedListNode<E> oldElement = lastLinkedListNode;
        lastLinkedListNode = oldElement.getPrevNode();
        lastLinkedListNode.setNextNode(null);
        size--;
        return oldElement.getData();
    }

    /**
     * Gets element on the given index
     *
     * @param index of the element to get
     * @return element on the given index
     * @throws IndexOutOfBoundsException if index is < 0 or more than size of the collection
     */
    public E get(int index) {
        return getNode(index).getData();
    }

    /**
     * Gets the first element in queue without deleting it, null if queue is empty
     *
     * @return first element in queue without deleting it, null if queue is empty
     */
    public E peek() {
        return size > 0 ? this.get(0) : null;
    }

    /**
     * Gets the last element in queue without deleting it, null if queue is empty
     *
     * @return last element in queue without deleting it, null if queue is empty
     */
    public E peekLast() {
        return size > 0 ? this.get(size - 1) : null; //-1 since index starts from 0
    }

    /**
     * Searches for the given element in the collection
     *
     * @param elem element to find
     * @return index of the element, or -1 if element wasn't found
     */
    public int indexOf(E elem) {
        Iterator<E> iterator = iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            if (iterator.next().equals(elem)) {
                return i;
            }
        }
        return INT_IF_NOT_FOUND; // if reached, means elem not found
    }

    /**
     * Searches for given element in the collection
     *
     * @param elem to search for
     * @return true if element is presented fasle otherwise
     */
    public boolean contains(E elem) {
        return this.indexOf(elem) != INT_IF_NOT_FOUND;
    }

    /**
     * Searches for all elements from given collection in this collection
     *
     * @param elems collection to search
     * @return true if all elements in param collection are presented in the underlying collection
     */
    public boolean containsAll(Iterable<E> elems) {
        for (E elem : elems) {
            if (!this.contains(elem)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Keeps in the collection only elements which were found in the other collection. The collection will be empty if nothing has matched
     *
     * @param elements to keep all matching elements from
     */
    public void retainAll(Iterable<E> elements) {
        BiFunction<Iterable<E>, E, Boolean> contains = (iter, elem) -> { //todo Better here or in separate method?
            for (E e : iter) {
                if (Objects.equals(e, elem)) {
                    return true;
                }
            }
            return false;
        };

        for (E elem : this) {
            if (!contains.apply(elements, elem)) {
                this.removeObj(elem);
            }
        }
    }

    /**
     * Gets Node element on the given index
     *
     * @param index of the element to get
     * @return Node element on the given index
     * @throws IndexOutOfBoundsException if index is < 0 or more than size of the collection
     */
    public LinkedListNode<E> getNode(int index) {
        checkIndex(index);
        LinkedListNode<E> currentLinkedListNode = firstLinkedListNode;
        for (int i = 0; i < index; i++) {//can be done with iterator
            currentLinkedListNode = currentLinkedListNode.getNextNode();
        }
        return currentLinkedListNode;
    }

    /**
     * Checks index and throws if the index is < 0 or >= size of the collection
     *
     * @param index to check
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Method to see size of the collection
     *
     * @return size of the collection
     */
    public int size() {
        return size;
    }

    /**
     * Method to iterate throw collection
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            LinkedListNode<E> nextLinkedListNode = firstLinkedListNode;

            @Override
            public boolean hasNext() {
                return Objects.nonNull(nextLinkedListNode);
            }

            @Override
            public E next() {
                LinkedListNode<E> returnLinkedListNode = nextLinkedListNode;
                nextLinkedListNode = hasNext() ? returnLinkedListNode.getNextNode() : null;
                return returnLinkedListNode.getData();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<E> iterator = this.iterator();
        String delimiter = ", ";

        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(delimiter);
            }
        }

        return "MyLinkedList{" +
                sb +
                '}';
    }
}
