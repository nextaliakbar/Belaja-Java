package programmer.zaman.now.jpa.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import programmer.zaman.now.jpa.embeddable.DepartementId;

@Entity
@Table(name = "departements")
public class Departement {

    public Departement() {
    }

    @EmbeddedId
    private DepartementId departementId;

    private String name;

    public DepartementId getDepartementId() {
        return departementId;
    }

    public void setDepartementId(DepartementId departementId) {
        this.departementId = departementId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
