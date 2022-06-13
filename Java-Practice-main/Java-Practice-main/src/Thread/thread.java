package Thread;

class res {
    public void print(String msg){
//        for(int i = 0; i<10; i++)
            System.out.println("message is  : " + msg + "::");
    }
}

class demo extends Thread{
    res res = new res();
    @Override
    public void run() {
        res.print("demo message");
    }
}

public class thread {

    public static void main(String[] args) {
        res res = new res();
        Runnable runnable = () -> {
            for(int i = 0; i<10; i++)
                res.print("demo message started " + ":::" + i);
        };
        demo d = new demo();
        Thread thread = new Thread(runnable);
        thread.start();
        d.start();
    }

}
