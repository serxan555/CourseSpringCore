package az.connection;

import az.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DataManager {
////    AUTOWIRED VASITESILE
//    @Autowired
//    private DataSource dataSource;
//
////  SETTER METOU VASITESILE
////    public void setDataSource(DataSource dataSource) {
////        this.dataSource = dataSource;
////    }
////  CONSTRUCTOR VASITESILE
////    public DataManager(DataSource dataSource) {
////        this.dataSource = dataSource;
////    }
//
//    public void connect() throws SQLException {
//        Connection connection = dataSource.getConnection();
//        if (connection != null){
//            System.out.println("***Success***");
//        }
//    }
//    // JDBC TEMPLATE ILE YAZDIQDA YUXARIDAKILAR LAZIM DEYIL

    @Autowired
    protected JdbcTemplate jdbcTemplate;


}
