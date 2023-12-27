package com.projet.agenda.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=150, nullable = false)
    private String titre;

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Temporal(TemporalType.DATE)  //use for TemporalType to handle date
    private Date eventDate;
    @Column(length = 128, nullable = false, unique = true)
    private LocalTime heureDebut;

    @Column(length = 128, nullable = false, unique = true)
    private LocalTime heureFin;

    @Column(length = 128, nullable = false)
    private String lieu;

    @Column(length = 255)
    private String commentaire;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="user_id")
    //Reference to the user who created the event
    private User createdBy;

    public Event(){}

    public Event(String titre, LocalDateTime heureDebut, LocalDateTime heureFin, String lieu, String commentaire){
        this.titre = titre;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.lieu = lieu;
        this.commentaire = commentaire;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDateTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalDateTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalDateTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalDateTime heureFin) {
        this.heureFin = heureFin;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public User getCreateBy() {
        return createdBy;
    }

    public void setCreateBy(User createBy) {
        this.createdBy = createBy;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Event other = (Event) obj;
        return id != null && id.equals(other.id);
    }

}
