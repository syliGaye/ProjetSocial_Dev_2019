package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviRsuMenageMoisViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviRsuMenageMoisView> menageMois = (List<PrgSuiviRsuMenageMoisView>)map.get("lesMenageMois");

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
        for(PrgSuiviRsuMenageMoisView menageMoi : menageMois){
            Row menageMoiRow =  sheet.createRow(currentRow++);
            menageMoiRow.createCell(0).setCellValue(menageMoi.getAnnee().intValue());
			menageMoiRow.createCell(1).setCellValue(menageMoi.getLibelleMois());
			
            menageMoiRow.createCell(2).setCellValue(menageMoi.getNbMenage().intValue());
            menageMoiRow.createCell(3).setCellValue(menageMoi.getEffTotal());
            menageMoiRow.createCell(4).setCellValue(menageMoi.getEffHomme());
			 menageMoiRow.createCell(5).setCellValue(menageMoi.getEffFemme());
			 
			
            menageMoiRow.createCell(6).setCellValue(menageMoi.getNbMemageChefFemme());
            menageMoiRow.createCell(7).setCellValue(menageMoi.getEffMembreFemme());
            menageMoiRow.createCell(8).setCellValue(menageMoi.getNbEffHommeFemme());
            menageMoiRow.createCell(9).setCellValue(menageMoi.getNbEffFemmeFemme());
            
            menageMoiRow.createCell(10).setCellValue(menageMoi.getNbMemageChefHomme());
            menageMoiRow.createCell(13).setCellValue(menageMoi.getEffMembreHomme());
            menageMoiRow.createCell(11).setCellValue(menageMoi.getEffHommeHomme());
            menageMoiRow.createCell(12).setCellValue(menageMoi.getEffHommeFemme());
			
            menageMoiRow.createCell(14).setCellValue(menageMoi.getNbMenagePauvreModel1());
            menageMoiRow.createCell(15).setCellValue(menageMoi.getNbMenageRicheModel1());
			
			 menageMoiRow.createCell(16).setCellValue(menageMoi.getNbMenagePauvreModel2());
            menageMoiRow.createCell(17).setCellValue(menageMoi.getNbMenageRicheModel2());
			
			 menageMoiRow.createCell(18).setCellValue(menageMoi.getNbMenagePauvreModel3());
            menageMoiRow.createCell(19).setCellValue(menageMoi.getNbMenageRicheModel3());
			
			 menageMoiRow.createCell(20).setCellValue(menageMoi.getNbMenagePauvreModel4());
            menageMoiRow.createCell(21).setCellValue(menageMoi.getNbMenageRicheModel4());
			
			 menageMoiRow.createCell(22).setCellValue(menageMoi.getNbMenagePauvreModel5());
            menageMoiRow.createCell(23).setCellValue(menageMoi.getNbMenageRicheModel5());
			
           
			
           
           
           
        }


       
    }
}
