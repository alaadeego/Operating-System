package threadiing;

import java.util.ArrayList;
import java.util.Arrays;

public class sort extends Thread{
	static void  merge(ArrayList<Integer> L,ArrayList<Integer> R,ArrayList<Integer> A)
	{
		int nl=L.size();
		int nr=R.size();
		int i=0,j=0,k=0;
	

		while(i<nl && j<nr)
		{
			if(L.get(i)<= R.get(j))
			{
				A.set(k, L.get(i));
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
	public static void mergesort(final ArrayList<Integer> A)
	{
		int n =A.size();
		if(n<2)
			return ;
		
		int mid=n/2;
		final ArrayList<Integer> left=new ArrayList<Integer>();
		final ArrayList<Integer> right=new ArrayList<Integer>();
		
		for(int i=0;i<mid;i++)
			left.add(A.get(i));
		for(int i=mid;i<n;i++) //*/
			right.add(A.get(i));
//		for(int i=0;i<mid;i++)
//			right.add(A.get(i));
		
		for(int i=0;i<mid-1;i++)
		{
			
			left.set(i, A.get(i));
		}
		for(int i=mid;i<n-1;i++)
		{
			right.set(i-mid, A.get(i));
		}
		Thread t=new Thread(new Thread(){
			public void run()
			{
				System.out.println("Thread left is working ");
				mergesort(left);
			}
		});		
		
		Thread t1=new Thread(new Thread(){
			public void run()
			{
				System.out.println("Thread right is working ");
				mergesort(right);
			}
		});		
		

		t.start();
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t2=new Thread(new Thread(){
			public void run()
			{
				System.out.println("Thread merge is working ");
				merge(left,right,A);
			}
		});	
		t2.start();
//		t2.setPriorit();
		
	
		
	}
	public static void main(String[] args) {

		ArrayList<Integer>A=new ArrayList<Integer>(Arrays.asList(3,4,5,6,7,3,1,2,9,55,1,2,44));
		mergesort(A);
		Thread.currentThread().setPriority(MIN_PRIORITY);
		System.out.println("Thread Main is working");
		for(int i=0;i<A.size();i++)
		{
			System.out.print(A.get(i)+ " ");
		}
	}

}
