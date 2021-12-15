package com.zklearn.graph;

import com.zklearn.linear.Queue;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.graph
 * @Author: zk
 * @CreateTime: 2021-12-15 10:02:01
 * @Description: 图
 */
public class Graph {
    public static void main(String[] args) {


    }


    //图的顶点数量
    private final int V;
    //记录边数量
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    public Graph(int V) {
        this.V=V;
        this.E=0;
        this.adj=new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new Queue<>();
        }
    }

    //获取图中顶点的数量
    public int V(){
        return V;
    }
    //获取图中边的数量
    public int E(){
        return E;
    }
    //向图中添加一条边
    public void addEdge(int v,int w){
        adj[v].enterQueue(w);
        adj[w].enterQueue(v);
        E++;
    }

    //获取顶点V相连的顶点队列
    public Queue<Integer> adj(int v){
        return adj[v];
    }




























}
