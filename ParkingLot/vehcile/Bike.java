package vehcile;

public class Bike implements Vechile {
    private String licensePlate;
    public Bike(String licenseNo){
        this.licensePlate = licenseNo;
    }

    @Override
    public String getLicensePlate()
     {   
        return licensePlate;
    }

    @Override
    public VechileType getType() {
        return VechileType.BIKE;
    }
}
