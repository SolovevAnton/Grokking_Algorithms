package com.solovev.dataStructures.LinkedList;

import java.util.Objects;

/**
 * Represents node for the linked list
 */
public class LinkedListNode<T> {
    private LinkedListNode<T> prevLinkedListNode;
    private LinkedListNode<T> nextLinkedListNode;
    private T data;

    public LinkedListNode(LinkedListNode<T> prevLinkedListNode, LinkedListNode<T> nextLinkedListNode, T data) {
        this.prevLinkedListNode = prevLinkedListNode;
        this.nextLinkedListNode = nextLinkedListNode;
        this.data = data;
    }
    public LinkedListNode<T> getPrevNode() {
        return prevLinkedListNode;
    }

    public void setPrevNode(LinkedListNode<T> prevLinkedListNode) {
        this.prevLinkedListNode = prevLinkedListNode;
    }

    public LinkedListNode<T> getNextNode() {
        return nextLinkedListNode;
    }

    public void setNextNode(LinkedListNode<T> nextLinkedListNode) {
        this.nextLinkedListNode = nextLinkedListNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinkedListNode<?> linkedListNode = (LinkedListNode<?>) o;

        if (!Objects.equals(prevLinkedListNode, linkedListNode.prevLinkedListNode)) return false;
        if (!Objects.equals(nextLinkedListNode, linkedListNode.nextLinkedListNode)) return false;
        return Objects.equals(data, linkedListNode.data);
    }

    @Override
    public int hashCode() {
        int result = prevLinkedListNode != null ? prevLinkedListNode.hashCode() : 0;
        result = 31 * result + (nextLinkedListNode != null ? nextLinkedListNode.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    /**
     * To string represents ONLY data
     * @return data in the node
     */
    @Override
    public String toString() {
        return  data.toString();
    }
}
