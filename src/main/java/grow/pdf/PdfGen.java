package grow.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

public class PdfGen {

	
	
    public static void main(String[] args) 
            throws IOException, DocumentException {
        String File_To_Convert = "print.html";
        String url = new File(File_To_Convert).toURI().toURL().toString();
        System.out.println(""+url);
        String HTML_TO_PDF = "ConvertedFile.pdf";
        OutputStream os = new FileOutputStream(HTML_TO_PDF);       
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(url);      
        renderer.layout();
        renderer.createPDF(os);        
        os.close();
    }
	
	
	
	public void pdfGenJava(){

		System.out.println(" START pdf generate");

		
		//get node as in JS.
		
		
	    try {
	String inputFile ="print.html";
			String url = new File(inputFile).toURI().toURL().toString();

			System.out.println(" URL => "+url);
			
	String outputFile = "firstdoc.pdf";
			OutputStream os = new FileOutputStream(outputFile);
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocument(url);
			renderer.layout();
			renderer.createPDF(os);
			os.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
		
		System.out.println(" END pdf generate");

	}
	
	
}
