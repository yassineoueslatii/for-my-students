package com.yassine.export;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.yassine.SERVICE.IArticleService;
import com.yassine.entities.Article;
import com.yassine.utils.ApplicationConstants;

import antlr.StringUtils;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ArticleExport implements FileExporter  {
	@Autowired
	IArticleService art;
	
	private static final String FILE_NAME="liste des articles";
	@Override
	public boolean exportDataToExcel(HttpServletResponse response, String fileName, String encodage) {
		if(org.springframework.util.StringUtils.isEmpty(fileName)) {
			fileName= FILE_NAME;
		}
		if(org.springframework.util.StringUtils.isEmpty(encodage)) {
			encodage= ApplicationConstants.DEFAULT_ENCODAGE;
		}
		response.setContentType(ApplicationConstants.EXCEL_CONTENT_TYPE);
		response.setHeader("Content-disposition", "attachement; filename=" + fileName+".xls");
		WorkbookSettings workbookSettings=new WorkbookSettings();
		
		OutputStream outStream = null;
		try {
			
			 outStream= response.getOutputStream(); 
			 WritableWorkbook workbook = Workbook.createWorkbook(outStream, workbookSettings);
			WritableSheet sheet=workbook.createSheet("Yaassine", 0);
			Label labelCode= new Label(0,0,ApplicationConstants.NOM_ARTICLE);
			labelCode.setCellFeatures(new WritableCellFeatures());
			labelCode.getCellFeatures().setComment("");
			sheet.addCell(labelCode);
			
			Label labelContenu= new Label(1,0,ApplicationConstants.CONTENU);
			labelContenu.setCellFeatures(new WritableCellFeatures());
			labelContenu.getCellFeatures().setComment("");
			sheet.addCell(labelContenu);
			int currentrow=1;
			List<Article> article= art.selectAll();
			if (article != null && !article.isEmpty()) {
				for (Article article2 : article) {
					
					sheet.addCell(new Label(0, currentrow,article2.getNomArticle()));
					sheet.addCell(new Label(1, currentrow,article2.getContenu()));
					currentrow++;
				}
				CellView cellView = new CellView();
				cellView.setAutosize(true);
				sheet.setColumnView(0, cellView);
				sheet.setColumnView(1, cellView);
				workbook.write();
				workbook.close();
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
			return true;
		} catch (Exception e) {
			e.fillInStackTrace();
			return false;
		}
	}

}
