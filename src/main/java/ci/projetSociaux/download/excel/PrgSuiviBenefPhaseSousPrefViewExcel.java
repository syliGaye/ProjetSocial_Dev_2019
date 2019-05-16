package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviBenefPhaseSousPrefView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviBenefPhaseSousPrefViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviBenefPhaseSousPrefView> benefPhaseSPs = (List<PrgSuiviBenefPhaseSousPrefView>)map.get("Suivi_Phase_A_SousPref");

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
        for(PrgSuiviBenefPhaseSousPrefView benefPhaseSP : benefPhaseSPs){
            Row benefPhaseSPRow =  sheet.createRow(currentRow++);
            benefPhaseSPRow.createCell(0).setCellValue(benefPhaseSP.getLibelleSelection());
			benefPhaseSPRow.createCell(1).setCellValue(benefPhaseSP.getNomSPref());
			 
           benefPhaseSPRow.createCell(2).setCellValue(benefPhaseSP.getNbMenageTot().intValue());
           benefPhaseSPRow.createCell(3).setCellValue(benefPhaseSP.getEffTotMenage().intValue());
           benefPhaseSPRow.createCell(4).setCellValue(benefPhaseSP.getEffTotHommeMenage().intValue());
		   benefPhaseSPRow.createCell(5).setCellValue(benefPhaseSP.getEffTotFemmeMenage().intValue());
			 
		   benefPhaseSPRow.createCell(6).setCellValue(benefPhaseSP.getNbMenageChefFemme().intValue());
           benefPhaseSPRow.createCell(7).setCellValue(benefPhaseSP.getEffTotTotMenageChefFemme().intValue());
           benefPhaseSPRow.createCell(8).setCellValue(benefPhaseSP.getEffTotHommeMenageChefFemme().intValue());
           benefPhaseSPRow.createCell(9).setCellValue(benefPhaseSP.getEffTotFemmeMenageChefFemme().intValue());
			 
           benefPhaseSPRow.createCell(10).setCellValue(benefPhaseSP.getNbMenageChefHomme().intValue());
           benefPhaseSPRow.createCell(11).setCellValue(benefPhaseSP.getEffTotMenageChefHomme().intValue());
           benefPhaseSPRow.createCell(12).setCellValue(benefPhaseSP.getEffTotHommeMenageChefHomme().intValue());
           benefPhaseSPRow.createCell(13).setCellValue(benefPhaseSP.getEffTotFemmeMenageChefHomme().intValue());

        }

    }
}
