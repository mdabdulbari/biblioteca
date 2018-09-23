package biblioteca.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<LibraryItem> libraryItems;
    private List<LibraryItem> checkedOutItems;
    private List<User> users;

    public Library(List<LibraryItem> libraryItems, List<User> users) {
        this.libraryItems = libraryItems;
        this.users = users;
        checkedOutItems = new ArrayList<>();
    }

    public boolean checkout(String libraryItemTitle) {
        for (LibraryItem libraryItem : libraryItems) {
            if (libraryItem.getTitle().equals(libraryItemTitle)) {
                libraryItems.remove(libraryItem);
                checkedOutItems.add(libraryItem);
                return true;
            }
        }
        return false;
    }

    public boolean returnLibraryItem(String libraryItemTitle) {
        for (LibraryItem libraryItem : checkedOutItems) {
            if (libraryItem.getTitle().equals(libraryItemTitle)) {
                checkedOutItems.remove(libraryItem);
                libraryItems.add(libraryItem);
                return true;
            }
        }
        return false;
    }

    public List<String> getList(ItemType itemType) {
        return libraryItems.stream().filter(libraryItem ->
                libraryItem.getType() == itemType)
                .map(LibraryItem::getDetails).collect(Collectors.toList());
    }

    public boolean contains(LibraryItem libraryItem) {
        return libraryItems.contains(libraryItem);
    }

    boolean isCheckedOut(LibraryItem libraryItem) {
        return checkedOutItems.contains(libraryItem);
    }
}
