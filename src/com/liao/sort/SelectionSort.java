package com.liao.sort;
/*
 * 选择排序是一种简单直观的排序算法。
 * 工作原理：初始时在序列中找到最小（大）元素放到序列的起始位置作为已排序序列；
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，放到已排序序列的末尾;
 * 以此类推，直到所有元素均排序完毕。

注意选择排序与冒泡排序的区别：冒泡排序通过依次交换相邻两个顺序不合法的元素位置，
从而将当前最小（大）元素放到合适的位置；而选择排序每遍历一次都记住了当前最小（大）
元素的位置，最后仅需一次交换操作即可将其放到合适的位置。
 */
public class SelectionSort {
	public static void main(String[] args) {
		int[] array={60,7,2,9,10,43,34,99,3};
		SelectionSort selectionSort=new SelectionSort();
		selectionSort.selectionSort(array);
		for(int i:array){
			System.out.print(i+" ");
		}
	}
	
	public void selectionSort(int[] array){
		int length=array.length;
		for(int i=0;i<length-1;i++){
			int min=i;
			for(int j=i+1;j<length;j++){
				if(array[j]<array[min]){
					min=j;
				}
			}
			if(min!=i){
				swap(array, i, min);
			}
		}
	}
	
	public void swap(int[] array,int i,int j){
		int tmp=array[i];
		array[i]=array[j];
		array[j]=tmp;
	}
}
