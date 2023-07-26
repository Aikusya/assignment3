package com.company;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(5, "five");
        bst.put(3, "three");
        bst.put(7, "seven");
        bst.put(10, "ten");
        bst.put(9, "nine0");
        bst.put(12, "twelve");

        System.out.println(bst.consist(11));

        // Testing get() and delete()
        //System.out.println("Value at key 3: " + bst.get(3));
        //bst.delete(5);

        // Printing the tree using iterator()
        //for (Map.Entry<Integer, String> entry : bst) {
          //  Integer key = entry.getKey();
            //String value = entry.getValue();
            //System.out.println("Key: " + key + ", Value: " + value);
        //}


    }
}

