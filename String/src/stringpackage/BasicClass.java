package stringpackage;

import java.util.Arrays;

public class BasicClass {
    public static void main(String[] args){


        boolean res = isPalindrome.fun("abba");
        System.out.println(res);

    }
}



class isPalindrome{

    static boolean fun(String str){




        int low = 0; int high = str.length()-1;
        char lowchar; char highchar;
        while(low<high){

            lowchar = str.charAt(low);
            highchar = str.charAt(high);

            if(!Character.isLetterOrDigit(lowchar)){
                low++;
            }else if(!Character.isLetterOrDigit(highchar)){
                high--;
            }else {
                if (Character.toLowerCase(str.charAt(low)) != Character.toLowerCase(str.charAt(high))) {
                    return false;
                }
            }
            low++;
            high--;
        }

        return true;


    }
}
