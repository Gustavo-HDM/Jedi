package com.jedi.jedi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JediRequestDTO(@NotNull @NotBlank String name, String race, Integer powerLevel, Long idLightSaber, Long idPlanet) {}