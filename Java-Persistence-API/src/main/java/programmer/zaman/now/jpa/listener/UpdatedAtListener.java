package programmer.zaman.now.jpa.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import programmer.zaman.now.jpa.entity.UpdatedAtAware;

import java.time.LocalDateTime;

public class UpdatedAtListener {

    @PrePersist
    @PreUpdate
    public void setLastUpdatedAt(UpdatedAtAware updatedAtAware) {
        updatedAtAware.setUpdatedAt(LocalDateTime.now());
    }
}
