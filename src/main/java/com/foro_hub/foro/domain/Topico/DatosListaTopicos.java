package com.foro_hub.foro.domain.Topico;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosListaTopicos(
        @NotNull
        @JsonAlias("id") Long id,
        @NotBlank
        @JsonAlias("titulo") String titulo,
        @NotBlank
        @JsonAlias("Mensaje") String mensaje,
        @NotBlank
        @JsonAlias("status") Estado status
) {

    public DatosListaTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getStatus());
    }

}
