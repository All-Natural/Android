package dongyiying;

import java.util.Date;

public class Student implements Comparable<Student> {

    @Override
    public int compareTo(Student o) {

        return this.id - o.id;
    }

    private int id;
    private String name;
    private Date brithday;
    private String sex;

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {

        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        Student s = (Student) obj;
        return this.id == s.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    //
    public String toString() {

        return "学号:" + id + "\t姓名 :" + name + "\t性别:" + sex + "\t\t生日:" + brithday;
    }

    public Integer getId() {
        return id;
    }
}