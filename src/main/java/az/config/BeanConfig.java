package az.config;

import az.connection.DataManager;
import az.connection.StudentRepository;
import az.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource({"classpath:datasource.properties"})
public class BeanConfig {

    @Autowired
    private Environment environment;

    @Bean(name = "student")
//    @Scope(value = "singleton")
    public Student student(){
        return new Student();
    }

    @Bean(name = "studentP")
    @Scope(value = "prototype")
    public Student studentP(){
        return new Student();
    }

    @Bean(name = "dataSource")
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("driver"));
        dataSource.setUrl(environment.getRequiredProperty("url"));
        dataSource.setUsername(environment.getRequiredProperty("user"));
        dataSource.setPassword(environment.getRequiredProperty("password"));
        return dataSource;
    }

    @Bean(name = "dataManager")
    public DataManager dataManager(){
//      Autowired vasitesile asagidaki kimi
        return new DataManager();

//      SETTER VASITESILE YAZILARSA ASAGIDAKI KIMI
//        DataManager manager = new DataManager();
//        manager.setDataSource(dataSource());
//        return manager;

//      CONSTRUCTOR VASITESILE OLDUQDA ASAGIDAKI KIMI
//        DataManager manager = new DataManager(dataSource());
//          return manager;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    @Bean(name = "studentRepository")
    public StudentRepository studentRepository(){
        return new StudentRepository();
    }
}
