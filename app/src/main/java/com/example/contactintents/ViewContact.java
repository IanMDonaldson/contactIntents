package com.example.contactintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ViewContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contact);
        Person person = getIntent().getParcelableExtra(MainActivity.EXTRA_PERSON);
        TextView firstNameTextView = findViewById(R.id.firstNametextView);
        TextView lastNameTextView = findViewById(R.id.lastNametextView);
        TextView phoneNumberTextView = findViewById(R.id.phonetextView);
        TextView emailTextView = findViewById(R.id.emailtextView);
        TextView locationTextView = findViewById(R.id.locationtextView);
        TextView websiteTextView = findViewById(R.id.websitetextView);

        firstNameTextView.setText(String.format(person.getFirstName()));
        lastNameTextView.setText(String.format(person.getLastName()));
        phoneNumberTextView.setText(String.format(person.getPhoneNumber()));
        emailTextView.setText(String.format(person.getEmail()));
        locationTextView.setText(String.format(person.getLocation()));
        websiteTextView.setText(String.format(person.getWebsite()));
    }

}
