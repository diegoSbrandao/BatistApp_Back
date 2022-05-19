package com.apprest.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Campo nome é de preencimento obrigatório.")
    @NotBlank(message = "Campo nome é de preencimento obrigatório.")
    @Column(name = "nm_evento")
    private String nome;

    @NotNull(message = "Campo local é de preencimento obrigatório.")
    @NotBlank(message = "Campo nome é de preencimento obrigatório.")
    @Column(name = "nm_local")
    private String local;

    @NotNull(message = "Campo data é de preencimento obrigatório.")
    @NotBlank(message = "Campo nome é de preencimento obrigatório.")
    @Column(name = "dt_data_evento")
    private String data;

    @NotNull(message = "Campo horario é de preencimento obrigatório.")
    @NotBlank(message = "Campo nome é de preencimento obrigatório.")
    @Column(name = "ds_horario_evento")
    private String horario;

}
