import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj6236 {
    static int[] spends;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        spends = new int[N];

        for(int i = 0; i < N; i++){
            spends[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(spends);

        int low = spends[0];
        int high = spends[spends.length-1];
        int cnt = 0;

        while(low < high){
            int mid = (low + high) / 2;
            int rest = mid;

            for(int i = 0; i < N; i++){
                if(rest >= spends[i]){
                    rest += (mid - spends[i]);
                } else {
                    cnt++;
                    rest += mid;
                }
            }
        }
    }
}
