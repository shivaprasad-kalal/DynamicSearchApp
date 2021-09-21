package com.shiva.view;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.shiva.entity.Insurance;

@Component("pdfView")
public class InsuranceHoldersPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get model attribute data
		List<Insurance> insHolders = (List<Insurance>) model.get("holders");

		response.setHeader("Content-Disposition",
				"attachment; filename=Insurance_Holders_Details_" + new Date() + ".pdf");
		// create paragraph
		Paragraph para = new Paragraph("Insurance Holders Report", new Font(Font.HELVETICA, 20, Font.BOLD));
		para.setAlignment(Element.ALIGN_CENTER);
		// add paragramp to document
		document.add(para);

		// add table
		PdfPTable t = new PdfPTable(5);
		t.setWidthPercentage(100);
		t.setSpacingBefore(20);

		// Font
		Font font = new Font(Font.HELVETICA, 12, Font.BOLD, Color.WHITE);
	
		// create cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.GREEN);
		
		// add header cells to table
		cell.setPhrase(new Phrase("PLAN ID", font));
		t.addCell(cell);

		cell.setPhrase(new Phrase("PLAN NAME", font));
		t.addCell(cell);

		cell.setPhrase(new Phrase("HOLDER NAME", font));
		t.addCell(cell);

		cell.setPhrase(new Phrase("PLAN STATUS", font));
		t.addCell(cell);

		cell.setPhrase(new Phrase("SSN ID", font));
		t.addCell(cell);

		// adding data to table rows
		for (Insurance ins : insHolders) {
			t.addCell(String.valueOf(ins.getPlanId()));
			t.addCell(ins.getPlanName());
			t.addCell(ins.getHolderName());
			t.addCell(ins.getPlanStatus());
			t.addCell(String.valueOf(ins.getSsn()));
		}
		document.add(t);
		document.close();
	}
}
