package az.main;

import az.config.BeanConfig;
import az.connection.DataManager;
import az.connection.StudentRepository;
import az.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MainClass {

    @Autowired
    Student student;

    public static void main(String[] args) throws SQLException, ParseException {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Student student = (Student) context.getBean("student");


//        DataManager manager = (DataManager) context.getBean("dataManager");
//        DataManagerle yazarken asagidaki kimi olur
//        manager.connect();

//      JDBC TEMPLATE ILE ASAGIDAKI KIMI YAZILIR
        StudentRepository studentRepository = (StudentRepository) context.getBean("studentRepository");
//        System.out.println(studentRepository.getStudentList());
        System.out.println(studentRepository.getStudentById(190));
//        ADDSTUDENT
//        Student student = (Student) context.getBean("studentP");
//        student.setName("Raul");
//        student.setSurname("Semed");
//        student.setParent("Cesaret");
//        student.setBirthDate(dateFormat.parse("1995-05-07"));
//        student.setPhone("055-808-13-29");
//        student.setGmail("ssmdbyli@gmail.com");
//        student.setGmailCode("555ss777ss");
//        student.setGender("Male");
//        studentRepository.addStudent(student);
//        System.out.println(studentRepository.addStudentWithLastid(student));

    }

}
