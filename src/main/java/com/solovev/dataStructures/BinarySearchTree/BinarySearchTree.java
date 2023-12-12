package com.solovev.dataStructures.BinarySearchTree;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;
import java.util.Optional;

public record BinarySearchTree<T extends Comparable<T>>(@NonNull BinarySearchTreeNode<T> root) {
        public void insert(T object){
            root.insert(object);
        }
        public Optional<BinarySearchTreeNode<T>> find(T data){
            return root.find(data);
        }
        public boolean remove(T data){ //todo implement
            return true;
        }
        public T max(){
            return root.max();
        }
        public T min(){
            return root.min();
        }

    /*
     * From most left to most right [1,2,3]
     */
    public List<T> traverseInOrder(){
            return root.traverseInOrder();
    }

    /*
    form main to left to right [2,1,3]
     */
    public List<T> traversePreOrder(){
        return root.traversePreOrder();
    }
}
