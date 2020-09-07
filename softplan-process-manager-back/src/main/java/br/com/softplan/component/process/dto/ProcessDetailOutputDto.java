package br.com.softplan.component.process.dto;

import br.com.softplan.component.user.dto.UserOutputDto;
import br.com.softplan.enums.ProcessStatus;

import java.util.Date;
import java.util.List;

public class ProcessDetailOutputDto {

    private String name;
    private String description;
    private Date insertDate;
    private ProcessStatus status;
    private List<UserOutputDto> collaborators;
    private List<ProcessFeedbackOutputDto> feedbacks;

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

    public ProcessStatus getStatus() {
        return status;
    }

    public void setStatus(ProcessStatus status) {
        this.status = status;
    }

    public List<UserOutputDto> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<UserOutputDto> collaborators) {
        this.collaborators = collaborators;
    }

    public List<ProcessFeedbackOutputDto> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<ProcessFeedbackOutputDto> feedbacks) {
        this.feedbacks = feedbacks;
    }
}
