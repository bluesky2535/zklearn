package com.zklearn.uf;

import java.util.Scanner;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.uf
 * @Author: zk
 * @CreateTime: 2021-12-14 15:31:12
 * @Description: 并查集,树型结构,并平衡树
 */
public class UF_Tree_Weighted {
    public static void main(String[] args) {

        UF_Tree_Weighted uf=new UF_Tree_Weighted(5);
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("请输入第一个要合并的元素");
            int p = scanner.nextInt();
            System.out.println("请输入第二个要合并的元素");
            int q = scanner.nextInt();
            if(uf.connected(p,q)){
                System.out.println(p+"元素和"+q+"元素已经在一个分组中了");
            }else{
                uf.union(p,q);
                System.out.println("当前并查集中还有"+uf.count+"个分组");
            }
        }
    }
    //每一个索引是当前元素值，每个索引处存的值是它的父节点
    private int[] eleAndGroup;
    //记录并查集中数据的分组个数
    private int count;
    //用来存储每一个根节点对应的树中保存的节点的个数
    private int[] sz;


    //初始化并查集，以整数标识(0,N-1)个节点
    public UF_Tree_Weighted(int N) {

        this.eleAndGroup=new int[N];
        this.sz=new int[N];

        for (int i = 0; i < N; i++) {
            eleAndGroup[i]=i;
            sz[i]=1;
        }

        this.count=N;
    }

    //获取当前并查集中的数据有多少个分组
    public int count(){
        return count;
    }

    //判断并查集中元素p和元素q是否在同一分组中
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }

    //元素p所在分组的标识符
    public int find(int p){
        if(eleAndGroup[p]==p){
            return p;
        }else{
            return find(eleAndGroup[p]);
        }
    }

    //把p元素所在分组和q元素所在分组进行合并
    public void union(int p,int q){
        int pRoot=find(p);
        int qRoot=find(q);

        if(pRoot==qRoot){
            return;
        }

        //判断proot对应的树大还是qroot对应的树大，最终需要把较小的树合并到较大的树中
        if(sz[pRoot]<sz[qRoot]){
            eleAndGroup[pRoot]=qRoot;
            sz[qRoot]+=sz[pRoot];
        }else{
            eleAndGroup[qRoot]=pRoot;
            sz[pRoot]+=sz[qRoot];
        }
        this.count--;
    }



}
