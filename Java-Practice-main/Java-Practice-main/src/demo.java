import java.text.DecimalFormat;
import java.util.Arrays;


public class demo {
    public static void main(String[] args) throws InterruptedException {
        int[] num = {1,2,3,4,5,6,7,8,9,10};
//        even(num);
//        odd(num);
	System.out.println("hello there");
        Thread t1 = new Thread(() -> odd(num));
        Thread t2 = new Thread(() -> even(num));
        t1.start();
        t1.join();
        t2.start();
	System.out.println("Hi there");
    }

    private static void odd(int[] num) {
        Arrays.stream(num).filter(i -> i%2 != 0).forEach(System.out::println);
    }

    private static void even(int[] num) {
        Arrays.stream(num).filter(i -> i%2 == 0).forEach(System.out::println);
    }
}
