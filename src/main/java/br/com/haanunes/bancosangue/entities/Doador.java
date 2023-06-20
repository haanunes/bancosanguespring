/*
 * Click nbfs;//nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs;//nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haanunes.bancosangue.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Hélder
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Doador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    private LocalDate data_nasc;
    private String sexo;
    private String mae;
    private String pai;
    private String email;
    private String cep;
    private String endereco;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone_fixo;
    private String celular;
    private double altura;
    private double peso;
    private String tipo_sanguineo;
}
