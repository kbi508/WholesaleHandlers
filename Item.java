

public class Item {
	String name;
	int id;
	double supPrice;
	int maxAmmount;
	
	public Item(String name, int id, double price, int max){
		this.name = name;
		this.id = id;
		this.supPrice = price;
		this.maxAmmount = max;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSupPrice() {
		return supPrice;
	}

	public void setSupPrice(double supPrice) {
		this.supPrice = supPrice;
	}

	public int getMaxAmmount() {
		return maxAmmount;
	}

	public void setMaxAmmount(int maxAmmount) {
		this.maxAmmount = maxAmmount;
	}

	public String toString() {
		return "Item name: " + this.name + "\nItem Id: " + this.id + "\nSupplier price: $"
					+ this.supPrice + "\nMaxiumum Inventory: " + this.maxAmmount + "\n";
	}
	
	

}
