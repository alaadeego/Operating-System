package Synchronization;

public class Semaphore {
	
	protected int value = 0;
	protected int valueR =5;
	
	 protected Semaphore() 
	 {
		 value = 1;
		 valueR=5;
		 

	 }

	  protected Semaphore(int initial)
	  {
		  value = initial ; 
	
	  }

	  public synchronized void Pr(String name) 
	  {
		  value-- ;
		  valueR--;
		  if (valueR < 0)
		  {
			  System.out.println(name + " Blocked");
			  try {
				wait();
			} catch (InterruptedException e) {}
		  }
		      
	
	  }
	  
	  public synchronized void Vr() 
	  {
		    value++ ; 
		    valueR++;
		    if (valueR <= 0)
		    {
		    	notify() ;
		    }
	
	  }

	  public synchronized void P(String name) 
	  {
		  value-- ;
		  if (value < 0)
		  {
			  System.out.println(name + " Blocked");
			  try {
				wait();
			} catch (InterruptedException e) {}
		  }
		      
	
	  }
	  
	  public synchronized void V() 
	  {
		    value++ ; 
		    if (value <= 0)
		    {
		    	notify() ;
		    }
	
	  }



	

}
