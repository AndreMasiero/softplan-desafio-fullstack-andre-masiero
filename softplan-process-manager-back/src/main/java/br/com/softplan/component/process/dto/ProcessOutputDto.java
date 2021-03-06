package br.com.softplan.component.process.dto;

import br.com.softplan.component.user.dto.UserOutputDto;
import br.com.softplan.enums.ProcessStatus;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

public class ProcessOutputDto {

    @ApiModelProperty("${process.outputdto.id}")
    private Long id;
    @ApiModelProperty("${process.outputdto.name}")
    private String name;
    @ApiModelProperty("${process.outputdto.description}")
    private String description;
    @ApiModelProperty("${process.outputdto.insertDate}")
    private Date insertDate;
    @ApiModelProperty("${process.outputdto.updateDate}")
    private Date updateDate;
    @ApiModelProperty("${process.outputdto.users}")
    private List<UserOutputDto> users;
    @ApiModelProperty("${process.outputdto.processStatus}")
    private ProcessStatus processStatus;

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

    public List<UserOutputDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserOutputDto> users) {
        this.users = users;
    }

    public ProcessStatus getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(ProcessStatus processStatus) {
        this.processStatus = processStatus;
    }
}
