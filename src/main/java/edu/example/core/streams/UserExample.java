package edu.example.core.streams;

public class UserExample {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private boolean hasWork;

    public UserExample() {
    }

    public UserExample(Long id, String name, String email, Integer age, boolean hasWork) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.hasWork = hasWork;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isHasWork() {
        return hasWork;
    }

    public void setHasWork(boolean hasWork) {
        this.hasWork = hasWork;
    }

    @Override
    public String toString() {
        return "UserExamle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", hasWork=" + hasWork +
                '}';
    }
}
