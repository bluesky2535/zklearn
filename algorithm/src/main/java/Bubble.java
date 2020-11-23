import java.util.Arrays;

/**冒泡算法
 * @author zk
 */
public class Bubble {

    public static void main(String[] args) {
        int[] a={10,6,8,4,9};
        bubbleSort(a);
    }


    /**
     * 这是冒泡函数
     * @param arr 传入int数组
     */
    private static  void bubbleSort(int[] arr){
        //因为每一轮产生一个最大的数，那就是泡泡，最后只剩下一个数，没必要再循环
        for (int i=0 ;i<arr.length-1;i++){
            //后面的减去i是因为已经产生最大的数了，没有必要再去执行了
            for(int j=0;j<arr.length-1-i;j++){
                int temp;
                if(arr[j]>arr[j+1]){
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }

            System.out.println(Arrays.toString(arr));
        }
    }


}
