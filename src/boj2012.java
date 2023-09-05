import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class boj2012 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            int rank = Integer.parseInt(br.readLine());
            arr[i] = rank;
        }
        Arrays.sort(arr);
        long sum = 0;

        for(int i = 0; i < arr.length; i++){
           sum += Math.abs(arr[i] - (i+1));
        }
        System.out.println(sum);
    }
}
