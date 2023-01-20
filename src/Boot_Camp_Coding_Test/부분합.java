package Boot_Camp_Coding_Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        int arr[] = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        long sum = arr[0];
        int answer = 100001;
        int length = 1;
        while (true) {
            if(sum >= S){
                if (length < answer) {
                    answer = length;
                }
                sum -= arr[start];
                length --;
                start++;
                if (start > end) {
                    length++;
                    sum += arr[++end];
                }
            }else {
                sum += arr[++end];
                length ++;
            }

            if (end == arr.length-1 && sum <= S) {
                if(arr[end] >= S){
                    if (answer > 1) {
                        answer = 1;
                    }
                } else if (sum >= S) {
                    if (answer > length) {
                        answer = length;
                    }
                }
                break;
            }
        }
        if(answer == 100001){
            System.out.println(0);
        }else System.out.println(answer);
    }
}
