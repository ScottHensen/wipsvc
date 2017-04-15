package ninja.wip;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository <Task,Long> 
{
	// select * from tasks where name = :bk;
	Collection<Task> findByName (String tk);
}
