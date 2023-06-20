/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package br.com.haanunes.bancosangue.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 *
 * @author Hélder
 */
public record DoadorRecordDTO(@NotBlank String nome, @NotBlank String cpf, @NotBlank String rg, 
         LocalDate data_nasc, @NotBlank String sexo, @NotBlank String mae, @NotBlank String pai, 
        @NotBlank String email, @NotBlank String cep, @NotBlank String endereco, int numero, 
        @NotBlank String bairro, @NotBlank String cidade, @NotBlank String estado, 
        @NotBlank String telefone_fixo, @NotBlank String celular, double altura, 
         double peso, @NotBlank String tipo_sanguineo) {

}
