import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj2578 {
    public static int count = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[5][5];
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int a = 1; a <= 25; a++){

            int num = sc.nextInt();
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(arr[i][j] == num)
                        arr[i][j] = 0;
                }
            }
            rCheck(arr);
            cCheck(arr);
            rightCheck(arr);
            leftCheck(arr);

            if(count >= 3){
                System.out.println(a);
                break;
            }
            count = 0;
        }
    }
    private static void rCheck(int arr[][]){
        for(int i = 0; i < 5; i++){
            int zeroCount = 0;
            for(int j = 0; j < 5; j++) {
                if (arr[i][j] == 0) {
                    zeroCount++;
                }
                if (zeroCount == 5)
                    count++;
            }
        }
    }

    private static void cCheck(int arr[][]){
        for(int i = 0; i < 5; i++){
            int zerocount = 0;
            for(int j = 0; j < 5; j++){
                if(arr[j][i] == 0)
                    zerocount++;
                if(zerocount == 5)
                    count++;
            }
        }
    }

    private static void leftCheck(int arr[][]){
        int zerocount = 0;
        for(int i = 0; i < 5; i++){
            if(arr[i][i] == 0)
                zerocount++;
        }
        if(zerocount == 5)
            count++;
    }

    private static void rightCheck(int arr[][]){
        int zerocount = 0;
        for(int i = 0; i < 5; i++){
            if(arr[i][4-i] == 0){
                zerocount++;
            }
        }
        if(zerocount == 5){
            count++;
        }
    }
}
