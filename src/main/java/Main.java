import dao.DataSetup;
import entities.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repo.PersonRepository;


public class Main {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSetup.class)) {
            PersonRepository personRepository = context.getBean(PersonRepository.class);
            //personRepository.getPeople().forEach(System.out::println);
            System.out.println(personRepository.getPersonById(2));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
