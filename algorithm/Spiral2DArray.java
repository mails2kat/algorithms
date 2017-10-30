/*
 * Copyright (c) 2015 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package algorithm;

/**
 * 
 * @author 212365826
 */
public class Spiral2DArray
{

    public static void main(String[] args) {

        int[][] values = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        
        int m = values.length;
        int n = values[0].length;
        int i, k = 0, l = 0;
        while (k < m && l < n)
        {
            /* Print the first row from the remaining rows */
            for (i = l; i < n; ++i)
            {
                System.out.println(values[k][i]);
            }
            k++;
     
            /* Print the last column from the remaining columns */
            for (i = k; i < m; ++i)
            {
                System.out.println(values[i][n-1]);
            }
            n--;
     
            /* Print the last row from the remaining rows */
            if ( k < m)
            {
                for (i = n-1; i >= l; --i)
                {
                    System.out.println(values[m-1][i]);
                }
                m--;
            }
     
            /* Print the first column from the remaining columns */
            if (l < n)
            {
                for (i = m-1; i >= k; --i)
                {
                    System.out.println(values[i][l]);
                }
                l++;    
            }        
        }

    }

}
