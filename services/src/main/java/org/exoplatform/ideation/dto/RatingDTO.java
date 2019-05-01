package org.exoplatform.ideation.dto;

import org.exoplatform.ideation.entities.RatingEntity;

public class RatingDTO {
    private Long id;
    private RatingEntity.Status status;
    private String user;
    private Long id_idea;

    public RatingDTO(Long id, RatingEntity.Status status, String user, Long id_idea) {

        this.id = id;
        this.status = status;
        this.user = user;
        this.id_idea = id_idea;
    }

    public RatingDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RatingEntity.Status getStatus() {
        return status;
    }

    public void setStatus(RatingEntity.Status status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getId_idea() {
        return id_idea;
    }

    public void setId_idea(Long id_idea) {
        this.id_idea = id_idea;
    }
}
