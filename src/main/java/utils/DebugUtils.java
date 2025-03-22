package utils;

import java.util.concurrent.TimeUnit;

public class DebugUtils {

    public static void debugWait(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}