package domein;

import java.util.List;

/**
 *
 * @author Michiel.S
 */
public class SortFunctions {
    public void printTable(List<Integer> list, int width)
       {
           int remain = list.size() % width;
           String table = "";

           /*make table*/

           for (int i = 0; i <= (list.size() - (remain * 2)); i += width)
           {

               /* make table row*/
               for (int x = i; x <= (i + width >= list.size() ? list.size() - 1 : i + width); x++)
               {
                   table += String.format("%"+width+"d",list.get(x));
               }
               /*make a new row*/
               table += String.format("%n");
           }

           /*add remainder*/
           if (remain != 0)
           {
               for (int i = (list.size() - remain); i <= list.size() - 1; i++)
               {
                   table += String.format("%"+width+"d",list.get(i));
               }
           }

           /*print the table*/
           System.out.println(table);
       }
}
