public class Start {
    public static void main(String[] args) {
        System.out.println("We are the champions");
    }

    static void pause(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
