package com.zklearn.graph;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.graph
 * @Author: zk
 * @CreateTime: 2021-12-15 10:31:16
 * @Description: 深度优先搜索
 */
public class DepthFirstSearch {


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

        DepthFirstSearch search=new DepthFirstSearch(G,0);
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

    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //与S顶点相通的顶点数量
    private int count;

    public DepthFirstSearch(Graph G,int s) {
        this.marked=new boolean[G.V()];
        this.count=0;
        dfs(G,s);
    }

    //深度优先搜索
    private void dfs(Graph G,int v){
        marked[v]=true;
        for (Integer w : G.adj(v)) {
            if(!marked[w]){
                dfs(G,w);
            }
        }
        count++;
    }

    //判断w顶点与s顶点是否相通
    public boolean marked(int w){
        return marked[w];
    }
    //获取与顶点s相通的所有顶点的总数
    public int count(){
        return count;
    }


}
