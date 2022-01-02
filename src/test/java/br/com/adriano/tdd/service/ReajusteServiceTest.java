package br.com.adriano.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.adriano.tdd.modelo.Desempenho;
import br.com.adriano.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
//	@BeforeEach
//	public void inicializar() {
//      System.out.println("Início.");
//		this.service = new ReajusteService();
//		this.funcionario = new Funcionario("Ana",
//				LocalDate.now(),new BigDecimal("1000"));			
//	}
	@AfterEach
	public void finalizar() {
		System.out.println("Fim.");
	}
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("Antes de todos.");
	}
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("Depois de todos");
	}
	
	public void atribuir(String s,
			LocalDate ld, BigDecimal bd) {
		service = new ReajusteService();
		funcionario = new Funcionario(s,
				ld,bd);
	}
	public void testar(String valor,Desempenho desempenho) {
		service.concederReajuste(funcionario,desempenho);
		
		assertEquals(new BigDecimal(valor),funcionario.getSalario());
	}
	public void atribuirEtestar(String nome,
			LocalDate ld, BigDecimal bd,String vTeste,
			Desempenho desempenho) {
		atribuir(nome,ld,
				bd);
		testar(vTeste,desempenho);
	}
	
	@Test
	public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForAdesejar() {
		atribuirEtestar("Hans Schieck",LocalDate.now(),
				new BigDecimal(1000),"1030.00",
				Desempenho.A_DESEJAR);
	}
	@Test
	public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom() {	
		atribuirEtestar("Hans",
				LocalDate.now(),new BigDecimal("1000"),
				"1150.00",Desempenho.BOM);
	}
	@Test
	public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForBom() {
		atribuirEtestar("Hans",
				LocalDate.now(),new BigDecimal("1000"),
				"1200.00",Desempenho.OTIMO);
	}
}
