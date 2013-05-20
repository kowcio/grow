package grow.entities;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;


@Entity
@Table(name = "grow")  

public class Grow implements Serializable {
	/*	@PostConstruct	void init(){	}	*/

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column( unique = true, nullable = false)  
	int id;
	
	@Column(unique = false, nullable = false) 
	Long user_id;
	
	@Column(unique = false, nullable = false) 
	int grow_id;
	
	//string for each grow element
	@Column( unique = false, nullable = false) 	
	String grow_g;
	@Column( unique = false, nullable = false)
	String grow_r;
	@Column( unique = false, nullable = false)
	String grow_o;
	@Column( unique = false, nullable = false)
	String grow_w;
	
	/*
	 * 	KONSTRUKTORY
	 */
	/**
	 * Blank constructor for the grow object.
	 */
	public Grow(){	}
	
	/**
	 * public method returning a new grow object
	 * @return new Grow with default values
	 */
	public static Grow createGrow() {
		
	 Grow grow = new Grow();
	 grow.setGrow_g("New G");
	 grow.setGrow_r("New R");
	 grow.setGrow_o("New O");
	 grow.setGrow_w("New W");
	 
	return grow;
		
	}
	
	
	
	public Grow setDefaultGrow(Grow grow) {
		 grow.setGrow_g("Not loaded or no grow");
		 grow.setGrow_r("Not loaded or no grow R");
		 grow.setGrow_o("Not loaded or no grow O");
		 grow.setGrow_w("Not loaded or no grow W");
		 
		return grow;
			
		}
	
	
	
	
	/*
	 * 	SETTERS GETTERS
	 */
	public int getId() {		return id;	}
	public void setId(int id) {		this.id = id;	}
	public Long getUser_id() {		return user_id;	}
	public void setUser_id(Long long1) {		this.user_id = long1;	}
	public int getGrow_id() {		return grow_id;	}
	public void setGrow_id(int grow_id) {		this.grow_id = grow_id;	}
	
	public String getGrow_g() {		return grow_g;	}
	public void setGrow_g(String grow_g) {		this.grow_g = grow_g;	}
	public String getGrow_r() {		return grow_r;	}
	public void setGrow_r(String grow_r) {		this.grow_r = grow_r;	}
	public String getGrow_o() {		return grow_o;	}
	public void setGrow_o(String grow_o) {		this.grow_o = grow_o;	}
	public String getGrow_w() {		return grow_w;	}
	public void setGrow_w(String grow_w) {		this.grow_w = grow_w;	}
	
	
	
	//GetGrows by Hibernate
	public String getInfo(){
		//System.out.print("\n ==Grow_id = "+id+" \n ==UserId = "+user_id+" \n ==gid = "+grow_id+"\n ==main="+grow_main+"\n"				);
		return "\n ==Grow_id = "+id+" \n ==UserId = "+user_id+" \n ==gid = "+grow_id+"" +
		"\n";
	}

	@Override
	public String toString() {
		return "Grow [id=" + id + ", user_id=" + user_id + ", grow_id="
				+ grow_id + ", grow_g=" + grow_g + ", grow_r=" + grow_r
				+ ", grow_o=" + grow_o + ", grow_w=" + grow_w + "]";
	}
	
	

	
	
}
