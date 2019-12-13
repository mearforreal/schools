package org.lauchcode;

public class Pupil extends Person {
    private Long id;
    //    private String subjects;
    private int class_num;
    private String clas_char;
    private int age;
    private String username;
    private String password;



    public Pupil(String username, String password) {

        this.username = username;
        this.password = password;
    }


    public Pupil(Long id, String name, String surname, String middle_name, int age , int class_num, String clas_char, String username, String password) {
        super(name, surname, middle_name);
        this.id = id;
        this.class_num = class_num;
        this.clas_char = clas_char;
        this.age = age;
        this.username = username;
        this.password = password;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getClass_num() {
        return class_num;
    }

    public void setClass_num(int class_num) {
        this.class_num = class_num;
    }

    public String getClas_char() {
        return clas_char;
    }

    public void setClas_char(String clas_char) {
        this.clas_char = clas_char;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "id=" + id +
                ", class_num=" + class_num +
                ", character=" + clas_char +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

