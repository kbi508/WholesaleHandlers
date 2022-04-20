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
	
	public static String getNeeds(ArrayList<Item> itemL) {
		String recipt = "";
		String needStr;
		int numNeeds;
		double iCost;
		double total = 0;
		for(Item thing: itemL) {
			numNeeds = thing.maxAmmount - thing.has;
			if(numNeeds > 0) {
				iCost = thing.supPrice * numNeeds;
				total += iCost;
				needStr = String.format("%s: $%.2f x %d = %.2f", thing.name, thing.supPrice, numNeeds, iCost);
				recipt = recipt + "\n" + needStr;
			}
		}
		if(recipt == "") {
			return "Looks like you are all good on inventory!";
		}
		recipt += String.format("\nYour total cost is $%.2f", total);
		
		return recipt;
		
	}
	

	
	public static void main(String[] args) {
		ArrayList<Item> b = bigRead();
		/*for(Item p: b) {
			System.out.println(p);
		}*/
		
		/*b.get(0).setHas(9);
		b.get(1).setHas(9);
		b.get(2).setHas(9);*/
		String o = getNeeds(b);
		System.out.println(o);
	}

}
