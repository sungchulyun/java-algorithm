package samsung01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj2798 {
	static int sum;
	static int n;
	static int m;
	static int temp = 0;
	public static void main(String args[])throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		temp = 0;
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[n];
		int sum = 0;
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int r = black(arr);
		System.out.println(r);
  }
	
	public static int black(int[] arr) {
		for(int i = 0; i<n-2; i++) {
			for(int j = i+1; j<n-1; j++) {
				for(int t = j+1; t<n; t++) {
					sum = arr[i] + arr[j] + arr[t];
					if(sum == m) {
						return sum;
					}
					if(temp < sum && sum < m) {
						temp = sum;
					}
				}
			}
		}
		return temp;
	}
}
