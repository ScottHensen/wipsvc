package ninja.wip;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import ninja.wip.CORSFilter;

@SpringBootApplication
public class WipsvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(WipsvcApplication.class, args);
	}
	
	@Bean
	@Transactional
	CommandLineRunner runner (BoardRepository br, TaskRepository tr) {
		return args -> {
			Board board1 = new Board("Board1");
			board1.setTeam("FooTeam");
			board1.setPerson("FooPerson");
			board1.setTasks(null);
			br.save(board1);
			
			tr.save(new Task("ninja", "frontend prototype", board1));
			tr.save(new Task("ninja", "backend prototype",  board1));
			tr.save(new Task("ninja", "frontend container", board1));

			tr.findAll().forEach( System.out::println );
			tr.findByName("Task 1b").forEach( System.out::println );

			List<Task> tasks1 = new ArrayList<Task>();
			tr.findAll().forEach(n -> tasks1.add(n));
			tasks1.forEach( System.out::println );
			
			board1.setTasks(tasks1);
			System.out.println("board1 tasks...");
			board1.getTasks().forEach(System.out::println);
			
			br.save(board1);
			br.findAll().forEach( System.out::println );

			
			
//			Arrays.asList("shit,shower,shave".split(","))
//			  .forEach(n -> tr.save(new Task(n)));
//			tr.findAll().forEach( System.out::println );
//			tr.findByTaskName("shower").forEach( System.out::println );

			
//			Set<Task> tasks = new HashSet<Task>();
//			Task task = new TaskBuilder().type("FooType")
//										 .name("FooName")
//										 .desc("FooDesc")
//										 .status("FooStatus")
//										 .person("FooPerson")
//										 .build();
//			tasks.add(task);
//			tr.save(task);
//
//			Board board = new Board("BoardBarName", "BoardBarTeam", "BoardBarPerson", tasks);
//			br.save(board);
		};
	}

	//Filter servlet requests, so that we can handle CORS
	@Bean
	public FilterRegistrationBean commonsRequestLoggingFilter()
	{
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new CORSFilter());
		return registrationBean;
	}

}
