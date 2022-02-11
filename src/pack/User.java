package pack;

import java.io.Serializable;

public class User implements Serializable {
//    public static final long serialVersionUID = 7131745169394219991L;
    public static enum Gender{
        FEMALE,
        MALE,
        OTHER,
    }
    private String name;
    private int age;
    private boolean activated;
    /*transient*/ private Gender gender;
    private String login;

    public User() {
    }

    public User(String name, int age, boolean activated, Gender gender) {
        this.name = name;
        this.age = age;
        this.activated = activated;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", activated=" + activated +
                ", gender=" + gender +
                '}';
    }
}
