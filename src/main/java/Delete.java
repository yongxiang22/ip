import java.util.ArrayList;
public class Delete {
    
    protected int index;

    public Delete(ArrayList<Task> list, int index) {

        this.index = index;
         System.out.println("Noted. I've removed this task: ");
         System.out.println(list.get(index).toString());
         list.remove(index);
         System.out.println("Now you have " + list.size() + " tasks in the list.");
         
        
       
        
        }
}
