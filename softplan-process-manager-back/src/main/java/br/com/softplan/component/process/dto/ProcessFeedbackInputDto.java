package br.com.softplan.component.process.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class ProcessFeedbackInputDto {

    @ApiModelProperty("${process.feedback.inputdto.feddback}")
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
