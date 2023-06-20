/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haanunes.bancosangue.controllers;

import br.com.haanunes.bancosangue.dtos.DoadorInterfaceImcMedioPorFaixaDeIdade;
import br.com.haanunes.bancosangue.dtos.DoadorInterfaceMediaIdadeGrupoSanguineo;
import br.com.haanunes.bancosangue.dtos.DoadorInterfacePercentualObesosPorSexo;
import br.com.haanunes.bancosangue.dtos.DoadorRecordDTO;
import br.com.haanunes.bancosangue.entities.Doador;
import br.com.haanunes.bancosangue.dtos.DoadorInterfacePorEstado;
import br.com.haanunes.bancosangue.repositories.DoadorRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hélder
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200/") 
public class DoadorController {
    @Autowired
    DoadorRepository doadorRepository;
    
    @PostMapping("/doadores")
    public ResponseEntity<Doador> salvarDoador(@RequestBody @Valid DoadorRecordDTO doadorRecordDTO){
        Doador doador = new Doador();
        BeanUtils.copyProperties(doadorRecordDTO, doador);
        return ResponseEntity.status(HttpStatus.CREATED).body(doadorRepository.save(doador));
    }
    
    
    @GetMapping("/quantidadeDoadoresPorEstado")
    public ResponseEntity<List<DoadorInterfacePorEstado>> quantidadeDoadoresPorEstado(){
        return ResponseEntity.status(HttpStatus.OK).body(doadorRepository.quantidadeDoadoresPorEstado());
    }
    
    @GetMapping("/mediaIdadeGrupoSanguineo")
    public ResponseEntity<List<DoadorInterfaceMediaIdadeGrupoSanguineo>> mediaIdadeGrupoSanguineo(){
        return ResponseEntity.status(HttpStatus.OK).body(doadorRepository.mediaIdadeGrupoSanguineo());
    }
    
    @GetMapping("/percentualObesosPorSexo")
    public ResponseEntity<List<DoadorInterfacePercentualObesosPorSexo>> percentualObesosPorSexo(){
        return ResponseEntity.status(HttpStatus.OK).body(doadorRepository.percentualObesosPorSexo());
    }
    
}
