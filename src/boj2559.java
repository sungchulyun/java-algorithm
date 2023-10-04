import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2559 {
    static int max = Integer.MIN_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0;
        int count = k;

        while(true){
            if(count == 0) {
                sum -= arr[start++];
                count = k;
            } else
                sum += arr[end++];
            if(end == n)
                break;

            System.out.println(start);
            if(max < sum){
                max = sum;
            }
            count--;
        }
        System.out.println(max);
    }
}