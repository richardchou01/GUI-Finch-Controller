public class FinchTester {
    public static void main(String[] args) throws Exception {
        Finch finch = new Finch("A");

        for (int i = 0; i < 10; i++) {
            finch.setMotors(10.0, 10.0);
            finch.pause(1);
        }

        finch.stopAll();
        finch.disconnect();
    }

    public static void spiral(int n){

        
    }

    
}
