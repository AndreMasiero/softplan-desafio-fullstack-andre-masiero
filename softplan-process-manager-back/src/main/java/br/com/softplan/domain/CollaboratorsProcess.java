package br.com.softplan.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "collaborators_process")
public class CollaboratorsProcess implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "process_id")
    private Process process;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CollaboratorsProcess)) return false;

        CollaboratorsProcess that = (CollaboratorsProcess) o;

        return process != null ? process.equals(that.process) : that.process == null;
    }

    @Override
    public int hashCode() {
        return process != null ? process.hashCode() : 0;
    }
}
