package ninja.wip;

import java.util.Collection;

import ninja.wip.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository <Board,Long> 
{
	// select * from boards where name = :bk;
	Collection<Board> findByName (String bk);
}
