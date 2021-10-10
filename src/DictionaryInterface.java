/** Dictionary interface*/
public interface DictionaryInterface<K extends Comparable<K>,V> {

    /** Add an element to the binary search tree given a key and a value.
     * @param key - key with which to order nodes within the binary tree. That is, if key is 14, and the root
     * @param value - Value to associate with a given node and its specified key. Value does not determine
     * the position of a given node and its key in the binary search tree
     * node is 8, the key will go to the right of the root.
     * @return old value associated with key if the key already existed within the tree. If the key did not
     * exist, return null.*/
    public V add(K key, V value);

    /** Remove an element from the binary search tree given a key.
     * @param key - key with which to order nodes within the binary tree. Here, we remove the node with
     * our specified key.
     * @return the value associated with the key. If key is not present, or if the method was otherwise
     * unable to remove the key and value pair, return null*/
    public V remove(K key);

    /** Method to lookup whether a given key exists within the binary search tree
     * @param key - Key with which to order nodes within the tree. Method checks whether this key exists
     * within the tree.
     * @return the value associated with the key being looked up. If key is not present, return null*/
    public V lookup(K key);

    /**Wrapper method for recursively traversing a binary search tree*/
    public void inOrderTraverseRecursive();

    /**Wrapper method for iteratively traversing a binary search tree*/
    public void inOrderTraverseIterative();

}
