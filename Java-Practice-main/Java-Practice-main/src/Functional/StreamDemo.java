package Functional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        List<Person> personList = List.of(new Person("Himanshu",24),
                new Person("Naveen",16),new Person("Shivani",23));
        personList.stream().filter(person -> person.getAge()>18).
                filter(person -> person.getName().contains("i"))
                .collect(Collectors.toList());
//                .forEach(System.out::println);
    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
