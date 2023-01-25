package doitcodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class practice35 {
    public static void main(String Args[])throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> myQueue = new PriorityQueue<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            myQueue.add(new Node(start,end));
        }

        int endTime = 0;
        int count = 0;
        while(!myQueue.isEmpty()){
            Node temp = myQueue.poll();
            if(temp.start>=endTime){
                endTime = temp.end;
                count++;
            }
        }

        System.out.println(count);


    }

    static public class Node implements Comparable<Node>{
        int start;
        int end;

        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node input){
            if(input.end == this.end) return input.start<=this.start? 1:-1;
            else return input.end>this.end? -1:1;
        }
    }
}
