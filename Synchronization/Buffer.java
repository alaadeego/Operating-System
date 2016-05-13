package Synchronization;


public class Buffer 
{

	protected static  String str;
    protected Semaphore sem = new Semaphore();	
//	public Buffer()
//	{
//		sem = new Semaphore();
//	}
	public Buffer(String s)
	{
		str = s;
	}
	public void write(String d,String name)
	{
		
		sem.P(name);
		str+=d;
		System.out.println(name+"Writing : "+str);
	    System.out.println(name+" Finished Writing");
		sem.V();
		
		
	}
	public void read(String name)
	{
		
		sem.Pr(name);
		
	    System.out.println(name+"Reading : "+str);
	    System.out.println(name+" Finished Reading");
		sem.Vr();
		
	
	}
	public String getstr()
	{
		return str;
	}
}