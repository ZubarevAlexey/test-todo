package kg.java.testtodo.core.models.entity;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "priority", schema = "test3", catalog = "postgres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Builder(toBuilder = true)
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String color;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id", nullable = false)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Priority priority = (Priority) o;
        return Objects.equals(id, priority.id) && Objects.equals(name, priority.name) && Objects.equals(color, priority.color) && Objects.equals(user, priority.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color, user);
    }

    @Override
    public String toString() {
        return name;
    }
}
