package com.liao.sort;

public class HeapSort {
	public static void main(String[] args) {
		int[] array={12,101,34,93,19,1,1000};
		HeapSort heapSort=new HeapSort();
		heapSort.heapSort(array);
		for(int i:array){
			System.out.print(i+" ");
		}		
	}
	public void heapSort(int[] array){
		int length=array.length;
		for(int i=length/2-1;i>=0;i--){
			heapAjust(array, i, length);
		}
		for(int i=length-1;i>0;i--){
			swap(array, 0, i);
			heapAjust(array, 0, i);
		}
	}
	public void heapAjust(int[] array,int i,int length){
		int child;
		int tmp;
		while((child=2*i+1)<length){
			tmp=child;
			if((child+1)<length&&array[child+1]>array[child]){
				tmp++;
				
			}
			else if(child+1>=length&&array[child]<array[i]){
				
			}
			if(array[tmp]>array[i]){
				swap(array, i, tmp);
			}
			else{
				break;
			}
			i=tmp;
		}
	}
	public void swap(int[] array,int i,int len){
        int temp = array[i];
        array[i] = array[len];
        array[len] = temp;
	}
}
