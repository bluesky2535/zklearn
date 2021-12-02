import java.util.Arrays;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: PACKAGE_NAME
 * @Author: zk
 * @CreateTime: 2021-12-02 15:22:29
 * @Description: 选择排序
 */
public class Selection {

    public static void main(String[] args) {
        Integer[] a={6,10,8,4,9};
        selectionSort(a);
    }



    public static void selectionSort(Integer[] arr){
        for(int i=0;i<arr.length;i++){
            int min=i;
            System.out.println(Arrays.toString(arr));
            for(int j=i;j<arr.length-1;j++){
                if(arr[min]>arr[j+1]){
                    min=j+1;
                }
            }
            exchange(arr,i,min);
            System.out.println(Arrays.toString(arr)+" "+ min+"  "+i);
            System.out.println("========================== ");
        }

    }



    public static boolean greater(Comparable x,Comparable y){
        return x.compareTo(y)>0 ;
    }

    public static void exchange(Comparable[] arr ,int i,int j){
        Comparable temp;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
