package encora2;

import java.util.Arrays;

public class ArraySort {
	public static void main(String[] args) {
		ArraySort as = new ArraySort();
		int[] arr = {2, 45, 385, 9834, 8349, 34, 1};
		int[] res = as.ArraySort(arr);
		
		System.out.println(Arrays.toString(res));
	}
	
	public int[] ArraySort(int[] arr) {
		if(arr == null || arr.length == 0) {
			return new int[0];
		} 
		
		int n= arr.length;
		int[] digitCounts = new int[n];
		Integer[] indexes = new Integer[n];
		
		for(int i=0; i<n; i++) {
			digitCounts[i] = countDigits(arr[i]);
			indexes[i] = i;
		}
		
		Arrays.sort(indexes, (i,j) -> {
			if(digitCounts[i] != digitCounts[j]) {
				return Integer.compare(digitCounts[i], digitCounts[j]);
			} else {
				return Integer.compare(i, j);
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
		int count = 0;
		while(num > 0) {
			count++;
			num = num/10;
		}
		return count;
	}
}