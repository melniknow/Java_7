import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    String name;
    String lastName;
    String patronymic;

    @JsonCreator
    public Person(@JsonProperty(value = "name") String name, @JsonProperty(value = "lastName") String lastName, @JsonProperty(value = "patronymic") String patronymic) {
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(lastName, person.lastName) && Objects.equals(patronymic, person.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, patronymic);
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", patronymic='" + patronymic + '\'' +
            '}';
    }
}
