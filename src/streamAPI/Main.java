package streamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Student> students = getStudent();

//        ArrayList<Student> studentArrayList = new ArrayList<>();
//
//        Collections.addAll(studentArrayList, new Student("Erlan", 3.2, Group.SIS2012), new Student("Islam", 3.0, Group.SIS2011));
//
//
//        studentArrayList.sort(new SortByGpa());
//        System.out.println(studentArrayList);
//        students.forEach(System.out::println);
        // filter
//        List<Student> collect = students.stream()
//                .filter(student -> student.getGpa() > 3.1 && student.getGroup().equals(Group.SIS2010))
//                .collect(Collectors.toList());
//
//        collect.forEach(System.out::println);
//        // takeWhile

//        students.stream()
//                .takeWhile(student -> student.getGpa() < 3.4)
//                .forEach(System.out::println);
        // dropWhile
//        students.stream()
//                .dropWhile(student -> student.getGpa() < 3.4)
//                .forEach(System.out::println);
        // distinct
//        students.stream()
//                .distinct()
//                .forEach(System.out::println);
        // concat

//        Stream<Student> std = Stream.of(new Student("Diana", 3.3, Group.SIS2012));
//        Stream<Student> std2 = Stream.of(new Student("Diana2", 3.2, Group.SIS2012));
//
//
//        List<Student> collect = Stream.concat(std, std2).collect(Collectors.toList());
//
//        collect.stream()
//        .sorted(Comparator.comparing(Student::getGpa))
//                .forEach(System.out::println);
        // max
//        students.stream()
//                .distinct()
//                .max(Comparator.comparing(Student::getGpa))
//                .ifPresent(System.out::println);
        // min

//        students.stream()
//                .min(Comparator.comparing(Student::getGpa))
//                .ifPresent(System.out::println);
        // sorted
//        students.stream()
//                .sorted(Comparator.comparing(Student::getGpa))
//                .forEach(System.out::println);
        // group

        Map<Group, List<Student>> collect = students.stream()
                .collect(Collectors.groupingBy(Student::getGroup));

        collect.forEach((group, students1) -> {
            System.out.println(group);
            students1.forEach(System.out::println);
            System.out.println("------");
        });

    }

    private static List<Student> getStudent(){
        return List.of(
                new Student("Erlan", 3.1, Group.SIS2011),
                new Student("Erlan", 3.1, Group.SIS2011),
                new Student("Erlan", 3.1, Group.SIS2011),
                new Student("Arman", 3.0, Group.SIS2011),
                new Student("Usman", 3.2, Group.SIS2010),
                new Student("Usman", 3.2, Group.SIS2010),
                new Student("Usman", 3.2, Group.SIS2010),
                new Student("Beka", 3.4, Group.SIS2010),
                new Student("Danik", 3.6, Group.SIS2011),
                new Student("Danik", 3.6, Group.SIS2011),
                new Student("Danik", 3.6, Group.SIS2011),
                new Student("Meir", 3.0, Group.SIS2012)
        );

    }
}

enum Group{
    SIS2010, SIS2011, SIS2012;
}

class SortByGpa implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getGpa() == o2.getGpa())
            return 0;
        else if (o1.getGpa() > o2.getGpa())
            return 1;
        return -1;
    }
}

class Student{
    private String name;
    private double gpa;
    private Group group;

    public Student(String name, double gpa, Group group) {
        this.name = name;
        this.gpa = gpa;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.gpa, gpa) == 0 && Objects.equals(name, student.name) && group == student.group;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gpa, group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                ", group=" + group +
                '}';
    }
}
