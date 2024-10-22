package com.hospede.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hospede.entity.Produto;



@DataJpaTest
public class ProdutoRepositoryTest {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		
		Produto produto1 = new Produto(null, "barra",
				                              90.00);
		
		Produto saveProduto = produtoRepository.save(produto1);
		
		Assertions.assertNotNull(saveProduto);
		Assertions.assertTrue(saveProduto.getId() > 0);
	}
	@DisplayName("Testando Get para todos os produtos")
	@Test
	void testGetAllRepository() {
		
		Produto produto1 = new Produto(null, "algo",
				                        10.00
				                             );
		
		Produto produto2 = new Produto(null, "Joao",
                5.00);
		
		produtoRepository.save(produto1);
		produtoRepository.save(produto2);
		
		List<Produto> produtoList = produtoRepository.findAll();
		
		Assertions.assertNotNull(produtoList);
		Assertions.assertEquals(2, produtoList.size());
	}
	@DisplayName("Testando GET By ID")
	@Test
	void testGetById() {
		
		Produto produto1 = new Produto(null, "bala",
                4.00);
		
		produtoRepository.save(produto1);
		
		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();
		
		Assertions.assertNotNull(saveProduto);
		Assertions.assertEquals(produto1.getId(), saveProduto.getId());


}
    @DisplayName("Testando UPDATE")	
	@Test
	void testUpdateProduto() {
		
		Produto produto1 = new Produto(null, "algo",
				                             10.00);
		
		produtoRepository.save(produto1);
		
		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();
		produto1.setNome("Lucas");
		produto1.setPreco(8.00);
		
		Produto updateProduto = produtoRepository.save(saveProduto);
		
		Assertions.assertNotNull(updateProduto);
		Assertions.assertEquals("Lucas",updateProduto.getNome());
		Assertions.assertEquals(10.00, updateProduto.getPreco());

}
    @DisplayName("Testando Delete")	
   	@Test
   	void testDeleteProduto() {
   		
   		Produto produto1 = new Produto(null, "algo",
   				                             10.00);
   		
   		produtoRepository.save(produto1);
   		
   		produtoRepository.deleteById(produto1.getId());
   		
   		
   		Optional<Produto> produtoOptional = produtoRepository.findById(produto1.getId());
   		Assertions.assertTrue(produtoOptional.isEmpty());


   }
}

