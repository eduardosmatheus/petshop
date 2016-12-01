package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;

@JsonSerialize
public class AppointmentConfig implements Serializable {

    private Integer id;   
    private Integer employeers_id;
    private long entryTime;
    private long lunchTime;
    private long entryTimeAfterLunch;
    private long homeTime;

    public AppointmentConfig() {
    }

    public AppointmentConfig(Integer id, int employeers_id, long entryTime, long lunchTime, long entryTimeAfterLunch, long homeTime) {
        this.id = id;
        this.employeers_id = employeers_id;
        this.entryTime = entryTime;
        this.lunchTime = lunchTime;
        this.entryTimeAfterLunch = entryTimeAfterLunch;
        this.homeTime = homeTime;
    }
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
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

    public int getEmployeers_id() {
        return employeers_id;
    }

    public void setEmployeers_id(Integer employeers_id) { 
        this.employeers_id = employeers_id;
    }
    
    
}
