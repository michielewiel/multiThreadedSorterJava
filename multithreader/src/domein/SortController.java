package domein;

import java.util.List;
import java.util.ArrayList;
import enums.Modes.Mode;
/**
 *
 * @author Michiel.S
 */
public class SortController {
    private Mode Sortmode;
    private List<Integer> unsorted = new ArrayList();
    
    /************
     Constructor
     ***********/
     
    public SortController(String mode,List<Integer> li){
        setMode(mode);
        setList(li);
    }
    
    /*************
     Mode handler 
     ************/
    private void setMode(String mode){
       if(mode!="Ascending" && mode != "Descending")
           throw new IllegalArgumentException("Incorrect mode (needs to be Ascending or Descending");
       else
            if (mode=="Ascending")
                this.Sortmode = Mode.Ascending;
            else
                this.Sortmode = Mode.Descending;
    }
    
    public Mode GetMode(){
        return this.Sortmode;
    }
    
    /*************
     List Handler
     ************/
    
    private void setList(List<Integer> li){
        this.unsorted = li;
    }
    
    public int getUnsortedLength(){
        return this.unsorted.size();
    }
    
    public List<Integer> getList(){
        return this.unsorted;
    }
    
}
