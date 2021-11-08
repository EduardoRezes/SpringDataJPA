package br.com.alura.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.specification.SpecificationFuncionario;

@Service
public class RelatorioFuncionarioDinamico {

	private final FuncionarioRepository funcionarioRepository;
	
	public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial (Scanner scanner) {
		System.out.println("Digite o nome");
		String nome = scanner.next();
		
		if (nome.equalsIgnoreCase("NULL")) {
			nome=null;
		}
		
		System.out.println("Digite o CPF");
		String cpf = scanner.next();
		
		if (cpf.equalsIgnoreCase("NULL")) {
			cpf=null;
		}
		
		System.out.println("Digite o nome");
		Double salario = scanner.nextDouble();
		
		if (salario == 0) {
			salario=null;
		}
		
		List<Funcionario> funcionario = funcionarioRepository.findAll(Specification.where(SpecificationFuncionario.nome(nome)));
	}
}
