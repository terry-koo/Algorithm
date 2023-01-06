import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 회의실배정1931 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        ArrayList<Time> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);

        int answer = 0;
        int nFin = 0;

        for (Time t : list) {
            if (t.start >= nFin) {
                answer++;
                nFin = t.finish;
            }
        }

        System.out.println(answer);


    }

    public static void main(String[] args) throws Exception {
        new 회의실배정1931().solution();
    }
}

class Time implements Comparable<Time> {
    int start;
    int finish;

    Time(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public int compareTo(Time o) {
        if (this.finish == o.finish) {
            return this.start - o.start;
        } else {
            return this.finish - o.finish;
        }
    }
}
