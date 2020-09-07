package br.com.softplan.component.process.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class ProcessFeedbackInputDto {

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 100, message = "O tamanho deve ser entre 3 e 100 caracteres")
    private String feedback;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
