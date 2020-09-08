package br.com.softplan.component.user.dto;

import br.com.softplan.enums.RoleUser;
import io.swagger.annotations.ApiModelProperty;

public class UserOutputDto {

    @ApiModelProperty("${user.outputdto.id}")
    private Long id;
    @ApiModelProperty("${user.outputdto.firstName}")
    private String firstName;
    @ApiModelProperty("${user.outputdto.lastName}")
    private String lastName;
    @ApiModelProperty("${user.outputdto.email}")
    private String email;
    @ApiModelProperty("${user.outputdto.role}")
    private RoleUser role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleUser getRole() {
        return role;
    }

    public void setRole(RoleUser role) {
        this.role = role;
    }
}
