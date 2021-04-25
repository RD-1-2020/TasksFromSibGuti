package Password_Check_Exception;

public class NotUpperException extends Exception{
    public NotUpperException(){
        System.out.println("Необходимо чтобы хотя бы один символ был в верхнем регистре");
    }
}
