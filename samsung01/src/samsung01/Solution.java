package samsung01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String args[]) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		String NK = br.readLine();
		String nk [] = NK.split(" ");				//k는 알고싶은 학생의 학점
		int n = Integer.parseInt(nk[0]);		//학생수
		int k = Integer.parseInt(nk[1]);
		double[] sum = new double[n];
		double[] score= new double[3];
		int gradecount = n/10;
		double studentScore = 0.0;
		String[] grade = {"A+" , "A0" ,"A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
		String[] grade1 = null;
		
		
		for(int i = 0; i < T; i++) {
			
			String scores = br.readLine();
			String kScore[] = scores.split(" ");
			
			for(int j = 0; j<3; j++) {
				
				score[j] = Integer.parseInt(kScore[j]);
				sum[i] = score[0] * 0.35 + score[1] * 0.45 + score[2] * 0.2;	
			}
		}
		
		studentScore = sum[k-1];
		Arrays.sort(sum);
		int rank = 0;
		for(int i = 0; i< n; i++) {
			if(studentScore < sum[i]) {
				rank += 1;
			}
			
			System.out.print("#" + i + " " + grade[rank]);
		}
		
		
	}
}
