package screenshotMethod;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommonMethods {
	
	
	
	
	public String CreateFolder(String FolderPath,String FolderName) throws Exception 
	{
		String CreatedFolderPath = null;
		try 
		{
			CreatedFolderPath = FolderPath+FolderName+"\\";
			File tmpDir = new File(CreatedFolderPath);
			boolean exists = tmpDir.exists();
			if (exists != true) 
			{
				File f2 = new File(CreatedFolderPath);
				f2.mkdir();
				if(tmpDir.exists()==true)
				{
					System.out.println("Folder is sucessfully created.");
				}
				else
				{
					System.out.println("Folder is not created.");
				}
			} 
			else if (exists == true) 
			{
				System.out.println("Folder is already is exists.");
			}
			File f1 = new File(CreatedFolderPath);
			f1.listFiles();
		}
		catch (Exception e) 
		{
			System.err.println("Unable to create folder!!!!!!!!!!!!!");
			System.err.println("Got Exception!!!!!!!!!!!");
			e.printStackTrace();
		}
		
		return CreatedFolderPath;
	}
	
	public boolean CopyFile(String SourceFile,String Destination) throws Exception
	{
		Path sourceDirectory = null, targetDirectory = null;
		boolean Copied = true;
		try 
		{
			sourceDirectory = Paths.get(SourceFile);
	        targetDirectory = Paths.get(Destination);
	        Files.copy(sourceDirectory, targetDirectory);
	        Copied = true;
		}
		catch (Exception e) 
		{
			System.err.println("Unable Copy File!!!!!!!!!!!!");
			System.err.println("!!!!!!!!!Got Exception!!!!!!!!");
			e.printStackTrace();
			Copied = false;
		}
		return Copied;
	}
	
	public boolean MoveFile(String SourceFile,String Destination) throws Exception
	{
		Path sourceDirectory = null, targetDirectory = null;
		boolean Moved = true;
		try 
		{
			sourceDirectory = Paths.get(SourceFile);
	        targetDirectory = Paths.get(Destination);
	        Files.move(sourceDirectory, targetDirectory);
	        Moved = true;
		}
		catch (Exception e) 
		{
			System.err.println("Unable Move File!!!!!!!!!!!!");
			System.err.println("!!!!!!!!!Got Exception!!!!!!!!");
			e.printStackTrace();
			Moved = false;
		}
		return Moved;
	}
}
