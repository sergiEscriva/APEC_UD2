import Conexiones.ConexionMs;

import java.sql.ResultSet;
import java.sql.Statement;

public class mAIN {
	public static void main(String[] args) {
		ConexionMs conexionMs = new ConexionMs();
		try (Statement statement = conexionMs.getConnection().createStatement()){
			statement.execute("SELECT * from driver");
			ResultSet resultSet = statement.getResultSet();
			while (resultSet.next()){
				System.out.println(resultSet.getString("name"));
			}
		}catch (Exception e){
			
		}
	}
}
