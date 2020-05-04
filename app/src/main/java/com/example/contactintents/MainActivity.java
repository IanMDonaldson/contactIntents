package com.example.contactintents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    /*public static final String EXTRA_FIRST_NAME = "defaultFirstName";
    public static final String EXTRA_LAST_NAME = "defaultLastName";
    public static final String EXTRA_PHONE_NUMBER = "defaultPhoneNum";
    public static final String EXTRA_EMAIL = "defaultEmail";
    public static final String EXTRA_LOCATION = "defaultLocation";
    public static final String EXTRA_WEBSITE = "defaultWebsite";*/
    public static final String EXTRA_PERSON = "personData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onButtonClicked(View view) {
        EditText firstNameEditText = findViewById(R.id.firstNameEditText);
        EditText lastNameEditText = findViewById(R.id.lastNameEditText);
        EditText phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText locationEditText = findViewById(R.id.phoneNumberEditText);
        EditText websiteEditText = findViewById(R.id.websiteEditText);
        Person person = new Person(firstNameEditText,
                lastNameEditText,
                phoneNumberEditText,
                emailEditText,
                locationEditText,
                websiteEditText);

        Intent intent = new Intent(this, ViewContact.class);
        intent.putExtra(EXTRA_PERSON, person);
        startActivity(intent);
    }
}
