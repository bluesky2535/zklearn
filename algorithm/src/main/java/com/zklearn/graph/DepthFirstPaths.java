package com.zklearn.graph;

import com.zklearn.linear.Stack;
import com.zklearn.uf.UF_Tree_Weighted;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.graph
 * @Author: zk
 * @CreateTime: 2021-12-15 14:27:19
 * @Description: 深度优先搜索路径
 */
public class DepthFirstPaths {

    public static void main(String[] args) throws Exception {
        //读取文件
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("D:\\交控科技\\ideaworkspace\\zklearn\\algorithm\\src\\main\\resources\\traffic_path.txt")));

        //有多少顶点
        int vNum = Integer.parseInt(br.readLine());

        //读取边
        int borderNum = Integer.parseInt(br.readLine());
        Graph G=new Graph(vNum);
        for (int i = 0; i < borderNum; i++) {
            String[] cityArr = br.readLine().split(" ");
            int city_p=Integer.parseInt(cityArr[0]);
            int city_q=Integer.parseInt(cityArr[1]);
            //图中添加边
            G.addEdge(city_p,city_q);
        }

        DepthFirstPaths depthFirstPaths=new DepthFirstPaths(G,0);
        Stack<Integer> stack = depthFirstPaths.pathTo(4);
        for (Integer integer : stack) {
            System.out.print(integer+"-");
        }
    }



    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //起点
    private int s;
    //索引代表顶点，值代表从起点s到当前顶点路径上的最后一个顶点
    private int[] edgeTo;


    //构造深度优先搜索对象，使用深度优先搜索找出G图中的起点为S的所有路径
    public DepthFirstPaths(Graph G,int s){
        this.marked=new boolean[G.V()];
        this.s=s;
        this.edgeTo=new int[G.V()];
        dfs(G,s);
    }

    //使用深度优先搜索找出G图中V顶点的所有相邻顶点
    public void dfs(Graph G,int v){
        marked[v]=true;
        for (Integer w : G.adj(v)) {
            if(!marked[w]){
                edgeTo[w]=v;
                dfs(G,w);
            }
        }
    }

    //判断W顶点与s顶点是否存在路径
    public boolean hasPathTo(int v){
        return marked[v];
    }

    //找出从起点S到顶点V的路径(就是该路径经过的顶点）
    public Stack<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        Stack<Integer> stack=new Stack<>();
        //创建栈对象保存路径
        for(int x=v;x!=s;x=edgeTo[x]){
            stack.push(x);
        }
        //存入首节点
        stack.push(s);

        return stack;
    }




































}
