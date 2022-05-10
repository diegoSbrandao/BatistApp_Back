package com.apprest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Devocional implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Campo Titulo Devocional é de preencimento obrigatório.")
    @Column(name = "nm_titulodevocional")
    private String tituloDevocional;

    @NotNull(message = "Campo Texto Versiculo é de preencimento obrigatório.")
    @Column(name = "ds_textoversiculo")
    private String textoVersiculo;

    @NotNull(message = "Campo Texto Devocional é de preencimento obrigatório.")
    @Column(name = "ds_textodevocional")
    private String textoDevocional;

    @NotNull(message = "Campo Texto Oracao é de preencimento obrigatório.")
    @Column(name = "ds_textooracao")
    private String textoOracao;

    @NotNull(message = "Campo Data da Postagem é de preencimento obrigatório.")
    @Column(name = "dt_dataPostagem")
    private String dataPostagem;

    @NotNull(message = "Campo Hora da Postagem é de preencimento obrigatório.")
    @Column(name = "dt_horaPostagem")
    private String horaPostagem;

}