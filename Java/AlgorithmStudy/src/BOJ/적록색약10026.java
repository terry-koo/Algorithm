package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 적록색약10026 {
    static int N;
    static String[][] matrix;
    static String[] strArr = {"B", "R", "G"};
    static boolean[][] check;
    static int[] answer = new int[2];
    static int count = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        matrix = new String[N][N];
        check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            matrix[i] = new StringTokenizer(br.readLine()).nextToken().split("");
        }

        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (DFS(j, k, strArr[i])) {
                        count++;
                    }
                }
            }
        }
        check = new boolean[N][N];
        answer[0] = count;
        count = 0;

        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (DFS(j, k, strArr[i])) {
                        count++;
                    }
                }
            }
        }
        answer[1] = count;
        System.out.println(answer[0] + " " + answer[1]);

    }

    Boolean DFS(int y, int x, String target) {
        if (check[y][x] == false && target.equals(matrix[y][x])) {
            check[y][x] = true;
            if (target.equals("G")) { // 적녹색맹 판별할때 사용하기 위해 바꿔둠
                matrix[y][x] = "R";
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    DFS(ny, nx, target);
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        new 적록색약10026().solution();
    }
}
