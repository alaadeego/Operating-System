package threadiing;
import java.util.Scanner;

public class matrix  extends Thread{

	public static void main(String[] args) {
		Thread.currentThread().setPriority(MAX_PRIORITY);
		Scanner input=new Scanner(System.in);
		int n;
		final int M1[][]=new int [3][3];
		final int M2[][]=new int [3][3];
		final int R[][]=new int [3][3];
		System.out.println("Main is Working ");
		for(int i=0;i<2;i++)
		{
			for(int j=0; j<2;j++)
			{
				n=input.nextInt();
				M1[i][j]=n;
			}
		}
		
		for(int i=0;i<2;i++)
		{
			for(int j=0; j<2;j++)
			{
				n=input.nextInt();
				M2[i][j]=n;
			}
		}
		
		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Thread R1=new Thread(new Thread(){
				public void run()
				{	System.out.println("R1 is working");
					R[0][0]=M1[0][0]*M2[0][0]+M1[0][1]*M2[1][0];
				}
			});
		
	
		
		Thread R2=new Thread(new Thread()
		{
			public void run()
			{
				System.out.println("R2 is working");
				R[0][1]=M1[0][0]*M2[0][1]+M1[0][1]*M2[1][1];
			}
		});
	
		
		Thread R3=new Thread(new Thread()
		{
			public void run()
			{
				System.out.println("R3 is working");
				R[1][0]=M1[1][0]*M2[0][0]+M1[1][1]*M2[1][0];
			}
		});
		Thread R4=new Thread(new Thread()
		{
			public void run()
			{
				System.out.println("R4 is working");
				R[1][1]=M1[1][0]*M2[0][1]+M1[1][1]*M2[1][1];
			}
		});
		R4.start();
		R1.start();
		R3.start();
		R2.start();
		
		Thread.currentThread().setPriority(MIN_PRIORITY);
//	Thread.currentThread().start();
		for(int i=0;i<2;i++)
		{
			for(int j=0 ;j<2;j++)
				System.out.print(R[i][j]+" ");
			System.out.println();
		}
		
	}
	

}
