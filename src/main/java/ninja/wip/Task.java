package ninja.wip;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Task")
public class Task {

	private Long id;
	private String name;
	private String desc;
	private Board board;

	
	public Task() 
	{
		
	}
	
	public Task(String name) 
	{
		this.name = name;
	}

	public Task(String name, Board board)
	{
		this.name  = name;
		this.board = board;
	}

	public Task(String name, String desc, Board board)
	{
		this.name  = name;
		this.board = board;
		this.desc  = desc;
	}

	
	
	@Id 
	@GeneratedValue
	public Long getId() 
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@ManyToOne
	@JoinColumn(name = "board_id")
	public Board getBoard() 
	{
		return board;
	}
	
	public void setBoard(Board board)
	{
		this.board = board;
	}
	
	@Override
	public String toString() {
		return "Task{" + 
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}

}
