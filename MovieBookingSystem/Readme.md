# 🎬 Movie Booking System — Low Level Design (Java)

A complete **Low Level Design** implementation of a Movie Ticket Booking System in Java, demonstrating core OOP principles, design patterns, and clean package separation.

---

## 📌 What This Project Does

Simulates the end-to-end flow of booking a movie ticket:

1. **Create** a Movie, Theatre, Screen, and Seats
2. **Schedule** a Show (movie + screen + theatre + time)
3. **Book** a seat for a user
4. **Pay** via a chosen payment method (Credit Card / PhonePe)
5. **Confirm** the booking and mark the seat as booked

---

## 🗂️ Project Structure

```
MovieBookingSystem/
├── Main.java                        # Entry point — wires everything together
├── bookingService/
│   ├── Booking.java                 # Booking entity (id, show, user, seat, amount, status)
│   ├── BookingRepo.java             # In-memory repository (List<Booking>)
│   ├── BookingService.java          # Orchestrates create + confirm booking
│   └── BookingStatus.java           # Enum: CREATED, CONFIRMED, CANCELLED, EXPIRED
├── movieService/
│   └── Movie.java                   # Movie entity (id, name, duration)
├── theatreService/
│   └── Theatre.java                 # Theatre entity (name, id, Map<Screen>)
├── screenservice/
│   └── Screen.java                  # Screen entity (id, name, Map<Seats>)
├── showservice/
│   └── Show.java                    # Show entity (movie + theatre + screen + time)
├── seats/
│   ├── Seats.java                   # Abstract base class for all seats
│   ├── SeatType.java                # Enum: Recliner, Regular, Gold
│   ├── Recliner.java                # Concrete seat — extends Seats
│   └── Regular.java                 # Concrete seat — extends Seats
├── paymentService/
│   ├── Payment.java                 # Interface with pay(amount) → Strategy Pattern
│   ├── CreditCardPayment.java       # Concrete strategy
│   ├── PhonePay.java                # Concrete strategy
│   └── PaymentStatus.java           # Enum: PENDING, SUCCESS, FAILED, REFUNDED, CANCELLED
├── user/
│   └── User.java                    # User entity (id, name)
└── lockMechanism/                   # (Placeholder — for future seat locking)
```

---

## 📐 UML Class Diagram

```mermaid
classDiagram
    direction TB

    class User {
        -String userId
        -String name
        +getUserId() String
        +getName() String
    }

    class Movie {
        -String movieId
        -String movieName
        -int duration
        +getMovieId() String
        +getMovieName() String
        +getDuration() int
    }

    class Theatre {
        -Map~String, Screen~ screens
        -String name
        -String theatreId
        +getname() String
        +getId() String
        +addScreens(Screen) void
        +getScreen(String) Screen
    }

    class Screen {
        -String screenId
        -String screenName
        -Map~String, Seats~ seats
        +addSeats(Seats) void
        +getScreenName() String
        +getSeat(String) Seats
        +getScreenId() String
        +showavailableSeats() String
    }

    class Seats {
        <<abstract>>
        -String seatNumber
        -double price
        -boolean isBooked
        +getSeatType() SeatType*
        +getSeatNumber() String
        +getPrice() double
        +isBooked() boolean
        +bookedseat() void
    }

    class Recliner {
        +getSeatType() SeatType
    }

    class Regular {
        +getSeatType() SeatType
    }

    class SeatType {
        <<enumeration>>
        Recliner
        Regular
        Gold
    }

    class Show {
        -String showId
        -Movie movie
        -Theatre theatre
        -Screen screen
        -LocalDateTime startTime
        -LocalDateTime endTime
        +getShowDetails() void
        +getShowId() String
        +getMovieName() String
        +getMovie() Movie
        +getTheatre() Theatre
        +getScreen() Screen
        +getStartTime() LocalDateTime
        +getEndTime() LocalDateTime
    }

    class Payment {
        <<interface>>
        +pay(double amount) boolean
    }

    class CreditCardPayment {
        +pay(double amount) boolean
    }

    class PhonePay {
        +pay(double amount) boolean
    }

    class PaymentStatus {
        <<enumeration>>
        PENDING
        SUCCESS
        FAILED
        REFUNDED
        CANCELLED
    }

    class Booking {
        -String bookingId
        -String showId
        -String username
        -String seatno
        -double amount
        -PaymentStatus paymentStatus
        -BookingStatus status
        -LocalDateTime createdAt
        -LocalDateTime expiresAt
        +getBookingId() String
        +getShowId() String
        +getUsername() String
        +getSeatno() String
        +getAmount() double
        +getPaymentMethod() PaymentStatus
        +changepaymentStatus(PaymentStatus) void
    }

    class BookingStatus {
        <<enumeration>>
        CREATED
        CONFIRMED
        CANCELLED
        EXPIRED
    }

    class BookingRepo {
        -List~Booking~ bookings
        +addBooking(Booking) void
        +getBookings() List~Booking~
    }

    class BookingService {
        -BookingRepo bookingRepo
        +createBooking(Show, User, Seats) Booking
        +confirmBooking(Booking, Payment) void
    }

    %% Inheritance
    Recliner --|> Seats
    Regular --|> Seats
    CreditCardPayment ..|> Payment
    PhonePay ..|> Payment

    %% Associations
    Theatre "1" --> "*" Screen : contains
    Screen "1" --> "*" Seats : contains
    Show --> Movie : plays
    Show --> Theatre : hosted at
    Show --> Screen : on screen
    Booking --> PaymentStatus : tracks
    Booking --> BookingStatus : lifecycle
    BookingService --> BookingRepo : uses
    BookingService --> Show : reads
    BookingService --> User : reads
    BookingService --> Seats : books
    BookingService --> Payment : processes
    Seats --> SeatType : type
```

---

## 🔄 Booking Flow — Sequence Diagram

```mermaid
sequenceDiagram
    participant U as User
    participant BS as BookingService
    participant S as Show
    participant Seat as Seats
    participant BR as BookingRepo
    participant P as Payment

    U->>BS: createBooking(show, user, seat)
    BS->>Seat: getPrice()
    Seat-->>BS: amount
    BS->>BR: addBooking(new Booking)
    BS->>Seat: bookedseat()
    BS-->>U: Booking (status=CREATED, payment=PENDING)

    U->>BS: confirmBooking(booking, creditCardPayment)
    BS->>P: pay(amount)
    P-->>BS: true / false
    alt Payment Success
        BS->>Booking: changepaymentStatus(SUCCESS)
    else Payment Failed
        BS->>Booking: changepaymentStatus(FAILED)
    end
```

---

## 🧩 Design Patterns Used

| Pattern | Where | Why |
|---------|-------|-----|
| **Strategy** | `Payment` interface → `CreditCardPayment`, `PhonePay` | Swap payment methods at runtime without changing `BookingService` |
| **Repository** | `BookingRepo` | Decouples data storage from business logic; easy to swap with a DB later |
| **Template Method (light)** | `Seats` (abstract) → `Recliner`, `Regular` | Base class defines structure; subclasses provide seat-type-specific behavior |
| **Composition** | `Show` has `Movie`, `Theatre`, `Screen` | Rich domain objects composed from simpler entities |

---

## 🧱 Package-by-Package Breakdown

### `seats/` — Seat Hierarchy
- **`Seats`** is an abstract class with `seatNumber`, `price`, `isBooked`.
- Subclasses `Recliner` and `Regular` override `getSeatType()`.
- `SeatType` enum has `Recliner`, `Regular`, `Gold` (Gold is defined but not yet implemented).
- Seats are marked booked via `bookedseat()` — a simple boolean flip, no concurrency handling yet.

### `screenservice/` — Screen Management
- A `Screen` holds a `Map<String, Seats>` keyed by seat number.
- `showavailableSeats()` iterates the map and returns unbooked seat IDs.

### `theatreService/` — Theatre Management
- A `Theatre` holds a `Map<String, Screen>` keyed by screen ID.
- Simple add/get operations.

### `showservice/` — Show Scheduling
- A `Show` links a `Movie` + `Theatre` + `Screen` + start time.
- `endTime` is auto-calculated as `startTime + movie.duration`.

### `bookingService/` — Booking Orchestration
- **`BookingService.createBooking()`**: calculates price, creates a `Booking`, persists it in `BookingRepo`, and marks the seat as booked.
- **`BookingService.confirmBooking()`**: delegates to a `Payment` strategy; updates `PaymentStatus` accordingly.
- **`Booking`** tracks `createdAt` and `expiresAt` (1-hour window) — expiry logic is modeled but not yet enforced.

### `paymentService/` — Payment Strategy
- `Payment` interface with a single method `pay(double) → boolean`.
- `CreditCardPayment` and `PhonePay` are concrete strategies (currently always return `true`).

### `lockMechanism/` — Seat Locking (Future)
- Empty directory — placeholder for implementing seat-level locking / concurrency control (e.g., optimistic locking, TTL-based locks).

---

## ▶️ How to Run

```bash
# Compile everything
javac -d out Main.java

# Run
java -cp out Main
```

### Expected Output

```
250.0
false
========================================
              SHOW DETAILS
========================================
Show ID       : SH1
Movie         : Inception
Theatre       : PVR Cinemas
Screen        : Screen 1
Start Time    : 2026-09-20T18:30
End Time      : 2026-09-20T20:58
========================================
Available seats: R1 R2 N1
Processing credit card payment of amount: 250.0
Booking ID   : 1
Show ID      : SH1
User         : Alice
Seat         : R1
Amount       : 250.0
Payment      : SUCCESS
Available seats after booking: R2 N1
```

---

## 🧭 Entity Relationship Diagram

```mermaid
erDiagram
    USER ||--o{ BOOKING : makes
    BOOKING }o--|| SHOW : "is for"
    BOOKING }o--|| SEATS : reserves
    SHOW }o--|| MOVIE : plays
    SHOW }o--|| THEATRE : "hosted at"
    SHOW }o--|| SCREEN : "on"
    THEATRE ||--o{ SCREEN : has
    SCREEN ||--o{ SEATS : contains

    USER {
        string userId PK
        string name
    }
    MOVIE {
        string movieId PK
        string movieName
        int duration
    }
    THEATRE {
        string theatreId PK
        string name
    }
    SCREEN {
        string screenId PK
        string screenName
    }
    SEATS {
        string seatNumber PK
        double price
        boolean isBooked
        enum seatType
    }
    SHOW {
        string showId PK
        datetime startTime
        datetime endTime
    }
    BOOKING {
        string bookingId PK
        double amount
        enum paymentStatus
        enum bookingStatus
        datetime createdAt
        datetime expiresAt
    }
```

---

## 🚀 What Could Be Added Next

| Feature | Notes |
|---------|-------|
| **Seat Locking** | Use the `lockMechanism/` package — implement TTL-based locks so two users can't book the same seat simultaneously |
| **Gold Seat** | `SeatType.Gold` enum exists but no `Gold.java` class yet |
| **Booking Expiry** | `expiresAt` is set but never checked — add a scheduled job or lazy check |
| **Search** | Search movies by city, theatre, or time slot |
| **Notifications** | Email/SMS confirmation after booking |
| **Cancellation & Refund** | Use `BookingStatus.CANCELLED` + `PaymentStatus.REFUNDED` |
| **Multiple Seats per Booking** | Currently 1 seat per booking — extend to `List<Seats>` |

---

## 📚 Key OOP Concepts Demonstrated

- **Abstraction** — `Seats` abstract class hides seat internals; `Payment` interface hides payment details
- **Inheritance** — `Recliner` and `Regular` extend `Seats`
- **Polymorphism** — `BookingService.confirmBooking()` accepts any `Payment` implementation
- **Encapsulation** — All fields are `private` with getter methods
- **Composition** — `Show` is composed of `Movie`, `Theatre`, and `Screen`
- **Interface Segregation** — `Payment` has a single focused method
