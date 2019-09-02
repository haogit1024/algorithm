package com.czh.pq;

public interface PQTemplate<Key> {
    void insert(Key k);

    Key max();

    Key delMax();

    boolean isEmpty();

    int size();


}
