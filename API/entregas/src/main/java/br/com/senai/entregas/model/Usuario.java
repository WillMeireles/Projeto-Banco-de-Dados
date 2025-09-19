package br.com.senai.entregas.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Getter
    @Setter

// Obrigatorio para o JPA funcionar
    @NoArgsConstructor
    @AllArgsConstructor


// JPA
// Entity - Informa que essa classe e uma tabela
    @Entity
// Table - Permite que voce configure a tabela
    @Table(name = "usuario")



    public class Usuario implements UserDetails {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "usuario", nullable = false)
        private Integer usuarioId;


        @Column(name = "nome_completo", nullable = false)
        private String nomeCompleto;

        @Column(name = "email", nullable = false,  unique = true)
        private String email;


        @Column(name = "senha", nullable = false)
        private String senha;


        // Muitos USUARIOS para um TIPO USUARIO
        // FetchType.EAGER - Carrega os dados juntos
        // Optional - Se e obrigatorio ou nao
        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        // Avisar para o Java, qual coluna do tipo usuario que vou relacionar
        @JoinColumn(name = "tipo_usuario_id")
        private TipoUsuario tipoUsuario;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(tipoUsuario.getDescricao()));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

