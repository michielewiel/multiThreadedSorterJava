package sorts;

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import domein.SortController;
import enums.Modes.Mode;
import domein.SortFunctions;
/**
 *
 * @author: Michiel Schoofs
 */
public class BubbleSort
{
    
    private List<Integer> sorted = new ArrayList(), comp, unsorted;
    private int numSwaps, length, itteration = 0;
    SortController s;
    SortFunctions func = new SortFunctions();

    public BubbleSort(SortController s)
    {
        setUnsorted(s.getList());
        setLength(s.getUnsortedLength());
        this.s = s;
    }


    private void setUnsorted(List<Integer> unsorted)
    {
        this.unsorted = unsorted;
    }

    private void setLength(int length)
    {
        this.length = length;
    }


    
    public int getLength()
    {
        return this.length;
    }

    private boolean needSwapAscending(List<Integer> list)
    {
        return (list.get(0) >= list.get(1));
    }

    
    private boolean needSwapDescending(List<Integer> list){
        return(list.get(0)<= list.get(1));
    }
    
    private List<Integer> Swap(List<Integer> unsorted)
    {
        boolean ascendingswap = (needSwapAscending(unsorted) && s.GetMode() == Mode.Ascending),
                descendingswap= (needSwapDescending(unsorted ) && s.GetMode() == Mode.Descending);
        
        List<Integer> newComp = new ArrayList();
        
        
        /*returns the new comp list removes smallest from comp and puts it in sorted*/
        if (ascendingswap ||descendingswap)
        {
            
            /*There is a swap so the first was the biggest*/
            this.sorted.add(unsorted.get(1));
            newComp.add(unsorted.get(0));
            
            
            /*The program checks for number of swaps when it's finished these need to be 0
            So if there were two equal numbers we don't count them as a swap since the positions don't change
            */
            if ((int)comp.get(0)!=(int) comp.get(1)){
                this.numSwaps++;
            }

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
            System.out.println("Itteration preformed with "+this.numSwaps+" Swaps");
            /* prepare for next Iteration*/
            this.unsorted.addAll(sorted);
            this.sorted.clear();
            this.comp.clear();
            this.itteration++;
        } while (this.numSwaps != 0);

        /*return and give feedback*/
        System.out.println("Program finished with " + itteration + " iterations");
        func.printTable(this.unsorted, 8);
        return this.sorted;
    }

    public boolean isLast()
    {
        return ((sorted.size()) == length - 2);
    }


}
