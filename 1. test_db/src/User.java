public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String city;
    private Integer height;
    private Integer weight;

    public User(Long id, String firstName, String lastName, Integer age, String city, Integer height, Integer weight) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
        this.height = height;
        this.weight = weight;
    }

    public User(String firstName, String lastName, Integer age, String city, Integer height, Integer weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
        this.height = height;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                "}";
    }
}
