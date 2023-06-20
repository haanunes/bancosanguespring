/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.haanunes.bancosangue.dtos;

/**
 *
 * @author Hélder
 */
public interface DoadorInterfacePercentualObesosPorSexo {
    String getSexo();
    double getPercentual_obesos();
    void setSexo(String estado);
    void setPercentual_obesos(double percentual_obesos);
}
