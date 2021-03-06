package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgEmmissionPeriodeView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgEmmissionPeriodeViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgEmmissionPeriodeView> emmissions = (List<PrgEmmissionPeriodeView>)map.get("lesEmmissions");

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
        for(PrgEmmissionPeriodeView emmission : emmissions){
            Row emmissionRow =  sheet.createRow(currentRow++);
            emmissionRow.createCell(0).setCellValue(emmission.getCodPeriode());
            emmissionRow.createCell(1).setCellValue(emmission.getLibellePeriode());
            emmissionRow.createCell(2).setCellValue(emmission.getDateDebEmm().toString());
            emmissionRow.createCell(3).setCellValue(emmission.getDateFinEmm().toString());
            emmissionRow.createCell(4).setCellValue(emmission.getStatutPeriode());
            emmissionRow.createCell(5).setCellValue(emmission.getNbEmmissionBenef().intValue());
           // emmissionRow.createCell(6).setCellValue(emmission.getTotEmmissionBenef().intValue());
           
        }


       
    }
}
