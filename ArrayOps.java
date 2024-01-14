public class ArrayOps {
    public static void main(String[] args) {
    //    int [] arr = {0,1,4,53,25,2};
    //   System.out.println(findMissingInt(arr));
    System.out.println(containsTheSameElements(new int[] {3, -4, 1, 2, 5}, new int[] {1, 3, -4, 5}));;
    //    System.out.println(secondMaxValue(arr));
    //    System.out.println(isSorted(new int[] {7,7, 5, 4, 3, -12})); // true
    //   System.out.println( isSorted(new int[] {1, 2, 3})); // true
    //   System.out.println( isSorted(new int[] {1, -2, 3})); // false
    //   System.out.println( isSorted(new int[] {1, 1, 500})); // true
    //   System.out.println( isSorted(new int[] {1, 3, 2})); // false
       
    }
    
    public static int findMissingInt (int [] array) {
        int missNum = 0;
        int  sum = 0; 
        for (int i = 0; i < array.length; i++) {
           sum += array[i];
           missNum += i + 1;
        }
        return (missNum - sum);
    }
 
    public static int secondMaxValue(int [] array) {
        int secondVal = 0; 
      for (int i = 0; i < array.length; i++) {
            if(array[i] == firstMaxValue(array)){
                array[i] = 0;                          //First max value in array = 0
                break;
            }
         }
        secondVal = firstMaxValue(array);             //After I put in the first max value = 0, the second max become the first max
        return secondVal;
    }

    /*** function give the max value in array ***/
    public static int firstMaxValue(int[] array){
        int maxVal = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > maxVal)
                maxVal = array[i];
        }
        return maxVal;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        int [] uniq1 = set(array1);
        int [] uniq2 = set(array2);
        boolean isSame = false;
        if(uniq1.length != uniq2.length){
            return isSame;
        }
        for (int i = 0; i < uniq1.length; i++) {
            for (int j = 0; j < uniq2.length; j++) {
                if(array1[i] == array2[j]){
                    isSame = true;
                    break;
                }
            }
            if(!isSame){
                return isSame = false;
            }
        }
        return isSame;
    }

    /********helper function*******/
    public static boolean contains(int[] arr, int value, int index) {
        for (int i = 0; i < index; i++) {
            if (arr[i] == value) {
              return true;
            }
        }
        return false ;
    }
        
    public static int countUnique(int[] arr) {
        int count = 0; 
        for (int i = 0; i < arr.length; i++) {
            count = contains(arr, arr[i], i) ? count : count + 1;
        }
        return count;
    }
        
    public static int [] set (int[] arr) {
        int [] res = new int [countUnique(arr)];
        int index = 0; 
        for (int i = 0; i < arr.length; i++) {
            if (!contains(arr, arr[i], i)){
                res[index++] = arr[i];
            }
        }
        return res;
    }
        
    /*****************************************/

    public static boolean isSorted(int [] array) {
        boolean isSorted = true ;
        if (array[0] <= array [array.length - 1] ){   //check if the array is sorted increasingly or decreasingly
            for (int i = 1; i < array.length; i++) {  // sorted increasingly
                if(array[i - 1] > array[i])
                isSorted = false;
            }
        }else{
            for (int i = 1; i < array.length; i++) {  //sorted decreasingly
                if(array[i - 1]  < array[i])
                isSorted = false;
            }
        }
        return isSorted;
    }

}
