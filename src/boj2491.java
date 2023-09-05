import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2491 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int upcount = 1;
        int downcount = 1;
        int max = 1;

       for(int i = 0; i < n-1; i++){
           if(arr[i] <= arr[i+1]) upcount++;
           else upcount = 1;
           max = Math.max(max, upcount);
       }



        for(int i = 0; i < n-1; i++){
            if(arr[i] >= arr[i+1]) downcount++;
            else downcount = 1;
            max = Math.max(max, downcount);
        }

        System.out.println(max);
    }
}
