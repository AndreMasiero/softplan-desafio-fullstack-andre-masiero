package br.com.softplan.component.process.dto;

import br.com.softplan.component.user.dto.UserOutputDto;
import br.com.softplan.enums.ProcessStatus;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class ProcessDetailOutputDto {

    @ApiModelProperty("${process.outputdto.name}")
    private String name;
    @ApiModelProperty("${process.outputdto.description}")
    private String description;
    @ApiModelProperty("${process.outputdto.insertDate}")
    private Date insertDate;
    @ApiModelProperty("${process.outputdto.processStatus}")
    private ProcessStatus status;
    @ApiModelProperty("${process.outputdto.users}")
    private List<UserOutputDto> collaborators;
    @ApiModelProperty("${process.feedback.inputdto.feddback}")
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
