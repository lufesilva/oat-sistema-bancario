package com.mycompany.sistemabancario.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contas_corrente")
public class ContaCorrente extends Conta implements Serializable {

    private Double valor;
    private Double limite;
    private String numero;
    
    @OneToOne
    @JoinColumn(name = "id_conta")
    private Conta conta;
}
