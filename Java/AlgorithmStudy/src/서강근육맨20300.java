import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 서강근육맨20300 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        Long[] arr = new Long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Long max = Long.MIN_VALUE;
        Arrays.sort(arr);

        if (n%2 == 0) {
            for (int i = 0; i < (n/2 - 1); i++) {
                max = Math.max(max, arr[i] + arr[n-i-1]);
            }
        } else {
            for (int i = 0; i < (n/2 - 1); i++) {
                max = Math.max(max, arr[i] + arr[n-i-2]);
            }
            max = Math.max(max, arr[n-1]);
        }

        StringBuilder sb = new StringBuilder();

        sb.append(max);

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new 서강근육맨20300().solution();
    }
}