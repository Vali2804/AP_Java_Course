package Lab4;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lab4 {
    public static void main(String[] args) {
        Lab4 lab4 = new Lab4();
        lab4.compulsory();
        lab4.homework();
    }

    void compulsory() {
        System.out.println("compulsory ***************");
        var streamProjects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[]::new);
        var streamStudents = IntStream.rangeClosed(0, 2)
                .mapToObj(i ->
                {
                    if (i == 0) {
                        return new Student("S" + i, List.of(streamProjects));
                    } else {
                        if (i == 1) {
                            return new Student("S" + i, List.of(streamProjects[0], streamProjects[1]));
                        } else {
                            return new Student("S" + i, List.of(streamProjects[0]));
                        }
                    }
                })
                .toArray(Student[]::new);

        LinkedList<Student> linkedStudents = new LinkedList<>(Arrays.asList(streamStudents));
        linkedStudents.sort(Comparator.comparing(Student::getName));
        linkedStudents.forEach(student ->
                System.out.println(student.getName()));

        TreeSet<Project> treeProjects = new TreeSet<>(Arrays.asList(streamProjects));
        treeProjects.forEach(project ->
                System.out.println(project.getName()));

    }

    void homework() {
        System.out.println("homework ***********");
        Faker faker = new Faker();
        var streamProjects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project(faker.app().name()))
                .toArray(Project[]::new);
        var streamStudents = IntStream.rangeClosed(0, 2)
                .mapToObj(i ->
                {
                    if (i == 0) {
                        return new Student(faker.name().fullName(), List.of(streamProjects));
                    } else {
                        if (i == 1) {
                            return new Student(faker.name().fullName(), List.of(streamProjects[0], streamProjects[1]));
                        } else {
                            return new Student(faker.name().fullName(), List.of(streamProjects[0]));
                        }
                    }
                })
                .toArray(Student[]::new);

        LinkedList<Student> linkedStudents = new LinkedList<>(Arrays.asList(streamStudents));
        System.out.println();
        System.out.println("students before sorting");
        linkedStudents.forEach(student ->
                System.out.println(student.getName()));
        linkedStudents.sort(Comparator.comparing(Student::getName));
        System.out.println();
        System.out.println("students after sorting");
        linkedStudents.forEach(student ->
                System.out.println(student.getName()));

        TreeSet<Project> treeProjects = new TreeSet<>(Arrays.asList(streamProjects));
        System.out.println();
        System.out.println("projects:");
        treeProjects.forEach(project ->
                System.out.println(project.getName()));

        //query ??

        //rezolvare pb cu greedy.
        Problem p1 = new Problem(linkedStudents, treeProjects);
        System.out.println(p1.Greedy());
    }
}