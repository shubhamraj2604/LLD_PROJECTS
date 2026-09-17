package ticket;

import user.User;
import bookcopy.Bookcopy;
import java.util.Date;

public class Ticket {
    private User user;
    private Bookcopy bookcopy;
    private boolean isActive;
    private Date issueDate;
    private Date returnDate;
    public Ticket(User user, Bookcopy bookcopy) {
        this.user = user;
        this.bookcopy = bookcopy;
        this.issueDate = new Date();
        this.isActive = true;
        this.returnDate = null;
    }

    public Bookcopy getbookcopy(){
        return bookcopy;
    }
    public long checkout(Date date) {
        this.returnDate = date;
        this.isActive = false;
        // Convert allowed days into milliseconds
        long dueDate = issueDate.getTime()+(long) bookcopy.getDuedate() * 24 * 60 * 60 * 1000;
        // How many milliseconds after due date
        long diff = returnDate.getTime() - dueDate;
        // Convert milliseconds to days
        long overdueDays = diff / (24 * 60 * 60 * 1000);
        // No fine if returned before/on due date
        if (overdueDays <= 0) {
            return 0;
        }
        return overdueDays * bookcopy.getFine();
    }
    // long getTicketDuration() {
    //     if (isActive) {
    //         return (new Date().getTime() - issueDate.getTime()) / (24 * 60 * 60 * 1000);
    //     } else {
    //         return (returnDate.getTime() - issueDate.getTime()) / (24 * 60 * 60 * 1000);
    //     }
    // }

    public boolean isActive() {
        return isActive;
    }
}