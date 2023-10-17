package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1417 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int me = Integer.parseInt(br.readLine());

        int[] arr = new int[n-1];

        for(int i = 0; i < n - 1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < arr.length; i++){
            if(me < arr[i]){
                arr[i]--;
                me++;
            }
        }
    }
}
