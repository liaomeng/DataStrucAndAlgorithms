package com.liao.sort;

public class CocktailSort {
	public static void main(String[] args) {
		int[] array={0,60,7,2,9,10,43,34,99,3};
		CocktailSort cocktailSort=new CocktailSort();
		cocktailSort.cocktailSort(array, array.length);
		for(int i:array){
			System.out.print(i+" ");
		}
	}
	
	public void cocktailSort(int[] array,int length){
		int left=0;
		int right=length-1;
		while(left<right){
			for(int i=left;i<right;i++){
				if(array[i]>array[i+1]){
					swap(array, i, i+1);
				}
			}
			right--;
			for(int j=right;j>left;j--){
				if(array[j]<array[j-1]){
					swap(array, j, j-1);
				}
			}
			left++;
		}
	}
	public void swap(int[] array,int i,int j){
		int tmp=array[i];
		array[i]=array[j];
		array[j]=tmp;
	}
}
