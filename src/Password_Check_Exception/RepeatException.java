package Password_Check_Exception;

public class RepeatException extends Exception{
    public RepeatException(char repeat_c){
        System.out.println("Символ " + repeat_c + " повторяется более 2 раз" );
    }
}
