package com.yassine.export;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileExporter {
	boolean exportDataToExcel(HttpServletResponse response, String fileName, String encodage);
	

}
