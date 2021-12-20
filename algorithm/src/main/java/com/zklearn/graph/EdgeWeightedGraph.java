package com.zklearn.graph;

import com.zklearn.linear.Queue;

public class EdgeWeightedGraph {

    //顶点数量
    private  int V;
    //边的数量
    private  int E;
    //邻接表
    private Queue<Edge>[] adj;

    public EdgeWeightedGraph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i]=new Queue<Edge>();
        }
    }


    //获取顶点的数量
    public int  V(){
        return V;
    }

    //获取边的数量
    public int E(){
        return E;
    }

    //向加权无向图中添加一条边
    public void  addEdge(Edge edge){
        //需要将边添加到两个顶点对应的队列中
        int v=edge.either();
        int w=edge.other(v);
        adj[v].enterQueue(edge);
        adj[w].enterQueue(edge);
    }



    //获取顶点v的所有边
    public Queue<Edge> adj(int v){
        return adj[v];
    }

    //获取加权无向图的所有边
    public Queue<Edge> edges(){
        Queue<Edge> allEdges=new Queue<>();
        for (int v = 0; v< V; v++) {
            //遍历顶点v的所有边
            for (Edge edge : adj[v]) {
                //判断顶点大小，只有较小顶点的边才加入队列，避免了重复
                if(v > edge.other(v)){
                    allEdges.enterQueue(edge);
                }
            }
        }
        return allEdges;
        
    }















}
