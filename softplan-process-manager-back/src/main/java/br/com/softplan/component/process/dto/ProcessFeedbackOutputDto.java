package br.com.softplan.component.process.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class ProcessFeedbackOutputDto {

    @ApiModelProperty("${process.feedback.outputdto.feddback}")
    private String feedback;
    @ApiModelProperty("${process.feedback.outputdto.user}")
    private String user;
    @ApiModelProperty("${process.feedback.outputdto.insertDate}")
    private Date insertDate;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }
}
