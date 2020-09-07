package br.com.softplan.component.process.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

public class ProcessInputDto {

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 50, message = "O tamanho deve ser entre 3 e 50 caracteres")
    private String name;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 160, message = "O tamanho deve ser entre 3 e 160 caracteres")
    private String description;

    private Set<Long> usersId;

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

    public Set<Long> getUsersId() {
        return usersId;
    }

    public void setUsersId(Set<Long> usersId) {
        this.usersId = usersId;
    }
}
