package br.com.softplan.enums;

public enum ErrorMessage {

    ERROR_SAVING_USER("Erro ao salvar o usuário"),
    ERROR_UPDATE_USER("Erro ao atualizar o usuário"),
    ERROR_DELETE_USER("Erro ao deletar o usuário"),
    USER_EMAIL_UNAVAILABLE("Já existe um usuário cadastrado com este e-mail"),
    USER_EMAIL_ALREADY_IN_USE("Este e-mail já está em uso"),
    USER_INVALID_EMAIL("O formato do e-mail é inválido"),
    PROCESS_UNINFORMED_COLLABORATORS("Informe ao menos um colaborador para o projeto"),
    PROCESS_INVALIDE_COLABORATOR_ID("Nao foi encontrado um colaborador com o ID informado"),
    PROCESS_INVALIDE_COLABORATOR_PROFILE("Perfíl admin não pode participar do projeto"),
    PROCESS_SAVE_ERROR("Erro desconhecido ao salvar o processo"),
    PROCESS_NOT_FOUND("Processo não econtrado");

    private final String description;

    private ErrorMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
