import java.util.ArrayList;

public class LibraryItem {
    public final String title;
    public final String itemId;
    
    protected boolean isCheckedOut = false;

    public LibraryItem(String title, String itemId) {
        this.title = title;
        this.itemId = itemId;
    }

	public boolean available() {
		return !isCheckedOut;
	}

    public void checkOut() {
        isCheckedOut = true;
    }

    public void returnItem() {
        isCheckedOut = false;
    }

    public static void returnAll(LibraryItem[] items) {

    }

    public static ArrayList<LibraryItem> availableItems(LibraryItem[] items) {
        ArrayList<LibraryItem> availableItems = new ArrayList<>();
        return availableItems;
    }
}

