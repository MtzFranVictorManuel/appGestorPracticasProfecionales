package datos;

/**
 *
 * @author Martinez Franzoni Victor Manuel
 */
import java.sql.*;
import javax.sql.DataSource;


public class Conexion {
    private static final String JDBC_USER="root";
    private static final String JDBC_DATABASE="practicasprofecionales";
    private static final String JDBC_PASSWORD="123456";
    private static final String JDBC_URL = "jdbc:mysql://localhost/practicasprofecionales?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static Connection getConexion(){
        Connection connect = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        }
        catch(Exception excep){
            System.out.println("Error de conexion " + excep.getMessage());
        }
        return connect;
    }

    public static void close(ResultSet rSet){
        try{
            if(rSet != null){
                rSet.close();
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public static void close (PreparedStatement pStatement){
        try{
            if(pStatement != null){
                pStatement.close();
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    public static void close(Connection connect){
        try{
            if(connect != null){
                connect.close();
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

}
