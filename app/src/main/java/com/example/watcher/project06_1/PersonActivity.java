package com.example.watcher.project06_1;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;

import com.example.watcher.project06_1.model.Person;

import java.util.List;


public class PersonActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public static final String PERSON = "PERSON";
    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        personList = PersonProvider.getPersons();

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fragment_details);

        PersonListAdapter adapter = new PersonListAdapter(this, 0, personList);
        GridView gridView = (GridView) findViewById(R.id.list_persons);
        gridView.setAdapter(adapter);

        if (frameLayout == null) { // портретная ориентация
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Person person = personList.get(position);
                    Intent intent = new Intent(PersonActivity.this, PersonDetailsActivity.class);
                    intent.putExtra(PERSON, person.getName());
                    startActivity(intent);
                }
            });
        } else { // альбомная ориентация
            gridView.setOnItemClickListener(this);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        PersonDetailsFragment fragment = PersonDetailsFragment.newInstance(personList.get(position));
        Fragment old = getSupportFragmentManager().findFragmentById(R.id.fragment_details);
        if (old == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_details, fragment)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_details, fragment)
                    .commit();
        }
    }
}
