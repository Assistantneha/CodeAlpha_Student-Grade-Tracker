import java.util.Scanner;
public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        String[] names = new String[n];
        int[] marks = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            names[i] = sc.next();
            System.out.print("Enter marks of " + names[i] + ": ");
            marks[i] = sc.nextInt();
        }
        int sum = 0;
        int highest = marks[0], lowest = marks[0];
        String topStudent = names[0], lowStudent = names[0];

        for (int i = 0; i < n; i++) {
            sum += marks[i];
            if (marks[i] > highest) {
                highest = marks[i];
                topStudent = names[i];
            }
            if (marks[i] < lowest) {
                lowest = marks[i];
                lowStudent = names[i];
            }
        }
        double average = (double) sum / n;
        System.out.println("\n--- Student Report ---");
        System.out.println("Average Marks = " + average);
        System.out.println("Highest Marks = " + highest + " (by " + topStudent + ")");
        System.out.println("Lowest Marks = " + lowest + " (by " + lowStudent + ")");
    }
}
