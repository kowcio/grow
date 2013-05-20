package grow.controllers;


import grow.daos.PostDAO;
import grow.entities.Post;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Admin controller.
 * @author TalentLab1
 *
 */
@Controller
public class AdminController {

	/**
	 * Main index for admin is moved tothe root url "/" of application where the jps`s views includes 		<br />
	 * generate content from the authorities roles of logged user / non logged user.						<br />		
	 * Don`t use this url.																					<br />	
	 * 
	 * @return
	 */
	//@Deprecated
	@RequestMapping(value="/adminPanel",method= RequestMethod.GET)
	public ModelAndView indexForAdmin() {
		System.out.println(" Loading Admin panel");
		ModelAndView mav = new ModelAndView("/admin/adminPanel");
		
		//load posts list
		PostDAO dao = new PostDAO();
		if (dao.getAllPosts() == null){
			mav.addObject("postEMPTY" , "postListIsNull");
			System.out.println("PostList empty");
		}
		else mav.addObject("PostsList" , dao.getAllPosts() );
	
		
		//display delete link for admin
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    for (GrantedAuthority grantedAuthority : auth.getAuthorities()) {
			boolean isRolePresent = false;
	    	isRolePresent = grantedAuthority.getAuthority().equals("666");
	        if (isRolePresent) {	mav.addObject("ifadmin", "ok"); break;
	        }
	      }
		System.out.println(" Authorities => " + auth.getAuthorities().toString());
		
		
		
		
		return mav;

	}
	
	
	/**
	 * Shows the given post 
	 * @param postNo
	 * @return
	 */
	@RequestMapping(value="/adminPanel/post/{postNo}",method= RequestMethod.GET)
	public ModelAndView showEditFormToUpdatePost(
			@PathVariable("postNo") int postNo
			) {
		System.out.println(" Loading edit of post"+postNo);
		ModelAndView mav = new ModelAndView("/admin/editPostNo");
		PostDAO dao = new PostDAO();
		Post post = dao.getPostByID(postNo);
		if (post == null)
		{
			mav.addObject("postEMPTY" , "pos with given id = "+postNo +" does not exist in databse");
			mav.addObject("post" , post = Post.getNewPost("Brak", "Brak") );
		}
		else mav.addObject("post" , post );
		
		return mav;
		
	}
	
	/**
	 * Posts edit form for admin user, the old value can be see after editing on the same view.
	 * @param postNo
	 * @return
	 */
	@RequestMapping(value="/adminPanel/edit/{postNO}",method= RequestMethod.POST)
	public ModelAndView saveorUpdateTheEditedPostByAdmin(
			@ModelAttribute("post") @Valid Post updatedPost, 
			BindingResult result
			) {
		System.out.println(" Loading form after edit post");
		ModelAndView mav = new ModelAndView("/admin/editPostNo");
		PostDAO dao = new PostDAO();
		
		//load old data based on new ID vlaue that can be changed - that sucks...
		//need to rethink the model		
		
		mav.addObject("oldpost" , dao.getPostByID(updatedPost.getId()));

		  if (result.hasErrors()){
			  mav.addObject("allNotOK" , "post id = "+updatedPost.getId() +" update had an error");
			  return mav;
	  }
		  else
		  {
					try {
						dao.updatePost(updatedPost);
						mav.addObject("post" , updatedPost  );
						mav.addObject("allOK" , "post id = "+updatedPost.getId() +" update OK !!");
				//add redirect
						
						mav.addObject("redir" ,"<meta http-equiv=\"Refresh\" content=\"4; url=http://localhost:8080/Blog/adminPanel\"/>" );
						
					} catch (Exception e) {
						mav.addObject("allNotOK" , "post id = "+updatedPost.getId() +" update had an error");
						e.printStackTrace();
					}
		  }
	
		
		return mav;
		
	}
	
	
	
}