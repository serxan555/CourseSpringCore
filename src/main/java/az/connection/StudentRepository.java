package az.connection;

import az.model.Student;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.List;

public class StudentRepository extends DataManager {


    public List<Student> getStudentList(){
        String query = "select * from students where status = 0";
        List<Student> students = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Student.class));
        return students;
    }
    public Student getStudentById(int id){
        String query = "select * from students where  id = ? and status = 1";
        Object[] objects = new Object[]{id};
        Student student = jdbcTemplate.queryForObject(query,objects,new BeanPropertyRowMapper<>(Student.class));
        return student;
    }
    public void addStudent(Student student){
        String query = "insert into students (name, surname, parent, birthDate, phone, gmail, gmailCode, gender, status) values (?,?,?,?,?,?,?,?,1)";
        Object[] data = new Object[]{student.getName(),student.getSurname(),student.getParent(),student.getBirthDate(),student.getPhone(),student.getGmail(),student.getGmailCode(), student.getGender()};
        int[] types = {Types.NVARCHAR, Types.NVARCHAR, Types.NVARCHAR, Types.DATE,Types.NVARCHAR, Types.NVARCHAR, Types.NVARCHAR, Types.NVARCHAR};
        jdbcTemplate.update(query,data,types);
    }
    public int addStudentWithLastid(Student student){
        String query = "insert into students (name, surname, parent, birthDate, phone, gmail, gmailCode, gender, status) values (?,?,?,?,?,?,?,?,1)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement statement = connection.prepareStatement(query, new String[]{"id"});
                statement.setString(1,student.getName());
                statement.setString(2,student.getSurname());
                statement.setString(3,student.getParent());
                statement.setDate(4,new Date(student.getBirthDate().getTime()));
                statement.setString(5,student.getPhone());
                statement.setString(6,student.getGmail());
                statement.setString(7,student.getGmailCode());
                statement.setString(8,student.getGender());
                return statement;
            }
        },keyHolder);
        return keyHolder.getKey().intValue();
    }
}
