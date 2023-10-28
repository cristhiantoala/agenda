package dagatecompany.agenda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class Contacto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "idcontacto")
        private Integer id;

        @NotBlank(message = "Este campo es obligatorio")
        @Column(name = "nombres")
        private String nombre;

        @PastOrPresent(message = "Debe ser una fecha en el pasado")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @Column(name = "fecha_nacimiento")
        private LocalDate fechaNacimiento;

        @Size(max = 15, message = "Debe ser un correo valido")
        private String celular;

        @Email(message = "Debe ser un correo valido")
        @Column(name = "correo")
        private String email;

        @Column(name = "fecha_registro")
        private LocalDateTime fechaRegistro;
}
