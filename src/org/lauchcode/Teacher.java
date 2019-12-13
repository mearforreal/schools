package org.lauchcode;

public class Teacher extends Person {
    private Long id;
    private String subject_name;
    private String achievement;
    private String email;
    private int age;
    private int salary;
    private String username;
    private String password;

    public Teacher() {}

//    public Teacher(Long id, String subject_name, String achievement, String email, int age, int salary) {
//        this.id = id;
//        this.subject_name = subject_name;
//        this.achievement = achievement;
//        this.email = email;
//        this.age = age;
//        this.salary = salary;
//    }


    public Teacher(String name,  String username, String password) {
        super(name);
        this.username = username;
        this.password = password;
    }

    public Teacher(Long id, String name, String surname, String middle_name, String subject_name, String achievement, String email, int age, int salary, String username, String password) {
        super(name, surname, middle_name);
        this.id = id;
        this.subject_name = subject_name;
        this.achievement = achievement;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.username = username;
        this.password = password;
    }

    public void getFullName(){
        String fullName = getName() + " " + getSurname();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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
        return "Teacher{" +
                "id=" + id +
                ", subject_name='" + subject_name + '\'' +
                ", achievement='" + achievement + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

