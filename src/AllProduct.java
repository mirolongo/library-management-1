
public interface AllProduct {
	public default boolean confirmId() {
		return true;
	}
	static boolean confirmPositiveNumber(int a) {
		return false;
	}
	default boolean ExistFile() {
		return true;
	}
	default boolean confirmRating() {
		return true;
	}
	default boolean confirmBorrowed() {
		return true;
	}
	default void insertBook() {
		
	}
	default void insertMovie() {
		
	}
	default void deleteBook() {
		
	}
	default void deleteMovie() {
		
	}
	default void checkOut() {
		
	}
	default void checkIn() {
		
	}
	default void info() {
		
	}
	default void quit() {
		
	}
}
