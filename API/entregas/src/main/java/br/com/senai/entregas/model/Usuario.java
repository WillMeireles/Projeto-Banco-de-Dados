package br.com.senai.entregas.model;


import jakarta.persistence.*;
import lombok.*;

public class Usuario {

    @Getter
    @Setter

// Obrigatorio para o JPA funcionar
    @NoArgsConstructor
    @AllArgsConstructor


// JPA
// Entity - Informa que essa classe e uma tabela
    @Entity
// Table - Permite que voce configure a tabela
    @Table(name = "tipo_usuario")


    public class usuario {


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








    }
}
