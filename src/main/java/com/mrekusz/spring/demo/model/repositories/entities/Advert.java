package com.mrekusz.spring.demo.model.repositories.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "adverts")
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private LocalDateTime posted;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    @Column(name = "owner_id", insertable = false, updatable = false)
    private Long ownerId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPosted() {
        return posted;
    }

    public void setPosted(LocalDateTime posted) {
        this.posted = posted;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Advert)) return false;
        Advert advert = (Advert) o;
        return Objects.equals(id, advert.id) &&
                Objects.equals(title, advert.title) &&
                Objects.equals(description, advert.description) &&
                Objects.equals(posted, advert.posted) &&
                Objects.equals(owner, advert.owner) &&
                Objects.equals(ownerId, advert.ownerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, posted, owner, ownerId);
    }

    @Override
    public String toString() {
        return "Advert{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", posted=" + posted +
                ", owner=" + owner +
                ", ownerId=" + ownerId +
                '}';
    }
}
