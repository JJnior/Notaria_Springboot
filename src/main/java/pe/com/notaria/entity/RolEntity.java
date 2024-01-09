package pe.com.notaria.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pe.com.notaria.entity.base.BaseEntity;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "RolEntity")
@Table(name = "t_rol")
public class RolEntity extends BaseEntity implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "codrol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nomrol")
    @NotEmpty
    @Size (min=5, max=40, message = "El nombre de la categoria tiene que estar entre {min} y {max}")
    private String nombre;
}
