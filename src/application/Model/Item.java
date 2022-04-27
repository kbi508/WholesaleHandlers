package application.Model;


public class Item {
	String name;
	int id;
	double supPrice;
	int maxAmmount;
	int has;
	boolean checked;
	
	public Item(String name, int id, double price, int max){
		this.name = name;
		this.id = id;
		this.supPrice = price;
		this.maxAmmount = max;
		this.has = this.maxAmmount;
		this.checked = false;
	}
	
	public boolean getChecked() {
		return this.checked;
	}
	
	
	public String getName() {
		return name;
	}


	public int getId() {
		return id;
	}


	public int getHas() {
		return has;
	}


	public double getSupPrice() {
		return supPrice;
	}


	public int getMaxAmmount() {
		return maxAmmount;
	}


	public String toString() {
		return "Item name: " + this.name + "\nItem Id: " + this.id + "\nSupplier price: $"
					+ this.supPrice + "\nMaxiumum Inventory: " + this.maxAmmount + "\n";
	}

	public void setHas(int has) {
		this.has = has;
		this.checked = true;
		
	}
	
	

}
