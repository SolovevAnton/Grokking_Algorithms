package com.solovev.dataStructures.BinarySearchTree;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    @Nested
    public class EqualsAndToStringTests {
        @Test
        @Timeout(1)
        void toStringNoRequisitionProblem() {
            BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
            BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

            tree.insert(3);
            tree.insert(7);
            tree.insert(2);

            assertAll(() -> System.out.println(tree));
        }

        @Test
        @Timeout(1)
        void toEqualstestNoRequisitionProblem() {
            BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
            BinarySearchTreeNode<Integer> rootNew = new BinarySearchTreeNode<>(5);
            BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);
            BinarySearchTree<Integer> treeNew = new BinarySearchTree<>(rootNew);

            assertTrue(tree.equals(treeNew));

            tree.insert(3);
            tree.insert(7);
            tree.insert(2);

            assertFalse(tree.equals(treeNew));

            treeNew.insert(3);
            treeNew.insert(7);
            treeNew.insert(2);

            assertTrue(tree.equals(treeNew));
        }
    }

    @Nested
    public class InsertionAndFindings {
        @Test
        void insertAndFindElement() {
            BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
            BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

            tree.insert(3);
            tree.insert(7);
            tree.insert(2);

            Optional<BinarySearchTreeNode<Integer>> foundNode = tree.find(3);

            assertTrue(foundNode.isPresent());
            assertEquals(3, foundNode.get().getData());
        }

        @Test
        void findNonexistentElement() {
            BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
            BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

            tree.insert(3);
            tree.insert(7);

            Optional<BinarySearchTreeNode<Integer>> foundNode = tree.find(8);

            assertFalse(foundNode.isPresent());
        }

        @Test
        void insertDuplicateElement() {
            BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
            BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

            tree.insert(3);
            tree.insert(7);
            tree.insert(3); // inserting duplicate

            Optional<BinarySearchTreeNode<Integer>> foundNode = tree.find(3);

            assertTrue(foundNode.isPresent());
            assertEquals(3, foundNode.get().getData());
            assertNotNull(foundNode.get().getRightChild()); // duplicate should be in the right subtree
        }

        @Test
        void insertAndFindStrings() {
            BinarySearchTreeNode<String> root = new BinarySearchTreeNode<>("banana");
            BinarySearchTree<String> tree = new BinarySearchTree<>(root);

            tree.insert("apple");
            tree.insert("cherry");
            tree.insert("date");

            Optional<BinarySearchTreeNode<String>> foundNode = tree.find("cherry");

            assertTrue(foundNode.isPresent());
            assertEquals("cherry", foundNode.get().getData());
        }
    }

    @Disabled //before delete implimentation
    @Nested
    public class RemoveMethods {
        @Test
        void removeElementLeft() {
            BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
            BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

            tree.insert(3);
            tree.insert(7);

            // Ensure that the element to be removed exists initially
            Optional<BinarySearchTreeNode<Integer>> initialNode = root.find(3);
            assertTrue(initialNode.isPresent());

            // Remove the element
            assertTrue(tree.remove(3));

            // Ensure that the element is no longer in the tree
            Optional<BinarySearchTreeNode<Integer>> removedNode = root.find(3);
            assertFalse(removedNode.isPresent());
        }

        @Test
        void removeElementRight() {
            BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
            BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

            tree.insert(3);
            tree.insert(7);

            // Ensure that the element to be removed exists initially
            Optional<BinarySearchTreeNode<Integer>> initialNode = root.find(7);
            assertTrue(initialNode.isPresent());

            // Remove the element
            assertTrue(tree.remove(3));

            // Ensure that the element is no longer in the tree
            Optional<BinarySearchTreeNode<Integer>> removedNode = root.find(7);
            assertFalse(removedNode.isPresent());
        }

        @Test
        void removeNonexistentElement() {
            BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
            BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

            tree.insert(3);
            tree.insert(7);

            // Ensure that the element to be removed doesn't exist initially
            Optional<BinarySearchTreeNode<Integer>> initialNode = root.find(8);
            assertFalse(initialNode.isPresent());

            // Try to remove a nonexistent element
            assertFalse(tree.remove(8));

            // Ensure that the tree remains unchanged
            Optional<BinarySearchTreeNode<Integer>> unchangedNode = root.find(8);
            assertFalse(unchangedNode.isPresent());
        }

        @Test
        void removeNodeWithBothChildren() {
            BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
            BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

            tree.insert(3);
            tree.insert(7);
            tree.insert(2);
            tree.insert(4);
            tree.insert(6);
            tree.insert(8);

            // Ensure that the node to be removed exists initially
            Optional<BinarySearchTreeNode<Integer>> initialNode = root.find(7);
            assertTrue(initialNode.isPresent());

            // Remove a node with both left and right children
            assertTrue(tree.remove(7));

            // Ensure that the node is no longer in the tree
            Optional<BinarySearchTreeNode<Integer>> removedNode = root.find(7);
            assertFalse(removedNode.isPresent());

            // Ensure that the tree remains a valid binary search tree
            assertTrue(isBinarySearchTree(root));
        }

        @Test
        void removeNodeWithOnlyLeftChild() {
            BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
            BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

            tree.insert(3);
            tree.insert(2);
            tree.insert(4);

            // Ensure that the node to be removed exists initially
            Optional<BinarySearchTreeNode<Integer>> initialNode = root.find(3);
            assertTrue(initialNode.isPresent());

            // Remove a node with only a left child
            assertTrue(tree.remove(3));

            // Ensure that the node is no longer in the tree
            Optional<BinarySearchTreeNode<Integer>> removedNode = root.find(3);
            assertFalse(removedNode.isPresent());

            // Ensure that the tree remains a valid binary search tree
            assertTrue(isBinarySearchTree(root));
        }

        @Test
        void removeNodeWithOnlyRightChild() {
            BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
            BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

            tree.insert(7);
            tree.insert(6);
            tree.insert(8);

            // Ensure that the node to be removed exists initially
            Optional<BinarySearchTreeNode<Integer>> initialNode = root.find(7);
            assertTrue(initialNode.isPresent());

            // Remove a node with only a right child
            assertTrue(tree.remove(7));

            // Ensure that the node is no longer in the tree
            Optional<BinarySearchTreeNode<Integer>> removedNode = root.find(7);
            assertFalse(removedNode.isPresent());

            // Ensure that the tree remains a valid binary search tree
            assertTrue(isBinarySearchTree(root));
        }

        private <T extends Comparable<T>> boolean isBinarySearchTree(BinarySearchTreeNode<T> node) {
            if (node == null) {
                return true;
            }

            if (node.getLeftChild() != null && node.getLeftChild().getData().compareTo(node.getData()) > 0) {
                return false;
            }

            if (node.getRightChild() != null && node.getRightChild().getData().compareTo(node.getData()) < 0) {
                return false;
            }

            return isBinarySearchTree(node.getLeftChild()) && isBinarySearchTree(node.getRightChild());
        }
    }

    @Nested
    public class minMaxTests {
        @Test
        void findMinInTreeWithMultipleNodes() {
            BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
            BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

            tree.insert(3);
            tree.insert(7);
            tree.insert(2);
            tree.insert(4);
            tree.insert(6);
            tree.insert(8);

            Integer min = tree.min();

            assertNotNull(min);
            assertEquals(2, min);
        }

        @Test
        void findMaxInTreeWithMultipleNodes() {
            BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
            BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

            tree.insert(3);
            tree.insert(7);
            tree.insert(2);
            tree.insert(4);
            tree.insert(6);
            tree.insert(8);

            Integer max = tree.max();

            assertNotNull(max);
            assertEquals(8, max);
        }

        @Test
        void findMinInTreeWithOnlyRoot() {
            BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
            BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

            Integer min = tree.min();

            assertNotNull(min);
            assertEquals(5, min);
        }

        @Test
        void findMaxInTreeWithOnlyRoot() {
            BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
            BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

            Integer max = tree.max();

            assertNotNull(max);
            assertEquals(5, max);
        }
    }

    @Nested
    public class Traversing {
        @Nested
        public class TraverseInOrderTests {
            @Test
            void traverseInOrderWithOnlyRoot() {
                BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
                BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

                List<Integer> result = tree.traverseInOrder();

                assertEquals(Arrays.asList(5), result);
            }

            @Test
            void traverseInOrderWithTwoNodes() {
                BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
                BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

                tree.insert(3);

                List<Integer> result = tree.traverseInOrder();

                assertEquals(Arrays.asList(3, 5), result);
            }

            @Test
            void traverseInOrderWithOnlyLeftSide() {
                BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
                BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

                tree.insert(3);
                tree.insert(2);
                tree.insert(4);

                List<Integer> result = tree.traverseInOrder();

                assertEquals(Arrays.asList(2, 3, 4, 5), result);
            }

            @Test
            void traverseInOrderWithOnlyRightSide() {
                BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
                BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

                tree.insert(7);
                tree.insert(6);
                tree.insert(8);

                List<Integer> result = tree.traverseInOrder();

                assertEquals(Arrays.asList(5, 6, 7, 8), result);
            }

            @Test
            void traverseInOrderWithThreeLevels() {
                BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
                BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

                tree.insert(3);
                tree.insert(7);
                tree.insert(2);
                tree.insert(4);
                tree.insert(6);
                tree.insert(8);

                List<Integer> result = tree.traverseInOrder();

                assertEquals(Arrays.asList(2, 3, 4, 5, 6, 7, 8), result);
            }
        }
        @Nested
        public class PreOrderTesting{
            @Test
            void traversePreOrderWithOnlyRoot() {
                BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
                BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

                List<Integer> result = tree.traversePreOrder();

                assertEquals(Arrays.asList(5), result);
            }

            @Test
            void traversePreOrderWithTwoNodes() {
                BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
                BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

                tree.insert(3);

                List<Integer> result = tree.traversePreOrder();

                assertEquals(Arrays.asList(5, 3), result);
            }

            @Test
            void traversePreOrderWithOnlyLeftSide() {
                BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
                BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

                tree.insert(3);
                tree.insert(2);
                tree.insert(4);

                List<Integer> result = tree.traversePreOrder();

                assertEquals(Arrays.asList(5, 3, 2, 4), result);
            }

            @Test
            void traversePreOrderWithOnlyRightSide() {
                BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
                BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

                tree.insert(7);
                tree.insert(6);
                tree.insert(8);

                List<Integer> result = tree.traversePreOrder();

                assertEquals(Arrays.asList(5, 7, 6, 8), result);
            }

            @Test
            void traversePreOrderWithThreeLevels() {
                BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
                BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

                tree.insert(3);
                tree.insert(7);
                tree.insert(2);
                tree.insert(4);
                tree.insert(6);
                tree.insert(8);

                List<Integer> result = tree.traversePreOrder();

                assertEquals(Arrays.asList(5, 3, 2, 4, 7, 6, 8), result);
            }
        }
    }

}