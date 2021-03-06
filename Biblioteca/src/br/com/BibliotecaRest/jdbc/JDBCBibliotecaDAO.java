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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import br.com.BibliotecaRest.objetos.RelatorioServico;
public class JDBCBibliotecaDAO {

	private Connection conexao;

	public JDBCBibliotecaDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public boolean inserir(Servico servico) {
		Cliente cliente = new Cliente();
		String comando = "INSERT INTO servicos " + "(servico, observacao, quantidade, marca, modelo, placa, valor, metodo, data, horario) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		LocalDateTime agora = LocalDateTime.now();

        System.out.println("LocalDateTime antes de formatar: " + agora);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    

        String agoraFormatado = agora.format(formatter);
      

        System.out.println("LocalDateTime depois de formatar: " + agoraFormatado);
      
		
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
			p.setString(10, agoraFormatado);

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
				+ "FROM servicos order by data DESC, horario DESC;";
		
		if (!nome.equals("null") && !nome.equals("")) {
			comando = "SELECT servicos.*,\r\n"
					+ "       (SELECT SUM(servicos.valor)\r\n"
					+ "        FROM servicos\r\n"
					+ "        WHERE servicos.modelo = '"+nome+"'\r\n"
					+ "       ) as total\r\n"
					+ "FROM servicos WHERE servicos.modelo = '"+nome+"' order by data DESC, horario DESC;";
	
			
			
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



	
	public List<RelatorioServico> buscarNoMes(String valorBusca, String valorBusca2){
		Cliente cliente = new Cliente();
		
		
		
		String comando = "select year(data) AS 'Ano', month(data) AS 'Mes', sum(valor) AS 'Total'"
				+ " from servicos group by year(data), month(data) ORDER BY Mes;";
		
		if ((!valorBusca.equals("null") && !valorBusca.equals("")) && (!valorBusca2.equals("null") && !valorBusca2.equals(""))) {
			comando = "select year(data) AS 'Ano', month(data) AS 'Mes', sum(valor) AS 'Total'"
					+ " from servicos where data >= '"+valorBusca+"' and data <= '"+valorBusca2+"'"
					+ " group by year(data), month(data) ORDER BY Mes;";
			
		}else if(!valorBusca2.equals("null") && !valorBusca2.equals("") && (valorBusca.equals("null") || valorBusca.equals(""))) {
			comando = "select year(data) AS 'Ano', month(data) AS 'Mes', sum(valor) AS 'Total'"
					+ " from servicos where data >= '"+valorBusca2+"'"
					+ " group by year(data), month(data) ORDER BY Mes;";
			
			
		}else if(!valorBusca.equals("null") && !valorBusca.equals("") && (valorBusca2.equals("null") || valorBusca2.equals(""))) {
			comando = "select year(data) AS 'Ano', month(data) AS 'Mes', sum(valor) AS 'Total'"
					+ " from servicos where data >= '"+valorBusca+"'"
					+ " group by year(data), month(data) ORDER BY Mes;";
			
		}
		
		
		List<RelatorioServico> listRelatorioServico = new ArrayList<RelatorioServico>();
		RelatorioServico relatorioServico = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			
			while (rs.next()) {
				relatorioServico = new RelatorioServico();
			
				
				String ano = rs.getString("Ano");
				String mes = rs.getString("Mes");
				float total = rs.getFloat("Total");	
					
				
				relatorioServico.setAno(ano);
				relatorioServico.setMes(mes);
				relatorioServico.setTotal(total);
				
			

				
				listRelatorioServico.add(relatorioServico);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listRelatorioServico;
	}
	
	
	public List<Servico> buscarPorData(String valorBusca, String valorBusca2) {
		
		
		
		String comando = "SELECT servicos.*,\r\n"
				+ "       (SELECT SUM(servicos.valor)\r\n"
				+ "        FROM servicos\r\n"
				+ "       ) as total\r\n"
				+ " FROM servicos order by data DESC, horario DESC;";
		
		if ((!valorBusca.equals("null") && !valorBusca.equals("")) && (!valorBusca2.equals("null") && !valorBusca2.equals(""))) {
			comando = "SELECT servicos.*,\r\n"
					+ "       (SELECT SUM(servicos.valor)\r\n"
					+ "        FROM servicos\r\n"
					+ "        WHERE servicos.data >= '"+valorBusca+"' AND data <= '"+valorBusca2+"'\r\n"
					+ "       ) as total\r\n"
					+ "FROM servicos WHERE servicos.data >= '"+valorBusca+"' AND data <= '"+valorBusca2+"' order by data DESC, horario DESC;";
			
		}else if(!valorBusca2.equals("null") && !valorBusca2.equals("") && (valorBusca.equals("null") || valorBusca.equals(""))) {
			comando = "SELECT servicos.*,\r\n"
					+ "       (SELECT SUM(servicos.valor)\r\n"
					+ "        FROM servicos\r\n"
					+ "        WHERE servicos.data = '"+valorBusca2+"'\r\n"
					+ "       ) as total\r\n"
					+ "FROM servicos WHERE servicos.data = '"+valorBusca2+"' order by data DESC, horario DESC;";
			
			
		}else if(!valorBusca.equals("null") && !valorBusca.equals("") && (valorBusca2.equals("null") || valorBusca2.equals(""))) {
			comando = "SELECT servicos.*,\r\n"
					+ "       (SELECT SUM(servicos.valor)\r\n"
					+ "        FROM servicos\r\n"
					+ "        WHERE servicos.data = '"+valorBusca+"'\r\n"
					+ "       ) as total\r\n"
					+ "FROM servicos WHERE servicos.data = '"+valorBusca+"' order by data DESC, horario DESC;";
			
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
					+ " FROM servicos WHERE servicos.data >= '"+dataAte+"' AND servicos.data <= '"+dataDe+"' AND servicos.metodo = "+metodo+" order by data DESC, horario DESC;";
			
		}else {
			comando = "SELECT servicos.*,\r\n"
					+ "       (SELECT SUM(servicos.valor)\r\n"
					+ "        FROM servicos\r\n"
					+ "        WHERE servicos.data >= '"+dataAte+"' AND servicos.data <= '"+dataDe+"'\r\n"
					+ "       ) as total\r\n"
					+ " FROM servicos WHERE servicos.data >= '"+dataAte+"' AND servicos.data <= '"+dataDe+"' order by data DESC, horario DESC;";
			
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
						+ "FROM servicos WHERE servicos.data >= '"+valorBusca+"' AND metodo = '"+metodo+"' order by data DESC, horario DESC;";
		
		
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
				String horario = rs.getString("horario");

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
				servico.setHorario(horario);
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
		
			
		
			public List<Servico> buscarServicos() {
				String comando = "SELECT * FROM servicos order by data DESC, horario DESC;";
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
