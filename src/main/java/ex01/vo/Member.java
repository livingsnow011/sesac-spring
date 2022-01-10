package ex01.vo;

import java.time.LocalDateTime;

import ex01.exception.WrongIdPasswordException;

// 회원 정보를 표현하는 객체
public class Member {
    //Field
    private Long id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime registDate;

    //Constructor
    public Member(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.registDate = LocalDateTime.now();
    }

    //Method Getter & Setter
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public String getEmail(){return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public LocalDateTime getRegistDate() { return registDate; }
    public void setLocalDateTime(LocalDateTime registDate) {this.registDate = registDate;}

    // 패스워드 변경 처리 Method
    public void changePassword(String oldPassword, String newPassword) throws WrongIdPasswordException{
        //패스워드 변경을 요청하는 사용자를 확인
        if (!this.password.equals(oldPassword)) {
            throw new WrongIdPasswordException();
        }
    }
}
