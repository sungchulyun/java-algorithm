import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2512 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] budgets = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(budgets);

        int m = Integer.parseInt(br.readLine());
        int low, mid, high;
        low = 0;
        high = budgets[budgets.length-1];


        while(low <= high){
            mid = (low + high) / 2;
            long each = 0;

            for(int i = 0; i < n; i++){
                if(mid < budgets[i]){
                    each += mid;
                } else {
                    each += budgets[i];
                }
            }
            if(each <= m){
                low = mid+1;
            } else
                high = mid-1;
        }
        System.out.print(high);

    }
}
