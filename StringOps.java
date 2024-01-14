public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        System.out.println(camelCase("Hello World"));
    // System.out.println(capVowelsLowRest("Hello World")); // “hEllO wOrld”;
    // System.out.println(capVowelsLowRest("One two tHRee world")); // “OnE twO thrEE wOrld”;
    // System.out.println(capVowelsLowRest("vowels are fun")); // “vOwEls ArE fUn”;
    // System.out.println(capVowelsLowRest("intro")); // “IntrO”;
    // System.out.println(capVowelsLowRest("yellow"));
        
    println(allIndexOf("Hello world",'l')); // output: {2, 3, 9}
    // allIndexOf("Hello worLd",'l'); // output: {2, 3}
    // allIndexOf("Hello world",'o'); // output: {4, 7}
    // allIndexOf("Hello world",' '); // output: {5}
    // allIndexOf("Hello world",'d'); // output: {10}
    // allIndexOf("MMMM",'M'); 
    }

    public static String capVowelsLowRest (String string) {
        String vowelStrLow = ""; 
        String lowerLetter = camelCaseWithSpace(string);
        for (int i = 0; i < lowerLetter.length(); i++) {
            if(isVowel(lowerLetter.charAt(i))){
                vowelStrLow += (char)(lowerLetter.charAt(i) - 32);
            }else{
                vowelStrLow += (char)(lowerLetter.charAt(i));
            }
        }
        return vowelStrLow;
    }


    /*** Helper function ***/
    public static boolean isVowel (char ch){
        boolean vowel;
        vowel = ch == 'a' ||ch == 'i'||ch == 'u' || ch == 'o' ||ch == 'e' ||
                ch == 'A' ||ch == 'I'||ch == 'U' || ch == 'O' ||ch == 'E' ? true : false;
        return vowel;
     }

     public static String camelCaseWithSpace(String string) {
        String camelStr = ""; 
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z'){
                camelStr += (char)(string.charAt(i) + 32); 
            }else{
                camelStr += string.charAt(i);
            }
        }
        return camelStr;
    }
     /********************************************************************************/

    public static String camelCase(String string) {
        String camelStr = "";
        String nString = camelCaseWithSpace(string);
        if(nString.charAt(0) !=' ')
            camelStr += nString.charAt(0);
        for (int i = 1; i < nString.length(); i++) {
            if(nString.charAt(i - 1) == ' ' && nString.charAt(i)!=' ' &&camelStr.length() > 0){
                 camelStr += (char)(nString.charAt(i) - 32);
            }else if (nString.charAt(i) != ' '){
                camelStr += nString.charAt(i);
            }
            }
        return camelStr;
    }

    public static int[] allIndexOf (String string, char chr) {
        // Write your code here:
        int letterShow = countLetter(string, chr);
        int [] indexLettr = new int[letterShow]; 
        int itr = 0;
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == chr){
                indexLettr[itr] = i;
                itr++;
            }
        }
        return indexLettr;
    }

    public static int countLetter(String str , char ch){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ch){
                count++;
            }
        }
        return count;
    }

    /*** print array helper function ***/
    public static void println(int [] arr){
        System.out.print("{" + arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(", " + arr[i]);
        }
        System.out.println("}");
    }
}
