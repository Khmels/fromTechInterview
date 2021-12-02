package edu.example.core.objects;

import java.util.Date;

// Don't allow subclasses to override methods
//+++ Declare the immutable class as final so it can't be extended
public final class ImmutableObject {

    //+++ Declare all fields final and private
    private final int id;
    private final String name;
    private final String lastName;
    private final Date date;

    //+++ If a mutable object passed to the constructor must be assigned to a field create a defensive copy of it
    /*
    So holding a reference to an object passed to the constructor can create mutable objects.
    To solve this problem it is necessary to create a defensive copy of the parameter if they are mutable objects:
     */

    public ImmutableObject(int id, String name, String lastName, Date date) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    // +++ If a field is a mutable object create defensive copies of it for getter methods
    // defining a field final and private is not enough because it is possible to change its internal state.
    // To solve this problem we need to create a defensive copy of that field and return that field every time it is requested.
    public Date getDate() {
        return new Date(date.getTime());
    }

    /*
    Note that if a field is a reference to an immutable object is not necessary to create defensive copies of it
    in the constructor and in the getter methods
    it is enough to define the field as final and private.
    As an example of common immutable objects there are String,
    all primitive wrappers (Integer, Long, Double, Byte....), BigDecimal, BigInteger.
     */

    @Override
    // Declare all methods of the immutable class final so they can't be overriden
    public final String toString() {
        return "ImmutableObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date=" + date +
                '}';
    }
}

// Create a private constructor and a factory to create instances of the immutable class
// because a class with private constructors can't be extended
