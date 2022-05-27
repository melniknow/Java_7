import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Flat implements Serializable {
    int number;
    double square;
    ArrayList<Person> personList;

    public Flat(@JsonProperty(value = "number") int number, @JsonProperty(value = "square") double square, @JsonProperty(value = "name") ArrayList<Person> personList) {
        this.number = number;
        this.square = square;
        this.personList = personList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return number == flat.number && Double.compare(flat.square, square) == 0 && Objects.equals(personList, flat.personList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, square, personList);
    }

    @Override
    public String toString() {
        return "Flat{" +
            "number=" + number +
            ", square=" + square +
            ", personList=" + personList +
            '}';
    }
}
