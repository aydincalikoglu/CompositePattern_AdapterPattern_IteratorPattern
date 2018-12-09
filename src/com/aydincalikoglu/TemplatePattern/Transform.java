package com.aydincalikoglu.TemplatePattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Transform {
    List<List<Double>> matris = new ArrayList<>();
    public Transform()
    {
        matris.forEach(t-> t=new ArrayList<>());
    }
    public void readFile(String fileName)
    {
        for (List arr:matris) {
            for (int i = 0; i < 5; i++) {
                arr.add(0.0);
            }
        }
    }

    public abstract void transform(int matrix[][]);

    public void writeFile(String fileName)
    {
        for (List arr:matris) {
            for (int i = 0; i < 5; i++) {
                System.out.println(arr.get(i));
            }
        }
    }

}
