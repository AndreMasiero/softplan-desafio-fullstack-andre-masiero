package br.com.softplan.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Process implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Column(name = "insert_date")
    private Date insertDate;

    @Column(name = "update_date")
    private Date updateDate;

    private Boolean feedback;

    @OneToMany(mappedBy = "process")
    private List<CollaboratorsProcess> collaborators = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getFeedback() {
        return feedback;
    }

    public void setFeedback(Boolean feedback) {
        this.feedback = feedback;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CollaboratorsProcess> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<CollaboratorsProcess> collaborators) {
        this.collaborators = collaborators;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Process)) return false;

        Process process = (Process) o;

        if (id != null ? !id.equals(process.id) : process.id != null) return false;
        if (name != null ? !name.equals(process.name) : process.name != null) return false;
        if (description != null ? !description.equals(process.description) : process.description != null) return false;
        if (insertDate != null ? !insertDate.equals(process.insertDate) : process.insertDate != null) return false;
        if (updateDate != null ? !updateDate.equals(process.updateDate) : process.updateDate != null) return false;
        if (feedback != null ? !feedback.equals(process.feedback) : process.feedback != null) return false;
        if (collaborators != null ? !collaborators.equals(process.collaborators) : process.collaborators != null)
            return false;
        return user != null ? user.equals(process.user) : process.user == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (insertDate != null ? insertDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (feedback != null ? feedback.hashCode() : 0);
        result = 31 * result + (collaborators != null ? collaborators.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
