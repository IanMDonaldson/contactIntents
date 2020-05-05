package com.example.contactintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textview.MaterialTextView;

public class ViewContact extends AppCompatActivity {
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_contact);
        Person person = getIntent().getParcelableExtra(MainActivity.EXTRA_PERSON);
        MaterialTextView fullNameTextView = findViewById(R.id.fullNameTextView);
        MaterialTextView firstNameTextView = findViewById(R.id.firstNameTextView);
        MaterialTextView lastNameTextView = findViewById(R.id.lastNameTextView);
        MaterialTextView phoneNumberTextView = findViewById(R.id.phoneTextView);
        MaterialTextView emailTextView = findViewById(R.id.emailTextView);
        MaterialTextView locationTextView = findViewById(R.id.locationTextView);
        MaterialTextView websiteTextView = findViewById(R.id.websiteTextView);

        fullNameTextView.setText(String.format(person.getFirstName() + " " + person.getLastName()));
        firstNameTextView.setText(String.format(person.getFirstName()));
        lastNameTextView.setText(String.format(person.getLastName()));
        phoneNumberTextView.setText(String.format(person.getPhoneNumber()));
        emailTextView.setText(String.format(person.getEmail()));
        locationTextView.setText(String.format(person.getLocation()));
        websiteTextView.setText(String.format(person.getWebsite()));
    }

    public void callContact(View view) {
        Person person = getIntent().getParcelableExtra(MainActivity.EXTRA_PERSON);
        Uri phoneNum = Uri.parse("tel;" + person.getPhoneNumber());
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }
    public void messageContact(View view) {
        Person person = getIntent().getParcelableExtra(MainActivity.EXTRA_PERSON);
        Uri phoneNum = Uri.parse("smsto:" + person.getPhoneNumber());
        Intent intent = new Intent(Intent.ACTION_SENDTO,phoneNum);
        startActivity(intent);
    }

    public void emailContact(View view) {
        Person person = getIntent().getParcelableExtra(MainActivity.EXTRA_PERSON);
        String emailAddress = person.getEmail();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
        startActivity(Intent.createChooser(intent, "Choose desired application: "));
    }

    public void getDirectionsToContact(View view) {
        Person person = getIntent().getParcelableExtra(MainActivity.EXTRA_PERSON);
        String location = person.getLocation();
        String locationUri = String.format("geo:0,0?q=(%s)", location);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(locationUri));
        startActivity(intent);
    }
    public void openContactWebsite(View view) {
        Person person = getIntent().getParcelableExtra(MainActivity.EXTRA_PERSON);
        String webUri = person.getWebsite();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webUri));
        startActivity(intent);
    }
}
