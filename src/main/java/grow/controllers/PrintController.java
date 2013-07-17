package grow.controllers;

import grow.daos.GrowDao;
import grow.entities.Grow;
import grow.entities.User;
import grow.pdf.PdfGen;

import java.io.OutputStream;
import java.io.StringBufferInputStream;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

@Controller
public class PrintController {


	/**
	 * 	MAIN INDEX OF THE SITE 
	 * 
	 * @param user - form from spring security 
	 * @param principal -  form from spring security
	 * @param result 
	 * @param mav 
	 * @return View of the main site.
	 */
	@RequestMapping(value="/print",method= RequestMethod.GET)
	public ModelAndView printChart(
			ModelAndView mav
			)
	{
		
	    	  mav.setViewName("print");
	   
	     	return mav;
	} 
	

	
	/**
	Generate a PDF
	 */
	@RequestMapping(value="/printPDF",method= RequestMethod.GET)
	public ModelAndView qweqwe(
			@ModelAttribute("grow") Grow grow,
			ModelAndView mav
			)
	{
			
			mav.setViewName("print");
			mav.getView().getContentType();
			
		
			PdfGen pg = new PdfGen();pg.pdfGenJava();

	     	return mav;
	} // end main index
	
	
	/**
	Generate a PDF
	 */
	@RequestMapping(value="/printPDF2",method= RequestMethod.GET)
	public ModelAndView printpdf2(
			@ModelAttribute("grow") Grow grow,
			ModelAndView mav,
			HttpServletResponse response,
			HttpServletRequest request
			)
	{
			mav.setViewName("print");
	        response.setContentType("application/pdf");
	        StringBuffer buf = new StringBuffer();
	        buf.append("&lt;html&gt;");
	        
	        String css = request.getContextPath()+"print.css";
	        //String css = getServletContext().getRealPath("/PDFservlet.css");
	        // put in some style
	        buf.append("&lt;head&gt;&lt;link rel='stylesheet' type='text/css' "+
	                "href='"+css+"' media='print'/&gt;&lt;/head&gt;");
	          try {
	            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	            Document doc = builder.parse(new StringBufferInputStream(buf.toString()));
	            ITextRenderer renderer = new ITextRenderer();
	            renderer.setDocument(doc, null);
	            renderer.layout();
	            OutputStream os = response.getOutputStream();
	            renderer.createPDF(os);
	            os.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	     	return mav;
	} 
	
	
	
	
	
	
	
	
	
}
