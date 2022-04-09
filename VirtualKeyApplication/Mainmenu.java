import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Mainmenu {
	
	private ArrayList<File> filelist = new ArrayList<>();
	String filepath="C:\\Users\\vbollineni\\Desktop\\files";
 	public void mainmenu()
 	{
		System.out.println();
		System.out.println("1.Retrieve Files");
		System.out.println("2.File Operations");
		System.out.println("3.Exit application");
		System.out.println("Choose the option you want:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		switch(n)
		{
			case 1:
				this.retrievefiles();
				break;
			case 2:
				Submenu s=new Submenu();
				s.submenu();
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Invalid Input");
		}
 	}
	private void retrievefiles() {
		ArrayList<File> files = this.getfiles();
		Collections.sort(files);
		System.out.println("List of files/folders in the specified directory:");
		for(File f:files)
        {
            System.out.println(f.getName());
        }
	}
	public ArrayList<File> fillfiles() {
	    	
		File file = new File(filepath);
		File flist[]=file.listFiles();
		filelist.clear();
		for (int i = 0; i < flist.length; i++) {
    		if (flist[i].isFile()) {
    			filelist.add(flist[i]);
    		}
		}
	    return filelist;
	}
	public ArrayList<File> getfiles() {
	    	
	    	fillfiles();
	    	return filelist;
	   }
}
