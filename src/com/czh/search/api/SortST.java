package com.czh.search.api;

/**
 * 有序字符表api
 * @param <Key>
 * @param <Value>
 */
public interface SortST<Key extends Comparable<Key>, Value> {
    void put(Key key, Value value);
    Value get(Key key);
    void delete(Key key);
    boolean contains(Key key);
    boolean isEmpty();
    int size();
    Key mini();
    Key max();

    /**
     * 小于等于key的最大值(向下取整)
     * @param key
     * @return
     */
    Key floor(Key key);

    /**
     * 大于等于key的最小值(向上取整)
     * @param key
     * @return
     */
    Key ceiling(Key key);

    /**
     * 小于 key 的数量
     * @param key
     * @return
     */
    int rank(Key key);

    /**
     * 获取排名为 k 的 key
     * @param k
     * @return
     */
    Key select(int k);

    void deleteMin();

    void deleteMax();

    int size(Key lo, Key hi);

    Iterable<Key> keys(Key lo, Key hi);

    Iterable<Key> keys();
}
