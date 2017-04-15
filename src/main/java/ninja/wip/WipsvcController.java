package ninja.wip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class WipsvcController {

	@Autowired BoardRepository boardRepo;
	@Autowired TaskRepository  taskRepo;
	
	//Spring-Rest-Repo is GIVING you all the repo-mapping-to-rest; only code overrides and nuanced stuff here
	//   ...like if you want to write to redis/rabbit for a POST; that's something you'll build here.

}
