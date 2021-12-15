package com.zklearn.graph;

import com.zklearn.uf.UF_Tree_Weighted;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.graph
 * @Author: zk
 * @CreateTime: 2021-12-15 11:32:01
 * @Description: 畅通工程
 */
public class Traffic_Project_Graph {

    public static void main(String[] args) throws Exception {
        //读取文件
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("D:\\交控科技\\ideaworkspace\\zklearn\\algorithm\\src\\main\\resources\\traffic_project.txt")));
        int cityNum = Integer.parseInt(br.readLine());
        //读取一共有多少条道路
        int roadNum = Integer.parseInt(br.readLine());
        Graph G=new Graph(cityNum);
        for (int i = 0; i < roadNum; i++) {
            String[] cityArr = br.readLine().split(" ");
            int city_p=Integer.parseInt(cityArr[0]);
            int city_q=Integer.parseInt(cityArr[1]);
            //调用union方法让两个城市相通
            G.addEdge(city_p,city_q);
        }

        DepthFirstSearch search=new DepthFirstSearch(G,9);
        boolean marked = search.marked(8);
        System.out.println("9顶点是否与8顶点相通"+marked);
        boolean marked2 = search.marked(10);
        System.out.println("9顶点是否与10顶点相通"+marked2);

    }

}
