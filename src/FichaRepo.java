import java.sql.ResultSet;
import java.util.ArrayList;

public class FichaRepo {
	private BD bd;
	
	 public FichaRepo(BD bd) {
		this.bd = bd;	
	}
	 public void cadastrar(Personagem personagem) {
		 String query = "INSERT INTO "
					+ "ficha "
					+ "(nome, sexo, classe, hp, origem)"
					+ "VALUES"
					+ "('" + personagem.getNome() + "', 	"
					+ " '" + personagem.getSexo() + "',  "	
					+ " '" + personagem.getClasse() + "', "
					+ " '" + personagem.getHp() + "', "
					+ " '" + personagem.getOrigem() + "');";
					 this.bd.executeUpdate(query); 
	 }
	
	 public Personagem obter(int id) {
		 String query = "SELECT * FROM ficha  WHERE id =" + id + ";";
		 ResultSet dados = this.bd.executeQuery(query);
		 Personagem personagem = new Personagem();
		 try {
			 dados.next();
			 
			 personagem.setId(dados.getInt("id"));
			 personagem.setNome(dados.getString("nome"));
			 personagem.setSexo(dados.getString("sexo"));
			 personagem.setClasse(dados.getString("Classe"));
			 personagem.setHp(dados.getInt("hp"));
			 personagem.setOrigem(dados.getString("Origem"));
			 
		 } catch (Exception e) {
			 System.err.println(e.getMessage());
			 } return personagem;
	 }
	 
	 public ArrayList<Personagem> listar() {
		 String query = "SELECT * FROM ficha;";
		 ResultSet dados = this.bd.executeQuery(query);
		 ArrayList<Personagem> personagens = new ArrayList <>();
		 try {
			 while(dados.next()) {
				 Personagem personagem = new Personagem();
				 personagem.setId(dados.getInt("id"));
				 personagem.setNome(dados.getString("nome"));
				 personagem.setSexo(dados.getString("sexo"));
				 personagem.setClasse(dados.getString("Classe"));
				 personagem.setHp(dados.getInt("hp"));
				 personagem.setOrigem(dados.getString("Origem"));
				 personagens.add(personagem);
			 }
		 } catch (Exception e) {
			 System.err.println(e.getMessage());
		 }
		 return personagens;
	 }
	 
	 public void excluir (int id) {
		 String query = "DELETE FROM ficha WHERE id =" + id + ";";
		 this.bd.executeUpdate(query);
	 }

	public void editar(Personagem personagem) {
		String query = "UPDATE ficha SET "
				+ "nome = '" + personagem.getNome() + "', "
				+ "sexo = '" + personagem.getSexo() + "', "
				+ "classe = '" + personagem.getClasse() + "', "
				+ "hp = '" + personagem.getHp() + "', "
				+ "origem = '" + personagem.getOrigem() + "' "
				+ "WHERE id = " + personagem.getId() + ";";
		this.bd.executeQuery(query);
	}
	 
	
	 
}
