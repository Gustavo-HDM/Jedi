package com.jedi.jedi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JediRequestDTO(String name, String race, Integer powerLevel, Long idLightSaber, Long idPlanet) {}