package com.jedi.jedi.dto;

import com.jedi.jedi.domain.LightSaber;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JediRequestDTO(@NotNull @NotBlank String name, String race, Integer powerLevel, Long idLightSaber, Long idPlanet) {}