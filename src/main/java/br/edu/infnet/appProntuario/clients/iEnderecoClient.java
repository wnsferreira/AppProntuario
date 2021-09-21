package br.edu.infnet.appProntuario.clients;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

import br.edu.infnet.appProntuario.model.domain.Endereco;


@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
public interface iEnderecoClient {
	
	@GetMapping(value = "{cep}/json")
	public Endereco obterCep(@PathVariable String cep);

}
