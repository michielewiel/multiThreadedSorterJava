/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;

/**
 *
 * @author iamja
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class GenerateList
{
    int maxlength;
    List<Integer> list;
    
    public GenerateList(int length){
        setMaxlength(length);
    }
    
    private void setMaxlength(int length){
        if (length<=0)
            this.maxlength=900;
        else
            this.maxlength = length;
    }
    
    public List generateList(){
       List<Integer> randlist = new ArrayList<Integer>();
       Random random = new Random();
       int rand;
       
       
       while (randlist.size()<=this.maxlength-1){
           rand = random.nextInt(maxlength);
           if(inList(randlist,rand)==-1){
               randlist.add(rand);
           }
       }
       
       this.list = randlist;
       return randlist;
    }
    
    private int inList(List list,int integer){
        return list.indexOf(integer);
    }
}
