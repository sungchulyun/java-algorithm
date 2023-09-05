import java.util.Scanner;

public class boj5585 {
    static int coins[] = {500, 100, 50, 10, 5, 1};
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int charge = 1000 - N;
        int cnt = 0;

        for(int coin : coins){
            cnt += charge / coin;
            charge %= coin;
        }
        System.out.print(cnt);
    }
}
