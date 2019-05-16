package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviBenefPhaseLocaliteView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviBenefPhaseLocaliteViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviBenefPhaseLocaliteView> prgSuiviBenefPhaseLocaliteView = (List<PrgSuiviBenefPhaseLocaliteView>)map.get("lesPrgSuiviBenefPhaseLocaliteView");

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
        for(PrgSuiviBenefPhaseLocaliteView menage :prgSuiviBenefPhaseLocaliteView){
            Row menageRow =  sheet.createRow(currentRow++);
            menageRow.createCell(0).setCellValue(menage.getLibelleSelection());
            menageRow.createCell(1).setCellValue(menage.getNomLocalite());
            menageRow.createCell(2).setCellValue(menage.getNbMenageTot().intValue());
            menageRow.createCell(3).setCellValue(menage.getEffTotMenage().intValue());
            menageRow.createCell(4).setCellValue(menage.getEffTotHommeMenage().intValue());
            menageRow.createCell(5).setCellValue(menage.getEffTotFemmeMenage().intValue());
            menageRow.createCell(6).setCellValue(menage.getNbMenageChefFemme().intValue());
            menageRow.createCell(7).setCellValue(menage.getEffTotTotMenageChefFemme().intValue());
            menageRow.createCell(8).setCellValue(menage.getEffTotHommeMenageChefFemme().intValue());
            menageRow.createCell(9).setCellValue(menage.getEffTotFemmeMenageChefFemme().intValue());
            menageRow.createCell(10).setCellValue(menage.getNbMenageChefHomme().intValue());
            menageRow.createCell(11).setCellValue(menage.getEffTotMenageChefHomme().intValue());
            menageRow.createCell(12).setCellValue(menage.getEffTotHommeMenageChefHomme().intValue());
            menageRow.createCell(13).setCellValue(menage.getEffTotFemmeMenageChefHomme().intValue());
            
                       
        }


       
    }
}
