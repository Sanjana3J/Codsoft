import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student 
{
    String name;
    int rollNumber;
    String grade;

    public Student(String name, int rollNumber, String grade) 
    {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() 
    {
        return name;
    }

    public int getRollNumber() 
    {
        return rollNumber;
    }

    public String getGrade() 
    {
        return grade;
    }

    public String toString() 
    {
        return name + " " + rollNumber + " " + grade;
    }
}

class StudentManagementSystem extends Student
{
    List<Student> studentList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    static String name;
    static int rollNumber;
    static String grade;
    StudentManagementSystem() 
    {
        super(name,rollNumber,grade);
    }

    public void addStudent(Student student) 
    {
        studentList.add(student);
    }

    public void removeStudent(Student student) 
    {
        studentList.remove(student);
    }

    public Student searchStudent(int rollNumber) 
    {
        for (Student student : studentList) 
        {
            if (student.getRollNumber() == rollNumber) 
            {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() 
    {
        for (Student student : studentList) 
        {
            System.out.println(student);
        }
    }

    public void addNewStudent() 
    {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student roll number: ");
        int rollNumber = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter student grade: ");
        String grade = sc.nextLine();

        Student newStudent = new Student(name, rollNumber, grade);
        addStudent(newStudent);
        System.out.println("Student added successfully.");
    }

    public void removeExistingStudent() 
    {
        System.out.print("Enter roll number of student to remove: ");
        int rollNumber = sc.nextInt();
        Student studentToRemove = searchStudent(rollNumber);
        if (studentToRemove != null) 
        {
            removeStudent(studentToRemove);
            System.out.println("Student removed successfully.");
        } 
        else 
        {
            System.out.println("Student not found.");
        }
    }

    public void searchForStudent() 
    {
        System.out.print("Enter roll number of student to search: ");
        int rollNumber = sc.nextInt();
        Student foundStudent = searchStudent(rollNumber);
        if (foundStudent != null) 
        {
            System.out.println("Student found:");
            System.out.println(foundStudent);
        } 
        else 
        {
            System.out.println("Student not found.");
        }
    }
}

public class StudentManagement
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while(true)
        {
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Search student");
            System.out.println("4. Display all students");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            switch (ch) 
            {
                case 1: system.addNewStudent();
                        break;
                    
                case 2: system.removeExistingStudent();
                        break;
                    
                case 3: system.searchForStudent();
                        break;
                    
                case 4: system.displayAllStudents();
                        break;
                    
                default: System.out.println("Invalid choice.");
                         System.exit(0);
            }
        } 
    }
}