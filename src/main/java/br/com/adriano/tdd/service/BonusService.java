package br.com.adriano.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.adriano.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if(valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException("Funcion�rio com sal�rio maior de 10000 reais n�o pode receber b�nus.");
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}
}
