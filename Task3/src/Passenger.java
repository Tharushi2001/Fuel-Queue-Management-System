//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID: w1907403
//Date: 07.08.2022





public class Passenger {

    private String firstName;
    private String secondName;
    private String vehicleNo;
    private int Noliters;


    Passenger(){
        firstName = "";
        secondName  = "";
        vehicleNo="";
        Noliters=0;
    }

    //Get and Set methods starts form here
    public  String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {

        return secondName;
    }

    public void setSecondName(String secondName) {

        this.secondName = secondName;
    }

    public String getVehicleNo() {

        return vehicleNo;
    }


    public void setVehicleNo(String vehicleNo) {

        this.vehicleNo=vehicleNo;
    }


    public void setNoLiters(int Noliters) {

        this.Noliters=Noliters;
    }
    public int getNoliters(){
        return Noliters;

    }



}
