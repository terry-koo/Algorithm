package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추1012 {
    static int T, M, N, K; // 케이스, 가로, 세로, 배추
    static int answer = 0;
    static int[][] matrix;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        // 테스트 케이스 개수인 T만큼 반복
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            matrix = new int[N][M];

            // 배추의 개수만큼 반복
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                matrix[y][x] = 1;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (DFS(k, j)) {
                        answer++;
                    }
                }
            }

            System.out.println(answer);
            answer = 0;

        } // 테스트 케이스 종료
    }

    Boolean DFS(int y, int x) {
        if (matrix[y][x] == 1) {
            matrix[y][x] = 0;
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    DFS(ny, nx);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        new 유기농배추1012().solution();
    }
}
