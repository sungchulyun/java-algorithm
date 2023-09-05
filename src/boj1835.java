import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class boj1835 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Deque<Integer> dequeue = new ArrayDeque<>();

        int num = sc.nextInt();
        int n = num;

        dequeue.addFirst(num);
        if(num == 1){
            System.out.println(1);
            return;
        }
        dequeue.addFirst(num  - 1);

        while(true){
            n--;
            for(int r = n; r > 0; r--){
                int last = dequeue.peekLast();
                dequeue.addFirst(last);
                dequeue.pollLast();
            }
            if(n == 1)break;
            dequeue.addFirst(n - 1);
        }
        StringBuilder sb = new StringBuilder();

        Iterator iter = dequeue.iterator();
        while(iter.hasNext()){
            sb.append(iter.next()).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
