package com.foro_hub.foro.Topico;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DatosRegistroTopico(
        @NotBlank
        @JsonAlias("titulo") String titulo,
        @NotBlank
        @JsonAlias("Mensaje") String mensaje,
        @NotNull
        @JsonAlias("fechaCreacion") Date fechaCreacion,
        @NotBlank
        @JsonAlias("status") Estado status,
        @NotNull
        @JsonAlias("autor") Integer autor,
        @NotNull
        @JsonAlias("curso") Integer curso) {
}
