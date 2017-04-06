package training;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Contract
 *
 */
@Entity
public class Contract implements Serializable {
	@EmbeddedId
	private ContractId contractId;
	private Integer duration;
	private Double salary;
	
	@ManyToOne
	@JoinColumn(name="idTeam",referencedColumnName="id",insertable=false,updatable=false)
	private Team team;
	
	@ManyToOne
	@JoinColumn(name="idPlayer",referencedColumnName="id",insertable=false,updatable=false)
	private Player player;
	private static final long serialVersionUID = 1L;

	public Contract() {
		super();
	}

	public Contract(Integer duration, Double salary, Team team, Player player) {
		super();
		this.contractId=new ContractId(player.getId(), team.getId());
		this.duration = duration;
		this.salary = salary;
		this.team = team;
		this.player = player;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
