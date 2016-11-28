package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;

@JsonSerialize
public class Schedule {

    private int id;
    private DiaryConfig configurations;
    private Date date;
    private int schedule;
    private Animal animal;
    private String observations;

    public Schedule() {
    }

    public Schedule(int id, DiaryConfig configurations, Date date, int schedule, Animal animal, String observations) {
        this.id = id;
        this.configurations = configurations;
        this.date = date;
        this.schedule = schedule;
        this.animal = animal;
        this.observations = observations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DiaryConfig getConfigurations() {
        return configurations;
    }

    public void setConfigurations(DiaryConfig configurations) {
        this.configurations = configurations;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSchedule() {
        return schedule;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
    
    
}
