	package DeadLock;

	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.sun.glass.ui.SystemClipboard;


public class BankerAlgoritm{
	
		private int [] available; 			 	//the available amount of each resource
		private	int [][] maximum; 				//the maximum demand of each process
		private int [][] allocation;			//the amount currently allocation to each process
		private int [][] need;

		BankerAlgoritm(int A,int B,int C)
		{
			available=new int[3];
			maximum=new int [5][3];
			allocation=new int [5][3];
			need=new int [5][3];
			available[0] = A;
	        available[1] = B;
	        available[2] = C;
		}
		
		public void ReadFile() throws IOException
	    {
	        int i=0,j=0;
	        try{
	        	FileReader reader = new FileReader("file.txt");
	        	BufferedReader br = new BufferedReader(reader);
	        	String line;
	        	while((line=br.readLine())!=null)
	        	{
	        		j=0;
	        		String delim = ",";
	        		String tokens[] = line.split(delim);
	 
	 
	        		for(String a : tokens)
	        		{	
	        			maximum[i][j] = Integer.parseInt(a);
	        			j++;
	        		}	
	        		i++;
	        	}	
	        }
	        catch(Exception e)
	        {
	                e.printStackTrace();
	        }
	        for(i=0;i<5;i++)
	        {
	            for( j=0;j<3;j++)
	            {
	                need [i][j] = maximum[i][j];
	               allocation [i][j] = 0;
	 
	            }      
	        }
	    
	    }
		void Status()
		{
			System.out.println("Available:");
			System.out.println("A  B  C");
			System.out.println( available[0] +"  "+ available[1]+"  "+available[2]);
			
			System.out.println("Alocation");
			for(int i=0 ;i<5;i++)
			{
				for(int j=0 ;j<3;j++)
					System.out.print(allocation[i][j]+"  ");
				System.out.println();
			}
			System.out.println("Maximum:");
			for(int i=0 ;i<5;i++)
			{
				for(int j=0 ;j<3;j++)
					System.out.print(maximum[i][j]+"  ");
				System.out.println();
			}
			
			System.out.println("Need:");
			for(int i=0 ;i<5;i++)
			{
				for(int j=0 ;j<3;j++)
					System.out.print(need[i][j]+"  ");
				System.out.println();
			}
			
		}
		
		void Request(int p,int a,int b ,int c)
		{
			if(a<=this.need[p][0] && b<=this.need[p][1] && c<= this.need[p][2])
			{
			if((a<=this.available[0] && b<=this.available[1] && c<= this.available[2]))
			{
				
				/*this.available[0]-=a;
				this.available[1]-=b;
				this.available[2]-=c;
				
				this.need[p][0]-=a;
				this.need[p][1]-=b;
				this.need[p][2]-=c;
				
				this.allocation[p][0]+=a;
				this.allocation[p][1]+=b;
				this.allocation[p][2]+=c;
				*/
				
			int []Avalible= Arrays.copyOf(this.available,3);	
			int [][]Need=new int[5][3];
			int [][]Maximum=new int[5][3];
			int [][]Allocation=new int[5][3];
			for(int i=0;i<5;i++)
			{
				Need[i]=Arrays.copyOf(this.need[i],this.need[i].length);
				Maximum[i]=Arrays.copyOf(this.maximum[i],this.maximum[i].length);
				Allocation[i]=Arrays.copyOf(this.allocation[i],this.allocation[i].length);

			}
				Avalible[0]-=a;
				Avalible[1]-=b;
				Avalible[2]-=c;
				
				Need[p][0]-=a;
				Need[p][1]-=b;
				Need[p][2]-=c;
				
				Allocation[p][0]+=a;
				Allocation[p][1]+=b;
				Allocation[p][2]+=c;

				//if(Banker(this.available, this.need, this.allocation,this.maximum))
				if(Banker(Avalible, Need, Allocation,Maximum))	
				 {
					 System.out.println("System current state is Safe request granted.");
						this.available[0]-=a;
						this.available[1]-=b;
						this.available[2]-=c;
							
						this.need[p][0]-=a;
						this.need[p][1]-=b;
						this.need[p][2]-=c;
							
						this.allocation[p][0]+=a;
						this.allocation[p][1]+=b;
						this.allocation[p][2]+=c;
					//Status();
						
				 }
				 else
				 {
					 System.out.println("System current state is unSafe request not granted.");
					 /*	this.available[0]+=a;
						this.available[1]+=b;
						this.available[2]+=c;
						
						this.need[p][0]+=a;
						this.need[p][1]+=b;
						this.need[p][2]+=c;
						
						this.allocation[p][0]-=a;
						this.allocation[p][1]-=b;
						this.allocation[p][2]-=c;
						
						*/
				 }
					 
				}
			}
			else
				System.out.println("Process"+p+"can't request");
		}
		
		Boolean Banker(int[]Avalible  ,int[][] Need,int[][] Allocation,int [][]Maximum)
		{
			Boolean flag=true;
			Boolean []Process=new Boolean[5];
			Arrays.fill(Process, false);
			
			while(flag)
			{
				flag=false;
				for(int i=0;i<5;i++)
				{
						if ((Process[i]==false)&&(Need[i][0]<=Avalible[0] ) &&  (Need[i][1]<=Avalible[1] )&&  (Need[i][2]<=Avalible[2]))
						{
							flag=true;
							Process[i]=true;
							
							Avalible[0]+=Allocation[i][0];									
							Avalible[1]+=Allocation[i][1];
							Avalible[2]+=Allocation[i][2] ;
							
						}
				}
			}
			
			for(int i=0; i<5;i++)
			{
				if(Process[i]==false)
					return false;	
			}
			return true;
		}
		void Release(int p, int a, int b, int c)
		{
			if(a<=allocation[p][0] && b<=allocation[p][1] && c<=allocation[p][2])
			{
				int []Avalible= Arrays.copyOf(this.available,3);	
				int [][]Need=new int[5][3];
				int [][]Maximum=new int[5][3];
				int [][]Allocation=new int[5][3];
				for(int i=0;i<5;i++)
				{
					Need[i]=Arrays.copyOf(this.need[i],this.need[i].length);
					Maximum[i]=Arrays.copyOf(this.maximum[i],this.maximum[i].length);
					Allocation[i]=Arrays.copyOf(this.allocation[i],this.allocation[i].length);
				}
				Avalible[0]+=a;
				Avalible[1]+=b;
				Avalible[2]+=c;
				Need[p][0]+=a;
				Need[p][1]+=b;
				Need[p][2]+=c;
				Allocation[p][0]-=a;
				Allocation[p][1]-=b;
				Allocation[p][2]-=c;

				if(Banker(Avalible, Need, Allocation,Maximum))
				{
					System.out.println("System current state is Safe .");

					System.out.println("P"+ p +" release"+a +"  "+b +"  "+c +"  ");
					this.available[0] += a;
					this.available[1] += b;
					this.available[2] += c;
					this.need[p][0]+=a;
					this.need[p][1]+=b;
					this.need[p][2]+=c;
					this.allocation[p][0]-=a;
					this.allocation[p][1]-=b;
					this.allocation[p][2]-=c;
				}
				else
					System.out.println("System current state is unSafe .");
			}
			else
				System.out.println("Process"+p+"can't release" );	
		}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BankerAlgoritm Process=new BankerAlgoritm(10,5,7);
		Process.ReadFile();	
		
		Scanner input=new Scanner(System.in);
		int v=1;
		while( v!=0)
		{
			System.out.println("For Status press 1\n for request print 2 \n for relese press 3\n for quit press 0 \n ");
			v=input.nextInt();
			if(v==1)
			{
				Process.Status();
			}
			else if(v==2)
			{
				System.out.println("For resquest Enter p, A ,B ,C : ");
				int p=input.nextInt();
				int a=input.nextInt();
				int b=input.nextInt();
				int c=input.nextInt();
				Process.Request(p,a, b, c);
				
			}
			else if (v==3)
			{
				System.out.println("For release Enter p, A ,B ,C : ");
				int p=input.nextInt();
				int a=input.nextInt();
				int b=input.nextInt();
				int c=input.nextInt();
				Process.Release(p, a, b, c);
				
				
			}
			else if(v==0)
				break;
				
		}
		
	/*	Process.Request(1,2, 0, 0);
		Process.Status();
		Process.Request(2,3, 0, 2);
		Process.Status();
		Process.Release(1,1, 0, 0);
		Process.Status();
   */
		

}
	}

