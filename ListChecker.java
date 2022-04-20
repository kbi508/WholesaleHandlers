import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import javax.swing.filechooser.FileSystemView;
import java.util.ArrayList;
public class ListChecker {
	
	public static ArrayList<Item> bigRead() {
		/*Scanner rere = new Scanner(System.in);
		System.out.print("Input File\n");
		String filename = "/" + rere.nextLine();*/
		String filename = "src/data/food.csv";
		Item thing;
		ArrayList<Item> itemList = new ArrayList<Item>();
		File dir = new File(filename);
		try {
			//rere.close();
			Scanner rere = new Scanner(dir);
			String boo = rere.nextLine();
			while(rere.hasNextLine()) {
				boo = rere.nextLine();
				String [] itemProp = boo.split(",",0);
				thing = new Item(itemProp[0], Integer.parseInt(itemProp[1]), Double.parseDouble(itemProp[2].substring(1)), Integer.parseInt(itemProp[4]));
				itemList.add(thing);
			}
		}
		catch(FileNotFoundException e) {
			System.err.println("Error writing save file: " + filename);
		}
		return itemList;
	}
	
	
	/*public static void getFile() {
		Desktop d = null;
		String desktopPath = System.getProperty("user.home") + "/Desktop";
		System.out.print(desktopPath.replace("\\", "/"));
		File f = new File(desktopPath);
		if(Desktop.isDesktopSupported()) {
			d = Desktop.getDesktop();
		}
		
		try {
			d.open(f);
		}
		catch(IOException e){
			
		}
	}*/

	
	public static void main(String[] args) {
		//getFile();
		ArrayList<Item> b = bigRead();
		for(Item p: b) {
			System.out.println(p);
		}
	}

}
