package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.List;

@JsonSerialize
public class ServiceOrder implements Serializable {

    private Integer id;  
    private Appointment appointment;
    private List<ItemOrder> itens;
    private String accessKey;
    private double price;

    public ServiceOrder() {
    }

    public ServiceOrder(Integer id, Appointment appointment, List<ItemOrder> itens, String accessKey, double price) {
        this.id = id;
        this.appointment = appointment;
        this.itens = itens;
        this.accessKey = accessKey;
        this.price = price;
    } 
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ItemOrder> getItens() {
        return itens;
    }

    public void setItens(List<ItemOrder> itens) {
        this.itens = itens;
    }
    
}
