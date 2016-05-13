package CPUSchedulig;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 
public class Scheduler {
	int numberOfProcesses;
	int waitingTime = 0;
	//ArrayList to hold the process
	private ArrayList<Process> processes=new ArrayList<Process>();
	private ArrayList<Process> processes1=new ArrayList<Process>();
	private ArrayList<Process> processes2=new ArrayList<Process>();
	 
	void addProcess(Process p)
	{
		processes.add(p);
        processes1.add(p);
        processes2.add(p);
		numberOfProcesses++;
	}
 
	private void setProcessesWaitingandresponseTime_FCFS()     //set response FCFS
	{
		sortFCFS(processes2);
		int waitingTime=0;
		int responseTime=0;//(processes2.get(0)).getBurstTime();
 
		for (int i = 0; i < numberOfProcesses; i++) 
		{
			Process tempProcess = (Process) processes2.get(i);
			tempProcess.setWaitingTime(waitingTime);
			tempProcess.setresponseTime(responseTime);
			waitingTime+=tempProcess.getBurstTime();
			//Process tempProcess1 = (Process) processes2.get(i+1);
			responseTime+=tempProcess.getBurstTime();
 
		}
 
	}
	void schedule_FCFS() 
	{
		
		setProcessesWaitingandresponseTime_FCFS();
			double avrage=0;
				System.out.println("\t.....FCFS Sedheduling....");
			 for(int i=0 ; i<numberOfProcesses;i++)
			 {
				 System.out.println("The processeor schedule process : "
							+ (processes2.get(i)).getName() + " that has the burst time : "
							+ (processes2.get(i)).getBurstTime() + " waiting Time: "
							+ (processes2.get(i)).getWaitingTime()+" responseTime:"
							+(processes2.get(i)).getresponseTime());
				 avrage+=(processes.get(i)).getWaitingTime();
			 }
			 System.out.println("Avrage waitint Time for The FCFS is: "+ (double)(avrage/numberOfProcesses));
	 }
 

		//Sort Processes
	private void sortProcesses(ArrayList<Process>pro)
	{
		
		for(int i=1; i<pro.size();i++)
		{
			if((pro.get(0).getArrivalTime()!=0 && pro.get(i).getArrivalTime()==0 )|| ((pro.get(0).getArrivalTime()==0 && pro.get(i).getArrivalTime()==0) && (pro.get(0).getArrivalTime()>pro.get(i).getArrivalTime() )))
				Collections.swap( pro,  i,  0);
		}

		for(int i=1; i<pro.size();i++)
		{
			for(int j=i+1;j<pro.size();j++)
			{
				if(pro.get(i).getBurstTime()>pro.get(j).getBurstTime() &&(pro.get(i).getArrivalTime()!=0 ||pro.get(j).getArrivalTime()!=0 ))
					Collections.swap( pro,  i,  j);
			}
		}
	}
 
	
	private void setProcessesWatingTimeandresponsetime_SJF()
	{
		sortProcesses(processes1);
		int waitingTime=0;
		int responseTime=processes1.get(0).getBurstTime();
		int starttime=0;
		for (int i = 0; i < processes1.size(); i++) 
		{
			
			Process tempProcess = (Process) processes1.get(i);
			responseTime=starttime-tempProcess.getArrivalTime()+ tempProcess.getBurstTime();
			tempProcess.setWaitingTime(waitingTime);
			tempProcess.setresponseTime(responseTime);
			waitingTime+=tempProcess.getBurstTime();
			starttime=starttime+tempProcess.getBurstTime();
 
		}
	}
 
 
	private void schedule_SJF_Non_Prem() 
	{

		setProcessesWatingTimeandresponsetime_SJF();
                //sortProcesses(processes1);
		int avrage=0;
		System.out.println("\t\t\t.....SJF_Non_Premitive Sedheduling....");
 
		for(int i=0 ; i<processes1.size();i++)
		{
			System.out.println("The processeor schedule process : "
					+ (processes1.get(i)).getName() + " that has the burst time : "
					+ (processes1.get(i)).getBurstTime() + " waiting Time: "
					+ (processes1.get(i)).getWaitingTime()+" responseTime:"
					+ (processes1.get(i)).getresponseTime());
			avrage+=(processes1.get(i)).getresponseTime();
		}
		System.out.println("Avrage response Time for The FCFS is: "+ avrage/numberOfProcesses);
	}
 
		void setProcessresponseTime_RR(int q)
	{

			System.out.println("Strategy of  Round Robin ");
			sortFCFS(processes); ////*****************
		Boolean flag=true;
		int starttime=0;
		while(flag)
		{
			flag=false;
			
			for(int i=0 ;i<numberOfProcesses;i++)
			{
				int responseTime=0;
				int newburst=0;
				if(processes.get(i).getBurstTime()>0 && processes.get(i).getR()==true)
				{
					
					Process tempProcess=(Process) processes.get(i);
					responseTime=starttime- tempProcess.getArrivalTime()+tempProcess.getBurstTime();
					tempProcess.setresponseTime(responseTime);
					tempProcess.setR(false);
					if(tempProcess.getBurstTime()-q>0)
					{
						
						newburst=tempProcess.getBurstTime()-q;
						tempProcess.setBurstTime(newburst);
						//processes.remove(processes.get(i));
						System.out.println(tempProcess.getName());
						processes.set(i, tempProcess);
						starttime+=q;
						flag=true;
					}
					else if (tempProcess.getBurstTime()-q<=0)
					{
						System.out.println(tempProcess.getName());

						starttime+=tempProcess.getBurstTime();
						tempProcess.setBurstTime(0);
						//processes.remove(i);
						processes.set(i, tempProcess);
						flag=true;
					}
				}
				else if(processes.get(i).getBurstTime()>0 && processes.get(i).getR()==false)
				{
					Process tempProcess=(Process) processes.get(i);

					if(tempProcess.getBurstTime()-q>0)
					{					
						System.out.println(tempProcess.getName());

						newburst=tempProcess.getBurstTime()-q;
						tempProcess.setBurstTime(newburst);
					//	processes.remove(i);
						processes.set(i, tempProcess);

						starttime+=q;
						flag=true;
					}
					else if (tempProcess.getBurstTime()-q<=0)
					{
						System.out.println(tempProcess.getName());

						starttime+=tempProcess.getBurstTime();

						tempProcess.setBurstTime(0);
						//processes.remove(i);
						processes.set(i, tempProcess);

					
						flag=true;
					}

				}
			}
		}
	}
	
		private void sortFCFS(ArrayList<Process>pro)
		{
			for(int i=0; i<pro.size()-1;i++)
			{
				for(int j=i+1;j<pro.size();j++)
				{
					if(pro.get(i).getArrivalTime()>pro.get(j).getArrivalTime())
						Collections.swap( pro,  i,  j);
				}
			}
		}
		
		private void schedule_RR(int q) 
		{
			 setProcessresponseTime_RR(q);
	 
	                
			double avrage=0;
			System.out.println("\t\t\t.....Round Robin Sedheduling....");
	 
			for(int i=0 ; i<processes.size();i++)
			{
				System.out.println("The processeor schedule process : "
						+ (processes.get(i)).getName() + " that has the burst time : "
						+ (processes.get(i)).getBurstTime() + " waiting Time: "
						+" responseTime:"
						+ (processes.get(i)).getresponseTime());
				avrage+=(processes.get(i)).getresponseTime();
			}
			System.out.println("Avrage response Time for The RR is: "+(double)(avrage/numberOfProcesses));
		}
		
	
		public static void main(String[] args) {
			// Create processes
			
			Scanner input = new Scanner(System.in);
			Scheduler scheduler = new Scheduler();
			System.out.println("Enter Number of Process:");
			int numberOfProcesses= input.nextInt();
			System.out.println("Enter Round robin Time Quantum:");
			int RR= input.nextInt();
			String Name ;
			int Arrival;
			int Burst;
			for(int i=1 ;i<=numberOfProcesses;i++)
			{
				 System.out.println("Enter Process "+ i+" Name");
				 Name =input.next();
				 System.out.println("Enter Process "+ i+" Arrival Time");
				 Arrival =input.nextInt();
				 System.out.println("Enter Process "+ i+" Burst Time");
				 Burst =input.nextInt();
				 Process p1 = new Process(Arrival, Burst, Name);
				 scheduler.addProcess(p1);
				 
					
			}	
	
			scheduler.schedule_FCFS();
			scheduler.schedule_SJF_Non_Prem();
			scheduler. schedule_RR(10) ;
			
			
			
		}
	}