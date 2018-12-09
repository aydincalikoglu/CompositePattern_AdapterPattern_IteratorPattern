package com.aydincalikoglu;

import com.aydincalikoglu.CompositePattern.Email;
import com.aydincalikoglu.Helper.IteratorType;
import com.aydincalikoglu.IteratorPattern.OrbitData;
import java.util.Iterator;


public class Main {

    public static void main(String[] args) {
        Email groupMail = new Email("a@gtu.edu.tr", "Gtu A maili");
        groupMail.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
        groupMail.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
        groupMail.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
        groupMail.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));

        Email e = (new Email("aydin@aydin.com.tr", "aydinCalik2"));
        e.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
        e.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
        e.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
        Email em = (new Email("aydin@aydin.com.tr", "aydinCalik3"));
        em.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
        em.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
        em.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
        groupMail.addMail(e);
        groupMail.addMail(em);

        System.out.println(groupMail.toString());


        int N = 4;

        // Test Case 1
        int mat[][] =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };

        OrbitData orbitData = new OrbitData(mat);
        Iterator it = orbitData.getIterator(IteratorType.CLOCKWISE);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("antiClock");
        it = orbitData.getIterator(IteratorType.ANTICLOCKWISE);
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}

