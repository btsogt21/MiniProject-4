# MiniProject-4
Implementing and testing functionality of a Binary Search Tree with inorderTraversal.

Binary Search Tree implementation utilizes supporting Node class containing key-value pairs and implements a Dictionary Interface. The key determines the position of a given
node within the BST, whilst value is the data that which we want to store in a given node. The BST, Node, and DicitionaryInterface all extend Comparable.

The Tester.java file is a basic test for the functionality of the BST. It tests the add, remove, lookup, in-order-traverse-Iterative, and in-order-traverse-Recursive methods.

The CountWords.java file is an extension of the basic test. This file reads in text from the 'sample.txt' file within the same directory as CountWords.java and utilizes a
BST to count the number of times each word appears within the text. The word is used as a key, whilst the number of times the word appears is utilized as the value associated
with the key's node.
