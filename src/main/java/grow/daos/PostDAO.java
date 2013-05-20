package grow.daos;

import grow.entities.Post;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PostDAO {

		/**
	 *Save a Post class  into the user table
	 *
	 * @param  Post post  
	 * @return 
	 */
	
	public String savePost(Post post){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
	   	try {
	   		Session session = fabrykaHibernejta.getNewSessionAnnotations();
	   		System.out.println("Wypisanie rzeczy w zwiazlku z embedded SessioNFactory pobranym z dispatchera");
	   		System.out.println("");
			System.out.println("Saving Record");
			Transaction tx = session.beginTransaction();
			post.getDisplayPostInfo();

			//setting the date of adding the post
			post.saveCreationEditDate();
			session.save(post);
			tx.commit();
			System.out.println("Post id = "+post.getId()+" added !");
			return "OK";
		} catch (Exception e) {
			System.out.println("Cos sie wysypalo - FigureBoxDAO");
			 e.printStackTrace();
			 return "notOK";
		}

	}   	
	
	
	
	/**
	 * 
	 * @return All posts as list.
	 */
	
	
	@SuppressWarnings("unchecked")
	public List<Post> getAllPosts(){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
		List<Post> postsList = null;
	   	try {
			Session session = fabrykaHibernejta.getNewSessionAnnotations();
			Transaction tx = session.beginTransaction();
			postsList = (List<Post>)session.createQuery("from Post").list();
		   	System.out.println("PostsList count = "+postsList.size());	
			tx.commit();
	   	} catch (Exception e) {
			System.out.println("Cos sie wysypalo - PostDAO - getAllPosts");
			 e.printStackTrace();
		}
	   
	   	
	   	return postsList;
	}

	/**
	 * Return Post by ID.
	 * 
	 * @param postId - Posts ID which we wish to load.
	 * @return	Specified Post
	 */
	
	
	public Post getPostByID(int postId){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
		Post post = Post.getNewPost();
	   	try {
			Session session = fabrykaHibernejta.getNewSessionAnnotations();
			Transaction tx = session.beginTransaction();
			
			post = (Post) session.get(Post.class, postId);
			
			tx.commit();
	   	} catch (Exception e) {
			System.out.println("Cos sie wysypalo - getPostByID");
			 e.printStackTrace();
		}
	   
		System.out.println("Pobrano post, id = "+postId);
	   	return post;
	}

/**	Update a Post object in db.
 * 
 * @param post Post which we wish to update. Needs to have a specified ID.
 */

	public void updatePost(Post post){
		HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
	   	try {
			Session session = fabrykaHibernejta.getNewSessionAnnotations();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(post);
			tx.commit();
	   	} catch (Exception e) {
			System.out.println("Cos sie wysypalo - getPostByID");
			 e.printStackTrace();
		}
		System.out.println("Update post = "+post.getDisplayPostInfo());
	}


	/**	Delete in db a Post object by given ID.
	 * 
	 * @param Needs to have a specified ID.
	 */

		public void deletePost(int id){
			HibGetDBSession fabrykaHibernejta = new HibGetDBSession();
		   	try {
				Session session = fabrykaHibernejta.getNewSessionAnnotations();
				PostDAO post = new PostDAO();
				Transaction tx = session.beginTransaction();
		   		System.out.println("Before delete");
		   		session.delete(post.getPostByID(id));
		   		System.out.println("After delete");
				tx.commit();

		   	} catch (IllegalArgumentException e) {  
		   		System.out.println(" No post by that id");
				 e.printStackTrace();
	        }  	catch (Exception e) {
				System.out.println("Cos sie wysypalo - DeletePostByID");
			}
		}


	
	
	

}
