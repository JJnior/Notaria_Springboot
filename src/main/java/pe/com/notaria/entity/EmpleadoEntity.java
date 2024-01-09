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
@Entity(name = "EmpleadoEntity")
@Table(name = "t_empleados")
public class EmpleadoEntity extends BaseEntity implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "codemp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nomemp")
    @NotEmpty
    @Size (min=8, max=20, message = "El nombre del empleado tiene que estar entre {min} y {max}")
    private String nombreEmpl;
    @Column(name = "apeemp")
    @NotEmpty
    @Size (min=8, max=40, message = "El apellido del empleado tiene que estar entre {min} y {max}")
    private String apellidoEmpl;
    @Column(name = "dniemp")
    @NotEmpty
    @Size (min=8, max=20, message = "El DNI del empleado tiene que estar entre {min} y {max}")
    private String dniEmpl;
    @Column(name = "telemp")
    @NotEmpty
    @Size (min=8, max=20, message = "El telefono del empleado tiene que estar entre {min} y {max}")
    private String telefonoEmpl;
    @ManyToOne
    @JoinColumn(name = "codrol",nullable = false)
    private RolEntity rol;
}
