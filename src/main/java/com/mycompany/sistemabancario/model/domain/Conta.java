package com.mycompany.sistemabancario.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contas")
@EqualsAndHashCode(of = "id")
public class Conta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private Tipo tipo;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @OneToOne(mappedBy = "contas")
    private ContaCorrente contaCorrente;
    
    @OneToOne(mappedBy = "contas")
    private ContaPoupanca contaPoupanca;
    
    @ManyToOne
    @JoinColumn(name = "id_agencia")
    private Agencia agencia;
    
    @OneToMany(mappedBy = "contas")
    private Set<Emprestimo> emprestimos = new HashSet<>();
    
    @OneToMany(mappedBy = "contas")
    private Set<Transferencia> transferencias = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "id_gerente")
    private Gerente gerente;
    
}
