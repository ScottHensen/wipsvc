package ninja.wip;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ninja.wip.Task; 

@Entity(name = "Board")
public class Board {
	
	private Long id;
	private String name;
	private String team;
	private String person;
	private List<Task> tasks;

	// JPA requires a no-args constructor (note lombok @Data provides this)
	public Board() {
		
	}
	
	public Board(String name) {
		this.name = name;
	}
	

	
	@Id 
	@GeneratedValue
	@Column(name = "board_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	@OneToMany
	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	@Override
	public String toString() {
		String result = String.format(
				"Board[id=%d, name='%s]%n", 
				id, name);
//		if (tasks != null) {
//			for(Task task : tasks) {
//				result += String.format(
//						"Task[id=%d, name='%s']%n", 
//						task.toString());
//			}
//		}
		return result;
	}
	
}
