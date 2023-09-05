import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj13305 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Long[] oilPrices = new Long[N];
        Long[] distances = new Long[N];
        long min = 1000000000;
        long answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N-1; i++){
            distances[i] = Long.parseLong(st.nextToken());

        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            oilPrices[i] = Long.parseLong(st.nextToken());
        }

       for(int i = 0; i < N-1 ;i++){
           min = Math.min(min, oilPrices[i]);
           answer += min * distances[i];
       }
       System.out.print(answer);
    }
}
