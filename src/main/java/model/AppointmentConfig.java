package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;

@JsonSerialize
public class AppointmentConfig implements Serializable {

    private Integer id;  
    private Employeer employeer;
    private long entryTime;
    private long lunchTime;
    private long entryTimeAfterLunch;
    private long homeTime;

    public AppointmentConfig() {
    }
 
    public Integer getId() {
        return id;
    }

    public AppointmentConfig(Integer id, Employeer employeer, long entryTime, long lunchTime, long entryTimeAfterLunch, long homeTime) {
        this.id = id;
        this.employeer = employeer;
        this.entryTime = entryTime;
        this.lunchTime = lunchTime;
        this.entryTimeAfterLunch = entryTimeAfterLunch;
        this.homeTime = homeTime;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }

    public Employeer getEmployeer() {
        return employeer;
    }

    public void setEmployeer(Employeer employeer) {
        this.employeer = employeer;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public long getLunchTime() {
        return lunchTime;
    }

    public void setLunchTime(long lunchTime) {
        this.lunchTime = lunchTime;
    }

    public long getEntryTimeAfterLunch() {
        return entryTimeAfterLunch;
    }

    public void setEntryTimeAfterLunch(long entryTimeAfterLunch) {
        this.entryTimeAfterLunch = entryTimeAfterLunch;
    }

    public long getHomeTime() {
        return homeTime;
    }

    public void setHomeTime(long homeTime) {
        this.homeTime = homeTime;
    }
    
    
}
