package com.azapps.bloodbankipda3.data;

public class SignUpUser {
    private String name, email, birth_date, donation_last_date, phone, password, password_confirmation;
    private int blood_type_id, city_id;

    public SignUpUser(String name, String email, String birth_date, int blood_type_id, String donation_last_date, int city_id, String phone, String password, String password_confirmation) {
        this.name = name;
        this.email = email;
        this.birth_date = birth_date;
        this.donation_last_date = donation_last_date;
        this.phone = phone;
        this.password = password;
        this.password_confirmation = password_confirmation;
        this.blood_type_id = blood_type_id;
        this.city_id = city_id;
    }

    public String getUserName() {
        return name;
    }

    public void setUserName(String userName) {
        this.name = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getDonation_last_date() {
        return donation_last_date;
    }

    public void setDonation_last_date(String donation_last_date) {
        this.donation_last_date = donation_last_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmNewPassword() {
        return password_confirmation;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.password_confirmation = confirmNewPassword;
    }

    public int getBlood_type_id() {
        return blood_type_id;
    }

    public void setBlood_type_id(int blood_type_id) {
        this.blood_type_id = blood_type_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }
}
