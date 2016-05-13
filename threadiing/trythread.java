package threadiing;

import java.util.ArrayList;
import java.util.Arrays;

public class trythread extends Thread{
	static void  merge(ArrayList<Integer> L,ArrayList<Integer> R,ArrayList<Integer> A)
	{
		int nl=L.size();
		int nr=R.size();
		int i=0,j=0,k=0;
		
		

		while(i<nl && j<nr)
		{
			if(L.get(i)<= R.get(j))
			{
				A.set(k, L.get(i)); //*//
				i++;
				
			}
			
			else
			{
				A.set(k, R.get(j));
				j++;
			}
			k++;
		}
		while(i<nl)
		{
			A.set(k,  L.get(i));
			i++;
			k++;
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		while(j<nr)
		{
			A.set(k,  R.get(j));
			j++;
			k++;
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
	}
	public static void mergesort(ArrayList<Integer> A)
	{
		int n =A.size();
		if(n<2)
			return ;
		
		int mid=n/2;
		ArrayList<Integer> left=new ArrayList<Integer>();
		ArrayList<Integer> right=new ArrayList<Integer>();
		
		for(int i=0;i<mid;i++)
			left.add(A.get(i));
		for(int i=mid;i<n;i++) //*/
			right.add(A.get(i));
		
		for(int i=0;i<mid-1;i++)
		{
			
			left.set(i, A.get(i));
		}
		for(int i=mid;i<n;i++)
		{
			right.set(i-mid, A.get(i));
		}
		mergesort(left);
		mergesort(right);
		merge(left,right,A);
		
	}
	public static void main(String[] args) {

		ArrayList<Integer>A=new ArrayList(Arrays.asList(3,4,5,6,7,3,1,2,9,55,1,2,44));
		mergesort(A);
		for(int i=0;i<A.size();i++)
		{
			System.out.print(A.get(i)+ " ");
		}
		//Thread.currentThread().setPriority(newPriority);
	}

}
