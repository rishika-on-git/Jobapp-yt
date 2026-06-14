## Ques 1 - "Why is a default constructor required in a JPA Entity?"

JPA needs a **default (no-argument) constructor** so it can create entity objects automatically when reading data from the database.

### Example

```java
@Entity
public class Job {

    private Long id;
    private String title;

    public Job() { }   // Default constructor

    public Job(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
```

When JPA fetches a row:

```text
Database Row
(id=1, title="Developer")
```

it does something like:

```java
Job job = new Job();   // uses default constructor
job.setId(1L);
job.setTitle("Developer");
```

Without a default constructor, JPA wouldn't know how to create the object first.

### Interview Answer

> JPA requires a no-argument constructor because it creates entity objects using reflection when loading data from the database. After creating the object, it populates the fields with the retrieved values.