/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.StudentDTO;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author zS18019639
 */
public interface StudentDao {
    public List<StudentDTO> select() throws SQLException;
    
    public int insert(StudentDTO student) throws SQLException;
    
    public int update(StudentDTO student) throws SQLException;
    
    public int delete(StudentDTO student) throws SQLException;
}
