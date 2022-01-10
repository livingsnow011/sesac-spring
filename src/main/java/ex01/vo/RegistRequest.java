package ex01.vo;

public class RegistRequest {
    private String email;
    private String password;
    private String confirmPassword;
    private String name;

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
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // 패스워드와 패스워드 확인 정보가 일치하는지 여부를 반환
    public boolean isPasswordEqualsToConfirmPassword() {
        return this.password.equals(this.confirmPassword);
    }
}
