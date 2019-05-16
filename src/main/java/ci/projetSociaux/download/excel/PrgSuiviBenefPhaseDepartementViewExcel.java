package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviBenefPhaseDepartementView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviBenefPhaseDepartementViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviBenefPhaseDepartementView> beneficiaireDepSelections = (List<PrgSuiviBenefPhaseDepartementView>)map.get("lesBeneficiaireDepSelection");

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
        for(PrgSuiviBenefPhaseDepartementView beneficiaireDepSelection : beneficiaireDepSelections){
            Row beneficiaireDepSelectionRow =  sheet.createRow(currentRow++);
            beneficiaireDepSelectionRow.createCell(0).setCellValue(beneficiaireDepSelection.getLibelleSelection());
			 beneficiaireDepSelectionRow.createCell(1).setCellValue(beneficiaireDepSelection.getNomDepartement());
			 
            beneficiaireDepSelectionRow.createCell(2).setCellValue(beneficiaireDepSelection.getNbMenageTot().intValue());
            beneficiaireDepSelectionRow.createCell(3).setCellValue(beneficiaireDepSelection.getEffTotMenage().intValue());
            beneficiaireDepSelectionRow.createCell(4).setCellValue(beneficiaireDepSelection.getEffTotHommeMenage().intValue());
			 beneficiaireDepSelectionRow.createCell(5).setCellValue(beneficiaireDepSelection.getEffTotFemmeMenage().intValue());
			 
			  beneficiaireDepSelectionRow.createCell(6).setCellValue(beneficiaireDepSelection.getNbMenageChefFemme().intValue());
            beneficiaireDepSelectionRow.createCell(7).setCellValue(beneficiaireDepSelection.getEffTotTotMenageChefFemme().intValue());
            beneficiaireDepSelectionRow.createCell(8).setCellValue(beneficiaireDepSelection.getEffTotHommeMenageChefFemme().intValue());
            beneficiaireDepSelectionRow.createCell(9).setCellValue(beneficiaireDepSelection.getEffTotFemmeMenageChefFemme().intValue());
			 
            beneficiaireDepSelectionRow.createCell(10).setCellValue(beneficiaireDepSelection.getNbMenageChefHomme().intValue());
            beneficiaireDepSelectionRow.createCell(11).setCellValue(beneficiaireDepSelection.getEffTotMenageChefHomme().intValue());
            beneficiaireDepSelectionRow.createCell(12).setCellValue(beneficiaireDepSelection.getEffTotHommeMenageChefHomme().intValue());
            beneficiaireDepSelectionRow.createCell(13).setCellValue(beneficiaireDepSelection.getEffTotFemmeMenageChefHomme().intValue());
			
			
	
           
        }

}
       
    }

