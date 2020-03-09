package Exercise2;

public class Teacher extends Person {
    private int numCourses = 0;
    private String[] courses = {"PFI","MMA","ID","P2"};

    Teacher(String name, String address){
        super(name, address);
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
