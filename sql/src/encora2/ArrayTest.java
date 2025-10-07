package encora2;

import java.util.Arrays;

public class ArrayTest{
	public static void main(String[] args) {
		ArrayTest ar = new ArrayTest();
		int[] arr = {0,20, 38, 4, 579, 2,90, 0,4937, 45};
		int[] res = ar.sortArray(arr);
		System.out.println(Arrays.toString(res));
	}
	
	public int[] sortArray(int[] arr) {
		if(arr == null || arr.length ==0) return new int[0];
		
		int n = arr.length;
		int[] digitCounts = new int[n];
		Integer[] indexes = new Integer[n];
		
		for(int i=0; i<n;i++) {
			digitCounts[i] = countDigits(arr[i]);
			indexes[i] = i;
		}
		
		Arrays.sort(indexes, (i,j)->{
			if(digitCounts[i]!=digitCounts[j]) {
				return Integer.compare(digitCounts[i], digitCounts[j]);
			} else {
				return Integer.compare(arr[i], arr[j]);
			}
		});
		
		int[] sortedArray = new int[n];
		for(int k=0; k<n; k++) {
			sortedArray[k] = arr[indexes[k]];
		}
		return sortedArray;
	}
	
	private int countDigits(int num) {
		if(num==0) return 1;
		int count=0;
		while(num > 0) {
			count++;
			num /= 10;
		}
		return count;
	}
}