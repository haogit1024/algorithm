package com.czh.unionfind;

/**
 * Created by czh on 17-8-28.
 * 快速合并算法,缺点是容易生成瘦长高的树,导致find访问数组次数太大
 */
public class QuickUnionUF {
    private int[] id;
    private int count;

    public QuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    public int getCount() {
        return count;
    }
}
