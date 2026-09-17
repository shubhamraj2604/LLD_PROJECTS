package books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bookcopy.Bookcopy;
import shelf.Shelf;
import status.Status;

public class Books {
    private int book_id;
    private String book_name;
    ArrayList<Bookcopy> bookcopy;

    public Books(int book_id, String book_name, int quantity, int fine, int due_date) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.bookcopy = new ArrayList<>();
        createBookcopy(quantity, fine, due_date);
    }

    private void createBookcopy(int quantity, int fine, int due_date) {
        for (int i = 0; i < quantity; i++) {
            Bookcopy newbookcopy = new Bookcopy(fine, due_date);
            // shelf.addBooks(newbookcopy);
            bookcopy.add(newbookcopy);
        }
    }

    public List<Bookcopy> getBookCopies() {
        return Collections.unmodifiableList(bookcopy);
    }

    public int getBookId() {
        return book_id;
    }

    public Bookcopy getAvailableBook() {
        Bookcopy ans = null;
        for (Bookcopy copy : bookcopy) {
            if (copy.getstatus() == Status.AVAILABLE) {
                ans = copy;
            }
        }
        return ans;
    }
}