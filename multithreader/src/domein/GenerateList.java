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
import java.util.Scanner;

public class GenerateList
{
    boolean recursion,random;
    int maxlength,upperlimit,lowerlimit;
    List<Integer> list;
    
    
    /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
                Constructors
    -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
    public GenerateList(int length){    
        setMaxlength(length);
        boolean newrecursion = askRecursion();
        setRecursion(newrecursion);
        boolean rand = askTrueRandom();
        setRandom(rand);
        if (rand)
            askAndSetLimit();
        checklimits();
    }
    
    public GenerateList(int length,boolean recurssion){
        setMaxlength(length);
        setRecursion(recurssion);
        boolean rand = askTrueRandom();
        setRandom(rand);
        if(rand)
            askAndSetLimit();
        checklimits();
    }
    
    public GenerateList(int length, boolean recurssion, boolean rand){
        setMaxlength(length);
        setRecursion(recurssion);
        setRandom(rand);
        if (rand)
            askAndSetLimit();
        checklimits();
    }
    
    public GenerateList(int length, boolean recurssion,boolean rand, int upperlimit, int lowerlimit){
        setMaxlength(length);
        setRecursion(recurssion);
        setRandom(rand);
        setLimits(lowerlimit,upperlimit);
        checklimits();
    }
    
    
    
    /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-
               Asking additional information
    -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
       private boolean askRecursion(){
        String anwser="";
        Scanner invoer = new Scanner(System.in);
        
        do{
            System.out.print("Do you want recursion in your list? (y for yes n for no): ");
            anwser = invoer.next();
        }while(!(anwser.equals("y")||anwser.equals("n")));
        
        return (anwser.equals("y"));
    }
    
    private boolean askTrueRandom(){
        String anwser="";
        Scanner invoer = new Scanner(System.in);
        
        do{
            System.out.print("Do you want the list to contain random numbers? \n"
                    + "Otherwise the list will contain numbers between [0-length] of your list."+" (y for yes n for no): ");
            anwser = invoer.next();
        }while(!(anwser.equals("y")||anwser.equals("n")));
        
        return (anwser.equals("y"));
    }
    
    private void askAndSetLimit(){
        int lowerlimit,upperlimit;
        Scanner invoer =  new Scanner(System.in);
        
        do{
            System.out.print("Enter the lower limit of the Array (must be bigger or equal to 0): ");
            lowerlimit = invoer.nextInt();
        }while(lowerlimit<0);
        
        do{
            System.out.print("Enter the higher number of the Array (must be bigger then the lower one)");
            upperlimit = invoer.nextInt();
        }while(upperlimit<lowerlimit);
        
       this.lowerlimit = lowerlimit;
       this.upperlimit = upperlimit;
    }
    
    /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
                Setters
    -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
    private void setRecursion(boolean recursion){
        this.recursion = recursion;
    }
    
    private void setRandom(boolean rand){
        this.random = rand;
    }   
    
    private void setMaxlength(int length){
        if (length<=0)
            this.maxlength=900;
        else
            this.maxlength = length;
    }
    
    private void setLimits(int lowerlimit,int upperlimit){
        
        this.upperlimit = upperlimit;
        this.lowerlimit = lowerlimit;
    }
  
   /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
                    1 Checking functions
    -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

    private void checklimits(){
        
        if (this.recursion && !(this.random)){
            /*recurssion and no random numbers*/
            this.upperlimit = this.maxlength;
            this.lowerlimit = 0;
        }
        
        if (!(this.recursion) && !(this.random)){
            /*recurssion and no random numbers*/
            this.upperlimit = this.maxlength;
            this.lowerlimit = 0;
        }
        
        /*no recursion but random numbers means that the range of these numbers must at least be 
        the size of the list you want to generate.
        */
        if(!(this.recursion) && this.random){
            if((upperlimit-lowerlimit)<=this.maxlength){
                throw new IllegalArgumentException("Your range with random, no recursion must at least be "
                        + "bigger then the range of your list ("+this.maxlength+")");
            }
        }
        
        /*
        If there is no recursion and no random number you need to be the exact length of the list
        */
        
        if(!(this.recursion)&&!(this.random)){
            if((upperlimit-lowerlimit)!=this.maxlength){
                throw new IllegalArgumentException("Your range needs to be exactly "+(this.maxlength)
                +"apart for example :[0,"+(0+this.maxlength)+"]");
            }
        }
        
        
        /*
        Check if the lowerlimit and upper limit are natural numbers
        */
       if(upperlimit < 0|| lowerlimit <0){
           throw new IllegalArgumentException("Your limits must be natural positive numbers.");
       } 
        
    }
    
    
    /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
                          Main function
    -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
    public List<Integer> generateList(){
       List<Integer> randlist = new ArrayList<Integer>();
       Random random = new Random();
       int rand;
       
       
       while (randlist.size()<=this.maxlength-1){
           /*to get the range of the number correct*/
           rand = lowerlimit+random.nextInt(upperlimit);
           
           /*If there is no recurssion the number needs to be unique otherwise add all*/
           if(!this.recursion){
              if(inList(randlist,rand)==-1)
                    randlist.add(rand);
           }else
               randlist.add(rand);
          
           
        }
    
    this.list = randlist;
    return randlist;
    }
    
    /*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
                           Helper functions
    -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
    private int inList(List<Integer> list,int integer){
        return list.indexOf(integer);
    }
   
}
