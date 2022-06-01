package com.apprest.entities;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Devocional implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Campo Titulo Devocional é de preencimento obrigatório.")
    @NotBlank(message = "Campo Titulo Devocional é de preencimento obrigatório.")
    @Column(name = "nm_titulo_Devocional")
    private String tituloDevocional;

    @NotNull(message = "Campo Texto Versiculo é de preencimento obrigatório.")
    @NotBlank(message = "Campo Titulo Devocional é de preencimento obrigatório.")
    @Column(name = "ds_texto_Versiculo")
    private String textoVersiculo;

    @NotNull(message = "Campo Texto Devocional é de preencimento obrigatório.")
    @NotBlank(message = "Campo Titulo Devocional é de preencimento obrigatório.")
    @Column(name = "ds_texto_Devocional")
    private String textoDevocional;

    @NotNull(message = "Campo Texto Oracao é de preencimento obrigatório.")
    @NotBlank(message = "Campo Titulo Devocional é de preencimento obrigatório.")
    @Column(name = "ds_texto_Oracao")
    private String textoOracao;

    @NotNull(message = "Campo Data da Postagem é de preencimento obrigatório.")
    @NotBlank(message = "Campo Titulo Devocional é de preencimento obrigatório.")
    @Column(name = "dt_data_Postagem")
    @Temporal(value=TemporalType.DATE)
    private Date dataPostagem;

    @NotNull(message = "Campo Hora da Postagem é de preencimento obrigatório.")
    @NotBlank(message = "Campo Titulo Devocional é de preencimento obrigatório.")
    @Column(name = "dt_hora_Postagem")
    private String horaPostagem;
    
}