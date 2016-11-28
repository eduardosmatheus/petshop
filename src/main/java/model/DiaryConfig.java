package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class DiaryConfig {

    private int id;
    private int agenda;
    private Person person;
    private int hoursCapacity;

    public DiaryConfig(int id, int agenda, Person person, int hoursCapacity) {
        this.id = id;
        this.agenda = agenda;
        this.person = person;
        this.hoursCapacity = hoursCapacity;
    }

    public DiaryConfig() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAgenda() {
        return agenda;
    }

    public void setAgenda(int agenda) {
        this.agenda = agenda;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getHoursCapacity() {
        return hoursCapacity;
    }

    public void setHoursCapacity(int hoursCapacity) {
        this.hoursCapacity = hoursCapacity;
    }
    
}
