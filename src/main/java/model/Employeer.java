package model;
 
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Employeer {
    private int id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
    private AppointmentConfig appointmentConfig;

    public Employeer(int id, String name, String cpf, String phone, String email, AppointmentConfig appointmentConfig) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.email = email;
        this.appointmentConfig = appointmentConfig;
    }

    public Employeer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { 
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AppointmentConfig getAppointmentConfig() {
        return appointmentConfig;
    }

    public void setAppointmentConfig(AppointmentConfig appointmentConfig) {
        this.appointmentConfig = appointmentConfig;
    }
    
    
}
