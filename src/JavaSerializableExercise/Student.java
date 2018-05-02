package JavaSerializableExercise;

import java.io.Serializable;

/**
 * @author: linyijin
 * @Date: Created in 2018/1/3 18:09
 * @Description:
 **/
public class Student implements Serializable {
    private String name;
    private char Sex;
    private int year;
    private double gpa;

    public Student() {

    }

    public Student(String name, char sex, int year, double gpa) {
        this.name = name;
        Sex = sex;
        this.year = year;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return Sex;
    }

    public void setSex(char sex) {
        Sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
