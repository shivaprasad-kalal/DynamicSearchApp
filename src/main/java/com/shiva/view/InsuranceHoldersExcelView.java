package com.shiva.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.shiva.entity.Insurance;

@Component("excelView")
public class InsuranceHoldersExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// get model attribute data
		List<Insurance> insHolders = (List<Insurance>) model.get("holders");

		// create work sheet
		Sheet sheet = workbook.createSheet("Insurance Holders Report");

		Row row = sheet.createRow(0);

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		Cell cell = row.createCell(0);
		cell.setCellValue("PLAN ID");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(1);
		cell.setCellValue("PLAN NAME");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(2);
		cell.setCellValue("HOLDER NAME");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(3);
		cell.setCellValue("PLAN STATUS");
		cell.setCellStyle(headerCellStyle);

		cell = row.createCell(4);
		cell.setCellValue("SSN ID");
		cell.setCellStyle(headerCellStyle);

		// add rows
		int i = 1;
		for (Insurance ins : insHolders) {
			Row dataRow = sheet.createRow(i);
			dataRow.createCell(0).setCellValue(ins.getPlanId());
			dataRow.createCell(1).setCellValue(ins.getPlanName());
			dataRow.createCell(2).setCellValue(ins.getHolderName());
			dataRow.createCell(3).setCellValue(ins.getPlanStatus());
			dataRow.createCell(4).setCellValue(ins.getSsn());
			i++;
		}

	}

}
