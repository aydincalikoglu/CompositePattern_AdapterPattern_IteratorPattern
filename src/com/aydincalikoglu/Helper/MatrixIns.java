package com.aydincalikoglu.Helper;

import java.util.LinkedList;
import java.util.List;

public class MatrixIns {
    public static List<Integer> spiralTravers(int data[][])
    {
        List<Integer> listTravers = new LinkedList<>();
        int n = data[0].length;
        int m = data.length;
        int i, k = 0, l = 0;
        while (k < m && l < n)
        {
            for (i = l; i < n; ++i)
            {
                listTravers.add(data[k][i]);
            }
            k++;

            // Print the last column from the remaining columns
            for (i = k; i < m; ++i)
            {
                listTravers.add(data[i][n-1]);
            }
            n--;

            // Print the last row from the remaining rows */
            if ( k < m)
            {
                for (i = n-1; i >= l; --i)
                {
                    listTravers.add(data[m-1][i]);
                }
                m--;
            }

            // Print the first column from the remaining columns */
            if (l < n)
            {
                for (i = m-1; i >= k; --i)
                {
                    listTravers.add(data[i][l]);
                }
                l++;
            }
        }
        return listTravers;
    }
}
