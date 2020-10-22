
public class MainProduct implements AllProduct {

	public static void main(String[] args) {
		Product book = new Book(0, 0, null, args);
		Product movie = new Movie(0, 0, null, args);
		System.out.println(book.confirmPositiveNumber(book.productId));
	}

}
