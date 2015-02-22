// merge two sorted arrays into a new one
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;



public  class Merge2Arrays
{
    private static  void addRest(int arrC[], int arr[], int cIndex, int index, String arrayName)
    {
	System.out.println("         addrest from array:" + arrayName);
	for (int i = index; i< arr.length; i ++)
	    arrC[cIndex++] = arr[i];
    }
    public static int[] merge2Arrays(int arrA[], int arrB[])
    {
	int aLen = arrA.length;
	if (aLen == 0)
	    return arrB;
	
	int bLen = arrB.length;
	if (arrB.length == 0)
	    return arrA;

	int arrC[] = new int[aLen + bLen];
	
	int aIndex = 0;
	int bIndex = 0;
	int cIndex = 0;
	
	while (true)
	    {
		System.out.println("aIndex:" + aIndex + "' bIndex:" + bIndex);
		while (aIndex < aLen && arrA[aIndex] <= arrB[bIndex] )
		    {
			//System.out.println("         adding from arrA:" +  arrA[aIndex]);
			arrC[cIndex++] = arrA[aIndex++];			
		    }
		if ( aIndex  == aLen)
		    {
			addRest(arrC, arrB, cIndex, bIndex, "arrayB");
			return arrC;
		    }
		while ( aIndex <aLen && bIndex < bLen && arrB[bIndex] <= arrA[aIndex])

		    {
			//System.out.println("         adding from arrB:" +  arrB[bIndex]);
			arrC[cIndex++] = arrB[bIndex++];			
		    }
		
		if ( (bIndex  == bLen)  &&  (aIndex  != aLen))
		    {
			addRest(arrC, arrA, cIndex, aIndex, "arrayA");
			return arrC;
		    }			    
	    }
	
    }


    private static void printArray(int arr[])
    {
	for (int i=0; i< arr.length; i++)
	    System.out.print(arr[i] + ", ");

	System.out.println();
    }
   

    public static void main(String[] args) 
    {
	int arr1[]={1,3,5,6,8,9,10};
		    int arr2[]={3,4,6,7,8};
	int arr[] = merge2Arrays(arr1,arr2);
	
	printArray(arr1);
	printArray(arr2);
	printArray(arr);
	 
    }
	
}