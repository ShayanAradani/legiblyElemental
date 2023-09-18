import java.util.ArrayList;
import java.util.Stack;

public class Main {
    static String[] reverse(String a[]) {
        int i,n = a.length;
        String t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
        return a;
    }
    public static boolean isInArray(int element, Stack<Integer> list){
        for (int ele:list ){
            if (ele==element){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> middles= new ArrayList<Integer>(); // An Array full of middle of the elements
        Stack<Integer> locations= new Stack<Integer>();// An Stack full of middle locations main array's indexs

        // Examples
        String[] mainArray = {"forssss"," ","issss"," ","isssn"," ","rasssnge","(","12sss3",")",":"};
        String[] elements={"reserved keyword","separator","identifier","separator","reserved keyword","separator","reserved keyword","special characters","number","special characters","special characters"};
        for ( String index : mainArray ){
            int size= (int) Math.ceil((index.length())/2);
            middles.add(size);
        }
        String mainScript = "";
        for (int i = 0; i <= mainArray.length-1; i++) { //find main script
            mainScript+=(mainArray[i]).toString() ;
        }

        System.out.println(mainScript);
        int totalLength=0;
        for (int i = 0; i <= elements.length-1; i++){ // fill the locations stack based on middels
            if (i!=0){
                totalLength+=mainArray[i - 1].length();
                int midloc=((totalLength+ middles.get(i)));
                locations.add(midloc);
            }
            else{
                locations.add(middles.get(0));
            }
        }
        elements=reverse(elements);
        for (int i = 0; i <= elements.length-1; i++){

            String tempStrring="";
            for (int j = 0; j <= mainScript.length()-1; j++){
                if(  locations.size()>0) {
                    if (j <= locations.get(locations.size()-1)) {
                        if (isInArray(j, locations)) {
                            tempStrring += "|";
                        } else {
                            tempStrring += " ";
                        }
                    } else {
                        tempStrring += "-";
                    }
                }
            }
            tempStrring+="->";
            tempStrring+=elements[i];
            System.out.println(tempStrring);
            locations.pop();
        }
    }
}