package Do_It_Algorithm_Coding_Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class practice13 {
    //카드게임
    public static void main(String Args[]) throws NumberFormatException, IOException{

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i<=N; i++){
            queue.add(i);
        }

        while(queue.size()>1){
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
