package Exercise2;

public class Teacher extends Person {
    private int numCourses;
    private String[] courses;
    private static final int MAX_COURSES = 5;

    // Constructor
    Teacher(String name, String address){
        super(name, address);
        numCourses = 0;
        courses = new String[MAX_COURSES];
    }

    public String toString(){
        return "name" + name + "address" + address;
    }

    public boolean addCourse(String course){
        boolean a = true;
        for(int i = 0; i < courses.length; i++){
            if(courses[i] == course){
                a = false;
            }
            if(a){
                courses[numCourses] = course;
                numCourses ++;
            }
        }
        return a;
    }

    public boolean removeCourse(String course){
        boolean a = true;
        for(int i = 0; i < courses.length; i++){
            if(courses[i] == course){
                courses[i] = null;
                a = true;
            } else {
                a = false;
            }
        }
        return a;
    }
}
