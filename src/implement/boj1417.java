package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj1417 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n <= 1){
            System.out.println(0);
            return;
        }
        int me = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n - 1; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        while(true){
            if(pq.peek() >= me){
                int p = pq.poll() - 1;
                me++;
                cnt++;
                pq.add(p);
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }
}
