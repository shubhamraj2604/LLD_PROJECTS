package vehcile;

public class Car implements Vechile {
    private String licensePlate;
    public Car(String licenseNo){
        this.licensePlate = licenseNo;
    }

    @Override
    // what shpudl i c
    public String getLicensePlate()
     {   
        return licensePlate;
    }

    @Override
    public VechileType getType() {
        return VechileType.CAR;
    }
}



