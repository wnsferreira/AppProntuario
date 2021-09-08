package br.edu.infnet.appProntuario.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import br.edu.infnet.appProntuario.model.domain.Atendimento;
import br.edu.infnet.appProntuario.model.domain.Consulta;
import br.edu.infnet.appProntuario.model.domain.Exame;
import br.edu.infnet.appProntuario.model.domain.Paciente;
import br.edu.infnet.appProntuario.model.domain.Prontuario;
import br.edu.infnet.appProntuario.model.exceptions.HonoraiosNaoPreenchidosException;

public class AppTeste {

	public static void main(String[] args) throws NumberFormatException, ParseException {
		try {
			String dir = "d:/arquivo_prontuario/";
			String arq = "prontuario.txt";
			try {
				FileWriter fileW = new FileWriter(dir+"out_"+arq);
				BufferedWriter escrita = new BufferedWriter(fileW);
				
				FileReader file = new FileReader(dir+arq);
				BufferedReader leitura = new BufferedReader(file);
				
				String linha = leitura.readLine();
				
				while(linha != null) {
					
					String[] campos = linha.split(";");

					
						switch (campos[0].toUpperCase()) {
						case "0":
							System.out.println("Prontuario/Paciente");
							
							Paciente pac = new Paciente(campos[1],campos[2], campos[3]);
							
							Prontuario pront = new Prontuario();
							pront.setPaciente(pac);
														
							escrita.write(pront.obterProntuario()+"\r\n");	
							
							break;
						
						case "C":					
							Consulta cons = new Consulta(campos[1],Float.valueOf(campos[2]),"S".equalsIgnoreCase(campos[3]), campos[5]);
						
							cons.setConvenio(campos[4]);
							escrita.write(cons.obterConsulta());
												
							break;
							
						case "A":
							Atendimento atd = new Atendimento(campos[1],Float.valueOf(campos[2]), "S".equalsIgnoreCase(campos[3]));
							atd.setEspecializacao(campos[1]);
							atd.setNomeProfissional(campos[5]);
							atd.setTempoAtendimento(Integer.valueOf(campos[6]));
							atd.setHonorario(Float.valueOf(campos[7]));
							
							escrita.write(atd.obterAtendimento());
							
							break;
							
						case "E":
							Exame exm = new Exame(campos[1],Float.valueOf(campos[2]), "S".equalsIgnoreCase(campos[3]));					
//							exm.setTipo(campos[3]);
//							exm.setHora(Integer.valueOf(campos[4]));
//							exm.setResultado(campos[5]);
							escrita.write(exm.solicitarPedido());
							
							break;
							
						default:
							System.out.println("Entrada Inválida!");
							break;
						
					}
					
					linha = leitura.readLine();
				}
				
				file.close();
				leitura.close();
				escrita.close();
				fileW.close();
				
			} catch (HonoraiosNaoPreenchidosException | IOException e) {
				System.out.println(e.getMessage());
			}
		} finally {
				System.out.println("Processamento finalizado!!!");
		}
		
	}
}
		