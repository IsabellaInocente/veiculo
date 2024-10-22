package com.hospede.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hospede.entity.Veiculo;



@DataJpaTest
public class VeiculoRepositoryTestTest {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		
		Veiculo veiculo1 = new Veiculo(null, "Audi","2018", "r8", "Azul");
		
		Veiculo saveVeiculo = veiculoRepository.save(veiculo1);
		
		Assertions.assertNotNull(saveVeiculo);
		Assertions.assertTrue(saveVeiculo.getId() > 0);
	}
	@DisplayName("Testando Get para todos os veiculos")
	@Test
	void testGetAllRepository() {
		
		Veiculo veiculo1 = new Veiculo(null, "Ford","Mustang GT 500","2009", "Preto");
		
		Veiculo veiculo2 = new Veiculo(null, "Lamborghini","urus","2008", "Roxa");
		
		veiculoRepository.save(veiculo1);
		veiculoRepository.save(veiculo2);
		
		List<Veiculo> veiculoList = veiculoRepository.findAll();
		
		Assertions.assertNotNull(veiculoList);
		Assertions.assertEquals(2, veiculoList.size());
	}
	@DisplayName("Testando GET By ID")
	@Test
	void testGetById() {
		
		Veiculo veiculo1 = new Veiculo(null, "Ford","Mustang GT500"," 2012","preto");
		
		veiculoRepository.save(veiculo1);
		
		Veiculo saveVeiculo = veiculoRepository.findById(veiculo1.getId()).get();
		
		Assertions.assertNotNull(saveVeiculo);
		Assertions.assertEquals(veiculo1.getId(), saveVeiculo.getId());


}
    @DisplayName("Testando UPDATE")	
	@Test
	void testUpdateVeiculo() {
		
		Veiculo veiculo1 = new Veiculo(null, "nissan","gr3"," 2020", "preto");
		
		veiculoRepository.save(veiculo1);
		
		Veiculo saveVeiculo = veiculoRepository.findById(veiculo1.getId()).get();
		veiculo1.setMarca("nissan");
		veiculo1.setModelo("GTR");
		veiculo1.setCor("Azul com listras");
		
		Veiculo updateVeiculo = veiculoRepository.save(saveVeiculo);
		
		Assertions.assertNotNull(updateVeiculo);
		Assertions.assertEquals("nissan",updateVeiculo.getMarca());
		Assertions.assertEquals("GTR", updateVeiculo.getModelo());
		Assertions.assertEquals("GTR", updateVeiculo.getModelo());


}
    @DisplayName("Testando Delete")	
   	@Test
   	void testDeleteVeiculo() {
   		
   		Veiculo veiculo1 = new Veiculo(null, "Mitsubishi","eclipse","2018", "branca");
   		
   		veiculoRepository.save(veiculo1);
   		
   		veiculoRepository.deleteById(veiculo1.getId());
   		
   		
   		Optional<Veiculo> veiculoOptional = veiculoRepository.findById(veiculo1.getId());
   		Assertions.assertTrue(veiculoOptional.isEmpty());


   }
}

