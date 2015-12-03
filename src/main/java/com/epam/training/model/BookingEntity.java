package com.epam.training.model;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;

/**
 * Created by Mao Shaco on 12/3/2015.
 */
@Entity
@Table(name = "booking", schema = "", catalog = "example")
public class BookingEntity {
    private int id;
    private LocalDateTime timestamp;
    private int expense;
    private RequestEntity requestByRequestId;
    private RoomEntity roomByRoomId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "timestamp")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Basic
    @Column(name = "expense")
    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingEntity that = (BookingEntity) o;

        if (id != that.id) return false;
        if (expense != that.expense) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + expense;
        return result;
    }

    @OneToOne
    @JoinColumn(name = "request_id", referencedColumnName = "id", nullable = false)
    public RequestEntity getRequestByRequestId() {
        return requestByRequestId;
    }

    public void setRequestByRequestId(RequestEntity requestByRequestId) {
        this.requestByRequestId = requestByRequestId;
    }

    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id", nullable = false)
    public RoomEntity getRoomByRoomId() {
        return roomByRoomId;
    }

    public void setRoomByRoomId(RoomEntity roomByRoomId) {
        this.roomByRoomId = roomByRoomId;
    }
}