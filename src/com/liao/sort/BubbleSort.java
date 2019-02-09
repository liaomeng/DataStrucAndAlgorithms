package com.liao.sort;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] array={60,7,2,9,10,43,34,99,3};
		BubbleSort bubbleSort=new BubbleSort();
		bubbleSort.bubbleSort(array, array.length);
		for(int i:array){
			System.out.print(i+" ");
		}	
	}
	public void bubbleSort(int[] array, int length){
		for(int i=0;i<length;i++){
			for(int j=0;j<length-i-1;j++){
				if(array[j]>array[j+1]){            //if(array[j]>=array[j+1])   unstable
					swap(array, j, j+1);
				}
			}
		}
	}
	
	public void swap(int[] array,int i,int j){
		int tmp=array[i];
		array[i]=array[j];
		array[j]=tmp;
	}
}
