/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import domein.GenerateList;
import java.util.List;
import sorts.BubbleSort;
import domein.SortController;
/**
 *
 * @author Michiel S
 */
public class Test
{
    public static void main(String[] args)
    {
       GenerateList list = new GenerateList(2904,true,true);
       List randlist = list.generateList();
       
       SortController s = new SortController("Ascending",randlist);
       
       BubbleSort bubble = new BubbleSort(s);
       bubble.sort();
    }
    
}
