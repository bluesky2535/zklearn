package com.zklearn.uf;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.uf
 * @Author: zk
 * @CreateTime: 2021-12-14 17:34:51
 * @Description: 道路相通问题
 */
public class Traffic_Project {
    public static void main(String[] args) throws Exception {
        //读取文件
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("D:\\交控科技\\ideaworkspace\\zklearn\\algorithm\\src\\main\\resources\\traffic_project.txt")));
        int cityNum = Integer.parseInt(br.readLine());

        //构建并查集对象
        UF_Tree_Weighted utw=new UF_Tree_Weighted(cityNum);
        //读取一共有多少条道路
        int roadNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < roadNum; i++) {
            String[] cityArr = br.readLine().split(" ");
            int city_p=Integer.parseInt(cityArr[0]);
            int city_q=Integer.parseInt(cityArr[1]);
            //调用union方法让两个城市相通
            utw.union(city_p,city_q);
        }
        //并查集中的count-1 即为需要修建的道路数
        int roads= utw.count()-1;
        System.out.println("还需要修建的道路数"+roads);


    }

}
