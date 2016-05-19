package br.com.fiap.main;

import javax.swing.JOptionPane;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Cinemas;
import br.com.fiap.entity.Filmes;
import br.com.fiap.entity.Locais;

public class Main {
	
	public static void main (String[] args){
		
		Cinemas cinema1 = new Cinemas();
		cinema1.setDescricao(JOptionPane.showInputDialog("Por favor, digite a descrição do cinema."));
		cinema1.setContato(JOptionPane.showInputDialog("Por favor, digite as informações de contato."));

		GenericDao<Cinemas> cinemas = new GenericDao<>(Cinemas.class);
		cinemas.adicionar(cinema1);
		
		JOptionPane.showMessageDialog(null,"Cinema adicionado: " + cinemas.buscar(cinemas.listar().size()).getDescricao());
		
		Locais local1 = new Locais();
		local1.setCinemas(cinema1);
		local1.setLocal(JOptionPane.showInputDialog("Por favor, digite o endereço do local."));
		local1.setSalas(new Integer (JOptionPane.showInputDialog("Por favor, digite a quantidade de salas no cinema.")));
		
		GenericDao<Locais> locais = new GenericDao<>(Locais.class);
		locais.adicionar(local1);
		
		JOptionPane.showMessageDialog(null,"Local adicionado: " +  locais.buscar(locais.listar().size()).getLocal());
		
		Filmes filme1 = new Filmes();
		filme1.setLocais(local1);
		filme1.setDuracao(new Double (JOptionPane.showInputDialog("Por favor, digite o tempo de duração do filme.")));
		filme1.setNumSala(new Integer (JOptionPane.showInputDialog("Por favor, digite o numero da sala.")));
		
		GenericDao<Filmes> filmes = new GenericDao<>(Filmes.class);
		filmes.adicionar(filme1);
		
		JOptionPane.showMessageDialog(null,"Filme adicionado na sala: " +  filmes.buscar(filmes.listar().size()).getNumSala());
	}
}
