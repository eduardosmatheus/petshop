package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.Date;

@JsonSerialize
public class Appointment implements Serializable {

    private Integer id;  
    private AppointmentConfig appointmentConfig;
    private Animal pet;
    private Date date;
    private long entryTime;
    private long outTime;
    private int done;
    private String obs;

    public Appointment() {
    }
    
    public Appointment(Integer id, AppointmentConfig appointmentConfig, Animal pet, Date date, long entryTime, long outTime, int done, String obs) {
        this.id = id;
        this.appointmentConfig = appointmentConfig;
        this.pet = pet;
        this.date = date;
        this.entryTime = entryTime;
        this.outTime = outTime;
        this.done = done;
        this.obs = obs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AppointmentConfig getAppointmentConfig() {
        return appointmentConfig;
    }

    public void setAppointmentConfig(AppointmentConfig appointmentConfig) {
        this.appointmentConfig = appointmentConfig;
    }

    public Animal getPet() {
        return pet;
    }

    public void setPet(Animal pet) {
        this.pet = pet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public long getOutTime() {
        return outTime;
    }

    public void setOutTime(long outTime) {
        this.outTime = outTime;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    
    
}
