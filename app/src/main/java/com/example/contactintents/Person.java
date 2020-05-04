package com.example.contactintents;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.EditText;

public class Person implements Parcelable {


    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String location;
    private String website;

    public Person(String firstName,
                  String lastName,
                  String phoneNumber,
                  String email,
                  String location,
                  String website)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.location = location;
        this.website = website;
    }
    public Person(EditText firstNameEditText,
                  EditText lastNameEditText,
                  EditText phoneNumberEditText,
                  EditText emailEditText,
                  EditText locationEditText,
                  EditText websiteEditText)
    {
        this.firstName = firstNameEditText.getText().toString();
        this.lastName = lastNameEditText.getText().toString();
        this.phoneNumber = phoneNumberEditText.getText().toString();
        this.email = emailEditText.getText().toString();
        this.location = locationEditText.getText().toString();
        this.website = websiteEditText.getText().toString();
    }
    public Person() {
        this.firstName = "defaultFirstName";
        this.lastName = "defaultLastName";
        this.phoneNumber = "5015550000";
        this.email = "default@default.default";
        this.location = "5555 Someplace Rd, SomeCity, SomeState, SomeCountry, World 00000";
        this.website = "www.default.default";
    }

    protected Person(Parcel source) {
        this.firstName = source.readString();
        this.lastName = source.readString();
        this.phoneNumber = source.readString();
        this.email = source.readString();
        this.location = source.readString();
        this.website = source.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.phoneNumber);
        parcel.writeString(this.email);
        parcel.writeString(this.location);
        parcel.writeString(this.website);
    }
    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


}
