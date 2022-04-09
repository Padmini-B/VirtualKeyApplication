import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Submenu {
	Mainmenu m=new Mainmenu();
	Scanner sc=new Scanner(System.in);
	String filepath="C:\\Users\\vbollineni\\Desktop\\files";
	public void submenu() {
		int y;
		do {
			System.out.println("File Operations:");
			System.out.println("  1.Add File");
			System.out.println("  2.Delete File");
			System.out.println("  3.Search File");
			System.out.println("  4.Main menu");
			System.out.println("Choose the option you want:");
			int option=sc.nextInt();
			switch(option)
			{
					case 1:
						addfile();
						break;
					case 2:
						deletefile();
						break;
					case 3:
						searchfile();
						break;
					case 4:
						m.mainmenu();
						break;
					default:
		                System.out.println("Invalid Input");
		                break;
			}
			System.out.println("Do you want to Continue..? Press 1/0");
			y=sc.nextInt();
		}while(y==1);
	}
	private void searchfile() {
		Mainmenu m=new Mainmenu();
		Boolean found = false;
		System.out.println("Enter File name to search:");
		String fname=sc.next();
		File file = new File(filepath);
		ArrayList<File> files = m.getfiles();
		for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fname)) {
				System.out.println("File found at " + file.getAbsolutePath());
				found = true;
				break;
			}
        }
        if (found == false) {
        	System.out.println("File Not Found");
        }
		
	}
	private void deletefile() {
		System.out.println("Enter File name you want to delete:");
		String name=sc.next();
		File file = new File(filepath+"\\"+name);
		try  
		{                     
			System.out.println("File exists: " + file.exists());
			if(file.delete())                        
			{  
				System.out.println(file.getName() + " deleted successfully");    
				m.getfiles().remove(file);
			}  
			else  
			{  
				System.out.println("File Not Found");  
			}  
		}  
		catch(Exception e)  
		{  
			e.printStackTrace();  
		} 
		
	}
	private void addfile() {
		System.out.println("Enter File name to add:");
		String name=sc.next();
		boolean res;
		File file = new File(filepath+"\\"+name);
		try {
			res=file.createNewFile();
			if(res)
			{
				System.out.println("File added to "+file.getCanonicalPath());
				m.getfiles().add(file);
			}
			else  
			{  
				System.out.println("File already exist at location: "+file.getCanonicalPath());  
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
