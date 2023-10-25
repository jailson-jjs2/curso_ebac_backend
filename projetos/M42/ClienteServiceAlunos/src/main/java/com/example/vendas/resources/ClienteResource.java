package com.example.vendas.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vendas.domain.Cliente;
import com.example.vendas.usecase.BuscaCliente;
import com.example.vendas.usecase.CadastroCliente;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
	
	private BuscaCliente buscaCliente;
	
	private CadastroCliente cadastroCliente;
	
	@Autowired
	public ClienteResource(BuscaCliente buscaCliente,
			CadastroCliente cadastroCliente) {
		this.buscaCliente = buscaCliente;
		this.cadastroCliente = cadastroCliente;
	}
	
	@GetMapping
	public ResponseEntity<Page<Cliente>> buscar (Pageable pageable) {
		return ResponseEntity.ok(buscaCliente.buscar(pageable));
	}
	
	@GetMapping(value = "isCadastrado/{id}")
	public ResponseEntity<Boolean> isCadastrado(@PathVariable(value = "id", required = true) String id) {
		return ResponseEntity.ok(buscaCliente.isCadastrado(id));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid Cliente cliente) {
		return ResponseEntity.ok(cadastroCliente.cadastrar(cliente));
	}

}
