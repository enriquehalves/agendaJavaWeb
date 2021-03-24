package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	// Paramatros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://10.0.0.140:3306/agenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String senha = "10021993";

	// metodo de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, senha);
			return con;

		} catch (Exception e) {
			System.out.println("bbbbbbbbbbbb");
			return null;
		}

	}

	// teste de conexão
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println("sucesso");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void inserirContato(JavaBeans contato) {
		String create = "insert into agenda(nome,telefone,email) values (?,?,?)";
		try {
			// abrir conexão
			Connection con = conectar();
			// preparar a query
			PreparedStatement pst = con.prepareStatement(create);
			// substituir parametros (?) pelo conteudo das variaveis JavaBeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			// executar a query
			pst.executeUpdate();
			// encerrar conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	//listar
	public ArrayList<JavaBeans> listarContatos() {
		// objeto para acessa classe JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from agenda order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				// populando arraylist
				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	/*CRUD UPDATE*/
	//selecionar o contato
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select *from agenda where id = ?";
		try {  
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getIdcon());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				//setar as variaveis JavaBeans
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//editar contato
	public void alterarContato(JavaBeans contato) {
		String create = "update agenda set nome=?,telefone=?,email=? where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getIdcon());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
