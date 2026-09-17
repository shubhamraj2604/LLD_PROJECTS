package shelf;

import java.util.ArrayList;
import java.util.UUID;
import bookcopy.Bookcopy;

public class Shelf {
    private UUID Shelf_no;
    ArrayList<Bookcopy> bookcopies;
    public Shelf(){
        this.Shelf_no = UUID.randomUUID();
        this.bookcopies = new ArrayList<>();
    }
    public void addBooks(Bookcopy bookcopy){
         bookcopies.add(bookcopy);
    }
}
