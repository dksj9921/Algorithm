package swmaestro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class domino {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] location = new int[n];
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            location[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        solution sl = new solution();
        int answer = sl.solution(n, m, height, location);

        System.out.println(answer);

    }

    public static class solution {
        public int nCount;
        public int mCount;
        public int Max = 20;
        public ArrayList<Integer>[] arr;
        public ArrayList<String> pass;
        public int[] locationArr;
        boolean[] visited;
        int answerMin = 999999999;

        public int solution(int n, int m, int[] height, int[] location) {
            int answer = 0;

            arr = new ArrayList[Max + 1];
            locationArr = new int[Max + 1];
            nCount = n;
            mCount = m;

            for (int i = 0; i <= Max; i++) {
                arr[i] = new ArrayList<>();
            }

            visited = new boolean[n];
            int[] result = new int[n];
            pass = new ArrayList<>();

            combination(0, 0, result);



            for (int i = 0; i < pass.size(); i++) {
                int[] tempPass = new int[m];
                StringTokenizer st = new StringTokenizer(pass.get(i));
                for (int j = 0; j < m; j++) {
                    tempPass[j] = Integer.parseInt(st.nextToken());
                }

                int[] copyLocation = Arrays.copyOf(location, location.length);
                int[] copyHeight = Arrays.copyOf(height, height.length);

                for (int j = 0; j < m; j++) {
                    copyLocation[tempPass[j]] = 0;
                    copyHeight[tempPass[j]] = 0;
                }

                locationArr = new int[Max + 1];
                for (int k = 0; k < n; k++) {
                    if (copyLocation[k] != 0) {
                        locationArr[copyLocation[k]] = copyHeight[k] + copyLocation[k];
                    }
                }
                for (int j = 0; j <= Max; j++) {
                    arr[j] = new ArrayList<>();
                }

                System.out.println(pass.get(i));
                for (int j = 0; j < locationArr.length; j++) {
                    if (locationArr[j] != 0) {
                        for (int k = j + 1; k <= locationArr[j]; k++) {
                            if (locationArr[j] < locationArr.length) {
                                if (locationArr[k] != 0) {
                                    arr[j].add(k);
                                    System.out.print("j=" + j + " k="+ k + " ");
                                }
                            }
                        }
                        System.out.println("");
                    }
                }

                int Max = 0;
                for (int j = 0; j < arr.length; j++) {
                    int count = 0;
                    if (locationArr[j] != 0) {
                        count = 0;
                        Queue<Integer> myQueue = new LinkedList<>();
                        boolean visited2[] = new boolean[arr.length];
                        myQueue.add(j);
                        while (!myQueue.isEmpty()) {

                            int now = myQueue.poll();
                            visited2[now] = true;

                            for (int k : arr[now]) {
                                if(!visited2[k]){
                                    visited2[k] = true;
                                    count++;
                                    if (locationArr[k] > locationArr[now]) {
                                        myQueue.add(k);
                                    }
                                }
                            }
                        }
                        if (count > Max) {
                            Max = count;
                        }
                    }
                }
                if(answerMin > Max){
                    answerMin = Max;
                }
            }
            answer = answerMin;
            return answer;
        }

        public void combination(int r, int start, int[] result) {
            if (mCount == r) {
                String temp = "";
                for (int i = 0; i < mCount; i++) {
                    temp += result[i] + " ";
                }

                pass.add(temp);
                return;
            }

            for (int i = start; i < visited.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[r] = i;
                    combination(r + 1, i + 1, result);
                    visited[i] = false;
                }
            }
        }
    }
}
