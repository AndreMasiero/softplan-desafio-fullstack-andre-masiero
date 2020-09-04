package br.com.softplan.config.dto;

public class CredentialsInputDto {

    private String email;
    private String password;

    public CredentialsInputDto() {
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
}
