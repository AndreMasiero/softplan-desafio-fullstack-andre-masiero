package br.com.softplan.component.user.dto;

import br.com.softplan.enums.RoleUser;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

public class UserInputDto {

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 20, message = "O tamanho deve ser entre 3 e 20 caracteres")
    private String firstName;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 20, message = "O tamanho deve ser entre 3 e 20 caracteres")
    private String lastName;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 50, message = "O tamanho deve ser entre 5 e 50 caracteres")
    private String email;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 6, max = 14, message = "O tamanho deve ser entre 6 e 14 caracteres")
    private String password;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    private RoleUser role;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleUser getRole() {
        return role;
    }

    public void setRole(RoleUser role) {
        this.role = role;
    }
}
