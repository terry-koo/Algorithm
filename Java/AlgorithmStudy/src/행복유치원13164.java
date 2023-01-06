import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행복유치원13164 {

    public void solution() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] intervalArr = new int[N-1];
        for (int i = 0; i < N - 1; i++) {
            intervalArr[i] = arr[i+1] - arr[i];
        }

        Arrays.sort(intervalArr);
        int result = 0;
        for (int i = 0; i < (N - 1) - (K - 1); i++) {
            result += intervalArr[i];
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new 행복유치원13164().solution();
    }
}