package com.example.user.payforparking2;


public class Customer {
    String name = null;
    String platenumber = null;
    String color=null;
    String date=null;
    String time=null;
    String flage=null;

    public Customer(String Cname, String Cplate,String Ccolor,String Cdate,String Ctime,String Cflage){

        super();

        this.name = Cname;
        this.platenumber = Cplate;
        this.color = Ccolor;
        this.date = Cdate;
        this.time = Ctime;
        this.flage = Cflage;



    }

    public String getName() {

        return name;

    }
    public void setName(String Name2) {

        this.name = Name2;

    }
    public String getPlatenumber() {

        return platenumber;

    }
    public void setPlatenumber(String number2) {

        this.platenumber = number2;

    }

    public String getColor() {

        return color;

    }
    public void setColor(String color1) {

        this.color = color1;

    }

    public String getDate() {

        return date;

    }
    public void setDate(String date) {

        this.date = date;

    }
    public String getTime() {

        return time;

    }
    public void setTime(String time1) {

        this.time = time1;

    }

    public String getFlage() {

        return flage;

    }
    public void setFlage(String flage1) {

        this.time = flage1;

    }

    public String toString() {

        return name + " " + platenumber + " " + color+" "+date+" "+time+""+flage;


    }
}
