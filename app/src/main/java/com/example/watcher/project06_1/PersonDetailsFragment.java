package com.example.watcher.project06_1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.watcher.project06_1.model.Person;

public class PersonDetailsFragment extends Fragment {


    public static final String PERSON = "PERSON";

    public PersonDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle args = getArguments();
        Person person = args.getParcelable(PERSON);

        View view = inflater.inflate(R.layout.activity_person_details, container, false);

        // при альбомной ориентации
        assert person != null;
        ((TextView) view.findViewById(R.id.personName)).setText(person.getName());
        String str = "Именины: " + person.getName_day();
        ((TextView) view.findViewById(R.id.personNameDay)).setText(str);
        ((TextView) view.findViewById(R.id.personDescription)).setText(person.getDescription());

        return view;
    }

    public static PersonDetailsFragment newInstance(Person person) {
        PersonDetailsFragment fragment = new PersonDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(PERSON, person);
        fragment.setArguments(args);
        return fragment;
    }
}
