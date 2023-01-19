package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의부모찾기11725 {

    static List<List<Integer>> list = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static int[] answer;

    public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        answer = new int[N + 1];
        answer[1] = 1;

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);

        }
        queue.offer(1);
        BFS();

        for (int i = 2; i < answer.length; i++) {
            sb.append(answer[i]).append('\n');
        }

        System.out.println(sb);

    }

    void BFS() {
        while (!queue.isEmpty()) {
            int p = queue.poll();
            for (int i = 0; i < list.get(p).size(); i++) {
                int temp = list.get(p).get(i);
                if (answer[temp] == 0) {
                    answer[temp] = p;
                    queue.offer(temp);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        new 트리의부모찾기11725().solution();
    }
}

