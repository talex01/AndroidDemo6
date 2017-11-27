package com.example.watcher.project06_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.watcher.project06_1.model.Person;

public class PersonDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);

        Intent intent = getIntent();
        String name = intent.getStringExtra(PersonActivity.PERSON);
        Person person = getPersonByName(name);

        // при портретной ориентации
        ((TextView) findViewById(R.id.personName)).setText(person.getName());
        String str = "Именины: " + person.getName_day();
        ((TextView) findViewById(R.id.personNameDay)).setText(str);
        ((TextView) findViewById(R.id.personDescription)).setText(person.getDescription());
    }

    public Person getPersonByName(String name) {
        Person person = null;

        for (Person p : PersonProvider.getPersons()) {
            String n = p.getName();
            if (n.equals(name)) {
                person = p;
                break;
            }
        }

        return person;
    }
}
