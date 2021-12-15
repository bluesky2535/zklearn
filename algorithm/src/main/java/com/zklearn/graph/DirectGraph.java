package com.zklearn.graph;

import com.zklearn.linear.Queue;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.graph
 * @Author: zk
 * @CreateTime: 2021-12-15 16:44:13
 * @Description: 有向图
 */
public class DirectGraph {

    //图的顶点数量
    private final int V;
    //记录边数量
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    public DirectGraph(int V) {
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
        E++;
    }

    //获取顶点V相连的顶点队列
    public Queue<Integer> adj(int v){
        return adj[v];
    }


    //反向图
    public DirectGraph reverse(){
        //创建有向图对象
        DirectGraph r=new DirectGraph(V);
        for (int v = 0; v < V; v++) {
            for (Integer w : adj(v)) {
                r.addEdge(w,v);
            }
        }
        return r;
    }


}
