package com.solovev.dataStructures.BinarySearchTree;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Data
public class BinarySearchTreeNode<T extends Comparable<T>> {
    private final T data;
    /*
     * 1. All nodes in its left subtree have values less than the node.
     * 2. All nodes in its right subtree have values greater than the node.
     */
    private BinarySearchTreeNode<T> leftChild;
    private BinarySearchTreeNode<T> rightChild;

    public Optional<BinarySearchTreeNode<T>> find(T object) {
        return data.equals(object)
                ? Optional.of(this)
                : currentDataIsLarger(object)
                ? find(leftChild,object)
                : find(rightChild,object);
    }
    private boolean currentDataIsLarger(T object) {
        return data.compareTo(object) > 0; //important, since equals are inserted right
    }
    private Optional<BinarySearchTreeNode<T>> find(BinarySearchTreeNode<T> node, T object){
        return nonNull(node)
                ? node.find(object)
                : Optional.empty();
    }

    public void insert(@NonNull T data){
        if(currentDataIsLarger(data)){
            if(nonNull(leftChild)){
                leftChild.insert(data);
            } else {
                leftChild = new BinarySearchTreeNode<>(data);
            }
        } else {
            if(nonNull(rightChild)){
                rightChild.insert(data);
            } else {
                rightChild = new BinarySearchTreeNode<>(data);
            }
        }
    }
    public T max(){
        return isNull(rightChild)
                ? data
                : rightChild.max();
    }
    public T min(){
        return isNull(leftChild)
                ? data
                : leftChild.min();
    }
    public List<T> traverseInOrder(){
        List<T> result = new ArrayList<>();
        traverseInOrder(result);
        return result;
    }
    //modifies the parameter List!
    private void traverseInOrder(List<T> listToModify){
        if(nonNull(leftChild)){
            leftChild.traverseInOrder(listToModify);
        }
        listToModify.add(data);
        if(nonNull(rightChild)){
            rightChild.traverseInOrder(listToModify);
        }
    }
    public List<T> traversePreOrder(){
        List<T> result = new ArrayList<>();
        traversePreOrder(result);
        return result;
    }
    //modifies the parameter List!
    private void traversePreOrder(List<T> listToModify){
        listToModify.add(data);
        if(nonNull(leftChild)){
            leftChild.traversePreOrder(listToModify);
        }
        if(nonNull(rightChild)){
            rightChild.traversePreOrder(listToModify);
        }
    }
}
