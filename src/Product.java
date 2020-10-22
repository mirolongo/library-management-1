
public abstract class Product implements AllProduct {
int productId = 1;
int value;
String title;
String[] type = {"book", "movie"};
	public Product(int productId, int value, String title, String[] type) {
		this.productId = productId;
		this.value = value;
		this.title = title;
		this.type = type;
	}
	@Override
	public boolean confirmId() {
		return true;
	}
	public boolean confirmPositiveNumber(int a) {
		if (a < 0) {
			return true;
		}
		else {
			System.out.println("Enter a positive Number");
			
		}
		return false ;
		
	}
}
