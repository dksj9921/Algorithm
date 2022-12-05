import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class practice15 {

    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int arr[] = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }

        for(int i = N; i>0; i--){
            for(int j = 0; j<N; j++){
                if(j+1!=N&&arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i = 0; i<N; i++){
            System.out.println(arr[i]);
        }
    }

}
