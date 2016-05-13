import java.util.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;



public class CLI {
	private static final String MAIN_PATH = "C:\\Users\\HP WIN 8\\Desktop\\files\\";
	public void ls()
	{
		File folder = new File(MAIN_PATH);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) 
		    {
		      if (listOfFiles[i].isFile()) 
		      {
		        System.out.println("File " + listOfFiles[i].getName());
		      }
		      else if (listOfFiles[i].isDirectory()) 
		      {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
	}
	public void lsa(String path)
	{
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) 
	    {
	      if (listOfFiles[i].isFile()) 
	      {
	        System.out.println("File " + listOfFiles[i].getName());
	      }
	      else if (listOfFiles[i].isDirectory()) 
	      {
	        System.out.println("Directory " + listOfFiles[i].getName());
	      }
	    }
	}
	public void pwd()
	{
		try {
		System.out.println("Current user Dir:"+new java.io.File( "." ).getCanonicalPath());
		System.out.println("Current user Dir using System:" + System.getProperty("user.dir"));
		

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean cd(String directory_name) 
	{
		boolean result = false;  
		File directory = new File(directory_name).getAbsoluteFile();
	    if (directory.exists() || directory.mkdirs())
        {
	    	result = (System.setProperty("user.dir", directory.getAbsolutePath()) != null);
	    }
	    return result;
	}
	public void mkDir(String Foldername)
	{
		File theDir = new File(Foldername);
		if (!theDir.exists()) 
		{
		    boolean result = false;
		    try
		    {
		        theDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se)
		    {
		        System.out.println("Error in Creating Directory");
		    }        
		    if(result)
		    {    
		    	System.out.println("Directory Created.....");  
				lsa("C:\\Users\\HP WIN 8\\workspace\\Operating Sys");
		    }
		    
		}
		else
			System.out.println("Can't Creat Exist Director.....");
	 		
	 }
	public void Clear() throws IOException, InterruptedException 
	{
	 
		for(int i=0 ; i<40;i++)
			System.out.println();
	// Runtime.getRuntime().exec("cls");
//		try {			
//			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public void cp(File source,File dest) throws IOException,InterruptedException
	{
		InputStream input = null;
		OutputStream output = null;
	    try {
		
		     input = new FileInputStream(source);
		     output = new FileOutputStream(dest);
		     byte[] buf = new byte[1024];
		     int bytesRead;
		     while ((bytesRead = input.read(buf)) > 0) 
		     {
		    	 output.write(buf, 0, bytesRead);
		     }
		    
		   } finally {
		    	input.close();
		        output.close();
		        }
 
	}
	public void mv(String source,String des)    //move file
	{
		try{
	    	   File old =new File(source);
	 
	    	   if(old.renameTo(new File(des+ old.getName()))){
	    		System.out.println("File is moved successfully to the new folder !");
	    	   }
	    	   else
	    	   {
	    		System.out.println("File is failed to move!");
	    	   }
	 
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	}

	public void  rm(String filename)           //remove file
	{
		try
		{
			File file = new File(filename);
			if(file.delete())
			{
				System.out.println(file.getName() + " Is Deleted..");
			}
			else
			{
				System.out.println("Delete Operation Is Failed.");
			}

		}
		catch(Exception e)
		{ e.printStackTrace(); }
		
	 }
	public void  rmr(String path)             //remove folder inside the directory and the directory
	{
		File file = new File(path);
		if(file.exists())
		{
			String[]entries = file.list();
			for(String s: entries)
			{
				File currentFile = new File(file.getPath(),s);
			    currentFile.delete();
			}
			 System.out.println(" Directory : \""+file.getPath()+ "\"is Deleted.");
		    file.delete();
		}
		else
			System.out.println("File or Folder Not Found : "+path);
			
	}
	public void  rmdir(String path)                 //remove the folder and files inside the directory 
	{
		File file = new File(path);
		if(file.exists())
		{
			String[]entries = file.list();
			for(String s: entries)
			{
				File currentFile = new File(file.getPath(),s);
			    currentFile.delete();
			}
			
		}
		else
			System.out.println("File or Folder Not Found : "+path);
			
	}
	
	public void cat(File file1,File file2) throws IOException, InterruptedException
	{
		cp(file1,file2);
	}
	public void cat(String file1) throws IOException
	{
		InputStream input = new BufferedInputStream(new FileInputStream(file1));
		byte[] buffer = new byte[8192];

		try {
		    for (int length = 0; (length = input.read(buffer)) != -1;) {
		        System.out.write(buffer, 0, length);
		    }
		} finally {
		    input.close();
		}
	}
	public void date()
	{
		Date date = new Date();
        System.out.println(date.toString());
   
	}
	public void args()
	{
		System.out.println("\nmkdir: <dir name>");
		System.out.println("\nrmdir: < dir path>");
	    System.out.println("\nls: <no argument>  OR  <dir path>");
	    System.out.println("\nmv: <file name> <file name> ");
	    System.out.println("\ncp: <file name> <file name>");
	    System.out.println("\ncd: <path>"); 
	    System.out.println("\npwd: <no argument>");
	    System.out.println("\ncat:  <file name> oR <file name1, file name2 >");
	    System.out.println("\nclear: <no argument>");
		   
	}
	
	public void help()
	{
		   System.out.println("\nmkdir: Create New Directory");
		   System.out.println("\nrmdir: Delete An Existent Directory");
		   System.out.println("\nls   : List All Files And Directories");
		   System.out.println("\nmv   : Cut The content of file and paste it to another file  ");
		   System.out.println("\nrmv  : delete file");
		   System.out.println("\ncd   : change directory"); 
		   System.out.println("\npwd  : Show The Current Corking Directory");
		   System.out.println("\ncat  : if 1 parameter disply the content of 1 file and if 2 parameters "
		   		+ "display the content of the first file then the content of the second file  ");
		   System.out.println("\nclear: clear the screen");
	}
	public void find(String name,File file)
    {
        File[] list = file.listFiles();
        if(list!=null)
        for (File fil : list)
        {
            if (fil.isDirectory())
            {
                find(name,fil);
            }
            else if (name.equalsIgnoreCase(fil.getName()))
            {
                System.out.println(fil.getParentFile());
            }
        }
    }
	public void search(String path1,String path2) throws IOException
	{
		File file1 = new File(path1);
		File file2 =new File(path2);
		BufferedReader br = new BufferedReader(new FileReader(file1));
	    String line;
	    while((line = br.readLine()) != null) 
	    {
	    	final Scanner scanner = new Scanner(file2);
			while (scanner.hasNextLine()) 
			{
				final String lineFromFile = scanner.nextLine();
			    if(lineFromFile.contains(line)) 
			    { 
			       // a match!
				       System.out.println("I found " +line+ " in file " +file2.getName());
				       break;
				}
			}
        }
		
		
	}
	
	
}

