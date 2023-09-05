import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class boj1874 {
    static int temp = 1;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            int T = Integer.parseInt(br.readLine());

            for(; temp <= T; temp++){
                stack.push(temp);
                sb.append("+").append("\n");
            }
            if(stack.peek() == T){
                stack.pop();
                sb.append("-").append("\n");
            } else {
                flag = true;
            }
        }
        if(flag)
            System.out.println("NO");
        else
            System.out.println(sb);
    }
}
