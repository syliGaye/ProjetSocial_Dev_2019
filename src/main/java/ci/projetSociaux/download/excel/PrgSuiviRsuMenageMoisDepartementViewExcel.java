package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisDepartementView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviRsuMenageMoisDepartementViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviRsuMenageMoisDepartementView> menageMoiDeps = (List<PrgSuiviRsuMenageMoisDepartementView>)map.get("lesMenageMoiDeps");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet(sheetName);
        sheet.setDefaultColumnWidth(30);

        int currentRow = 0;
        short currentColumn = 0;

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

        // create header row
        Row headerRow = sheet.createRow(currentRow);
        for(String header: headers){
            headerRow.createCell(currentColumn).setCellValue(header);
            headerRow.getCell(currentColumn).setCellStyle(style);
            currentColumn++;
        }

        currentRow++;//exclude header

        //POPULATE VALUE ROWS/COLUMNS
        for(PrgSuiviRsuMenageMoisDepartementView menageMoiDep : menageMoiDeps){
            Row menageMoiDepRow =  sheet.createRow(currentRow++);
            menageMoiDepRow.createCell(0).setCellValue(menageMoiDep.getAnnee().intValue());
			menageMoiDepRow.createCell(1).setCellValue(menageMoiDep.getLibelleMois());
			 menageMoiDepRow.createCell(2).setCellValue(menageMoiDep.getNomDepartement());
			 
            menageMoiDepRow.createCell(3).setCellValue(menageMoiDep.getNbMenage().intValue());
            menageMoiDepRow.createCell(4).setCellValue(menageMoiDep.getEffTotal().intValue());
            menageMoiDepRow.createCell(5).setCellValue(menageMoiDep.getEffHomme().intValue());
			 menageMoiDepRow.createCell(6).setCellValue(menageMoiDep.getEffFemme().intValue());
			 
			 
			menageMoiDepRow.createCell(7).setCellValue(menageMoiDep.getNbMemageChefFemme().intValue());
			menageMoiDepRow.createCell(8).setCellValue(menageMoiDep.getEffMembreFemme().intValue());
            menageMoiDepRow.createCell(9).setCellValue(menageMoiDep.getNbEffHommeFemme().intValue());
            menageMoiDepRow.createCell(10).setCellValue(menageMoiDep.getNbEffFemmeFemme().intValue());
            
			 
            menageMoiDepRow.createCell(11).setCellValue(menageMoiDep.getNbMemageChefHomme().intValue());
		    menageMoiDepRow.createCell(12).setCellValue(menageMoiDep.getEffMembreHomme().intValue());
            menageMoiDepRow.createCell(13).setCellValue(menageMoiDep.getEffHommeHomme().intValue());
            menageMoiDepRow.createCell(14).setCellValue(menageMoiDep.getEffHommeFemme().intValue());
           
			
          
			
            menageMoiDepRow.createCell(15).setCellValue(menageMoiDep.getNbMenagePauvreModel1().intValue());
            menageMoiDepRow.createCell(16).setCellValue(menageMoiDep.getNbMenageRicheModel1().intValue());
			
			 menageMoiDepRow.createCell(17).setCellValue(menageMoiDep.getNbMenagePauvreModel2().intValue());
            menageMoiDepRow.createCell(18).setCellValue(menageMoiDep.getNbMenageRicheModel2().intValue());
			
			 menageMoiDepRow.createCell(19).setCellValue(menageMoiDep.getNbMenagePauvreModel3().intValue());
            menageMoiDepRow.createCell(20).setCellValue(menageMoiDep.getNbMenageRicheModel3().intValue());
			
			 menageMoiDepRow.createCell(21).setCellValue(menageMoiDep.getNbMenagePauvreModel4().intValue());
            menageMoiDepRow.createCell(22).setCellValue(menageMoiDep.getNbMenageRicheModel4().intValue());
			
			 menageMoiDepRow.createCell(23).setCellValue(menageMoiDep.getNbMenagePauvreModel5().intValue());
            menageMoiDepRow.createCell(24).setCellValue(menageMoiDep.getNbMenageRicheModel5().intValue());
			
           
			
           
           
           
        }


       
    }
}

