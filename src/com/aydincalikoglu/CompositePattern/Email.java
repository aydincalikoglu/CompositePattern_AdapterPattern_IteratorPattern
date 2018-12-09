package com.aydincalikoglu.CompositePattern;

import java.lang.annotation.Repeatable;
import java.util.LinkedList;
import java.util.List;

/**
 * CompasitePattern Email
 */
public class Email {
    private String mailAddress;
    private String nameSurname;
    private List<Email> subEmails = new LinkedList<>();

    public Email(String mailAddress, String nameSurname) {
        this.mailAddress = mailAddress;
        this.nameSurname = nameSurname;
    }

    public void addMail(Email email) {
        subEmails.add(email);
    }

    public void removeMail(Email email) {
        subEmails.remove(email);
    }

    public List<Email> getSubEmails() {
        return subEmails;
    }

    @Override
    public String toString() {
        return toStringAll(this, 0);
    }

    private String toStringAll(Email e, int tabSize) {
        StringBuilder stringBuilder = new StringBuilder(("Email :[ mailAddress : " + mailAddress + ", NameSurname : " + nameSurname + " ]")+"\n");
        for (Email em : e.getSubEmails()) {
            String tabs = (new String(new char[tabSize+1]).replace("\0", "\t"));
            stringBuilder.append(tabs+toStringAll(em, tabSize + 1));
        }
        return stringBuilder.toString();
    }
}
