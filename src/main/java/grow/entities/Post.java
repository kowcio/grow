package grow.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * Post entity with fields <br />
 * id, title, content, add date
 * @author TalentLab1
 *
 */
@Entity
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column( unique = true, nullable = false)  
	int id;
	
	@NotNull(message="It cannot be null or empty.")
	@Length(min = 5, max = 30,message="Min 5 max 30 (ann)")
	@Column( unique = true, nullable = false)  
	String title;
	

	@Column( unique = false, nullable = false)  
	@Length(min = 5, max = 300,message="Min 5 max 300 (ann)")
	String content;
	
	@Column( unique = false, nullable = false)
	//@Transient
	Date addDate;

	//constructor and fabric
	
	private Post(){
		id = 0;
		title 	= "Default title ";
		content	="Default content";
	}
	
	private Post(String titleIN, String contentIN){
		id = 0;
		title = titleIN;
		content=contentIN;	
	}
	
	
	/**
	 * 	Returns a Post object with default vlaues of title and content. Id = 0;
	 * @return
	 */
	
	public static Post getNewPost(){
		return new Post();
	}
	
	
	/**
	 * Get new Post object with specified title and content values. ID arbitrary assumed = 0;
	 * @param title
	 * @param content
	 * @return	Post object.
	 */
	public static Post getNewPost(String title, String content){
		return new Post(title,content);		 
	}
	
	
	//methods
	
	/**
	 * 	Save the actuall date as creation date inside the current Post object.
	 * 	Sets the field addDate to current date of SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 * 
	 */
	
	public void saveCreationEditDate(){
	   //get current date time with Date()
	   Date date = new Date();
	   //date writes only date and zeroes the hour time
	   //http://www.h2database.com/html/datatypes.html#date_type
	   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   String dateBufferString = dateFormat.format(date);
	 
	try {
		addDate = dateFormat.parse(dateBufferString);
	} catch (ParseException e) {
		System.out.println("Error parsing date - saveAddedDate.Post");
	}


	}
	
	/**
	 * Util function to return the current date
	 * @return current date SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 */
	
	public static Date getCurrentDate(){
		   //get current date time with Date()
		   Date date = new Date();
		   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   String dateBufferString = dateFormat.format(date);
		try {
			date = dateFormat.parse(dateBufferString);
		} catch (ParseException e) {
			System.out.println("Error parsing date - saveAddedDate.Post");
		}
		return date;

		}
	
	/**
	 * Display information about the object - System.out.pritnln ( fields );
	 * also return the same output string.
	 * @return
	 */
	public String getDisplayPostInfo(){
		System.out.println(" Post =\n" +
				" id = "+id+"" +
				"title = "+title +
				"content = "+content +
				"addDate = "+addDate +""				
				);
		return " Post =\n" +
		" id = "+id+"" +
		"title = "+title +
		"content = "+content +
		"addDate = "+addDate +"";
	}
	
	/**
	 * Return the post fields inside html tags to put it on the page - depracated
	 * @return
	 * 	@Deprecated - better not use it
	 */
	@Deprecated
	public String getHTMLFormatWithClasses(){
 		return " " +
 				"<table class=\"PostTable\"><tr><td><b>"		+ id +
 				"</b>"										 	+ title +
 				"</td></tr><tr><td>"							+ content +
 				"</td></tr><tr><td>"							+ addDate +
 				"</td></tr></table>" ;
	}
	
	
	
	
	
	
	
	//setters getters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	

	
	
	

}
