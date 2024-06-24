package model;

public class RegisterUser {
    private String email;
    private String password;
    private String repeatPassword;
    private String firstname;
    private String lastname;

    public RegisterUser(String email, String password, String repeatPassword, String firstname, String lastname) {
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getRepeatPassword() {
        return repeatPassword;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
}
