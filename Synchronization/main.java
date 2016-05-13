package Synchronization;


import java.util.Scanner;

public class main 
{
	
	public static void main(String []args)
	{
		String buffer ="";
		int THwrite_size = 0;
		int THread_size = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println(".....Synchronizaiton Program.....");
		System.out.print("Enter Buffer content: ");
		buffer = scan.nextLine();
		
		Buffer buf = new Buffer(buffer); 
		
		
		System.out.println("\nEnter Number of reader threads : ");
		THread_size = scan.nextInt();
		
		System.out.println("\nEnter Number of Write threads : ");
		THwrite_size = scan.nextInt();
		
		
		
		Write [] writes = new Write[THwrite_size];
		Read  [] reads = new Read[THread_size];
		
		for(int i = 0; i<THread_size ; i++)
		{
			System.out.print("\nEnter Thread read "+ i + " name : ");
			String s=scan.next();
			reads[i] = new Read(s,buf);
			
		}
		for(int i = 0; i<THwrite_size ; i++)
		{
			System.out.println("Enter The Name of Thread "+i+" and Word to Write..");
			String n=scan.next();
			String w=scan.next();
			writes[i] = new Write(n,buf,w);
			
		}
		
		for(int i = 0; i<THread_size ; i++)
		{
			reads[i].start();
			
		}
		for(int i = 0; i<THwrite_size ; i++)
		{
			writes[i].start();	
		}
		
		System.out.println("\n"+buf.str);		
	}

}