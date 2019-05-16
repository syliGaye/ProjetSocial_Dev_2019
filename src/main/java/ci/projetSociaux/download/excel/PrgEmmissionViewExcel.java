package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgEmmissionView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgEmmissionViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgEmmissionView> emmissions = (List<PrgEmmissionView>)map.get("lesEmmissions");

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

        //POPULATE VALUE ROWS/COLUMNS dateDebEmm
        for(PrgEmmissionView emmission : emmissions){
            Row emmissionRow =  sheet.createRow(currentRow++);
            emmissionRow.createCell(0).setCellValue(emmission.getAnneePeriode());
            emmissionRow.createCell(1).setCellValue(emmission.getLibellePeriode());
            emmissionRow.createCell(2).setCellValue(emmission.getDateDebEmm().toString());
            emmissionRow.createCell(3).setCellValue(emmission.getNomLocalite());
            emmissionRow.createCell(4).setCellValue(emmission.getVillageQuartier());
            emmissionRow.createCell(5).setCellValue(emmission.getCodMenage());
            emmissionRow.createCell(6).setCellValue(emmission.getNomChefMenage());
            emmissionRow.createCell(7).setCellValue(emmission.getMontantEmis().doubleValue());
          
           
        }


       
    }
}
