package com.liao.sort;

import java.util.Stack;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] array={60,7,2,9,10,43,34,99,3};
		int length=array.length;
		QuickSort quickSort=new QuickSort();
		quickSort.quickSort(array, 0, length-1);
		for(int i:array){
			System.out.print(i+" ");
		}
	}
	
	
	public void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
	}
	
	
	//以最后一位为基准 ，每次遍历分区
	//遍历式分区，比基准小的放在左边子数组
	public int partition(int[] array,int left,int right){
		int standard=array[right];
		int tail=left-1;
		for(int i=left;i<right;i++){
			if(array[i]<=standard){
				swap(array, ++tail, i);
			}
		}
		swap(array, tail+1, right);
		return tail+1;
	}
	
	public int getMid(int[] array ,int left,int right){
		int mid =left+((right-left)>>1);
		if(array[left]<=array[right]){
			if(array[mid]<array[left]){
				return left;
			}
			else if(array[mid]>array[right]){
				return right;
			}
			else
				return mid;
		}
		else{
			if(array[mid]<array[right]){
				return right;
			}
			else if(array[mid]>array[left]){
				return left;
			}
			else{
				return mid;
			}
		}

	}
	
	//左右指针法
	int PartSort1(int[] array,int left,int right){
		int mid=getMid(array, left, right);
		swap(array, mid, right);
		int key=array[right];
		while(left<right){
			while(left<right&&array[left]<=key){
				++left;
			}
			while(left<right&&array[right]>=key){
				--right;
			}
			swap(array, left, right);
		}
		swap(array, left, key);
		return left;
	}
	
	//挖坑法
	int PartSort2(int[] array,int left,int right){
		int mid =getMid(array, left, right);
		swap(array, mid, right);
		int key=array[right];
		
		while(left<right){
			while(left<right&&array[left]<=key){
				++left;
			}
			swap(array, left, right);
			while(left<right&&array[right]>=key){
				--right;
			}
			swap(array, right, left);
		}
		array[right]=key;
		return right;
	}
	
	int PartSort3(int[] array,int left,int right){
		int mid =getMid(array, left, right);
		swap(array, mid, right);
		if(left<right){
			int key=array[right];
			int cur=left;
			int pre=left-1;
			while(cur<right){
				while(array[cur]<key&&++pre!=cur){
					swap(array, cur, pre);
				}
				++cur;
			}
			swap(array, ++pre, right);
			return pre;
		}
		return -1;
	}
	
	//递归实现
	public void quickSort(int[] array,int left,int right){
		if(left>=right){
			return;
		}
		int standard_index=partition(array, left, right);
		quickSort(array, left, standard_index-1);
		quickSort(array, standard_index+1, right);
	}
	
	//非递归实现
	public void QuickSortNotR(int[] array,int left,int right){
		Stack<Integer> s=new Stack<>();
		s.push(left); 
		s.push(right);
		while(!s.empty()){
			int rightIndex=s.pop();
			int leftIndex=s.pop();
			int index = PartSort1(array,leftIndex,rightIndex);
	        if((index - 1) > left)//左子序列
	        {
	            s.push(left);
	            s.push(index - 1);
	        }
	        if(((index) + 1) < leftIndex)//右子序列
	        {
	            s.push(index + 1);
	            s.push(rightIndex);
	        }
		}
	}
}
