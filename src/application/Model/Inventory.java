package application.Model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import javax.swing.filechooser.FileSystemView;
public class Inventory {
	private ArrayList<Item> list = new ArrayList<Item>();
	public int choice = -1;
	
	private final static Inventory INSTANCE = new Inventory();
	private Inventory() {}
	
	public static Inventory getInstance() {
		return INSTANCE;
	}
	
	
	public static void bigRead(File f, Inventory i) {
		String filename = f.getName();
		Item thing;
		ArrayList<Item> itemList = new ArrayList<Item>();
		try {
			Scanner rere = new Scanner(f);
			String boo = rere.nextLine();
			while(rere.hasNextLine()) {
				boo = rere.nextLine();
				String [] itemProp = boo.split(",",0);
				thing = new Item(itemProp[0], Integer.parseInt(itemProp[1]), Double.parseDouble(itemProp[2].substring(1)), Integer.parseInt(itemProp[4]));
				itemList.add(thing);
			}
			rere.close();
		}
		catch(FileNotFoundException e) {
			System.err.println("Error writing save file: " + filename);
		}
		 i.setList(itemList);
		
	}
	

	public ArrayList<Item> getList() {
		return list;
	}

	public void setList(ArrayList<Item> list) {
		this.list = list;
	}

	public String getNeeds() {
		System.out.println("getNeeds is called");
		String recipt = "";
		String needStr;
		int numNeeds;
		double iCost;
		double total = 0;
		for(Item thing: this.list) {
			numNeeds = thing.maxAmmount - thing.has;
			if(numNeeds > 0) {
				iCost = thing.supPrice * numNeeds;
				total += iCost;
				needStr = String.format("%s: $%.2f x %d = %.2f", thing.name, thing.supPrice, numNeeds, iCost);
				recipt = recipt + "\n" + needStr;
			}
		}
		if(recipt.equals("")) {
			return "Looks like you are all good on inventory!";
		}
		recipt += String.format("%nYour total cost is $%.2f", total);
		
		return recipt;
		
	}
	
	public static ArrayList<String> invStr(Inventory i) {
		ArrayList<String> all = new ArrayList<String>();
		for(Item p: i.list) {
			all.add(p.toString());
		}
		return all;
	}
	


}
