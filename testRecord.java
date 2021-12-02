import java.util.Scanner;

class testRecord{

    // Attributes
    private String name;
    private String brand;
    private double cost;
    private int itemQuant;
    static private int IDNum = 0; // helps in assigning unique ID Numbers to individual records
    private int rIDNum; // the current record's actual ID number
    private int lowQuantAcceptance;
    private double discount;
    private int expDay;
    private int expMonth;
    private int expYear;
    private int withinExpDay;
    private int withinExpMonth;
    private int withinExpYear;
    // add attributes that will reference the Warning classes

    //constructor
    public testRecord(String rName, String rBrand, double rCost, int rQuant){
        name = rName;
        cost = rCost;
        itemQuant = rQuant;
        brand = rBrand;
        IDNum += 1;
        // default values where for data that does not have to be entered immediately
        discount = -1;
        expDay = -1;
        expMonth = -1;
        expYear = -1;
        withinExpDay = -1;
        withinExpMonth = -1;
        withinExpYear = -1;
        lowQuantAcceptance = -1;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getItemQuant() {
        return itemQuant;
    }

    public String getBrand() {
        return brand;
    }

    // Low Quantity Method
    public int getLowQuantAcceptance() {
        return lowQuantAcceptance;
    }

    // Expiration Date Methods
    public int getExpDay() {
        return expDay;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public int getExpYear() {
        return expYear;
    }

    public double getDiscount() {
        return discount;
    }

    // Expiration Date Limit Methods
    public int getWithinExpDay() {
        return withinExpDay;
    }

    public int getWithinExpMonth() {
        return withinExpMonth;
    }

    public int getWithinExpYear() {
        return withinExpYear;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setItemQuant(int itemQuant) {
        this.itemQuant = itemQuant;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Low Acceptance Method - exception to ensure only integers are passed
    public void setLowQuantAcceptance(int lowQuantAcceptance) {
        if (getItemQuant() != -1){
            this.lowQuantAcceptance = lowQuantAcceptance;
        } else {
            System.out.println(getName() + " does not currently have any quantity set!");
        }
    }

    // Expiration Date Methods - each (expiration date) should have an exception that ensures only integers are entered
    public void setExpDay(int expDay) {
        // a record does not necessarily need the expDate set because it might not be a perishable item
        if (expDay > 31){
            System.out.println("Cannot enter a number larger than 31 for the expiry day!");
        } else if (expDay < 1) {
            System.out.println("Cannot enter a number smaller than 1 for the expiry day!");
        }else {
            this.expDay = expDay;
        }
        
    }

    public void setExpMonth(int expMonth) {
        // a record does not necessarily need the expDate set because it might not be a perishable item
        if (expMonth > 12){
            System.out.println("Cannot enter a number larger than 12 for the expiry month!");
        } else if (expMonth < 1) {
            System.out.println("Cannot enter a number smaller than 1 for the expiry month!");
        } else {
            this.expMonth = expMonth;
        }
    }

    public void setExpYear(int expYear) {
        // a record does not necessarily need the expDate set because it might not be a perishable item
        /* Use the time-date function to change the 2021 to current year */
        if (expYear > 2021){
            System.out.println("Cannot enter a number larger than the current year!");
        } else if (expYear < 1){
            System.out.println("Cannot enter a number smaller than 1 for the expiry year!");
        } else {
            this.expYear = expYear;
        }
    }

    // Expiration Date Limit Methods - each (expiration date limit) should have an exception that ensures only integers are entered
    public void setWithinExpDay(int withinExpDay) {
        // a record does not necessarily need the expDate set because it might not be a perishable item
        if (getExpDay() == -1) {
            System.out.println(getName() + " does not currently have an expiry day set!");
        } if ( (getExpDay() - withinExpDay) < 7) {
            System.out.println("Expiry Day Limits must be a week or more from the actual expiry date");
        }
        else{
            this.withinExpDay = withinExpDay;
        }
    }

    public void setWithinExpMonth(int withinExpMonth) {
        // a record does not necessarily need the expDate set because it might not be a perishable item

        // add code sets the month only if 
        // 1) the expiry day limit is set
        if (getWithinExpDay() == -1) {
            System.out.println("Cannot set expiry month limit for " + getName() + " because expiry day limit is not set!");
        }
        // 2) the expiry month is set (different from the expiry month limit which is this method)
        else if (getExpMonth() == -1) {
            System.out.println("Cannot set expiry month limit for "  + getName() + " because expiry month is not set!");
        }
        // 3) the withinExpMonth parameter is less than or equal to the expiry month
        else if ( withinExpMonth > getExpMonth()) {
            System.out.println("Cannot set expiry month limit for "  + getName() + " the current limit chosen is a larger value than the expiry month!");
        } else {
            this.withinExpMonth = withinExpMonth;
        }
    }

    public void setWithinExpYear(int withinExpYear) {
        // a record does not necessarily need the expDate set because it might not be a perishable item

        // add code sets the year only if 
        // 1) the expiry day limit is set
        if (getWithinExpDay() == -1){
            System.out.println("Cannot set expiry month limit for " + getName() + " because expiry day limit is not set!");
        }
        // 2) the expiry month limit is set
        else if (getExpMonth() == -1) {
            System.out.println("Cannot set expiry month limit for "  + getName() + " because expiry month is not set!");
        }
        // 3) the expiry year is set
        else if (getExpYear() == -1){
            System.out.println(getName() + " does not have it's expiry year set yet!");
        } 
        // 4) the withinExpMonth parameter is less than or equal to the expiry year
        else if (withinExpYear > getExpYear()){
            System.out.println("Cannot set expiry year limit for " + getName() + " because the current (year) limit is a larger value than the expiry year!");
        } else {
            this.withinExpYear = withinExpYear;
        }
    }

    // Discount Method
    public void setDiscount(double discount) {
        // discount does not apply if the expiry date limit has not been reached (is more than 1 week away from expiry)
        if ( ( ( getExpDay() - getWithinExpDay() ) < 7) && (getExpMonth() == getWithinExpMonth()) && (getExpYear() == getWithinExpYear()) ) { 
            this.discount = discount;
            double newCost = getCost() * (this.discount/100);
            setCost(newCost);
        } else {
            System.out.println("Discount is not needed as " + getName() + " is not within its expiration limit!");
        }
    }

    public String toString() {
        return ("Name: " + getName() + " Brand: " + getBrand() + " Cost: " +  getCost() + " Quantity: " + getItemQuant());
    }

}
