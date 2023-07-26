package com.company;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        BST<Integer, String> bst = new BST<>();
        bst.put(5, "five");
        bst.put(3, "three");
        bst.put(7, "seven");
        bst.put(10, "ten");

        //System.out.println(bst.get(3));
        //bst.delete(5);



        for (Map.Entry<Integer, String> entry : bst.iterator()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}
