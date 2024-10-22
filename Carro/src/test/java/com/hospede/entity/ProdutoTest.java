package com.hospede.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProdutoTest {

	private Produto produto;

	@BeforeEach
	void setUp() {
// Arrange
		produto = new Produto(1L, "bala", 4.00);
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
// Act
		produto.setId(2L);
// Assert
		Assertions.assertEquals(2L, produto.getId());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
// Act
		produto.setNome("fausto");
// Assert
		Assertions.assertEquals("fausto", produto.getNome());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo email")
	void testEmail() {
// Act
		produto.setNome("bala");
// Assert
		Assertions.assertEquals("bala", produto.getNome());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo telefone")
	void testTelefone() {
// Act
		produto.setPreco(4.00);
// Assert
		Assertions.assertEquals(4.00, produto.getPreco());
	}

	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstructorAll() {
// Act
		Produto novoProduto = new Produto(3L, "barra",5.00);
// Assertion
		Assertions.assertAll("novoProduto", () -> Assertions.assertEquals(3L, novoProduto.getId()),
				() -> Assertions.assertEquals("carlos", novoProduto.getNome()),
				() -> Assertions.assertEquals(15.00, novoProduto.getPreco()));

	}
}
