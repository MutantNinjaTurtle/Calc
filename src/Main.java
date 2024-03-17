import java.util.Scanner;


public class Main {
    public static int num1;
    public static int num2;
    public static String rezultat;

    public static void main(String[] args) throws MyExeption{

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(calc(s));




    }
    public static String calc(String input) throws MyExeption {
        String[] parts = input.split(" ");
        Check(parts.length);
        char znak = parts[1].charAt(0);
        CheckZnak(znak);
        if (num1Num2Int(parts[0],parts[2] )){
            rezultat = String.valueOf(Operation(num1,num2,znak));
        //    System.out.println(result);
        } else if (Roman.romanToArab(parts[0],parts[2])) {
            rezultat = Roman.arabToRoman(Operation(num1,num2,znak));
           // System.out.println(result);
        }


        return rezultat;
    }


    static boolean num1Num2Int(String a, String b) throws NumberFormatException{
        boolean z=false;
        try {
            num1 = Integer.parseInt(a);
            num2 = Integer.parseInt(b);
            z=true;
        }
        catch (NumberFormatException e) {
            z=false;
        }
        return z;

    }



    static void Check(int a) throws MyExeption {
        if (a>3) {
        throw new MyExeption("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
    } else if (a<3) {
        throw new MyExeption("т.к. строка не является математической операцией");
        }
    }
    static void CheckZnak(char znak) throws MyExeption{
        if ((znak != '+') && (znak != '-') && (znak != '*') && (znak != '/')){
            throw new MyExeption("т.к. формат математической операции не удовлетворяет заданию");
        }
    }

    static int Operation(int num1,int num2,char znak) throws MyExeption{
        int result=0;
        if (num1 <0||num1>10||num2<0||num2>10){
            throw new MyExeption("введеные числа должны быть интервале от 0 до 10");
        }
        switch (znak) {
        case '+':
            result = num1 + num2;
            break;
        case '-':
            result= num1 - num2;
            break;
        case '*':
            result=num1 * num2;
            break;
        case '/':
            if (num2==0){
                throw new MyExeption("т.к. на 0 делить нельзя");
            }
            result=num1 / num2;
            break;

    }
        return result;

    }


}