package homework6.entities;


import javax.persistence.*;

@Entity
@Table(name = "animal_db")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    @Column(name = "col_age")
    int age;
    boolean tail;
    @ManyToOne
    @JoinColumn(name = "vetId")
    Vet vet;
    @ManyToOne
    @JoinColumn(name = "aviaryId")
    Aviary aviary;

    public Animal() {
    }

    public Animal(int age, String name) {
        this.name = name;
        this.age = age;
        this.tail = true;
    }

    public Animal(String name, int age, boolean tail) {
        this.name = name;
        this.age = age;
        this.tail = tail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setTail(boolean tail) {
        this.tail = tail;
    }


    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Aviary getAviary() {
        return aviary;
    }

    public void setAviary(Aviary aviary) {
        this.aviary = aviary;
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
