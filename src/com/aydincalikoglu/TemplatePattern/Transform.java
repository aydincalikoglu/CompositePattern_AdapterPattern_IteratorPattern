package com.aydincalikoglu.TemplatePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * TemplatePattern
 * Ortak olan methodlar soyut sınıf içerisinde tanımlanır.
 * Kalan methodlar ilgili sınıfa bırakılmak üzere abstract tanımlanır.
 */
public abstract class Transform {
    List<List<Double>> matris = new ArrayList<>();

    public abstract void transform(int matrix[][]);

    public void readFile(String fileName)
    {
        for (int j = 0; j < 8; j++) {
            List arr = new ArrayList();
            for (int i = 0; i < 8; i++) {
                arr.add(1.0);
            }
            matris.add(arr);
        }
    }

    public void writeFile(String fileName)
    {
        for (List arr:matris) {
            for (int i = 0; i < 8; i++) {
                System.out.println(arr.get(i));
            }
        }
    }

}
