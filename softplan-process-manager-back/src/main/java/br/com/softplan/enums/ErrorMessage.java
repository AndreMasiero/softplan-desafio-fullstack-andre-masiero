package br.com.softplan.enums;

public enum ErrorMessage {

    ERROR_SAVING_USER("Erro ao salvar o usuário"),
    ERROR_UPDATE_USER("Erro ao atualizar o usuário"),
    USER_EMAIL_UNAVAILABLE("Já existe um usuário cadastrado com este e-mail"),
    USER_EMAIL_ALREADY_IN_USE("Este e-mail já está em uso"),
    USER_INVALID_EMAIL("O formato do e-mail é inválido");

    private final String description;

    private ErrorMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
