package com.czh.unionfind;

/**
 * Created by czh on 17-8-27.
 */
public class QuickFindUF {
    private int[] id;
    private int count;

    public QuickFindUF(int N){
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        if (pid == qid) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
        count--;
    }

    public int getCount(){
        return count;
    }
}
