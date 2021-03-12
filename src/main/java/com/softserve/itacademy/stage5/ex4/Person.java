package com.softserve.itacademy.stage5.ex4;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

    private String firstName;
    private String lastName;
    private String idCode;

    static Person buildPerson(String firstName, String lastName, String idCode) {
        Person person = new Person();
        StringBuffer message = new StringBuffer();
        try
        {
            person.setFirstName(firstName);
        }
        catch(NameException e) {
            message.append(e.getMessage()) ;
            message.append("; ");
        }
        try
        {
            person.setLastName(lastName);
        }
        catch(NameException e) {
            message.append(e.getMessage()) ;
            message.append("; ");
        }
        try
        {
            person.setIdCode(idCode);
        }
        catch(CodeException e) {
            message.append(e.getMessage()) ;
            message.append("; ");
        }
        if (message.length() == 0) return person;
        else throw new IllegalArgumentException(message.substring(0, message.length()-2));
    }

    boolean isNameValid (String name) {
        boolean result = true;
        Pattern p = Pattern.compile("^([A-Z]{1}[a-z]+)$");
        for(String s : name.split(" ")) {
            Matcher m = p.matcher(s);
            if (!m.matches()) result = false;
        }
        return result;
    }
    boolean isCodeValid (String code) {
        Pattern p = Pattern.compile("^[0-9]{10}$");
        Matcher m = p.matcher(code);
        return m.matches();
    }

    public void setFirstName(final String firstName) {
        if (!isNameValid(firstName)) {
            throw new NameException(String.format("Incorrect value %s for firstName (should start from upper case and contains only alphabetic characters and symbols -, _)", firstName));
        }
        this.firstName = firstName;
    }

    public void setLastName(final String lastName) {
        if (!isNameValid(lastName)) {
            throw new NameException(String.format("Incorrect value %s for lastName (should start from upper case and contains only alphabetic characters and symbols -, _)", lastName));
        }
        this.lastName = lastName;
    }

    public void setIdCode(final String idCode) {
        if (!isCodeValid(idCode)) {
            throw new CodeException(String.format("Incorrect value %s for code (should contains exactly 10 digits)", idCode));
        }
        this.idCode = idCode;
    }

    @Override
    public boolean equals(final Object o) {
        if(this == o)
        {
            return true;
        }
        if(!(o instanceof Person))
        {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(idCode,
                                                                                                                          person.idCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, idCode);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ": " + idCode;
    }
}