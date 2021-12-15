package com.zklearn.graph;

import com.zklearn.linear.Queue;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.graph
 * @Author: zk
 * @CreateTime: 2021-12-15 11:02:00
 * @Description: 广度优先搜索
 */
public class BreadthFirstSearch {


    public static void main(String[] args) {

        //构造图
        Graph G=new Graph(13);
        G.addEdge(0,5);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,6);
        G.addEdge(6,4);
        G.addEdge(4,3);
        G.addEdge(5,4);
        G.addEdge(5,3);

        G.addEdge(7,8);

        G.addEdge(9,10);
        G.addEdge(9,11);
        G.addEdge(9,12);
        G.addEdge(11,12);

        BreadthFirstSearch search=new BreadthFirstSearch(G,0);
        //与0顶点相通的顶点数量
        int count = search.count();
        System.out.println("与0顶点相通的顶点数量"+count);
        //7和0顶点是否相通
        boolean marked = search.marked(7);
        System.out.println("7与0顶点是否相通"+marked);

        //6和0顶点是否相通
        boolean marked2 = search.marked(6);
        System.out.println("6与0顶点是否相通"+marked2);

    }

    private boolean[] marked;
    private int count;
    //用来存储待搜索邻接表的点
    private Queue<Integer> waitSearch;

    public BreadthFirstSearch(Graph G,int s){
        this.marked=new boolean[G.V()];
        this.count=0;
        this.waitSearch=new Queue<>();
        bfs(G,s);
    }

    //使用广度优先搜索
    private void bfs(Graph G,int v){
        marked[v]=true;
        waitSearch.enterQueue(v);
        for (Integer w : G.adj(v)) {
            if(!marked(w)){
                bfs(G,w);
            }
        }
        count++;
    }

    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return  count;
    }




}
