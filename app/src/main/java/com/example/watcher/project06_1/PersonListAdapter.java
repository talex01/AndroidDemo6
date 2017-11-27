package com.example.watcher.project06_1;


import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.watcher.project06_1.model.Person;

import java.util.List;

public class PersonListAdapter extends ArrayAdapter<Person> {
    public PersonListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Person> persons) {
        super(context, 0, persons);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Person person = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_person, parent, false);
        }

        TextView textViewName = (TextView) convertView.findViewById(R.id.personItemName);
        assert person != null;
        textViewName.setText(person.getName());

        return convertView;
    }
}
