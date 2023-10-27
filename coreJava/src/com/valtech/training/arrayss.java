package com.valtech.training;

public class arrayss {
	    public static void main(String[] args) {
	        int[] arr = {4, 5, 3, 2, 1};
	        if (isAscending(arr)) {
	            System.out.println("The array is in ascending order.");
	        } else if (isDescending(arr)) {
	            System.out.println("The array is in descending order.");
	        } else {
	            System.out.println("The array is neither in ascending nor descending order.");
	        }
	    }

	    public static boolean isAscending(int[] arr) {
	        for (int i = 1; i < arr.length; i++) {
	            if (arr[i - 1] > arr[i]) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public static boolean isDescending(int[] arr) {
	        for (int i = 1; i < arr.length; i++) {
	            if (arr[i - 1] < arr[i]) {
	                return false;
	            }
	        }
	        return true;
	    }
	}


}
