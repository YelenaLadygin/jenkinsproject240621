package com.example.demo;

import java.io.Serializable;

public class ReportDTO implements Serializable {

        private String License_Plate;
        private int Id;
        private int Driver_Id;
        private int Speed;

        public ReportDTO() {
            super();
        }

    public ReportDTO(int Id,String License_Plate, int Driver_Id, int Speed) {
        this.Id = Id;
        this.License_Plate = License_Plate;
        this.Driver_Id = Driver_Id;
        this.Speed = Speed;
    }

    public String getLicense_plate() {
            return License_Plate;
        }

    public void setLicense_plate(String License_Plate) {
            this.License_Plate = License_Plate;
        }

    public int getDriver_id() {
            return Driver_Id;
        }

    public void setDriver_id(int Driver_Id) {
            this.Driver_Id = Driver_Id;
        }
    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int Speed) {
        this.Speed = Speed;
    }
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

        @Override
        public String toString() {
            return "MyMessage [Id=" + Id + ", License_Plate =" + License_Plate + ",Driver_Id="+
            Driver_Id +",Speed = "+ Speed + "]";
        }

    }

