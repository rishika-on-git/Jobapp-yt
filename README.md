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
>

## API Design Decision: Updating Jobs and Company Relationships

A `Job` belongs to exactly one `Company`, while a `Company` can have multiple `Jobs`. This relationship is modeled using:

```java
@OneToMany(mappedBy = "company")
private List<Job> jobs;
```

in `Company`, and

```java
@ManyToOne
private Company company;
```

in `Job`.

### Update Strategy

Instead of updating a company's job list through the Company API, jobs are managed through the Job API.

When updating a job (`PUT /jobs/{id}`), the request contains both the job details and the target company identifier:

```json
{
  "title": "Senior SDE",
  "description": "Java Backend Developer",
  "minSalary": 20,
  "maxSalary": 40,
  "location": "Noida",
  "companyId": 2
}
```

The service performs the following steps:

1. Fetch the existing job.
2. Validate that the job exists.
3. Fetch the company specified by `companyId`.
4. Validate that the company exists.
5. Update the job fields.
6. Update the company association using `job.setCompany(company)`.
7. Save the updated job.

### Why This Approach?

This design keeps responsibilities separated:

* The **Company API** manages company information (name, description, etc.).
* The **Job API** manages job information and company associations.

As a result, changing a job's company is performed by updating the job itself rather than modifying the company's entire job collection. This keeps the API simpler, avoids accidental updates to multiple jobs, and aligns with the ownership of the relationship (`@ManyToOne` side).
