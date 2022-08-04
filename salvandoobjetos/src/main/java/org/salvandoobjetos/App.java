package org.salvandoobjetos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	Endereco end1 = new Endereco();
    	
    	end1.setRua("Waldemar Moss");
    	end1.setNumero(476);
    	end1.setBairro("Industrial");
    	end1.setCidade("Guarapuava");
    	
    	Telefone tel1 = new Telefone();
    	Telefone tel2 = new Telefone();
    	
    	tel1.setDdd(42);
    	tel1.setNumero(988040353);
    	tel1.setTipo("Principal");
    	tel2.setDdd(42);
    	tel2.setNumero(36215200);
    	tel2.setTipo("Residencial");
    	
    	List<Telefone> telefones= new ArrayList<Telefone>();
    	
    	telefones.add(tel1);
    	telefones.add(tel2);
    	
    	Cliente cliente = new Cliente();
    	
    	cliente.setNome("Vitor Siqueira");
    	cliente.setCpf("11131160050");
    	cliente.setDataNascimento("25/07/2002");
    	cliente.setEndereco(end1);
    	cliente.setSexo("Masculino");
    	cliente.setTelefones(telefones);
    	tel1.setCliente(cliente);
    	tel2.setCliente(cliente);
    	
    	Venda venda = new Venda();
    	venda.setCodigo("XL3215");    	
    	Produto prod1 = new Produto();
    	Produto prod2 = new Produto();
    	List<Produto> produtos = new ArrayList<Produto>();
    	
    	prod1.setCodigo(121);
    	prod1.setDescricao("Curso de Java");
    	prod1.setValor(600.36);
    	prod1.setVenda(venda);
    	prod2.setCodigo(352);
    	prod2.setDescricao("Curso de Firebase");
    	prod2.setValor(512.36);
    	prod2.setVenda(venda);
    	produtos.add(prod1);
    	produtos.add(prod2);
    	venda.setProdutos(produtos);
    	venda.setCliente(cliente);    	
    	venda.setValorTotal();
    	
    	@SuppressWarnings("deprecation")
    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	Transaction tx = session.beginTransaction();
 
    	session.save(cliente);
    	session.save(end1);
    	session.save(tel1);
    	session.save(tel2);
    	session.save(venda);
    	session.save(prod1);
    	session.save(prod2);
    	
    	tx.commit();
    	session.close();
    	sessionFactory.close();
    }
}
