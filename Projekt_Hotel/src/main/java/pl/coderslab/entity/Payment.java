package pl.coderslab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    Long id;
    String paymentType;
    int valueToPay;

    public List<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }

    @OneToMany
    List<Reservations> reservations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getValueToPay() {
        return valueToPay;
    }

    public void setValueToPay(int valueToPay) {
        this.valueToPay = valueToPay;
    }
}
