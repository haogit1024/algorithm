package com.czh.search;


import com.czh.search.api.SortST;
import edu.princeton.cs.algs4.Queue;

/**
 * 二叉树
 */
public class BST<Key extends Comparable<Key>, Value> implements SortST<Key, Value> {
    public class Node {
        private Key key;
        private Value value;
        private int N;
        private Node left;
        private Node right;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    private Node root;

    public int size() {
        return size(root);
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    @Override
    public Key max() {
        return max(root);
    }

    public Key max(Node x) {
        if (x.right == null) return x.key;
        return max(x.right);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return node.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
     * 和get方法类似，只有找到相同的key或null节点时才会停止
     *
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, 1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key floor(Key key) {
        return floor(root, key).key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t == null) return x;
        else return t;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node node, int k) {
        if (node == null) return null;
        int t = node.N;
        if (t > k) return select(node.left, k);
        else if (t < k) return select(node.right, k - t - 1);
        else return node;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    @Override
    public void deleteMin() {
        deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public void deleteMax() {
        deleteMax(root);
    }

    public Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public int size(Key lo, Key hi) {
        return root.N;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public void print() {
        print(root);
    }

    private void print(Node node) {
        if (node == null) return;
        print(node.left);
        System.out.println(node.key + "\t");
        print(node.right);
    }

    public void delete(Key key) {
       root = delete(root, key);
    }

    /**
     * 删除节点x步骤
     * 1.将只想即将被删除的节点的连接保存为 t
     * 2.将 x 指向它的后续节点 min(x.right)
     * 3.将 x 的右链接(原本指向一颗所有节点都大于 x.key 的二叉树)指向 deleteMin(t.right),
     *   也就是在删除后所有节点仍然大于 x.key 的子二叉树
     * 4.将 x 的左连接设为 t.left (其下所有的键都小于被删除的节点和他的后续节点)
     *
     * @param x
     * @param key
     * @return
     */
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) delete(x.left, key);
        else if (cmp > 0) delete(x.right, key);
        else {
            // key 相等
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;
            Node t = x;
            x = min(x.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.right) + size(x.right) + 1;
        return x;
    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }



    public static void main(String[] args) {
        System.out.println("hello");
        BST<Integer, String> bst = new BST<>();
        bst.put(4, "d");
        bst.put(2, "b");
        bst.put(1, "a");
        bst.put(3, "c");
        bst.put(5, "e");
        bst.print();
        System.out.println("-------------");
//        System.out.println(bst.max());
        for (Integer key : bst.keys()) {
            System.out.println(key);
        }
    }
}
