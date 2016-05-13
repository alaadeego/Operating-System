import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CommandLineInterperter {

	public static void main(String[] args) throws InterruptedException, IOException {
		CLI Command=new CLI();
		Scanner input = new Scanner(System.in); 
		String command,path;
		  while(true)
		  {
			  System.out.println("$");
			  command=input.next();
			  if(command.equals("ls"))
			  {
				  Command.ls();
			  }
			  else if(command.equals("lsa"))
			  {
				  //path="C:\\Users\\HP WIN 8\\Desktop\\files\\";
				  path=input.next();
				  Command.lsa(path);
			  }
			  else if (command.equals("pwd"))
			  {
				  Command.pwd();
			  }
			  else if(command.equals("cd"))
			  {
				  path=input.next();
				  Command.cd(path);
			  }
			  else if(command.equals("mkdir"))
			  {
				  String Folder;
				   Folder=input.next();
				  Command.mkDir(Folder);
			  }
			  else if(command.equals("clear"))
			  {
				  Command.Clear();
			  }
			  
			  else if(command.equals("cp"))
			  {
				  File source=new File("C:\\Users\\HP WIN 8\\Desktop\\files\\file1.txt");
				  File dest= new File("C:\\Users\\HP WIN 8\\Desktop\\files\\alaa.txt");
				  Command.cp(source,dest);
			  }
			  
			  else if(command.equals("mv"))
			  {
//				  String s=input.next();
//				  String d=input.next();
				  String s="C:\\Users\\HP WIN 8\\Desktop\\files\\file2.txt";
				//  String s="C:\\Users\\HP WIN 8\\Desktop\\files\\alaa.txt\\";

				  String d="C:\\Users\\HP WIN 8\\Desktop\\files\\folder1\\";
				  
				  Command.mv(s, d);
			  }
			  else if(command.equals("rm"))
			  {	
				  System.out.println("Enter file path pleas");
				  String filename="C:\\Users\\HP WIN 8\\Desktop\\files\\alaa.txt";
				  Command.rm(filename);
			  }
			  else if(command.equals("rmr"))
			  {
				  System.out.println("Enter file path pleas");
				  String filename=input.next();
				  Command.rmr(filename);
			  }
		 
			  else if(command.equals("find"))
			  {
				
			        System.out.println("Enter the file to be searched.. " );
			        String name ="rahaf.txt";
			        System.out.println("Enter the directory where to search ");
			        String directory ="C:\\Users\\HP WIN 8\\Desktop\\files\\";
			        Command.find(name,new File(directory));

			  }
			  else if (command.equals("search"))
			  {
				  String path1="C:\\Users\\HP WIN 8\\Desktop\\files\\alaa.txt";
				  String path2="C:\\Users\\HP WIN 8\\Desktop\\files\\file2.txt";
				  Command.search(path1, path2);
				  
			  }
			  else if(command.equals("date"))
			  {
				  Command.date();
			  }
			  else if(command.equals("args"))
			  {
				  Command.args();
			  }
			  else if(command.equals("help"))
			  {
				  Command.help();
			  }
			  else if(command.equals("cat1"))
			  {
				  String filename="C:\\Users\\HP WIN 8\\Desktop\\files\\file1.txt\\";
				  Command.cat(filename);
			  }
			  else if(command.equals("cat"))
			  {
				  File source=new File("C:\\Users\\HP WIN 8\\Desktop\\files\\file1.txt");
				  File dest= new File("C:\\Users\\HP WIN 8\\Desktop\\files\\file2.txt");
				  Command.cp(source, dest);
			  }
			  else if (command.equals("rmdir"))
			  {
				  String path1=input.next();
				  Command.rmdir(path1);
			  }
			  
			  else if(command.equals("Exit"))
				  break;
			  else 
				  System.out.println("command not found ");
	}
		  
	

	}

}