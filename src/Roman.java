import java.util.HashMap;
import java.util.Map;

 class Roman {
    public static boolean romanToArab(String num1,String num2) throws MyExeption {
        Map<String, Integer> map = new HashMap<>();

        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);

        if (map.containsKey(num1)){
            Main.num1=map.get(num1);
        }
        else {
            throw  new MyExeption("т.к. используются одновременно разные системы счисления");
        }
        if (map.containsKey(num2)){
            Main.num2=map.get(num2);
        }
        else {
            throw  new MyExeption("т.к. используются одновременно разные системы счисления");
        }
        return true;

    }
    public static String arabToRoman (int num) throws MyExeption {
        String [] key =  {  "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int [] vals = {  100, 90, 50, 40, 10, 9, 5, 4, 1 };

        if(num<1){throw new MyExeption("т.к. в римской системе нет отрицательных чисел и 0");

        }

        String rez = new String();
        int c = 0;

        while (c< key.length){
            while (num >= vals[c]){
                int d = num / vals[c];
                num = num % vals[c];
                for(int i=0; i<d; i++)
                    rez=rez+(key[c]);
            }
            c++;

        }
        return rez;

    }
}
