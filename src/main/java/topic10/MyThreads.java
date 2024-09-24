package topic10;

import topic10.Thread1;
import topic10.Thread2;

public class MyThreads {
    public static void main(String[] args){
        (new Thread(new Thread1())).start();
        (new Thread2()).start();
    }
}
