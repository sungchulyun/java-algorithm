import java.util.Scanner;

public class boj2839 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        while(true){
            if(n % 5 == 0){
                cnt += n / 5;
                break;
            } else {
                n -= 3;
                cnt++;
                if(n < 0){
                    System.out.print(-1);
                    return;
                }
            }
        }
        System.out.print(cnt);
    }
}
