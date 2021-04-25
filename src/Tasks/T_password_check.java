package Tasks;
import Password_Check_Exception.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class T_password_check extends Task {
    private String password;

    @Override
    public void input(Scanner input) {
        System.out.println("Введите пароль, который соответсвует требованиям:");
        System.out.println("- Более 20 и не менее 6 символов");
        System.out.println( "- Хотя бы одна буква в верхнем регистре");
        System.out.println("- Хоть один спец символ и не более чем два подряд одинкаовых символа");
        password = input.nextLine();
    }

    public boolean check() { //как это поправить просто тут всё плохо
        boolean isNotValid = false;
        try {
            check_length();
        }catch (LengthException e) {
            isNotValid = true;
        }
        try {
            check_digit();
        }
        catch (DigitException e){
            isNotValid = true;
        }
        try {
            check_upper();
        } catch (NotUpperException e) {
            isNotValid = true;
        }
        try {
            check_repeat();
        } catch (RepeatException e) {
            isNotValid = true;
        }
        return isNotValid;
    }

    private void check_length() throws LengthException {
        if (password.length() > 20 || password.length() < 6) {
            int dif;
            if (password.length() > 20)
                dif = 20 - password.length();
            else
                dif = 6 - password.length();
            throw new LengthException(dif);
        }
    }
    private void check_upper() throws NotUpperException {
        boolean in_password_upper_char = false;
        for(int i = 65;i<96;i++){
            in_password_upper_char = password.contains(String.valueOf((char)i));
            if (in_password_upper_char)
                break;
        }
        if (!in_password_upper_char)
            throw new NotUpperException();
    }

    private List<Integer> init_digit(List<Integer> Digits){
        for (int i = 32;i<127;i++){
            Digits.add(i);
            switch (i){
                case 47:
                    i = 57;
                    break;
                case 64:
                    i = 90;
                    break;
                case 96:
                    i = 122;
            }
        }
        return Digits;
    }

    private void check_digit() throws DigitException{
        List<Integer> Digits = new ArrayList<Integer>();
        init_digit(Digits);
        String tmp;
        boolean digit_be_in_password = false;
        for (int digit : Digits){
            tmp = String.valueOf((char)digit);
            digit_be_in_password = password.contains(tmp);
            if (digit_be_in_password)
                break;
        }
        if(!digit_be_in_password)
            throw new DigitException();
    }

    private void check_repeat() throws RepeatException {
        for (int i = 0; i+2 < password.length();i++){
            if (password.charAt(i) == password.charAt(i+1)&&password.charAt(i+1) == password.charAt(i+2))
                throw new RepeatException(password.charAt(i));
        }
    }
}
