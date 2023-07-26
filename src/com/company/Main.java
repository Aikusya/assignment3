package com.company;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        BST<Integer, String> bst = new BST<>();
        bst.put(5, "five");
        bst.put(3, "three");
        bst.put(7, "seven");


        for (Map.Entry<Integer, String> entry : bst.iterator()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}
