package com.zklearn.graph;

import com.zklearn.linear.Queue;

public class PrimMST {
    //索引代表顶点，值表示当前顶点和最小生成树的最短边
    private Edge[] edgeTo;
    //索引代表顶点，值表示当前顶点和最小生成树之间的最短边权重
    private double[] distTo;
    //索引代表顶点，如果当前顶点已经在树中，则值为true,否则为false
    private boolean[] marked;
    //存放树中顶点与非树中顶点之间的有效横切边
    private IndexMinPriorityQueue<Double> pq;


    //根据一副加权无向图，创建最小生成树计算对象
    public PrimMST(EdgeWeightedGraph G){
        //初始化edgeTo
        this.edgeTo=new Edge[G.V()];
        this.distTo=new double[G.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i]=Double.POSITIVE_INFINITY;
        }
        //初始化marked
        this.marked=new boolean[G.V()];
        //初始化pq
        this.pq=new IndexMinPriorityQueue<>();

        //默认让顶点0进入树中，但是树中只有一个顶点0，因此，0顶点默认没有和其他顶点相连，所以让distTo对应位置处的值存储0.0
        distTo[0]=0.0;
        pq.insert(0,0.0);

        //遍历索引最小优先队列，拿到最小和N切边对应的顶点，把该顶点加入到最小生成树中
        while (!pq.isEmpty()){
            visit(G,pq.delMin());
        }


    }




    //将顶点v添加到最小生成树中，并且更新数据
    private void visit(EdgeWeightedGraph G,int v){

    }

    //获取最小生成树的所有边
    public Queue<Edge> edges(){


    }
















}
