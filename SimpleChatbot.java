import java.util.Scanner;
public class SimpleChatbot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("🤖 Welcome to the Java Chatbot!");
        System.out.println("Type 'bye' to end the conversation.\n");

        while (true) {
            System.out.print("You: ");
            input = sc.nextLine().toLowerCase(); // make input lowercase for easy matching

          
            if (input.contains("bye")) {
                System.out.println("Bot: Goodbye! Have a great day! 👋");
                break;
            }

           
            else if (input.contains("hi") || input.contains("hello")) {
                System.out.println("Bot: Hello! How can I assist you today?");
            } 
            else if (input.contains("java")) {
                System.out.println("Bot: Java is a high-level programming language used for building applications.");
            } 
            else if (input.contains("who created java")) {
                System.out.println("Bot: Java was created by James Gosling at Sun Microsystems.");
            } 
            else if (input.contains("your name")) {
                System.out.println("Bot: I'm your friendly Java Chatbot. 😊");
            } 
            else if (input.contains("thanks") || input.contains("thank you")) {
                System.out.println("Bot: You're welcome! 😊");
            } 
            else {
                System.out.println("Bot: Sorry, I don't understand that yet.");
            }
        }

        sc.close();
    }
}