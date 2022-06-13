package Thread;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Executor {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService service = Executors.newSingleThreadExecutor();
//        service.execute(() -> System.out.println("hello there"));
//        Future<Integer> f = service.submit(() -> 5);
//        System.out.println(f.get());
//        service.shutdown();

        Set<String> s = new ConcurrentSkipListSet<>();
        s.add("hello");
        s.add("hi");
        Iterator<String> s1 = s.iterator();
        while(s1.hasNext()){
            System.out.println(s1.next());
            s.add("new");
        }

        List<String> list = Arrays.asList("hello","there");
        List<String> list1 = Arrays.asList("Hi","HEEE");
        List<List<String>> finalList = new ArrayList<>();
        finalList.add(list);
        finalList.add(list1);
        System.out.println(finalList);
        List<Stream<String>> collect1 = finalList.stream().map(l -> l.stream()).collect(Collectors.toList());

        System.out.println(collect1);

        List<String> collect = finalList.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
        System.out.println(collect);

    }
}
