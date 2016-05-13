package Synchronization;



public class Read extends Thread {
	
	private String name;
	private Buffer buf;
//	public Read()
//	{
//		buf = new Buffer();
//	}
	public Read(String n,Buffer b)
	{
		name = n;
	    buf = b;
	}
	public void run()
	{
		System.out.println(name+" Start Reading");
		buf.read(name);
	    

	}

}