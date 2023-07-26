package com.company;

import java.util.*;

public class BST<K extends Comparable<K>, V> implements Iterable<Map.Entry<K, V>> {
    private Node root;
    private int size;

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public BST() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new Node<>(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public V get(K key) {
        return (V) get(root, key);
    }

    private V get(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node<K, V> delete(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            size--;
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node<K, V> minRight = findMin(node.right);
                node.key = minRight.key;
                node.value = minRight.value;
                node.right = delete(node.right, minRight.key);
            }
        }
        return node;
    }

    private Node<K, V> findMin(Node<K, V> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        List<Map.Entry<K, V>> entries = new ArrayList<>();
        inorderTraversal(root, entries);
        return entries.iterator();
    }

    private void inorderTraversal(Node<K, V> node, List<Map.Entry<K, V>> entries) {
        if (node != null) {
            inorderTraversal(node.left, entries);
            entries.add(new AbstractMap.SimpleEntry<>(node.key, node.value));
            inorderTraversal(node.right, entries);
        }
    }
}
