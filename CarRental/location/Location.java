package CarRental.location;
import CarRental.car.*;
import java.util.*;

public class Location {
    // public String getLocation() {
    //     return "Default Location";
    // }
    private String name;
    private String pincode;
    private List<Car>carList;
    public Location(String name , String pincode){
         this.name = name;
         this.pincode = pincode;
         this.carList = new ArrayList<>();
    }
   
    public String getName() {
        return name;
    }
    public void addCar(Car car){
        if(carList.contains(car)){
            System.out.println("Car already exists in the location");
            return;
        }
        carList.add(car);
    }
    
    
    public void removeCar(Car car){
        if(!carList.contains(car)){
            System.out.println("Car does not exist in the location");
            return;
        }
        carList.remove(car);
    }

    public Car getCar(CarType carType){
        for(Car car : carList){
            if(car.getCarType() == carType && car.getStatus() == CarStatus.AVAILABLE){
                System.out.println("Car found: " + car.getRegistrationNumber());
                return car;
            }
        }
        System.out.println("Car not found");
        return null;
    }
}
