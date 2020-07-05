package logger;

public class MessageGame {

    public static void setMessage(String message) {
        System.out.print(" ");
        for (int i = 0; i <= message.length(); i++) System.out.print("═");
        System.out.print("═");
        System.out.print("═");
        System.out.print("═");
        System.out.println("");
        System.out.print(" ║ ");
        System.out.print(message);
        System.out.print(" ║ ");
        System.out.println("");
        System.out.print(" ");
        for (int i = 0; i <= message.length(); i++) System.out.print("═");
        System.out.print("═");
        System.out.print("═");
        System.out.print("═");
        System.out.println("");
    }
}
