package NDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음료수얼려먹기 {

    static int[] nx = {1, 0, -1, 0};
    static int[] ny = {0, 1, 0, -1};
    static String[][] matrix;
    static int N, M;

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int answer = 0;
        matrix = new String[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i] = st.nextToken().split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j].equals("1")) {
                    continue;
                } else {
                    answer++;
                    DFS(i, j);
                }
            }
        }
        System.out.println(answer);

    }

    void DFS(int x, int y) {
        if (matrix[x][y].equals("1")) {
            return;
        } else {
            matrix[x][y] = "1";
            for (int i = 0; i < 4; i++) {
                int dx = x + nx[i];
                int dy = y + ny[i];
                if (dx >= 0 && dx < N && dy >=0 && dy < M) {
                    DFS(x + nx[i], y + ny[i]);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new 음료수얼려먹기().solution();
    }
}
