import org.w3c.dom.Node;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class practice10 {
    //최솟값 찾기
    public static void main(String Args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());


        Deque<Node> myDeque = new LinkedList<>();

        for (int i = 0; i<N; i++){
            int now = Integer.parseInt(st.nextToken());

            while(!myDeque.isEmpty()&&myDeque.getLast().value>now) myDeque.removeLast();
            myDeque.addLast(new Node(now,i));
            if(myDeque.getFirst().index<=i-L){
                myDeque.removeFirst();
            }
            bw.write(myDeque.getFirst().value+"");
        }
        bw.flush();
        bf.close();
    }

    static class Node{
        public int value;
        public int index;

        Node(int value, int index){
            this.index = index;
            this.value = value;
        }
    }
}


