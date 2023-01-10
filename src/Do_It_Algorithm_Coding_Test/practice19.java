package Do_It_Algorithm_Coding_Test;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice19 {
    //Quick Sort
    public static void main(String Args[]) throws NumberFormatException, IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recursion(arr,0,N-1,K);

        System.out.println(arr[K-1]);

    }

    static void recursion(int []arr, int Left, int Right, int K){

        int pivot = partition(arr, Left, Right);
//        if(pivot == K) return;

        if(Left<pivot-1) recursion(arr,Left,pivot-1,K);
        if(Right>pivot) recursion(arr,pivot,Right,K);
    }

    static int partition(int []arr, int Left, int Right){
        int lo = Left;
        int hi = Right;
        int pivot = arr[(Left+Right)/2];

        while(hi>=lo){
            while(arr[lo]<pivot) lo++;
            while(arr[hi]>pivot) hi--;
            if(hi>=lo){
                swap(arr,lo,hi);
                lo++;
                hi--;
            }
        }

        return lo;
    }

    static void swap(int[]arr, int lo,int hi){
        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;
    }
}
