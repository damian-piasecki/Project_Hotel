package pl.coderslab.entity;

import javax.persistence.*;

@Entity
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String roomDesc;
    int roomCost;
    String roomType;

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public int getRoomCost() {
        return roomCost;
    }

    public void setRoomCost(int roomCost) {
        this.roomCost = roomCost;
    }


    @ManyToOne
    User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

}
