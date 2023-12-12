package com.solovev.dataStructures.BinarySearchTree;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

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
}
