package com.robertoljr.devsuperior_desafio_projeto_spring_boot_estruturado.projection;

public interface UserDetailsProjection {
    String getUsername();
    String getPassword();
    Long getRoleId();
    String getAuthority();
}
