package com.solovev.dataStructures.BinarySearchTree;

import lombok.Data;

@Data
public class BinarySearchTreeNode<T extends Comparable<T>>{
    private final T data;
    private BinarySearchTreeNode<T> leftChild;
    private BinarySearchTreeNode<T> rightChild;
}
