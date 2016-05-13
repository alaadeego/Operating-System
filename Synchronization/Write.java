package Synchronization;
public class Write extends Thread 
{
	
	private String name;
	private Buffer buffer;
	private String word;
//	public Write()
//	{
//		buffer = new Buffer();
//	}
	public Write(String name,Buffer buffer,	String word)
	{
		this.name =name;
		this.buffer = buffer;
		this.word = word;
	}
	public void run()
	{
	    System.out.println(name+" Start writeing");
		 buffer.write(word,name);
		
	}

}
