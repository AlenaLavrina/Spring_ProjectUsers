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
    @Column(name = "lastName", length = 50, nullable = false, unique = true, columnDefinition = "TEXT")
    private String lastName;
    @NotEmpty(message="Поле не может быть пустым")
    @Size(min=2, max=30, message="Поле должно содержать от 2 до 30 символов")
    private String firstName;
    private String patronymic;
    @Min(value=0, message="Поле не может содержать отрицательные значения")

    private int age;
    @NotEmpty(message="Поле не может быть пустым")
    @Email(message="Вы ввели не E-mail")

    private String email;
    @NotEmpty(message="Поле не может быть пустым")
    @Pattern(regexp="^((\\+7|7|8)+([0-9]){10})$", message="Номер телефона должен быть указан в формате +7/7/81234567890")

    private String phoneNumber;
    public User(int id, String lastName, String firstName, String patronymic, int age, String email, String phone_number) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
