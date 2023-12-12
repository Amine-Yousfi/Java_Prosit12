    package levels;

    import models.Teacher;
    import utils.Data;

    import java.util.List;
    import java.util.Comparator;

    public class Level1 {

        public static void main(String[] args) {
            List<Teacher> employees = Data.employees();

            /*
             * TO DO 1: Afficher tous les enseignants
             */
            employees.forEach(System.out::println);

            /*
             * TO DO 2: Afficher les enseignants dont le nom commence par la lettre n
             */
            employees
                    .stream()
                    .filter(teacher -> teacher.getName().startsWith("n"))
                    .forEach(System.out::println);

            /*
             * TO DO 3: Afficher les enseignants dont le nom commence par la lettre n et le salaire > 100000
             */
            employees.stream()
                    .filter(teacher -> teacher.getName().startsWith("n"))
                    .filter(teacher -> teacher.getSalary() > 100000)
                    .forEach(System.out::println);

            /*
             * TO DO 4: Afficher les enseignants JAVA triés par salaire (éliminer les redondances)
             */
            employees.stream()
                    .filter(teacher -> teacher.getSubject().equals("JAVA"))
                    .sorted(Comparator.comparingDouble(Teacher::getSalary).thenComparing(Teacher::getName))
                    .distinct()
                    .forEach(System.out::println);

            /*
             * TO DO 5: Afficher les noms des enseignants dont le salaire > 60000 avec 2 manières différentes
             */

            /* First Way */
            employees.stream()
                    .filter(teacher -> teacher.getSalary() > 60000)
                    .forEach(teacher -> System.out.println(teacher.getName()));

            /* Second Way */
            employees.stream()
                    .filter(teacher -> teacher.getSalary() > 60000)
                    .map(Teacher::getName)
                    .forEach(System.out::println);

            /*
             * TO DO 6:  Ajouter 200 Dt pour les enseignants dont le nom commence par m et afficher celui qui a le salaire le plus élevé
             */
            Teacher maxSalaryTeacher = employees.stream()
                    .filter(teacher -> teacher.getName().startsWith("m"))
                    .peek(teacher -> teacher.setSalary(teacher.getSalary() + 200))
                    .max(Comparator.comparingDouble(Teacher::getSalary))
                    .orElse(null);

            System.out.println("Teacher with the highest salary after the increase: " + maxSalaryTeacher);
        }
    }
