import Tasks.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.pow;

public class Main {
    public static void task_first(){
        T_password_check password_check = new T_password_check();
        Scanner input = new Scanner(System.in);
        do {
            password_check.input(input);
        } while (password_check.check());
        //input.close();
    }

    public static String reverseString(String str){
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public static long near_polindrom(long value){
        List<Integer> Digit_list = new ArrayList<Integer>();
        String s = String.valueOf(value);
        String big_s = String.valueOf(value + (long)pow(10,s.length()/2));
        long palindrome_big = Long.valueOf((big_s.length()%2==0)?
                big_s.substring(0,big_s.length()/2-1) + reverseString(big_s.substring(0,big_s.length()/2 -1 )):
                big_s.substring(0,big_s.length()/2) + reverseString(big_s.substring(0,big_s.length()/2-1)));
        long palindrome_low = Long.valueOf((s.length()%2==0)?
                s.substring(0,s.length()/2) + reverseString(s.substring(0,s.length()/2)):
                s.substring(0,s.length()/2+1) + reverseString(s.substring(0,s.length()/2)));
        return abs(value - palindrome_low) > abs(value - palindrome_big)? palindrome_big : palindrome_low;
    }

    public static void task_second(){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите число long");
        long polindrom = near_polindrom(input.nextLong());
        System.out.println("Ближайший полиндром - " + polindrom);
    }


    public static void main(String[] args){
        int task_num;

        Scanner input = new Scanner(System.in);
        do {
            System.out.println("==========================================================");
            System.out.println("Введите номер задачи или ноль если хотите заврешить работу");
            task_num = input.nextInt();
            switch (task_num) {

                case 1:
                    task_first();
                    break;

                case 2:
                    task_second();
                    break;
            }
        } while (task_num!=0);
        input.close();
    }

}
