package az.model;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String parent;
    private Date birthDate;
    private String phone;
    private String gmail;
    private String gmailCode;
    private String gender;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getGmailCode() {
        return gmailCode;
    }

    public void setGmailCode(String gmailCode) {
        this.gmailCode = gmailCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", parent='" + parent + '\'' +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", gmail='" + gmail + '\'' +
                ", gmailCode='" + gmailCode + '\'' +
                ", gender='" + gender + '\'' +
                ", status=" + status +
                '}';
    }
}
