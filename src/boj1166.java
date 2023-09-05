import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1166 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long L = Long.parseLong(st.nextToken());
        long W = Long.parseLong(st.nextToken());
        long H = Long.parseLong(st.nextToken());

        Long min = L;
        min = Math.min(min, W);
        min = Math.min(min, H);
        double low = 0;
        double high = min;

        while(low < high){
            double mid = (low + high) / 2;

            if((long)(L/mid) * (long)(W/mid) * (long)(H/mid) < N){
                if(high == mid) break;
                high = mid;
            } else {
                if(low == mid) break;
                low = mid;
            }
        }
        System.out.println(low);

    }
}
