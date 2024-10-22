package com.hospede.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hospede.entity.Cliente;



@DataJpaTest
public class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		
		Cliente cliente1 = new Cliente(null, "barra",
				                              90.00);
		
		Cliente saveCliente = clienteRepository.save(cliente1);
		
		Assertions.assertNotNull(saveCliente);
		Assertions.assertTrue(saveCliente.getId() > 0);
	}
	@DisplayName("Testando Get para todos os clientes")
	@Test
	void testGetAllRepository() {
		
		Cliente cliente1 = new Cliente(null, "algo",
				                        10.00
				                             );
		
		Cliente cliente2 = new Cliente(null, "Joao",
                5.00);
		
		clienteRepository.save(cliente1);
		clienteRepository.save(cliente2);
		
		List<Cliente> clienteList = clienteRepository.findAll();
		
		Assertions.assertNotNull(clienteList);
		Assertions.assertEquals(2, clienteList.size());
	}
	@DisplayName("Testando GET By ID")
	@Test
	void testGetById() {
		
		Cliente cliente1 = new Cliente(null, "bala",
                4.00);
		
		clienteRepository.save(cliente1);
		
		Cliente saveCliente = clienteRepository.findById((long) cliente1.getId()).get();
		
		Assertions.assertNotNull(saveCliente);
		Assertions.assertEquals(cliente1.getId(), saveCliente.getId());


}
    @DisplayName("Testando UPDATE")	
	@Test
	void testUpdateCliente() {
		
		Cliente cliente1 = new Cliente(null, "algo",
				                             10.00);
		
		clienteRepository.save(cliente1);
		
		Cliente saveCliente = clienteRepository.findById((long) cliente1.getId()).get();
		cliente1.setNome("Lucas");
		cliente1.setTelefone("15-0000-0000");
		
		Cliente updateCliente = clienteRepository.save(saveCliente);
		
		Assertions.assertNotNull(updateCliente);
		Assertions.assertEquals("Lucas",updateCliente.getNome());
		Assertions.assertEquals(10.00, updateCliente.getTelefone());

}
    @DisplayName("Testando Delete")	
   	@Test
   	void testDeleteCliente() {
   		
   		Cliente cliente1 = new Cliente(null, "algo",
   				                             10.00);
   		
   		clienteRepository.save(cliente1);
   		
   		clienteRepository.deleteById((long) cliente1.getId());
   		
   		
   		Optional<Cliente> clienteOptional = clienteRepository.findById((long) cliente1.getId());
   		Assertions.assertTrue(clienteOptional.isEmpty());


   }
}

