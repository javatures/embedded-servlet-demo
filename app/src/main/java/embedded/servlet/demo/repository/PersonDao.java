package embedded.servlet.demo.repository;

import java.util.ArrayList;
import java.util.List;

import embedded.servlet.demo.model.People;

public class PersonDao {
    private List<People> db;

    public PersonDao() {
        db = new ArrayList<>();
        db.add(new People(1, "Bob"));
        db.add(new People(2, "Sam"));
    }

    public List<People> getAll() {
        return db;
    }

    public People getPerson(int id) {
        for (People people : db) {
            if (people.getId() == id)
                return people;
        }
        return null;
    }
}
