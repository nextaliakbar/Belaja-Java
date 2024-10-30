package programmer.zaman.now.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    public Customer(String id, String name, String primaryEmail, Byte age, Boolean merried) {
        this.id = id;
        this.name = name;
        this.primaryEmail = primaryEmail;
        this.age = age;
        this.merried = merried;
    }

    public Customer() {

    }

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "primary_email")
    private String primaryEmail;

    private Byte age;

    private Boolean merried;

    @Transient
    private String fullName;

    @Enumerated(EnumType.STRING)
    private CustomerType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Boolean getMerried() {
        return merried;
    }

    public void setMerried(Boolean merried) {
        this.merried = merried;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
