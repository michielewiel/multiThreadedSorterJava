/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author: Michiel Schoofs
 */
public class BubbleSort
{

    List<Integer> sorted = new ArrayList(), comp, unsorted;
    int numSwaps, length, itteration = 0, index;

    public BubbleSort(List<Integer> list)
    {
        setUnsorted(list);
        setLength(list);
    }

    private void setUnsorted(List<Integer> unsorted)
    {
        this.unsorted = unsorted;
    }

    private void setLength(List<Integer> unsorted)
    {
        this.length = unsorted.size();
    }

    public int getLength()
    {
        return this.length;
    }

    private boolean needsSwap(List<Integer> list)
    {
        return (list.get(0) >= list.get(1));
    }

    private List<Integer> Swap(List<Integer> unsorted)
    {

        List<Integer> newComp = new ArrayList();
        /*returns the new comp list removes smallest from comp and puts it in sorted*/
        if (needsSwap(unsorted))
        {

            /*There is a swap so the first was the biggest*/
            this.sorted.add(unsorted.get(1));
            newComp.add(unsorted.get(0));
            this.numSwaps++;

        } else
        {

            /*There is no swap so the second argument is the smallest*/
            this.sorted.add(unsorted.get(0));
            newComp.add(unsorted.get(1));

        }

        return newComp;
    }

    public List<Integer> sort()
    {

        comp = new ArrayList();
        /*the do refers to while there were swaps needed in the iteration no swaps == sorted list*/

        do
        {
            this.numSwaps = 0;
            ListIterator<Integer> i = unsorted.listIterator();
            while (i.hasNext())
            {

                if (comp.isEmpty())
                {
                    comp.add(i.next());
                    i.remove();
                    comp.add(i.next());
                    i.remove();
                }

                /*preforms Swap and add a new element to comp*/
                comp = Swap(comp);
                comp.add(i.next());
                i.remove();
            }

            /*add the last comparison and make sure to include it in the right order*/
            comp = Swap(comp);
            sorted.addAll(comp);

            /* prepare for next Iteration*/
            this.unsorted.addAll(sorted);
            this.sorted.clear();
            this.comp.clear();
            this.itteration++;
        } while (this.numSwaps != 0);

        /*return and give feedback*/
        System.out.println("Program finished with " + itteration + " iterations");
        printTable(this.unsorted, 15);
        return this.sorted;
    }

    public boolean isLast()
    {
        return ((sorted.size()) == length - 2);
    }

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
                table += list.get(x) + "\t";
            }
            /*make a new row*/
            table += "\n";
        }

        /*add remainder*/
        if (remain != 0)
        {
            for (int i = (list.size() - remain); i <= list.size() - 1; i++)
            {
                table += list.get(i) + "\t";
            }
        }

        /*print the table*/
        System.out.println(table);
    }
}
