package com.aydincalikoglu;

import com.aydincalikoglu.CompositePattern.Email;
import com.aydincalikoglu.Helper.IteratorType;
import com.aydincalikoglu.IteratorPattern.OrbitData;
import com.aydincalikoglu.TemplatePattern.DiscreteCosineTransform;
import com.aydincalikoglu.TemplatePattern.DiscreteFourierTransform;
import com.aydincalikoglu.TemplatePattern.Transform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HW3 {
    private JButton testMailButton;
    private JTextArea textArea1;
    private JButton testIteratorButton;
    private JTextArea a1234TextArea;
    private JButton button3;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JButton button4;
    private JPanel mainPanel;
    private JTextArea textArea5;
    private JCheckBox calculateTimeCheckBox;

    public HW3() {
        testMailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Email groupMail = new Email("a@gtu.edu.tr", "Gtu A maili");
                groupMail.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
                groupMail.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
                groupMail.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
                groupMail.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));

                Email es = (new Email("aydin@aydin.com.tr", "aydinCalik2"));
                es.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
                es.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
                es.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
                Email em = (new Email("aydin@aydin.com.tr", "aydinCalik3"));
                em.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
                em.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
                em.addMail(new Email("aydin@aydin.com.tr", "aydinCalik"));
                groupMail.addMail(es);
                groupMail.addMail(em);
                textArea1.setText(groupMail.toString());
            }
        });
        testIteratorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // GET GIVEN MATRIS
                String[] rows = a1234TextArea.getText().split("\n");
                int[][] numbers = new int[rows.length][rows[0].split(",").length];
                for (int i = 0; i < rows.length; i++) {
                    for (int j = 0; j <numbers[0].length; j++) {
                        numbers[i][j]= Integer.parseInt(rows[i].split(",")[j]);
                    }
                }

                // ITERATORS
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SpirallyIteratorClockWise"+"\n");
                OrbitData orbitData = new OrbitData(numbers);
                Iterator it = orbitData.getIterator(IteratorType.CLOCKWISE);
                while (it.hasNext()) {
                    stringBuilder.append(it.next()+"\n");
                }
                stringBuilder.append("SpirallyIteratorAntiClockWise"+"\n");
                it = orbitData.getIterator(IteratorType.ANTICLOCKWISE);
                while (it.hasNext()) {
                    stringBuilder.append(it.next()+"\n");
                }
                textArea5.setText(stringBuilder.toString());

            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int matris[][] =
                        {
                                {1, 2, 3, 4,1, 2, 3, 4},
                                {5, 6, 7, 8,1, 2, 3, 4},
                                {9, 10, 11, 12,1, 2, 3, 4},
                                {13, 14, 15, 16,1, 2, 3, 4},
                                {1, 2, 3, 4,1, 2, 3, 4},
                                {5, 6, 7, 8,1, 2, 3, 4},
                                {9, 10, 11, 12,1, 2, 3, 4},
                                {13, 14, 15, 16,1, 2, 3, 4}
                        };
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                System.setOut(new PrintStream(bos));
                System.out.println("DCT");
                Transform transformDCT = new DiscreteCosineTransform();
                transformDCT.readFile("");
                transformDCT.transform(matris);
                transformDCT.writeFile("");
                textArea3.setText(bos.toString());

            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int matris[][] =
                        {
                                {1, 2, 3, 4,1, 2, 3, 4},
                                {5, 6, 7, 8,1, 2, 3, 4},
                                {9, 10, 11, 12,1, 2, 3, 4},
                                {13, 14, 15, 16,1, 2, 3, 4},
                                {1, 2, 3, 4,1, 2, 3, 4},
                                {5, 6, 7, 8,1, 2, 3, 4},
                                {9, 10, 11, 12,1, 2, 3, 4},
                                {13, 14, 15, 16,1, 2, 3, 4}
                        };

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                System.setOut(new PrintStream(bos));
                System.out.println();
                System.out.println("DFT");
                Transform transformDFT = new DiscreteFourierTransform(calculateTimeCheckBox.isSelected());
                transformDFT.transform(matris);
                textArea4.setText(bos.toString());

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HW3");
        HW3 ss = new HW3();
        ss.mainPanel.setPreferredSize(new Dimension(1024,800));// changed it to preferredSize, Thanks!

        frame.setContentPane(ss.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
