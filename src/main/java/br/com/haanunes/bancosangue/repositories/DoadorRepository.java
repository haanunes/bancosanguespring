package br.com.haanunes.bancosangue.repositories;

import br.com.haanunes.bancosangue.dtos.DoadorInterfaceImcMedioPorFaixaDeIdade;
import br.com.haanunes.bancosangue.dtos.DoadorInterfaceMediaIdadeGrupoSanguineo;
import br.com.haanunes.bancosangue.dtos.DoadorInterfacePercentualObesosPorSexo;
import br.com.haanunes.bancosangue.entities.Doador;
import br.com.haanunes.bancosangue.dtos.DoadorInterfacePorEstado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Hélder
 */
@Repository
public interface DoadorRepository extends JpaRepository<Doador, Long> {

    @Query("SELECT d.estado as estado, "
            + " COUNT(*) as quantidade FROM Doador AS d GROUP BY d.estado order by estado asc")
    List<DoadorInterfacePorEstado> quantidadeDoadoresPorEstado();
    
    @Query("SELECT d.tipo_sanguineo as tipo_sanguineo , AVG(TIMESTAMPDIFF(year, data_nasc,CURRENT_DATE())) AS media_idade "
            + "FROM Doador as d GROUP BY tipo_sanguineo order by tipo_sanguineo")
    List<DoadorInterfaceMediaIdadeGrupoSanguineo> mediaIdadeGrupoSanguineo();  
    
    
    @Query("SELECT d.sexo as sexo, (COUNT(*) / (SELECT COUNT(*) FROM Doador WHERE sexo = d.sexo)) * 100 AS percentual_obesos "
            + "FROM Doador as d WHERE (peso / (altura * altura)) > 30 GROUP BY sexo")
    List<DoadorInterfacePercentualObesosPorSexo> percentualObesosPorSexo();
    
    

}
