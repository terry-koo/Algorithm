package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안전영역2468 {
    static int N, maxHeight, count, answer;
    static int[][] matrix, check;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    void solution () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        maxHeight = Integer.MIN_VALUE;
        count = 0;
        answer = Integer.MIN_VALUE;
        matrix = new int[N][N];
        check = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(temp, maxHeight);
                matrix[i][j] = temp;
            }
        }

        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (DFS(j, k, i)) {
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
            count = 0;
            check = new int[N][N];
        } // 물의 높이 조건


        System.out.println(answer);
    }

    Boolean DFS(int y, int x, int height) {
        if (matrix[y][x] > height && check[y][x] != 1) {
            check[y][x] = 1;
            for (int l = 0; l < 4; l++) {
                int nx = x + dx[l];
                int ny = y + dy[l];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    DFS(ny, nx, height);
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        new 안전영역2468().solution();
    }
}
