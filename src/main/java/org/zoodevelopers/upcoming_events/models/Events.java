package org.zoodevelopers.upcoming_events.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "events")

public class Events {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_events")
    private Long id;

    private String title;
    private LocalDate date;
    private int maxparticipants;
    private String description;
    private String imageUrl;
    private String is_featured;
    private String location;
    private String time;
    
    public Events() {
        // This is intentionally left empty to allow default instantiation
    }

    public Events(Long id, String title, LocalDate date, int maxparticipants, String description, String imageUrl,
            String is_featured, String location, String time) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.maxparticipants = maxparticipants;
        this.description = description;
        this.imageUrl = imageUrl;
        this.is_featured = is_featured;
        this.location = location;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMaxparticipants() {
        return maxparticipants;
    }

    public void setMaxparticipants(int maxparticipants) {
        this.maxparticipants = maxparticipants;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIs_featured() {
        return is_featured;
    }

    public void setIs_featured(String is_featured) {
        this.is_featured = is_featured;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    
}