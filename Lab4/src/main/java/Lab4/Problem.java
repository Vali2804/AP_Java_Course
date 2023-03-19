package Lab4;

import java.util.*;

public class Problem {
    private List<Student> students;
    private Set<Project> projects;

    public Problem(List<Student> students, Set<Project> projects) {
        this.students = students;
        this.projects = projects;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public Set<Map.Entry<Student, Project>> Greedy() {

        Set<Map.Entry<Student, Project>> matching = new HashSet<>();

        // Creez o 'map-are'  a proiectelor în funcție de disponibilitatea acestora
        Map<Project, Integer> availability = new HashMap<>();
        projects.forEach(p -> availability.put(p, 1));

        // Sortez studentii după numărul descrescător de proiecte admisibile
        students.sort(Comparator.comparingInt(s -> -s.getAdmissibleProjects().size()));

        // Pentru fiecare student, atribui primul proiect disponibil din lista lor, abordare Greedy
        for (Student student : students) {
            for (Project project : student.getAdmissibleProjects()) {
                if (availability.getOrDefault(project, 0) > 0) {
                    matching.add(new AbstractMap.SimpleEntry<>(student, project));
                    availability.put(project, availability.get(project) - 1);
                    break;
                }
            }
        }
        return matching;
    }
}
