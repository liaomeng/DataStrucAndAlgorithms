package com.liao.sort;

public class HeapSortTest {
	public static void main(String[] args) {
		int[] array={12,101,34,93,19,1000};
		HeapSortTest heapSortTest=new HeapSortTest();
		heapSortTest.heapSort(array);
		for(int i:array){
			System.out.print(i+" ");
		}
	}
	
	
	public void heapSort(int[] array){
		int len=array.length;
		for(int i=len/2-1;i>=0;i--){             //make up the heap 
			heapAjust(array, i, len);
		}
		for(int i=len-1;i>0;i--){
			swap(array, 0, i);
			heapAjust(array, 0, i);
		}
	}
	
	public void heapAjust(int[] array,int i,int len){
		int child = 0;
		int tmp;
		for(tmp=array[i];leftChild(i)<len;i=child){
			child=leftChild(i);
			if(child!=len-1&&array[child]<array[child+1]){
				child++;
			}
			if(tmp<array[child]){
				array[i]=array[child];
			}
			else{
				break;
			}
		}
		array[i]=tmp;
	}
	public int leftChild(int i){
		return 2*i+1;
	}
	public void swap(int[] array,int i,int len){
        int temp = array[i];
        array[i] = array[len];
        array[len] = temp;
	}

}


