package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		String[] unsorted = {"5", "10", "200", "1", "2", "5041231298479571", "192381038", "12903810247102741", "123321312", "11111", "11111", "1", "1000000000000000"};

		// your code goes here
		Solution solution = new Solution();
		Solutions sol = solution.new Solutions();
		sol.solve(unsorted);
	}

	
	public class Solutions {
		public void solve(String[] unsorted) {
			Arrays.sort(unsorted, new CustomStringComparator());
			for (String item : unsorted) {
				System.out.println(item);
			}
		}

		public class CustomStringComparator implements Comparator<String> {

			@Override
			public int compare(String str1, String str2) {
				if (str1.length() > str2.length()) {
					return 1;
				} else if (str2.length() > str1.length()) {
					return -1;
				}
				int index = 0;

				int num1 = Character.getNumericValue(str1.charAt(index));
				int num2 = Character.getNumericValue(str2.charAt(index));
				while (index < str1.length() -1) {
					index++;
					num1 = Character.getNumericValue(str1.charAt(index));
					num2 = Character.getNumericValue(str2.charAt(index));
					if(num1 != num2){
						break;
					}
				}
				return num1 - num2;

			}
		}
	}

}
