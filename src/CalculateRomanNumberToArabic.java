import java.util.HashMap;

/**
 * Created by Professional on 2/6/2017.
 */

public class CalculateRomanNumberToArabic {
    public static void main(String[] args) {

    }

    public static boolean checkCorectNumber(char[] textTable){
        boolean check=true;
        for (int i = 0; i <=textTable.length-3 ; i++) {
            if((RomanNumberMap.get(textTable[i])< RomanNumberMap.get(textTable[i+1]))&&(RomanNumberMap.get(textTable[i+1])< RomanNumberMap.get(textTable[i+2]))){
                check=check&&false;
            }else {
                check=check&&true;
            }
        }return check;
    }

    private static final HashMap<Character ,Integer> RomanNumberMap =new HashMap<>();
    static {
        RomanNumberMap.put('I',1);
        RomanNumberMap.put('V',5);
        RomanNumberMap.put('X',10);
        RomanNumberMap.put('L',50);
        RomanNumberMap.put('C',100);
        RomanNumberMap.put('D',500);
        RomanNumberMap.put('M',1000);
    }

    public static Object changeRomanNumberToArabic(String romanNumber){
        int count=0;
        String wrongNumber="Wrong Number";
        if(romanNumber==""){
            return 0;
        }else {
            char[] romanNumberTable=romanNumber.toCharArray();
            if((romanNumber.matches(".*(I{4,}|V{4,}|X{4,}|L{4,}|C{4,}|D{4,}|M{4,}).*")) || (!checkCorectNumber(romanNumberTable))){
                System.out.println(wrongNumber);
                return wrongNumber;
            }else {
                for (int i = 0; i < romanNumberTable.length; i++){
                    if (RomanNumberMap.containsKey(romanNumberTable[i])){
                        if (i + 1 > romanNumberTable.length - 1){
                            count = count + RomanNumberMap.get(romanNumberTable[i]);
                        }else{
                            if (RomanNumberMap.get(romanNumberTable[i + 1]) > RomanNumberMap.get(romanNumberTable[i])){
                                count = count - RomanNumberMap.get(romanNumberTable[i]);
                            }else {
                                count = count + RomanNumberMap.get(romanNumberTable[i]);
                            }
                        }
                    }else {
                        System.out.println(wrongNumber);
                        return wrongNumber;
                    }
                }
            }
            return count;
        }
    }
}