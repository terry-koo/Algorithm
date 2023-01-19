package NDB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 큰수의법칙 {
    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M, K;
        int[] arr;
        int answer = 0;
        int count = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        OUTTER:
        while (true) {
            for (int i = 0; i < K; i++) {
                answer += arr[arr.length - 1];
                if(++count == M) {
                    break OUTTER;
                }
            }
            answer += arr[arr.length - 2];
            if(++count == M) {
                break OUTTER;
            }
        }


        System.out.println(answer);



    }

    public static void main(String[] args) throws IOException {
        new 큰수의법칙().solution();
    }
}
