package com.example.projectusers.models;

import javax.persistence.*;
import javax.validation.constraints.*;
@Entity(name = "user_site")

public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message="Поле не может быть пустым")
    @Size(min=2, max=30, message="Поле должно содержать от 2 до 30 символов")
    @Column(name = "LastName", length = 50, nullable = false, unique = true, columnDefinition = "TEXT")
    private String last_Name;
    @NotEmpty(message="Поле не может быть пустым")
    @Size(min=2, max=30, message="Поле должно содержать от 2 до 30 символов")
    private String first_Name;
    private String patronymic;
    @Min(value=0, message="Поле не может содержать отрицательные значения")

    private int age;
    @NotEmpty(message="Поле не может быть пустым")
    @Email(message="Вы ввели не E-mail")

    private String email;
    @NotEmpty(message="Поле не может быть пустым")
    @Pattern(regexp="^((\\+7|7|8)+([0-9]){10})$", message="Номер телефона должен быть указан в формате +7/7/81234567890")

    private String phone_number;
    public User(int id, String last_Name, String first_Name, String patronymic, int age, String email, String phone_number) {
        this.id = id;
        this.last_Name = last_Name;
        this.first_Name = first_Name;
        this.patronymic = patronymic;
        this.age = age;
        this.email = email;
        this.phone_number = phone_number;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", last_Name='" + last_Name + '\'' +
                ", first_Name='" + first_Name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
