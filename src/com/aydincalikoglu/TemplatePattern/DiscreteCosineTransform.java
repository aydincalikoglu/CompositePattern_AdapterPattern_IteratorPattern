package com.aydincalikoglu.TemplatePattern;

/**
 * DCT referans : https://www.geeksforgeeks.org/discrete-cosine-transform-algorithm-program/
 *
 */
public class DiscreteCosineTransform extends Transform {
    public static int n = 8,m = 8;
    public static double pi = 3.142857;

    @Override
    public void transform(int matrix[][]) {
        n=matrix.length;
        m=matrix[0].length;
        int i, j, k, l;
        double[][] dct = new double[m][n];
        double ci, cj, dct1, sum;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (i == 0)
                    ci = 1 / Math.sqrt(m);
                else
                    ci = Math.sqrt(2) / Math.sqrt(m);

                if (j == 0)
                    cj = 1 / Math.sqrt(n);
                else
                    cj = Math.sqrt(2) / Math.sqrt(n);
                sum = 0;
                for (k = 0; k < m; k++) {
                    for (l = 0; l < n; l++) {
                        dct1 = matrix[k][l] *
                                Math.cos((2 * k + 1) * i * pi / (2 * m)) *
                                Math.cos((2 * l + 1) * j * pi / (2 * n));
                        sum = sum + dct1;
                    }
                }
                dct[i][j] = ci * cj * sum;
            }
        }
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++)
                matris.get(i).set(j, dct[i][j]);
        }
    }
}
