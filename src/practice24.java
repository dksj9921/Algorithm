import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class practice24 {
    //뭐였더라 아 신기한 수
     static int arr2[] = {1,3,5,7,9};
     static int N;
     static ArrayList<Integer> result = new ArrayList<>();

     public static void main(String Args[]) throws NumberFormatException, IOException{

         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


         N = Integer.parseInt(bf.readLine());
         int arr1[] = {2,3,5,7};

         for(int i = 0; i<4; i++){
            DFS(arr1[i]);
         }

         for(int i =0; i< result.size(); i++){
             System.out.println(result.get(i));
         }
     }

     public static void DFS(int input){
         if(Math.pow(10,N-1)>input) {
             for (int i = 0; i < arr2.length; i++) {
                 if (isPrimeNumber((input * 10) + arr2[i])) DFS((input * 10) + arr2[i]);
             }
         }else if (isPrimeNumber(input)) result.add(input);
     }

     public static boolean isPrimeNumber(int target){
         for(int i=2;i<=Math.sqrt(target);i++){
             if(target%i==0) return false;
         }
         return true;
     }
}
