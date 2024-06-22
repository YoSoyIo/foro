package com.foro_hub.foro.Topico;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizaTopico(
        @NotNull
        @JsonAlias("id") Long id,
        @JsonAlias("titulo") String titulo,
        @JsonAlias("Mensaje") String mensaje,
        @JsonAlias("status") Estado status
) {

    /**public DatosListaTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getStatus());
    }**/
}
