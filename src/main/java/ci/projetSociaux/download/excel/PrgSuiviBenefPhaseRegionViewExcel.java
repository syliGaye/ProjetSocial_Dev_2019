package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviBenefPhaseRegionView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviBenefPhaseRegionViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviBenefPhaseRegionView> beneficiaireRegSelections = (List<PrgSuiviBenefPhaseRegionView>)map.get("lesBeneficiaireRegSelection");

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
        for(PrgSuiviBenefPhaseRegionView beneficiaireRegSelection : beneficiaireRegSelections){
            Row beneficiaireRegSelectionRow =  sheet.createRow(currentRow++);
            beneficiaireRegSelectionRow.createCell(0).setCellValue(beneficiaireRegSelection.getLibelleSelection());
			 beneficiaireRegSelectionRow.createCell(1).setCellValue(beneficiaireRegSelection.getNomRegion());
			 
            beneficiaireRegSelectionRow.createCell(2).setCellValue(beneficiaireRegSelection.getNbMenageTot().intValue());
            beneficiaireRegSelectionRow.createCell(3).setCellValue(beneficiaireRegSelection.getEffTotMenage().intValue());
            beneficiaireRegSelectionRow.createCell(4).setCellValue(beneficiaireRegSelection.getEffTotHommeMenage().intValue());
			 beneficiaireRegSelectionRow.createCell(5).setCellValue(beneficiaireRegSelection.getEffTotFemmeMenage().intValue());
			 
			 
			 	beneficiaireRegSelectionRow.createCell(6).setCellValue(beneficiaireRegSelection.getNbMenageChefFemme().intValue());
	            beneficiaireRegSelectionRow.createCell(7).setCellValue(beneficiaireRegSelection.getEffTotTotMenageChefFemme().intValue());
	            beneficiaireRegSelectionRow.createCell(8).setCellValue(beneficiaireRegSelection.getEffTotFemmeMenageChefFemme().intValue());
	            beneficiaireRegSelectionRow.createCell(9).setCellValue(beneficiaireRegSelection.getEffTotHommeMenageChefFemme().intValue());
				
			 
            beneficiaireRegSelectionRow.createCell(10).setCellValue(beneficiaireRegSelection.getNbMenageChefHomme().intValue());
            beneficiaireRegSelectionRow.createCell(11).setCellValue(beneficiaireRegSelection.getEffTotMenageChefHomme().intValue());
            beneficiaireRegSelectionRow.createCell(12).setCellValue(beneficiaireRegSelection.getEffTotHommeMenageChefHomme().intValue());
            beneficiaireRegSelectionRow.createCell(13).setCellValue(beneficiaireRegSelection.getEffTotFemmeMenageChefHomme().intValue());
			
           
	
           
        }

}
       
    }

