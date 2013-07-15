package grow.controllers;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.itextpdf.text.PageSize;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
 
public class PdfRevenueReportView extends AbstractPdfView{
 
	@Override
	protected void buildPdfDocument(
			Map model, 
			Document document,
			PdfWriter writer, 
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
	document.setMargins(20, 20, 20, 20);
		
		Map<String,String> revenueData = (Map<String,String>) model.get("revenueData");
 
		Table table = new Table(2);
		table.addCell("Month");
		table.addCell("Revenue");
 
		for (Map.Entry<String, String> entry : revenueData.entrySet()) {
			table.addCell(entry.getKey());
			table.addCell(entry.getValue());
                }
		
		String s1 = "11111111111111111111111111111111111";
		String s2 = "22222222222222222222222222222222222";
		String s3 = "33333333333333333333333333333333333333333333";
		String s4 = "444444444444444444444444444444444444444444444";
				
		Table tab = new Table(2);
		
		tab.addCell(s1);
		tab.addCell(s2);
		tab.addCell(s3);
		tab.addCell(s4);
 
		document.add(table);

		document.add(tab);
		
	}
}