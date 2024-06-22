package com.foro_hub.foro.Topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private Date fechaCreacion;
    private Boolean activo;
    @Enumerated(EnumType.STRING)
    private Estado status;
    private Integer autor;
    private Integer curso;

    public Topico(DatosRegistroTopico datos) {
        this.autor = datos.autor();
        this.curso = datos.curso();
        this.fechaCreacion = datos.fechaCreacion();
        this.mensaje = datos.mensaje();
        this.status = datos.status();
        this.titulo = datos.titulo();
        this.activo = true;
    }

    public void actualizarDatos(DatosActualizaTopico datos) {
        if (datos.mensaje() != null){
            this.mensaje = datos.mensaje();
        }
        if (datos.status() != null){
            this.status = datos.status();
        }
        if (datos.titulo() != null){
            this.titulo = datos.titulo();
        }
    }

    public void desactivarTopico() {
        this.activo = false;
    }
}
