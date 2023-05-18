
package practicearray;

/**
 *
 * @author hp
 */
public class Practicearray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        String name = "harsh";
        char[] array = new char[name.length()];
        for(int i=0;i<name.length();i++)
        {
            array[i]=name.charAt(i);
        }
        System.out.println("reversed word : ");
        for(int i=array.length - 1 ; i>=0; i--)
        {
            System.out.print(array[i]);
        }
    }
    
}
