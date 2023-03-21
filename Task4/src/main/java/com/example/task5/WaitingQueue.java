package com.example.task5;

public class WaitingQueue {
    String firstName;
    String secondName;
    String vehicleNo;
    int Noliters;

    public WaitingQueue(String firstName, String secondName,String vehicleNo, int Noliters) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.vehicleNo = vehicleNo;
        this.Noliters=Noliters;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName= secondName;
    }
    public void setVehicleNo(String vehicleNo){
        this.vehicleNo=vehicleNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setNoLiters(int Noliters ) {
        this.Noliters = Noliters;
    }
    public int getNoliters(){
        return Noliters;

    }
}















