import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2164 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            q.add(i);
        }

        while(!q.isEmpty()){
            if(q.size() == 1)
                break;
            int trash = q.poll();
            int go = q.poll();
            q.add(go);
        }

        System.out.print(q.poll());
    }
}
