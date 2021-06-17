package homework3;


import javax.persistence.*;

@Entity
@Table(name = "someanimal")
public class Animal {
    @Id
    @GeneratedValue
    int id;
    String name;
    @Column(name = "someName")
    int age;
    boolean tail;
    @Transient
    int num = 11;

    public Animal() {
    }

    public Animal(String name, int age, boolean tail) {
        this.name = name;
        this.age = age;
        this.tail = tail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isTail() {
        return tail;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setTail(boolean tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", tail=" + tail +
                '}';
    }
}
