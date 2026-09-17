package library;

import bookcopy.Bookcopy;
import books.Books;
import ticket.Ticket;
import java.util.*;
import shelf.Shelf;
import status.Status;
import ticket.Ticket;
import user.User;
public class Library {
    private String name;
    private List<Shelf>shelf;
    private List<Ticket> tickets;
    private Map<Integer , Books> books;
    Library(String name){
        this.name = name;
        this.shelf = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addBook(Books book){
        books.put(book.getBookId(), book);
    }

    public void addShelf(Shelf shel){
        shelf.add(shel);
    }

    public void placeBook(Books book , Shelf shelf){
        for(Bookcopy copy : book.getBookCopies()){
            shelf.addBooks(copy);
        }
    }

    public Ticket borrowBook(User user , Books book){
        Bookcopy copy = book.getAvailableBook();
        if(copy == null){
            System.out.println("Book is not available");
            return null;
        }
       
        copy.changeStatus(Status.BORROWED);
        Ticket ticket = new Ticket(user, copy);
        tickets.add(ticket);
        return ticket;
    }

    public void returnBook(Ticket ticket){
        Bookcopy bookcopy = ticket.getbookcopy();
        
    }
}
