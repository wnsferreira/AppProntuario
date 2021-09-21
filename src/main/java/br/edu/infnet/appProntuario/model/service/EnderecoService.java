package br.edu.infnet.appProntuario.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appProntuario.clients.iEnderecoClient;
import br.edu.infnet.appProntuario.model.domain.Endereco;

@Service
public class EnderecoService {

	@Autowired
	private iEnderecoClient enderecoClient;
	
	public Endereco obterCep(String cep) {
			
		
		return enderecoClient.obterCep(cep);
	}
}
 




//Endereco endereco = new Endereco();
//endereco.setBairro("bairro teste");
//endereco.setCep(cep);
//endereco.setComplemento("complemento teste");
//endereco.setLocalidade("localidade teste");
//endereco.setLogradouro("logradouro teste");
//endereco.setUf("RJ");