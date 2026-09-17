package bookcopy;

import status.Status;
import java.util.UUID;

public class Bookcopy {
    private UUID copy_id;
    private Status status;
    private int fine;
    private int dueDate;
    public Bookcopy(int fine ,int dueDate) {
        this.copy_id = UUID.randomUUID();
        this.status = Status.AVAILABLE;
        this.fine = fine;
        this.dueDate = dueDate;
    }

    public void changeStatus(Status status) {
        this.status = status;
    }

    public Status getstatus() {
        return status;
    }

    public int getFine() {
        return fine;
    }

    public int getDuedate(){
        return dueDate;
    }
}