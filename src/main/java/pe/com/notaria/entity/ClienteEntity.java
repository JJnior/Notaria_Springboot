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
@Entity(name = "ClienteEntity")
@Table(name = "t_clientes")
public class ClienteEntity extends BaseEntity implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name = "codcli")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nomcli")
    @NotEmpty
    @Size (min=8, max=20, message = "El nombre del cliente tiene que estar entre {min} y {max}")
    private String nombreUsua;
    @Column(name = "apecli")
    @NotEmpty
    @Size (min=8, max=40, message = "El apellido del cliente tiene que estar entre {min} y {max}")
    private String apellidoUsua;
    @Column(name = "dnicli")
    @NotEmpty
    @Size (min=8, max=20, message = "El DNI del cliente tiene que estar entre {min} y {max}")
    private String dniUsua;
    @Column(name = "telcli")
    @NotEmpty
    @Size (min=9, max=20, message = "El telefono del cliente tiene que estar entre {min} y {max}")
    private String telefonoUsua;
}
