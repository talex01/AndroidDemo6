package com.example.watcher.project06_1.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String name;
    private String name_day;
    private String description;

    public Person(String name, String name_day, String description) {
        this.name = name;
        this.name_day = name_day;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_day() {
        return name_day;
    }

    public void setName_day(String name_day) {
        this.name_day = name_day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", name_day='" + name_day + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.name_day);
        dest.writeString(this.description);
    }

    protected Person(Parcel in) {
        this.name = in.readString();
        this.name_day = in.readString();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
