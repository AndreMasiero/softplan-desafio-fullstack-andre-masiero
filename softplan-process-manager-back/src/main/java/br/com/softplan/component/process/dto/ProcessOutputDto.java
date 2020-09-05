package br.com.softplan.component.process.dto;

import br.com.softplan.component.user.dto.UserOutputDto;

import java.util.Date;
import java.util.List;

public class ProcessOutputDto {

    private Long id;

    private String name;

    private String description;

    private Date insertDate;

    private Date updateDate;

    private List<UserOutputDto> users;

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
}
