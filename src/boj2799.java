import java.util.Arrays;
import java.util.Scanner;

public class boj2799 {
    static int N, M;
    static int res[];
    static int count[];
    static int idx;
    static String str;

    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
       M = sc.nextInt();
       N = sc.nextInt();
       count = new int[N];
       res = new int[5];

       for(int k = 0; k < M; k++){
           sc.next();

           for(int i = 0; i < 4; i++){
               str = sc.next();
               for(int j = 1; j < 5 * N + 1; j += 5){
                   if(str.charAt(j) == '*'){
                       count[idx]++;
                       idx++;
                   }
               }
               idx = 0;
           }
           for(int i = 0; i < N; i++){
               res[count[i]]++;
           }
           Arrays.fill(count, 0);
       }
       sc.next();
       for(int i = 0; i < 5; i++) {
           System.out.print(res[i] + " ");
       }
    }
}
