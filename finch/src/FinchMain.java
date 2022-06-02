public class FinchMain {
    public static void main(String[] args) {
        // Main Finch Program
        Finch myFinch = new Finch("A");
        myFinch.setBeak(100, 100, 100);
        myFinch.pause(1);
        new FinchFrame(myFinch, 500, 500);

        // Testing Finch EventListener utilities
        // new FinchTest(500, 500);
    }
}