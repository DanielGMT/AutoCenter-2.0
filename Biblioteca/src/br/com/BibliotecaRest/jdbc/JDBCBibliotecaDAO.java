package br.com.BibliotecaRest.jdbc;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;



import br.com.BibliotecaRest.objetos.Servico;
import br.com.BibliotecaRest.objetos.Editora;
import br.com.BibliotecaRest.objetos.Emprestimo;
import br.com.BibliotecaRest.objetos.Livro;
import br.com.BibliotecaRest.objetos.Admin;
import br.com.BibliotecaRest.objetos.Cliente;
import br.com.BibliotecaRest.objetos.Divida;
import br.com.BibliotecaRest.objetos.Usuario;
public class JDBCBibliotecaDAO {

	private Connection conexao;

	public JDBCBibliotecaDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public boolean inserir(Servico servico) {
		Cliente cliente = new Cliente();
		String comando = "INSERT INTO servicos " + "(servico, observacao, quantidade, marca, modelo, placa, valor, metodo, data) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, servico.getServico());
			p.setString(2, servico.getObservacao());
			p.setInt(3, servico.getQuantidade());
			p.setString(4, servico.getMarca());
			p.setString(5, servico.getModelo());
			p.setString(6, servico.getPlaca());
			p.setFloat(7, servico.getValor());
			p.setInt(8, servico.getMetodo());
			p.setString(9, servico.getData());

			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Servico> buscarPorNome(String nome) {
		
		
		String comando = "SELECT servicos.*,\r\n"
				+ "       (SELECT SUM(servicos.valor)\r\n"
				+ "        FROM servicos\r\n"
				+ "       ) as total\r\n"
				+ "FROM servicos ORDER BY servicos.data DESC;";
		
		if (!nome.equals("null") && !nome.equals("")) {
			comando = "SELECT servicos.*,\r\n"
					+ "       (SELECT SUM(servicos.valor)\r\n"
					+ "        FROM servicos\r\n"
					+ "        WHERE servicos.modelo = '"+nome+"'\r\n"
					+ "       ) as total\r\n"
					+ "FROM servicos WHERE servicos.modelo = '"+nome+"' ORDER BY servicos.data DESC;";
	
			
			
		}
		
		
		List<Servico> listServico = new ArrayList<Servico>();
		Servico servico = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			
			while (rs.next()) {
				servico = new Servico();
				Cliente cliente = new Cliente();
				
				int id = rs.getInt("id");
				String nomeServico = rs.getString("servico");
				String nomeObservacao = rs.getString("observacao");
				int nomeQuantidade = rs.getInt("quantidade");
				String nomeMarca = rs.getString("marca");
				String nomeModelo = rs.getString("modelo");
				String nomePlaca = rs.getString("placa");
				float nomeValor = rs.getFloat("valor");
				int nomeMetodo = rs.getInt("metodo");
				String nomeData = cliente.converteNascimentoParaFrontend(rs.getString("data"));
				float total = rs.getFloat("total");
				
				
					
				servico.setId(id);
				servico.setServico(nomeServico);
				servico.setObservacao(nomeObservacao);
				servico.setQuantidade(nomeQuantidade);
				servico.setMarca(nomeMarca);
				servico.setModelo(nomeModelo);
				servico.setPlaca(nomePlaca);
		
				servico.setValor(nomeValor);
				servico.setMetodo(nomeMetodo);
				servico.setData(nomeData);
				servico.setTotal(total);
			
				listServico.add(servico);
			}
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listServico;
	}

	
	public List<Servico> buscarPorData(String valorBusca, String valorBusca2) {
		
		
		
		String comando = "SELECT servicos.*,\r\n"
				+ "       (SELECT SUM(servicos.valor)\r\n"
				+ "        FROM servicos\r\n"
				+ "       ) as total\r\n"
				+ " FROM servicos ORDER BY servicos.data DESC;";
		
		if ((!valorBusca.equals("null") && !valorBusca.equals("")) && (!valorBusca2.equals("null") && !valorBusca2.equals(""))) {
			comando = "SELECT servicos.*,\r\n"
					+ "       (SELECT SUM(servicos.valor)\r\n"
					+ "        FROM servicos\r\n"
					+ "        WHERE servicos.data >= '"+valorBusca+"' AND data <= '"+valorBusca2+"'\r\n"
					+ "       ) as total\r\n"
					+ "FROM servicos WHERE servicos.data >= '"+valorBusca+"' AND data <= '"+valorBusca2+"' ORDER BY servicos.data ASC;";
			
		}else if(!valorBusca2.equals("null") && !valorBusca2.equals("") && (valorBusca.equals("null") || valorBusca.equals(""))) {
			comando = "SELECT servicos.*,\r\n"
					+ "       (SELECT SUM(servicos.valor)\r\n"
					+ "        FROM servicos\r\n"
					+ "        WHERE servicos.data = '"+valorBusca2+"'\r\n"
					+ "       ) as total\r\n"
					+ "FROM servicos WHERE servicos.data = '"+valorBusca2+"' ORDER BY servicos.data ASC;";
			
			
		}else if(!valorBusca.equals("null") && !valorBusca.equals("") && (valorBusca2.equals("null") || valorBusca2.equals(""))) {
			comando = "SELECT servicos.*,\r\n"
					+ "       (SELECT SUM(servicos.valor)\r\n"
					+ "        FROM servicos\r\n"
					+ "        WHERE servicos.data = '"+valorBusca+"'\r\n"
					+ "       ) as total\r\n"
					+ "FROM servicos WHERE servicos.data = '"+valorBusca+"' ORDER BY servicos.data ASC;";
			
		}
		
		
	
		
		
		List<Servico> listServico = new ArrayList<Servico>();
		Servico servico = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			
			while (rs.next()) {
				servico = new Servico();
				Cliente cliente = new Cliente();
				int id = rs.getInt("id");
				String nomeServico = rs.getString("servico");
				String nomeObservacao = rs.getString("observacao");
				int nomeQuantidade = rs.getInt("quantidade");
				String nomeMarca = rs.getString("marca");
				String nomeModelo = rs.getString("modelo");
				String nomePlaca = rs.getString("placa");
				float nomeValor = rs.getFloat("valor");
				int nomeMetodo = rs.getInt("metodo");
				String nomeData = cliente.converteNascimentoParaFrontend(rs.getString("data"));
				float total = rs.getFloat("total");	
					
				
				servico.setId(id);
				servico.setServico(nomeServico);
				servico.setObservacao(nomeObservacao);
				servico.setQuantidade(nomeQuantidade);
				servico.setMarca(nomeMarca);
				servico.setModelo(nomeModelo);
				servico.setPlaca(nomePlaca);
				servico.setValor(nomeValor);
				servico.setMetodo(nomeMetodo);
				servico.setData(nomeData);
				servico.setTotal(total);

				
				listServico.add(servico);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listServico;
		
		
	}


	public List<Servico> buscarPorDataAte(String dataDe, String dataAte, int metodo) {
		String comando = "";
		if(metodo != 0) {
			comando = "SELECT servicos.*,\r\n"
					+ "       (SELECT SUM(servicos.valor)\r\n"
					+ "        FROM servicos\r\n"
					+ "        WHERE servicos.data >= '"+dataAte+"' AND servicos.data <= '"+dataDe+"' AND servicos.metodo = "+metodo+"\r\n"
					+ "       ) as total\r\n"
					+ " FROM servicos WHERE servicos.data >= '"+dataAte+"' AND servicos.data <= '"+dataDe+"' AND servicos.metodo = "+metodo+" ORDER BY servicos.data DESC;";
			
		}else {
			comando = "SELECT servicos.*,\r\n"
					+ "       (SELECT SUM(servicos.valor)\r\n"
					+ "        FROM servicos\r\n"
					+ "        WHERE servicos.data >= '"+dataAte+"' AND servicos.data <= '"+dataDe+"'\r\n"
					+ "       ) as total\r\n"
					+ " FROM servicos WHERE servicos.data >= '"+dataAte+"' AND servicos.data <= '"+dataDe+"' ORDER BY servicos.data DESC;";
			
		}
		
		
		
		List<Servico> listServico = new ArrayList<Servico>();
		Servico servico = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			
			while (rs.next()) {
				servico = new Servico();
				Cliente cliente = new Cliente();
				int id = rs.getInt("id");
				String nomeServico = rs.getString("servico");
				String nomeObservacao = rs.getString("observacao");
				int nomeQuantidade = rs.getInt("quantidade");
				String nomeMarca = rs.getString("marca");
				String nomeModelo = rs.getString("modelo");
				String nomePlaca = rs.getString("placa");
				float nomeValor = rs.getFloat("valor");
				int nomeMetodo = rs.getInt("metodo");
				float total = rs.getFloat("total");
				String nomeData = cliente.converteNascimentoParaFrontend(rs.getString("data"));

				servico.setId(id);
				servico.setServico(nomeServico);
				servico.setObservacao(nomeObservacao);
				servico.setQuantidade(nomeQuantidade);
				servico.setMarca(nomeMarca);
				servico.setModelo(nomeModelo);
				servico.setPlaca(nomePlaca);
				servico.setValor(nomeValor);
				servico.setMetodo(nomeMetodo);
				servico.setData(nomeData);
				servico.setTotal(total);
					
				

				listServico.add(servico);
			}	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listServico;
	}


public List<Servico> buscarPorDataHj(String valorBusca, String metodo) {
		
		
		
		String comando = "SELECT servicos.*,\r\n"
						+ "       (SELECT SUM(servicos.valor)\r\n"
						+ "        FROM servicos\r\n"
						+ "        WHERE servicos.data = '"+valorBusca+"' AND metodo = '"+metodo+"'\r\n"
						+ "       ) as total\r\n"
						+ "FROM servicos WHERE servicos.data >= '"+valorBusca+"' AND metodo = '"+metodo+"' ORDER BY servicos.data DESC;";
		
		
		List<Servico> listServico = new ArrayList<Servico>();
		Servico servico = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				servico = new Servico();
				Cliente cliente = new Cliente();
				int id = rs.getInt("id");
				String nomeServico = rs.getString("servico");
				String nomeObservacao = rs.getString("observacao");
				int nomeQuantidade = rs.getInt("quantidade");
				String nomeMarca = rs.getString("marca");
				String nomeModelo = rs.getString("modelo");
				String nomePlaca = rs.getString("placa");
				float nomeValor = rs.getFloat("valor");
				int nomeMetodo = rs.getInt("metodo");
				String nomeData = cliente.converteNascimentoParaFrontend(rs.getString("data"));
				float total = rs.getFloat("total");	
				
				servico.setId(id);
				servico.setServico(nomeServico);
				servico.setObservacao(nomeObservacao);
				servico.setQuantidade(nomeQuantidade);
				servico.setMarca(nomeMarca);
				servico.setModelo(nomeModelo);
				servico.setPlaca(nomePlaca);
				servico.setValor(nomeValor);
				servico.setMetodo(nomeMetodo);
				servico.setData(nomeData);
				servico.setTotal(total);
				
				listServico.add(servico);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listServico;
	}

	
	public boolean deletarServico(int id) {
		
				
		String comando = "DELETE from servicos WHERE id=" + id;
		Statement p;
		try {
			p = this.conexao.createStatement();
			p.execute(comando);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Servico buscarPorId(int id) {
		String comando = "SELECT * FROM servicos WHERE id="+id;
		Servico servico = new Servico();
		Cliente cliente = new Cliente();
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				
				id = rs.getInt("id");
				String nomeServico = rs.getString("servico");
				String nomeObservacao = rs.getString("observacao");
				int nomeQuantidade = rs.getInt("quantidade");
				String nomeMarca = rs.getString("marca");
				String nomeModelo = rs.getString("modelo");
				String nomePlaca = rs.getString("placa");
				float nomeValor = rs.getFloat("valor");
				int nomeMetodo = rs.getInt("metodo");
				String nomeData = cliente.converteNascimentoParaFrontend(rs.getString("data"));

				servico.setId(id);
				servico.setServico(nomeServico);
				servico.setObservacao(nomeObservacao);
				servico.setQuantidade(nomeQuantidade);
				servico.setMarca(nomeMarca);
				servico.setModelo(nomeModelo);
				servico.setPlaca(nomePlaca);
				servico.setValor(nomeValor);
				servico.setMetodo(nomeMetodo);
				servico.setData(nomeData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return servico;
	}

	public boolean atualizar(Servico servico) {
		Cliente cliente = new Cliente();
		String comando = "UPDATE servicos SET servico=?, observacao=?, quantidade=?, marca=?, modelo=?, placa=?, valor=?, metodo=?, data=? WHERE id="+servico.getId()+";";
		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, servico.getServico());
			p.setString(2, servico.getObservacao());
			p.setInt(3, servico.getQuantidade());
			p.setString(4, servico.getMarca());
			p.setString(5, servico.getModelo());
			p.setString(6, servico.getPlaca());
			p.setFloat(7, servico.getValor());
			p.setInt(8, servico.getMetodo());
			p.setString(9, cliente.converteNascimentoParaBD(servico.getData()));
			
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//---------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	public boolean inserirEditora(Editora editora) {
		String comando = "INSERT INTO editoras " + "(nome) " + "VALUES (?)";

		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, editora.getNome());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Editora> buscarEditoraPorNome(String nome) {
		String comando = "SELECT * FROM editoras ";
		if (!nome.equals("null") && !nome.equals("")) {
			comando += "WHERE nome LIKE '" + nome + "%'";
		}
		List<Editora> listEditora = new ArrayList<Editora>();
		Editora editora = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				editora = new Editora();
				String nomeEditora = rs.getString("nome");
				int id = rs.getInt("id");

				editora.setId(id);
				editora.setNome(nomeEditora);

				listEditora.add(editora);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listEditora;
	}

	public boolean deletarEditora(int id) {
		String comando = "SELECT COUNT('titulo') as row " + 
				"FROM livros where editoras_id ="+id+";";
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			int row = 0;
			while (rs.next()) {
				row = rs.getInt("row");
			}
			if(row > 0) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		comando = "DELETE from editoras WHERE id=" + id;
		Statement p;
		try {
			p = this.conexao.createStatement();
			p.execute(comando);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Editora buscarEditorasPorId(int id) {
		String comando = "SELECT * FROM editoras WHERE id=" + id;
		Editora editora = new Editora();
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				String nome = rs.getString("nome");
				int idAutor = rs.getInt("id");

				editora.setId(idAutor);
				editora.setNome(nome);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return editora;
	}

	public boolean atualizarEditora(Editora editora) {
		String comando = "UPDATE editoras SET nome=? WHERE id=" + editora.getId()
				+ ";";

		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, editora.getNome());
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//---------------------------------------------------------------------------
		
	public boolean inserirLivro(Livro livro) {
		String comando = "INSERT INTO livros " + 
		"(titulo, descricao, quantidade, imagem, editoras_id) " +
		"VALUES (?, ?, ?, ?, ?)";
		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, livro.getTitulo());
			p.setString(2, livro.getDescricao());
			p.setInt(3, livro.getQuantidade());
			p.setString(4, livro.getImagem());
			p.setInt(5, livro.getEditoraId());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		comando = "INSERT INTO livros_has_autores " +
				"(autores_id, livros_id) " +
				"VALUES (?, LAST_INSERT_ID())";
		try {
			p = this.conexao.prepareStatement(comando);
			p.setInt(1, livro.getAutorId());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<Livro> buscarLivroPorTitulo(String titulo) {
		String comando = "SELECT livros.*, livros_has_autores.* from livros inner join livros_has_autores "+ 
                      "on livros.id = livros_has_autores.livros_id ";
		if (!titulo.equals("null") && !titulo.equals("")) {
			comando += "WHERE livros.titulo LIKE '" + titulo + "%'";
		}
		List<Livro> listLivro = new ArrayList<Livro>();
		Livro livro = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			int id = 0;
			while (rs.next()) {
				livro = new Livro();
				id = rs.getInt("id");
				titulo = rs.getString("titulo");
				String descricao = rs.getString("descricao");
				int quantidade = rs.getInt("quantidade");
				String imagem = rs.getString("imagem");
				int editoraId = rs.getInt("editoras_id");
				int autorId = rs.getInt("autores_id");
				
				livro.setId(id);
				livro.setTitulo(titulo);
				livro.setDescricao(descricao);
				livro.setQuantidade(quantidade);
				livro.setImagem(imagem);
				livro.setEditoraId(editoraId);	
				livro.setAutorId(autorId);
				
				listLivro.add(livro);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listLivro;
	}

	public boolean deletarLivro(int id) {
		String comando = "DELETE from livros_has_autores WHERE livros_id=" + id;
				
		comando += "";
		
		Statement p;
		try {
			p = this.conexao.createStatement();
			p.execute(comando);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		comando = "DELETE from livros WHERE id=" + id;
		
		try {
			p = this.conexao.createStatement();
			p.execute(comando);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Livro buscarLivrosPorId(int id) {
		
		String comando = "SELECT livros.*, livros_has_autores.* FROM livros inner join livros_has_autores"
				+ " ON livros.id = livros_has_autores.livros_id WHERE livros.id=" + id + ";";
		Livro livro = new Livro();
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				int idLivro = rs.getInt("id");
				String tituloLivro = rs.getString("titulo");
				String descricao = rs.getString("descricao");
				int quantidade = rs.getInt("quantidade");
				String imagem = rs.getString("imagem");
				int editoraId = rs.getInt("editoras_id");
				int autorId = rs.getInt("autores_id");
				
				livro.setId(idLivro);
				livro.setTitulo(tituloLivro);
				livro.setDescricao(descricao);
				livro.setQuantidade(quantidade);
				livro.setImagem(imagem);
				livro.setEditoraId(editoraId);
				livro.setAutorId(autorId);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return livro;
	}

	public boolean atualizarLivro(Livro livro) {
		String comando = "UPDATE livros inner join livros_has_autores "
				+ "ON livros.id = livros_has_autores.livros_id "
				+ "SET livros.titulo=?, livros.descricao=?, livros.quantidade=?, livros.imagem=?, "
				+ "livros.editoras_id=?, livros_has_autores.autores_id=? WHERE livros.id=" + livro.getId() + ";";

		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, livro.getTitulo());
			p.setString(2, livro.getDescricao());
			p.setInt(3, livro.getQuantidade());
			p.setString(4, livro.getImagem());
			p.setInt(5, livro.getEditoraId());
			p.setInt(6, livro.getAutorId());
			p.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public List<Editora> coletarEditora() {
		String comando = "SELECT * FROM editoras";
		List<Editora> listEditora = new ArrayList<Editora>();
		Editora editora = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				editora = new Editora();
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				
				editora.setId(id);
				editora.setNome(nome);
				
				listEditora.add(editora);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listEditora;
	}
	
	public List<Servico> coletarServico() {
		String comando = "SELECT * FROM servicos";
		List<Servico> listServico = new ArrayList<Servico>();
		Servico servico = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				servico = new Servico();
				int id = rs.getInt("id");
				String nome = rs.getString("servico");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				String placa = rs.getString("placa");
				float valor = rs.getFloat("valor");
				int metodo = rs.getInt("metodo");
				String data = rs.getString("data");
				
				servico.setId(id);
				servico.setServico(nome);
				servico.setMarca(marca);	
				servico.setModelo(modelo);
				servico.setPlaca(placa);
				servico.setValor(valor);
				servico.setMetodo(metodo);
				servico.setData(data);				
				listServico.add(servico);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listServico;
	}
	
	public List<Cliente> coletarCliente() {
		String comando = "SELECT * FROM clientes";
		List<Cliente> listCliente = new ArrayList<Cliente>();
		Cliente cliente = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				cliente = new Cliente();
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String dataNasc = rs.getString("data_nasc");
				String email = rs.getString("email");
				String imagem = rs.getString("imagem");
				String usuarioLogin = rs.getString("usuario_login");
				
				cliente.setId(id);
				cliente.setNome(nome);
				cliente.setData(dataNasc);
				cliente.setEmail(email);
				cliente.setImagem(imagem);
				cliente.setLogin(usuarioLogin);
				
				listCliente.add(cliente);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listCliente;
	}
	
	public List<Livro> coletarLivro() {
		String comando = "SELECT livros.*, livros_has_autores.* from livros inner join livros_has_autores " + 
				"on livros.id = livros_has_autores.livros_id";
		List<Livro> listLivro = new ArrayList<Livro>();
		Livro livro = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				livro = new Livro();
				int id = rs.getInt("id");
				String titulo = rs.getString("titulo");
				String descricao = rs.getString("descricao");
				int quantidade = rs.getInt("quantidade");
				String imagem = rs.getString("imagem");
				int editoraId = rs.getInt("editoras_id");
				
				livro.setId(id);
				livro.setTitulo(titulo);
				livro.setDescricao(descricao);
				livro.setQuantidade(quantidade);
				livro.setImagem(imagem);
				livro.setEditoraId(editoraId);
				
				listLivro.add(livro);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listLivro;
	}
	
	public List<Livro> coletarLivro2() {
		String comando = "SELECT * from livros;";
		List<Livro> listLivro = new ArrayList<Livro>();
		Livro livro = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				livro = new Livro();
				int id = rs.getInt("id");
				String titulo = rs.getString("titulo");
				String descricao = rs.getString("descricao");
				int quantidade = rs.getInt("quantidade");
				String imagem = rs.getString("imagem");
				int editoraId = rs.getInt("editoras_id");
				
				livro.setId(id);
				livro.setTitulo(titulo);
				livro.setDescricao(descricao);
				livro.setQuantidade(quantidade);
				livro.setImagem(imagem);
				livro.setEditoraId(editoraId);
				
				listLivro.add(livro);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listLivro;
	}
	
	
	public boolean inserirAdmin(Admin admin) {
		
		String comando = "INSERT INTO usuario " +
				"(login, senha, nivel_permissao) " +
				"VALUES (?, ?, 2)";
		
		PreparedStatement p;
		
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, admin.getLogin());
			p.setString(2, admin.getSenha());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		comando = "INSERT INTO administradores " + 
		"(nome, imagem, usuario_login) " +
		"VALUES (?, ?, ?)";
		
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, admin.getNome());
			p.setString(2, admin.getImagem());
			p.setString(3, admin.getLogin());
			p.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}

	public List<Admin> buscarAdminPorNome(String nome) {
		String comando = "SELECT administradores.*, usuario.* from administradores inner join usuario "+ 
                      "on administradores.usuario_login = usuario.login ";
		if (!nome.equals("null") && !nome.equals("")) {
			comando += "WHERE administradores.nome LIKE '" + nome + "%'";
		}
		List<Admin> listAdmin = new ArrayList<Admin>();
		Admin admin = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			int id = 0;
			while (rs.next()) {
				admin = new Admin();
				id = rs.getInt("id");
				nome = rs.getString("nome");
				String imagem = rs.getString("imagem");
				String login = rs.getString("usuario_login");
				String senha = rs.getString("senha");
				
				admin.setId(id);
				admin.setNome(nome);
				admin.setImagem(imagem);
				admin.setLogin(login);
				admin.setSenha(senha);
				
				listAdmin.add(admin);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listAdmin;
	}

	public boolean deletarAdmin(int id) {
		String comando = "DELETE administradores, usuario from administradores INNER JOIN usuario on "
				+ "administradores.usuario_login = usuario.login WHERE administradores.id="+ id;
		
		Statement p;
		try {
			p = this.conexao.createStatement();
			p.execute(comando);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Admin buscarAdminsPorId(int id) {
		String comando = "SELECT administradores.*, usuario.* from administradores inner join usuario "+ 
                "on administradores.usuario_login = usuario.login where administradores.id="+ id + ";";

		Admin admin = new Admin();
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			
			while (rs.next()) {
				int idAdmin = rs.getInt("id");
				String nome = rs.getString("nome");
				String imagem = rs.getString("imagem");
				String login = rs.getString("login");
				String senha= rs.getString("senha");
				
				admin.setId(idAdmin);
				admin.setNome(nome);
				admin.setImagem(imagem);
				admin.setLogin(login);
				admin.setSenha(senha);

	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return admin;
	}

	public boolean atualizarAdmin(Admin admin) {
		String comando = "UPDATE usuario inner join administradores "
				+ "ON administradores.usuario_login = usuario.login "
				+ "SET usuario.senha=? WHERE administradores.id=" + admin.getId()
				+ ";";

		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, admin.getSenha());
			p.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}return true;
	}
	
	//---------------------------------------------------------
	
	
	
	public boolean inserirCliente(Cliente cliente) {
		String comando = "INSERT INTO usuario " +
				"(login, senha, nivel_permissao) " +
				"VALUES (?, ?, 1)";
		
		PreparedStatement p;
		
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, cliente.getLogin());
			p.setString(2, cliente.getSenha());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		comando = "INSERT INTO clientes " + 
		"(nome, data_nasc, email, imagem, usuario_login) " +
		"VALUES (?, ?, ?, ?, ?)";
		
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, cliente.getNome());
			p.setString(2, cliente.converteNascimentoParaBD(cliente.getData()));
			p.setString(3, cliente.getEmail());
			p.setString(4, cliente.getImagem());
			p.setString(5, cliente.getLogin());
			p.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
		public List<Cliente> buscarClientePorNome(String nome) {
			String comando = "SELECT clientes.*, usuario.* from clientes inner join usuario "+ 
	                      "on clientes.usuario_login = usuario.login ";
			if (!nome.equals("null") && !nome.equals("")) {
				comando += "WHERE clientes.nome LIKE '" + nome + "%'";
			}
			List<Cliente> listCliente = new ArrayList<Cliente>();
			Cliente cliente = null;
			try {
				java.sql.Statement stmt = conexao.createStatement();
				ResultSet rs = stmt.executeQuery(comando);
				int id = 0;
				while (rs.next()) {
					cliente = new Cliente();
					id = rs.getInt("id");
					nome = rs.getString("nome");
					String data = cliente.converteNascimentoParaFrontend(rs.getString("data_nasc"));
					String email = rs.getString("email");
					String imagem = rs.getString("imagem");
					String login = rs.getString("usuario_login");
					String senha = rs.getString("senha");
					
					cliente.setId(id);
					cliente.setNome(nome);
					cliente.setData(data);
					cliente.setEmail(email);
					cliente.setImagem(imagem);
					cliente.setLogin(login);
					cliente.setSenha(senha);
					
					listCliente.add(cliente);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return listCliente;
			
		}

		public boolean deletarCliente(int id) {
			String comando = "DELETE clientes, usuario from clientes INNER JOIN usuario on "
					+ "clientes.usuario_login = usuario.login WHERE clientes.id="+ id;
			
			Statement p;
			try {
				p = this.conexao.createStatement();
				p.execute(comando);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		public Cliente buscarClientesPorId(int id) {
			String comando = "SELECT clientes.*, usuario.* from clientes inner join usuario "+ 
                    "on clientes.usuario_login = usuario.login where clientes.id="+ id + ";";

			Cliente cliente = new Cliente();
			try {
				java.sql.Statement stmt = conexao.createStatement();
				ResultSet rs = stmt.executeQuery(comando);
				
				while (rs.next()) {
					int idCliente = rs.getInt("id");
					String nome = rs.getString("nome");
					String data = cliente.converteNascimentoParaFrontend(rs.getString("data_nasc"));
					String email = rs.getString("email");
					String imagem = rs.getString("imagem");
					String login = rs.getString("login");
					String senha = rs.getString("senha");
					
					cliente.setId(idCliente);
					cliente.setNome(nome);
					cliente.setData(data);
					cliente.setEmail(email);
					cliente.setImagem(imagem);
					cliente.setLogin(login);
					cliente.setSenha(senha);
	
		
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return cliente;
		}

		public boolean atualizarCliente(Cliente cliente) {
			String comando = "UPDATE usuario inner join clientes "
					+ "ON clientes.usuario_login = usuario.login "
					+ "SET usuario.senha=? WHERE clientes.id=" + cliente.getId()
					+ ";";

			PreparedStatement p;
			try {
				p = this.conexao.prepareStatement(comando);
				p.setString(1, cliente.getSenha());
				p.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
				return false;
			}return true;
		}
		
		public Usuario adminLogado(int id) {
			String comando = "SELECT administradores.*, usuario.* from administradores inner join usuario "+ 
                    "on administradores.usuario_login = usuario.login where administradores.id="+ id + ";";

			Usuario usuario = new Usuario();
			try {
				java.sql.Statement stmt = conexao.createStatement();
				ResultSet rs = stmt.executeQuery(comando);
				
				while (rs.next()) {
					String login = rs.getString("login");
					String senha = rs.getString("senha");
					int permissao = rs.getInt("nivel_permissao");
					
					usuario.setLogin(login);
					usuario.setSenha(senha);
					usuario.setPermissao(permissao);
	
		
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return usuario;
		}
		
		public Usuario clienteLogado(int id) {
			String comando = "SELECT clientes.*, usuario.* from clientes inner join usuario "+ 
                    "on clientes.usuario_login = usuario.login where clientes.id="+ id + ";";

			Usuario usuario = new Usuario();
			try {
				java.sql.Statement stmt = conexao.createStatement();
				ResultSet rs = stmt.executeQuery(comando);
				
				while (rs.next()) {
					String login = rs.getString("login");
					String senha = rs.getString("senha");
					int permissao = rs.getInt("nivel_permissao");
					
					usuario.setLogin(login);
					usuario.setSenha(senha);
					usuario.setPermissao(permissao);
	
		
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return usuario;
		}
		
		public Admin buscarAdminPorUsuario(String usuario) {
			String comando = "SELECT administradores.*, usuario.* from administradores inner join usuario "+ 
                    "on administradores.usuario_login = usuario.login where usuario.login LIKE '%" + usuario + "'";

			Admin admin = new Admin();
			try {
				java.sql.Statement stmt = conexao.createStatement();
				ResultSet rs = stmt.executeQuery(comando);
				int id = 0;
				
				while (rs.next()) {
					id = rs.getInt("id");
					String nome = rs.getString("nome");
					String imagem = rs.getString("imagem");
					usuario = rs.getString("login");
					String senha = rs.getString("senha");
					
					admin.setId(id);
					admin.setNome(nome);
					admin.setImagem(imagem);
					admin.setLogin(usuario);
					admin.setSenha(senha);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return admin;
		}
		
		public Cliente buscarClientePorUsuario(String usuario) {
			String comando = "SELECT clientes.*, usuario.* from clientes inner join usuario "+ 
                    "on clientes.usuario_login = usuario.login where usuario.login LIKE '%" + usuario + "'";

			Cliente cliente = new Cliente();
			try {
				java.sql.Statement stmt = conexao.createStatement();
				ResultSet rs = stmt.executeQuery(comando);
				int id = 0;
				
				while (rs.next()) {
					id = rs.getInt("id");
					String nome = rs.getString("nome");
					String data = cliente.converteNascimentoParaFrontend(rs.getString("data_nasc"));
					String email = rs.getString("email");
					String imagem = rs.getString("imagem");
					usuario = rs.getString("login");
					String senha = rs.getString("senha");
					
					cliente.setId(id);
					cliente.setNome(nome);
					cliente.setData(data);
					cliente.setEmail(email);
					cliente.setImagem(imagem);
					cliente.setLogin(usuario);
					cliente.setSenha(senha);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return cliente;
		}
		
//---------------------------
		
		public boolean inserirEmprestimo(Emprestimo emprestimo) {
			String comando = "SELECT COUNT(id) as row FROM emprestimos" + 
					" WHERE clientes_id =" + emprestimo.getClienteId() +" and status = 1;";
			try {
				java.sql.Statement stmt = conexao.createStatement();
				ResultSet rs = stmt.executeQuery(comando);
				int row = 0;
				while (rs.next()) {
					row = rs.getInt("row");
				}
				if(row > 0) {
					return false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			comando = "INSERT INTO emprestimos (data_devolucao, data_emprestimo, status, livros_id, clientes_id) SELECT ?, ?, ?, ?, ? "+
			 "WHERE NOT EXISTS (SELECT clientes_id FROM emprestimos WHERE clientes_id = ? AND status = ?);";
			
			
			 
			PreparedStatement p;
			try {
				p = this.conexao.prepareStatement(comando);
				p.setString(1, emprestimo.getDataDev());
				p.setString(2, emprestimo.getDataEmp());
				p.setInt(3, emprestimo.getStatus());
				p.setInt(4, emprestimo.getLivroId());
				p.setInt(5, emprestimo.getClienteId());
				p.setInt(6, emprestimo.getClienteId());
				p.setInt(7, emprestimo.getStatus());
				p.execute();
	
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			comando = "SELECT * from livros;";
			try {
				java.sql.Statement stmt = conexao.createStatement();
				ResultSet rs = stmt.executeQuery(comando);
				int quantidade = 0;
				int novoId = 0;
				while (rs.next()) {
					int id = rs.getInt("id");
					if(id == emprestimo.getLivroId()) {
						 quantidade = rs.getInt("quantidade");
						 novoId =  id;
					}
				}
			comando = "UPDATE livros " + 
					"SET quantidade = (?)" +
					"WHERE id ="+ novoId +";";
		
				p = this.conexao.prepareStatement(comando);	
				p.setInt(1, (quantidade-1));
				p.executeUpdate();
			
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
				
			
			
			return true;
		}
		
		public boolean finalizarEmprestimo(int id) {
			
			String comando = "SELECT * from emprestimos where id=" + id +";";
			PreparedStatement p;
			try {
				java.sql.Statement stmt = conexao.createStatement();
				ResultSet rs = stmt.executeQuery(comando);
				int quantidade = 0;
				int livrosId = 0;
				while (rs.next()) {
					livrosId = rs.getInt("livros_id");
				}
				
				
				comando = "SELECT * from livros where id=" + livrosId +";";
				rs = stmt.executeQuery(comando);
				while (rs.next()) {
					quantidade = rs.getInt("quantidade");
				}
			
				comando = "UPDATE livros " + 
						"SET quantidade = (?)" +
						"WHERE id ="+ livrosId +";";
			
					p = this.conexao.prepareStatement(comando);	
					p.setInt(1, (quantidade+1));
					p.executeUpdate();	
					
				}catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			
				comando = "UPDATE emprestimos " +
					"SET data_real_devolucao = (?)" +
					"WHERE id ="+id+";";
			
				try {
					
					Date data = new Date(System.currentTimeMillis()); 
					SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd"); 
					
					p = this.conexao.prepareStatement(comando);	
					p.setString(1, (formatarDate.format(data)));
					p.executeUpdate();
					
					comando = "UPDATE emprestimos " +
							"SET status = (?)" +
							"WHERE id ="+id+";";
					
					p = this.conexao.prepareStatement(comando);	
					p.setInt(1, 2);
					p.executeUpdate();
					
					Emprestimo emprestimo = new Emprestimo();
					emprestimo.setDataReal(formatarDate.format(data));
					emprestimo.setStatus(2);
					
					comando = "UPDATE dividas " +
							"SET status = (?)" +
							"WHERE emprestimos_id ="+id+";";
					
					p = this.conexao.prepareStatement(comando);	
					p.setInt(1, 2);
					p.executeUpdate();
						
						
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			
			
			return true;
		}
		
		
			public List<Emprestimo> buscarEmprestimos() {
				String comando = "SELECT * FROM emprestimos where status = 1;";
				
				List<Emprestimo> listEmprestimo = new ArrayList<Emprestimo>();
				Emprestimo emprestimo = null;
				try {
					java.sql.Statement stmt = conexao.createStatement();
					ResultSet rs = stmt.executeQuery(comando);
					while (rs.next()) {
						emprestimo = new Emprestimo();
						int idEmp = rs.getInt("id");
						String dataDev = emprestimo.converteDataParaFrontend(rs.getString("data_devolucao"));
						String dataEmp = emprestimo.converteDataParaFrontend(rs.getString("data_emprestimo"));
						String dataReal = rs.getString("data_real_devolucao");
						int status = rs.getInt("status");
						int livroId = rs.getInt("livros_id");
						int clienteId = rs.getInt("clientes_id");
						
						emprestimo.setId(idEmp);
						emprestimo.setDataDev(dataDev);
						emprestimo.setDataEmp(dataEmp);
						emprestimo.setDataReal(dataReal);
						emprestimo.setStatus(status);
						emprestimo.setLivroId(livroId);
						emprestimo.setClienteId(clienteId);
						
						listEmprestimo.add(emprestimo);
					}
			
				} catch (Exception e) {
					e.printStackTrace();
				}
				return listEmprestimo;
				
			}
			
			public List<Emprestimo> buscarEmpPorData(String dataFinal) {
			
					String comando = dataFinal+";";
				
				
				
				List<Emprestimo> listEmprestimo = new ArrayList<Emprestimo>();
				Emprestimo emprestimo = null;
				try {
					java.sql.Statement stmt = conexao.createStatement();
					ResultSet rs = stmt.executeQuery(comando);
					while (rs.next()) {
						emprestimo = new Emprestimo();
						int idEmp = rs.getInt("id");
						String dataDev = emprestimo.converteDataParaFrontend(rs.getString("data_devolucao"));
						String dataEmp = emprestimo.converteDataParaFrontend(rs.getString("data_emprestimo"));
						String dataReal = rs.getString("data_real_devolucao");
						int status = rs.getInt("status");
						int livroId = rs.getInt("livros_id");
						int clienteId = rs.getInt("clientes_id");
						
						emprestimo.setId(idEmp);
						emprestimo.setDataDev(dataDev);
						emprestimo.setDataEmp(dataEmp);
						emprestimo.setDataReal(dataReal);
						emprestimo.setStatus(status);
						emprestimo.setLivroId(livroId);
						emprestimo.setClienteId(clienteId);
						
						listEmprestimo.add(emprestimo);
					}
			
				} catch (Exception e) {
					e.printStackTrace();
				}
				return listEmprestimo;
				
			}
			
			
			public List<Emprestimo> buscarEmprestimos2() {
				String comando = "SELECT * FROM emprestimos;";
				
				List<Emprestimo> listEmprestimo = new ArrayList<Emprestimo>();
				Emprestimo emprestimo = null;
				try {
					java.sql.Statement stmt = conexao.createStatement();
					ResultSet rs = stmt.executeQuery(comando);
					while (rs.next()) {
						emprestimo = new Emprestimo();
						int idEmp = rs.getInt("id");
						String dataDev = emprestimo.converteDataParaFrontend(rs.getString("data_devolucao"));
						String dataEmp = emprestimo.converteDataParaFrontend(rs.getString("data_emprestimo"));
						String dataReal = rs.getString("data_real_devolucao");
						int status = rs.getInt("status");
						int livroId = rs.getInt("livros_id");
						int clienteId = rs.getInt("clientes_id");
						
						emprestimo.setId(idEmp);
						emprestimo.setDataDev(dataDev);
						emprestimo.setDataEmp(dataEmp);
						emprestimo.setDataReal(dataReal);
						emprestimo.setStatus(status);
						emprestimo.setLivroId(livroId);
						emprestimo.setClienteId(clienteId);
						
						listEmprestimo.add(emprestimo);
					}
			
				} catch (Exception e) {
					e.printStackTrace();
				}
				return listEmprestimo;
				
			}
			
	
				
			
			public boolean inserirDividas() {
				String comando = "SELECT * FROM emprestimos where status = 1;";
				
				List<Emprestimo> listEmprestimo = new ArrayList<Emprestimo>();
				Emprestimo emprestimo = null;
				try {
					java.sql.Statement stmt = conexao.createStatement();
					ResultSet rs = stmt.executeQuery(comando);
					
					while (rs.next()) {
						emprestimo = new Emprestimo();
						Date data = new Date(System.currentTimeMillis()); 
						SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd"); 
						
						String dataDev = emprestimo.converteDataParaFrontend(rs.getString("data_devolucao"));
						String dataEmp = emprestimo.converteDataParaFrontend(rs.getString("data_emprestimo"));
						String dataAtual = emprestimo.converteDataParaFrontend(formatarDate.format(data));
				
						
						DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
				        df.setLenient(false);
				        
				        Date d1 = df.parse (dataDev);
				    
				        Date d2 = df.parse (dataAtual);
				       
				        long dt = (d2.getTime() - d1.getTime()) + 3600000; 
				        
				        long diasDeDivida = (dt / 86400000L);
						
						int idEmp = rs.getInt("id");
						
						String dataReal = rs.getString("data_real_devolucao");
						int status = rs.getInt("status");
						int livroId = rs.getInt("livros_id");
						int clienteId = rs.getInt("clientes_id");
						
						emprestimo.setId(idEmp);
						emprestimo.setDataDev(dataDev);
						emprestimo.setDataEmp(dataEmp);
						emprestimo.setDataReal(dataReal);
						emprestimo.setStatus(status);
						emprestimo.setLivroId(livroId);
						emprestimo.setClienteId(clienteId);
						
						
						if(diasDeDivida > 0) {
							 float valorDaMulta = (diasDeDivida * 3);
							
							comando = "INSERT INTO dividas (tipo, valor, status, emprestimos_id) SELECT 1, ?, 1, ?"
									+ " WHERE NOT EXISTS (SELECT emprestimos_id FROM dividas WHERE emprestimos_id = ?) LIMIT 1;";
							
							 PreparedStatement p;
								p = this.conexao.prepareStatement(comando);
							 	
									try {
										p = this.conexao.prepareStatement(comando);
										p.setFloat(1, valorDaMulta);
										p.setInt(2, idEmp);
										p.setInt(3, idEmp);
										p.execute();
										if(status == 1) {
											comando = "UPDATE dividas " +
													"SET valor = (?)" +
													"WHERE emprestimos_id ='"+idEmp+"' AND status = 1;";
											
											p = this.conexao.prepareStatement(comando);	
											p.setFloat(1, valorDaMulta);
											p.executeUpdate();
										}
									} catch (SQLException e) {
										e.printStackTrace();	
										return false;
									}
							
									
						}
						
						listEmprestimo.add(emprestimo);
						
						 
					}
			
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
			
			
			public List<Divida> buscarDividas() {
				String comando = "SELECT * FROM dividas where status = 1;";
				
				List<Divida> listDivida = new ArrayList<Divida>();
				Divida divida = null;
				try {
					
					java.sql.Statement stmt = conexao.createStatement();
					ResultSet rs = stmt.executeQuery(comando);
					while (rs.next()) {
						divida = new Divida();
						int id = rs.getInt("id");
						int tipo = rs.getInt("tipo");
						float valor = rs.getFloat("valor");
						int status = rs.getInt("status");
						int emprestimoId = rs.getInt("emprestimos_id");
						
						
						divida.setId(id);
						divida.setTipo(tipo);
						divida.setValor(valor);
						divida.setStatus(status);
						divida.setEmprestimoId(emprestimoId);
						
						listDivida.add(divida);
					}
			
				} catch (Exception e) {
					e.printStackTrace();
				}
				return listDivida;
				
			}
			
			public List<Divida> buscarDividas2() {
				String comando = "SELECT * FROM dividas where status = 2;";
				
				List<Divida> listDivida = new ArrayList<Divida>();
				Divida divida = null;
				try {
					
					java.sql.Statement stmt = conexao.createStatement();
					ResultSet rs = stmt.executeQuery(comando);
					while (rs.next()) {
						divida = new Divida();
						int id = rs.getInt("id");
						int tipo = rs.getInt("tipo");
						float valor = rs.getFloat("valor");
						int status = rs.getInt("status");
						int emprestimoId = rs.getInt("emprestimos_id");
						
						
						divida.setId(id);
						divida.setTipo(tipo);
						divida.setValor(valor);
						divida.setStatus(status);
						divida.setEmprestimoId(emprestimoId);
						
						listDivida.add(divida);
					}
			
				} catch (Exception e) {
					e.printStackTrace();
				}
				return listDivida;
				
			}
			
			public List<Emprestimo> buscarEmprestimosFinalizados() {
				String comando = "SELECT * FROM emprestimos where status = 2 order by data_real_devolucao ASC;";
				
				List<Emprestimo> listEmprestimo = new ArrayList<Emprestimo>();
				Emprestimo emprestimo = null;
				try {
					java.sql.Statement stmt = conexao.createStatement();
					ResultSet rs = stmt.executeQuery(comando);
					while (rs.next()) {
						emprestimo = new Emprestimo();
						int idEmp = rs.getInt("id");
						String dataDev = emprestimo.converteDataParaFrontend(rs.getString("data_devolucao"));
						String dataEmp = emprestimo.converteDataParaFrontend(rs.getString("data_emprestimo"));
						String dataReal = emprestimo.converteDataParaFrontend(rs.getString("data_real_devolucao"));
						int status = rs.getInt("status");
						int livroId = rs.getInt("livros_id");
						int clienteId = rs.getInt("clientes_id");
						
						emprestimo.setId(idEmp);
						emprestimo.setDataDev(dataDev);
						emprestimo.setDataEmp(dataEmp);
						emprestimo.setDataReal(dataReal);
						emprestimo.setStatus(status);
						emprestimo.setLivroId(livroId);
						emprestimo.setClienteId(clienteId);
						
						listEmprestimo.add(emprestimo);
						
					}
			
				} catch (Exception e) {
					e.printStackTrace();
				}
				return listEmprestimo;
			}
			

		
			public Usuario verificarLogin(String login) {
			
				String comando = "SELECT * FROM usuario where login="+ login +";";

				Usuario usuario = new Usuario();
				try {
					java.sql.Statement stmt = conexao.createStatement();
					ResultSet rs = stmt.executeQuery(comando);
					
					while (rs.next()) {
						login = rs.getString("login");
						String senha = rs.getString("senha");
						int permissao = rs.getInt("nivel_permissao");
						
						usuario.setLogin(login);
						usuario.setSenha(senha);
						usuario.setPermissao(permissao);
		
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return usuario;
			}
			
			public void trocarSenha(String email, String senha) {
				
				String comando = "update usuario set senha = ? where login = (select usuario_login from clientes where email = ?);";
				
				PreparedStatement p;
					
					
				try {
					p = this.conexao.prepareStatement(comando);
					p.setString(1, senha);
					p.setString(2, email);
								
					p.execute();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
	
};
