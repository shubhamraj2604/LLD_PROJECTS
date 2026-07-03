package CarRental.car;

public class Car {
    private String registrationNumber;
    private CarType carType;
    private CarStatus status;
    public Car(String registrationNumber, CarType carType) {
        this.registrationNumber = registrationNumber;
        this.carType = carType;
        this.status = CarStatus.AVAILABLE;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public CarStatus getStatus() {
        return status;
    }
    public CarType getCarType() {
        return carType;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }
}
