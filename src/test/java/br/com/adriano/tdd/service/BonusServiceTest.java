package br.com.adriano.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.adriano.tdd.modelo.Funcionario;

public class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
//		assertThrows(IllegalArgumentException.class,() -> service.calcularBonus(new Funcionario(
//				"Hin",LocalDate.now(),new BigDecimal("25000"))));
		
		try {
			service.calcularBonus(new Funcionario(
					"Hin",LocalDate.now(),new BigDecimal("25000")));
			fail("N�o ocorreu exception");
		} catch(Exception e) {
			assertEquals("Funcion�rio com sal�rio maior de 10000 reais n�o pode receber b�nus.",e.getMessage());
		}
		//assertEquals(new BigDecimal("0.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario(
				"Hin",LocalDate.now(),new BigDecimal("2500")));
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamante10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario(
				"Hin",LocalDate.now(),new BigDecimal("10000")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}
}
