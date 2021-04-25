package Password_Check_Exception;

public class LengthException extends Exception {
    public LengthException(int quantity) {
        if (quantity > 0)
            System.out.println("Добавте ещё " + quantity + " символов");
        else
            System.out.println("Уберите  " + quantity + " символов");
    }
}

