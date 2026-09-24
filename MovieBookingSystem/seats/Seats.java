package seats;

public abstract class Seats {
      private String seatNumber;
    //   private SeatType seatType;
      private double price;
      private boolean isBooked;
      Seats(String seatNumber, double price) {
          this.seatNumber = seatNumber;
          this.price = price;
          this.isBooked = false;
      }
      public abstract SeatType getSeatType();
      public String getSeatNumber(){
          return seatNumber;
      }

      public double getPrice(){
         return price;
      }

      public boolean isBooked(){
        return isBooked;
      }

      public void bookedseat(){
        isBooked = true;
      }
}
