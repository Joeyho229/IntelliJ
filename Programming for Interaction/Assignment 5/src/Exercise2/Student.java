package Exercise2;

public class Student extends Person {
    final static int MAX_COURSES = 4;
    private int numCourses = 0;
    private String[] courses = {"PFI", "MMA","ID","P2"};
    private int[] grades = new int [MAX_COURSES];

    public Student(String name, String address){
        super(name, address);
    }

    public String toString(){
        return "name" + name + "address" + address;
    }

    void addCourseGrade(String course, int grade){
        for(int i = 0; i < courses.length; i++){
            if(courses[i] == course) {
                grades[i] = grade;
            }
        }
    }

    void printGrades(){
        System.out.println("grades:" + grades);
    }

    double getAverageGrade(){
        int a = 0;
        for(int i = 0; i < grades.length; i++){
            a = a + grades[i];
        }
        return a / grades.length;
    }
}
