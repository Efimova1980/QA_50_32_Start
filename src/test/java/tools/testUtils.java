package tools;

public class testUtils {

    public static void pause(int time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
