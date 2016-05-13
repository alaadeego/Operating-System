package CPUSchedulig;


public class Process {
	private int arrivalTime;
	private int burstTime;
	private int responseTime;
	private int waitingTime;
	private String name;
	private Boolean R;
	
	public Process(int arrivalTime,int burstTime,String name)
	{
		this.arrivalTime=arrivalTime;
		this.burstTime= burstTime;
		this.name=name;
		waitingTime=0;
		responseTime=0;
		R=true;
	}
	public void setR(Boolean R)
	{
		this.R=R;
	}
	public Boolean getR()
	{
		return R;
	}
	
	// Get the arrive time value
		public int getArrivalTime() {
			return arrivalTime;
		}

		// Set the arrive time value
		public void setArrivalTime(int arrivalTime) {
			this.arrivalTime = arrivalTime;
		}

		// Get the burst time value
		public int getBurstTime() {
			return burstTime;
		}

		public int getWaitingTime() {
			return waitingTime;
		}
		
		public void setresponseTime(int responseTime)
		{
			this.responseTime=responseTime;
			
		}
		public int getresponseTime()
		{
			return responseTime;
			
		}

		// Set the burst time value
		public void setBurstTime(int burstTime) {
			this.burstTime = burstTime;
		}

		// Get the process name
		public String getName() {
			return name;
		}
		// Set the process name
		public void setName(String name) {
			this.name = name;
		}

		public void setWaitingTime(int waitingTime) {
			this.waitingTime = waitingTime;
		}




	

}
