/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import domein.GenerateList;
import java.util.List;
import domein.BubbleSort;
/**
 *
 * @author iamja
 */
public class Test
{
    public static void main(String[] args)
    {
       GenerateList list = new GenerateList(942);
       List randlist = list.generateList();
       
       BubbleSort bubble = new BubbleSort(randlist);
       bubble.sort();
       
    }
    
}