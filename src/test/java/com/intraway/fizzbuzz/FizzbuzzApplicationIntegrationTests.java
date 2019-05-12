package com.intraway.fizzbuzz;

import com.intraway.fizzbuzz.entities.FBError;
import com.intraway.fizzbuzz.entities.ListaNumero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FizzbuzzApplicationIntegrationTests {

	private final String MESSAGE_MULTIPLOS_TRES_CINCO = "se encontraron multiplos de 3 y de 5";
	private final String MESSAGE_MULTIPLOS_TRES = "se encontraron multiplos de 3";
	private final String MESSAGE_NO_MULTIPLOS = "no se encontraron multiplos";

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetListaNumeroMultiplosTresCinco() throws Exception {

		ResponseEntity<ListaNumero> entity = this.restTemplate.getForEntity("/intraway/api/fizzbuzz/1/10",
				ListaNumero.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getDescription()).isEqualTo(MESSAGE_MULTIPLOS_TRES_CINCO);

	}

	@Test
	public void testGetListaNumeroMultiplosTres() throws Exception {

		ResponseEntity<ListaNumero> entity = this.restTemplate.getForEntity("/intraway/api/fizzbuzz/1/4",
				ListaNumero.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getDescription()).isEqualTo(MESSAGE_MULTIPLOS_TRES);

	}

	@Test
	public void testGetListaNumeroSinMultiplos() throws Exception {

		ResponseEntity<ListaNumero> entity = this.restTemplate.getForEntity("/intraway/api/fizzbuzz/1/2",
				ListaNumero.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getDescription()).isEqualTo(MESSAGE_NO_MULTIPLOS);

	}

	@Test
	public void testGetListaErrorParamemtrosInvalidos() throws Exception {

		ResponseEntity<FBError> entity = this.restTemplate.getForEntity("/intraway/api/fizzbuzz/4/2",
				FBError.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		assertThat(entity.getBody().getMessage()).isEqualTo("Los parámetros enviados son incorrectos");

	}

	@Test
	public void testGetListaErrorMenosMenosCincuenta() throws Exception {

		ResponseEntity<FBError> entity = this.restTemplate.getForEntity("/intraway/api/fizzbuzz/-52/10",
				FBError.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		assertThat(entity.getBody().getMessage()).isEqualTo("Los parámetros enviados son incorrectos, min menor que -50");

	}

	@Test
	public void testGetListaErrorMayorCincuenta() throws Exception {

		ResponseEntity<FBError> entity = this.restTemplate.getForEntity("/intraway/api/fizzbuzz/4/55",
				FBError.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		assertThat(entity.getBody().getMessage()).isEqualTo("Los parámetros enviados son incorrectos, max mayor que 50");

	}

}
