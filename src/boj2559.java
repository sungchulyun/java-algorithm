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

        int cnt = 0;

        int start = 1, end = k;

        int totalcnt = 0;
        int currentSum = 0;

       while(end < arr.length){
           if(cnt == k){
               totalcnt++;
               max = Math.max(max, currentSum);

               currentSum = 0;
               cnt = 0;

               start = totalcnt + 1;
           } else {
               currentSum += arr[start];

               if(start == end){
                   end++;
               }
               start++;

               cnt++;
           }
       }
        System.out.println(max);
    }
}