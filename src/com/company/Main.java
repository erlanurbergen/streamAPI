package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // ArrayList - динамический массив, у него не ограниченная длина

//        String [] allStrings = new String[10];

//        ArrayList<String> strings = new ArrayList<String>(); // более гибкий вариант
//        String text = "hello";
//        for (int i = 0; i < 10; i++) {
//            strings.add(text + i);
//        }
//
//        strings.forEach(System.out::println); // вывол на экран
        List<User> users = getUsers();

//        List<User> unique = users.stream()
//                .distinct().collect(Collectors.toList());
//
//
//        unique.forEach(System.out::println);

//        ArrayList<User> userArrayList = new ArrayList<>();
//
//        userArrayList.add(new User("USer1", 18, Role.ADMIN));
//        userArrayList.add(new User("USer2", 20, Role.USER));
//        userArrayList.add(new User("USer3", 16, Role.GUEST));
//
//        Collections.sort(userArrayList, new SortByAge());
//
//        userArrayList.forEach(System.out::println);
	    // imperative approach

//        ArrayList<User> newUserRole = new ArrayList<>();
//
//        for (User u: users){
//            if (u.getRole().equals(Role.GUEST)){
//                newUserRole.add(u);
//            }
//        }
//
//        newUserRole.forEach(System.out::println);

        // declarative approach

        // filter
//        long count = users.stream()
//                .filter(user -> user.getAge() > 20)
//                .count();
//
//        System.out.println(count);

//        collect.forEach(System.out::println);


        // sort

//        List<User> sortedUsers = users.stream()
//                .sorted(Comparator.comparing(User::getName))
//                .collect(Collectors.toList());
//
//        sortedUsers.forEach(System.out::println);

        // max
//        users.stream()
//                .max(Comparator.comparing(User::getAge))
//                .ifPresent(System.out::println);
        // min
//        users.stream()
//                .min(Comparator.comparing(User::getAge))
//                .ifPresent(System.out::println);

        // group

//        Map<Role, List<User>> collect = users.stream()
//                .collect(Collectors.groupingBy(User::getRole));
//
//        collect.forEach((role, users1) -> {
//            System.out.println(role);
//            users1.forEach(System.out::println);
//            System.out.println("---------");
//        });
//
//        users.stream()
//                .filter(user -> user.getRole().equals(Role.USER))
//                .max(Comparator.comparing(User::getAge))
//                .map(User::getData)
//                .ifPresent(System.out::println);

        // anyMatch
//        boolean b = users.stream()
//                .anyMatch(user -> user.getAge() > 20);
//
//        System.out.println(b);
//        // allMatch
//
//        boolean b1 = users.stream()
//                .allMatch(user -> user.getAge() > 20);
//
//        System.out.println("almatch: " + b1);
//        // noneMatch
//        boolean b2 = users.stream()
//                .noneMatch(user -> user.getAge() < 30);
//
//        System.out.println(b2);
//        Stream<User> userStream = Stream.of(new User("Arman", 20, Role.ADMIN), new User("Arman", 21, Role.USER));
//        Stream<User> userStream2 = Stream.of(new User("Erlan", 20, Role.USER), new User("Usman", 21, Role.ADMIN));
//
//
//        Stream.concat(userStream, userStream2).forEach(System.out::println);
//

////
//        Citizen citizen = new Citizen("Daniyar");
//        Citizen citizen2 = new Citizen("Darkhan");
//        Citizen citizen3 = new Citizen("Eldana");
//        Citizen citizen4 = new Citizen("Dilyara");
//
//        City city = new City("Almaty");
//        City city2 = new City("Astana");
//
//        city.addCitizen(citizen);
//        city.addCitizen(citizen2);
//
//        city2.addCitizen(citizen3);
//        city2.addCitizen(citizen4);
//
//        Region region = new Region("million");
//        region.addCity(city);
//        region.addCity(city2);
//
//        Republic republic = new Republic("KZ");
//        republic.addRegion(region);
//
//        System.out.println(republic);


//        users.stream()
//                .takeWhile(user -> user.getAge() > 20)
//                .forEach(System.out::println);
//

        users.stream()
                .dropWhile(user -> user.getAge() > 20)
                .sorted(Comparator.comparing(User::getAge))
                .forEach(System.out::println);

    }

    private static List<User> getUsers(){
        return List.of(
                new User("Erlan", 28, Role.ADMIN),
                new User("Erlan", 28, Role.ADMIN),
                new User("Arman", 20, Role.USER),
                new User("Eric", 19, Role.USER),
                new User("Bekzat", 29, Role.GUEST),
                new User("Aruna", 18, Role.USER),
                new User("Anel", 21, Role.GUEST),
                new User("Anel", 21, Role.GUEST)
        );
    }
}

class SortByAge implements Comparator<User>{
    @Override
    public int compare(User o1, User o2) {
        return o1.getAge() - o2.getAge(); // сортировка от меньшего к большему
    }
}


enum Role{
    ADMIN, USER, GUEST;
}

class User{
    private String name;
    private int age;
    private Role role;

    public User(String name, int age, Role role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Role getRole() {
        return role;
    }
    public String getData(){
        return name + " " + age;
    }



    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", role=" + role +
                '}';
    }
}
//
//class Citizen {
//    private String name;
//
//    public Citizen(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Citizen{" +
//                "name='" + name + '\'' +
//                '}';
//    }
//}
//
//class City{
//    private String name;
//    private ArrayList<Citizen> citizens = new ArrayList<>();
//
//    public City(String name) {
//        this.name = name;
//    }
//
//    void addCitizen(Citizen citizen){
//        citizens.add(citizen);
//    }
//
//    @Override
//    public String toString() {
//        return "City{" +
//                "name='" + name + '\'' +
//                ", citizens=" + citizens +
//                '}';
//    }
//}
//
//class Region{
//    private String name;
//    private ArrayList<City> cities = new ArrayList<>();
//
//    public Region(String name) {
//        this.name = name;
//    }
//
//    void addCity(City city){
//        cities.add(city);
//    }
//
//    @Override
//    public String toString() {
//        return "Region{" +
//                "name='" + name + '\'' +
//                ", cities=" + cities +
//                '}';
//    }
//}
//
//class Republic{
//    private String name;
//    private ArrayList<Region> regions = new ArrayList<>();
//
//    public Republic(String name) {
//        this.name = name;
//    }
//
//    void addRegion(Region region){
//        regions.add(region);
//    }
//
//    @Override
//    public String toString() {
//        return "Republic{" +
//                "name='" + name + '\'' +
//                ", regions=" + regions +
//                '}';
//    }
//}

// citizen
// city
// region
// republic
