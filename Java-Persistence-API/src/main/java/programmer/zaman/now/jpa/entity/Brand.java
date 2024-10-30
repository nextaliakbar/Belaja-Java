package programmer.zaman.now.jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "brands")
@NamedQueries({
        @NamedQuery(name = "Brand.findAll", query = "SELECT b FROM Brand b"),
        @NamedQuery(name = "Brand.findAllByName", query = "SELECT b FROM Brand b WHERE b.name =: name")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "Brand.native.findAll", query = "SELECT * FROM brands", resultClass = Brand.class)
})
public class Brand extends AuditableEntity<String>{

    private String name;

    private String description;

    @OneToMany(mappedBy = "brands")
    private List<Product> products;

    @Version
    private Long version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
