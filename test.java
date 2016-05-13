import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class test {
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
	public static void main(String[] args) {
		

		
	}
}
