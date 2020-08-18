import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileComplexExampleApp {

	public static void main(String[] args) throws IOException {
		
		Food[] order; //= new Food[3];
		
		//order[0] = new Food("Pizza", 2, 75.00f);
		//order[1] = new Food("Salad", 1, 38.00f);
		//order[2] = new Food("Rice", 3, 15.00f);	
		
		//save(order);
		
		order = load();
		
		for (int i = 0; i < order.length; i++) {
			System.out.println(order[i]);
		}
		
	}
	
	public static Food[] load() throws FileNotFoundException {
		Food[] array = new Food[3];
		File file = new File("orders.txt");
		Scanner fin = new Scanner(file);
		
		for (int i = 0; i < array.length; i++) {
			String name = fin.next();
			float price = fin.nextFloat();
			int q = fin.nextInt();
			array[i] = new Food( name,
								 q,
								 price );			
		}		
		return array;
	}
	
	public static void save(Food[] array) throws IOException {
		File out = new File("orders.txt");
		FileWriter fw = new FileWriter(out);
		
		for (int i = 0; i < array.length; i++) {
			fw.write( array[i].getName() + " " +
					 array[i].getPrice() + " " +
					 array[i].getQuantity() + "\n");		
		}	
		fw.close();
	}
}

class Food{
	private String name;
	private int quantity;
	private float price;
	
	public Food(){}
	
	public Food(String name, int quantity, float price) {
		setName(name);
		setQuantity(quantity);
		setPrice(price);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Food [" + name + ", " + quantity + ", " + price + "]";
	}	
	
}