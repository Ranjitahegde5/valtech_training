package com.valtech.training;

import java.util.Arrays;
import java.util.List;

public class ArrayMountain {
	
	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(4,5,6,7,3,2,1);
	
		int start=0;
		int next=1;
		int index=0;
		int middle=0;
		while(arr.get(index)<=arr.size()) {
			int current;
			while(arr.get(current)<arr.get(next)) {
				int previous = current;
				current = next;
				next+=1;
				index+=1;
			
			
		}
		middle=current;
		if(arr.get(previous)<arr.get(middle) && arr.get(middle)>arr.get(next)) {
			
		System.out.println("Middle element is "+arr.get(middle));
		asc=true;
		}
		while(arr.get(start) > arr.get(next));  
			start=next;
			
		}
		
		}
		
	}

}
