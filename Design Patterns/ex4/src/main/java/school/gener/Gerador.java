package school.gener;

import java.util.*;

public class Gerador extends Thread implements NumListener {
     private List<NumListener> listeners = new ArrayList();
    
    public void run() {
        while (true) {
            int num = (int) (Math.random() * 1001);
            notifyNum(num);
        }
    }
    
    public void addListener(NumListener listener){
        listeners.add(listener);
    }

    public void onNum(int num) {
        System.out.println("Number listened: " + num);
    }
    
    protected void notifyNum(int num) {
        for(NumListener num_listener : listeners ){
            num_listener.onNum(num);
        }
    }
}