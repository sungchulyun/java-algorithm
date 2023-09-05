import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2960 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        for(int i = 2; i <= n; i++){
            list.add(i);
        }
        Collections.sort(list);
        Queue<Integer> queue = new LinkedList<>();

        while(!list.isEmpty()){

            int p = list.get(0);
            queue.add(list.remove(0));

            for(int i = 0; i < list.size(); i++){
                if(list.get(i) % p == 0)
                    queue.add(list.remove(i));
            }
        }
        for(int i = 1; i < k; i++){
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
