package com.jedi.jedi.dto;

import com.jedi.jedi.domain.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {}