package com.dongfang.dsa.algorithm.unionfind;

public class UnionFindByQuickUnion extends UnionFind {
    public UnionFindByQuickUnion(int capacity) {
        super(capacity);
    }

    /**
     * 通过parent链条不断向上找
     *
     * 返回所在集合的根节点
     * @param v 必须是数组的索引内
     * @return
     */
    @Override
    public int find(int v) {
        rangeCheck(v);
        // 这值不等于父节点，一直沿着树往上找
        // 循环退出时，v = 父节点
        while (v != parents[v]) {
            v = parents[v];
        }
        return v;
    }

    /**
     * 将 v1 的根节点，嫁接到 v2 的根节点上，
     *    v1 的根节点 成为 v2 的子节点
     *
     * 将v1的根节点的父节点，改成v2的根节点
     * @param v1
     * @param v2
     */
    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;
        parents[p1] = p2;
    }
}