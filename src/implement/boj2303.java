package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2303 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[5];
        int[] list = new int[n];
        int max = 0;

        for(int i = 0; i < n; i++){
            max = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int k = 0; k < 5; k++){
                for(int h = k + 1; h < 5; h++){
                    for(int g = h + 1; g < 5; g++){
                        max = Math.max((arr[k] + arr[h] + arr[g]) % 10, max);
                    }
                }
            }
            list[i] = max;
        }
        int idx = -1;
        int rest = -1;

        for(int i = 0; i < n; i++){
            if(rest <= list[i]){
                idx = i+1;
                rest = list[i];
            }
        }
        System.out.println(idx);
    }
}
