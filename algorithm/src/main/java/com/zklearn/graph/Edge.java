package com.zklearn.graph;

public class Edge implements Comparable<Edge>{

    private final int v;//顶点1
    private final int w;//顶点2
    private final double weight;//当前边的权重

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }


    //获取边的权重值
    public double weight(){
        return weight;
    }


    //获取边上的一个点
    public int either(){
        return v;
    }

    //获取边上除了顶点vertex外的另外一个顶点
    public int other(int vertex){
        if(vertex==v){
            return w;
        }else{
            return v;
        }
    }



    @Override
    public int compareTo(Edge other) {
        if(this.weight-other.weight>0){
            return 1;
        }else if(this.weight-other.weight<0){
            return -1;
        }
        return 0;
    } 
}
