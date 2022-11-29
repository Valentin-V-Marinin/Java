package Java.Seminar2;

import java.util.Random;
import java.util.Arrays;
import java.io.IOException;
import java.util.logging.*;

public class task1 {
    public static void main(String[] args)  throws IOException {
        Logger logger = Logger.getLogger(task1.class.getName());
        FileHandler fh = new FileHandler("log_task1.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        Random r = new Random();
        int[] bubles = new int[15];
        int[] peas   = new int[15];
        for (int j = 0; j < bubles.length; j++) {
            bubles[j] = r.nextInt(-100, 101);    
        }
        System.arraycopy(bubles, 0, peas, 0, 15);

        logger.log(Level.INFO,"source array: " + Arrays.toString(peas));
        int flag = 1; int buffer = 0;
        while (flag==1){
            flag = 0;
            for (int i = 1; i < peas.length; i++) {
                if (peas[i-1] > peas[i]){
                    flag = 1;
                    buffer = peas[i-1];
                    peas[i-1] = peas[i];
                    peas[i] = buffer;
                    logger.log(Level.INFO,"change elemments " + peas[i-1] + " and " + peas[i]);
                }
            }
        }
        logger.log(Level.INFO,"rrsult array: " + Arrays.toString(peas));
        System.out.println(Arrays.toString(bubles)  + " - source array");
        System.out.println(Arrays.toString(peas)    + " - result array");
    }
}
