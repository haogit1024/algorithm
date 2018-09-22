package com.czh.unionfind;

/**
 * Created by czh on 17-8-29.
 * 解决QuickUnionUF容易生成高树的问题
 * 是我想复杂了,合并两颗树其实很简单
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] si;
    private int count;

    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        si = new int[N];
        for (int i = 0; i < N; i++) {
            si[i] = 1;
        }
    }

    private int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (si[i] > si[j]) { id[j] = i; si[i] += si[j]; }
        else { id[i] = j; si[j] += si[i];}
    }
}
