package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgBeneficiaireView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgBeneficiaireViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgBeneficiaireView> beneficiaires = (List<PrgBeneficiaireView>)map.get("lesBeneficiaires");

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
        for(PrgBeneficiaireView beneficiaire : beneficiaires){
            Row beneficiaireRow =  sheet.createRow(currentRow++);
            beneficiaireRow.createCell(0).setCellValue(beneficiaire.getCodMenage());
            beneficiaireRow.createCell(1).setCellValue(beneficiaire.getNomChefMenage());
            beneficiaireRow.createCell(2).setCellValue(beneficiaire.getDateAffect().toString());
            beneficiaireRow.createCell(3).setCellValue(beneficiaire.getScorePrg());
            beneficiaireRow.createCell(4).setCellValue(beneficiaire.getNomRecipiendaire());
            beneficiaireRow.createCell(5).setCellValue(beneficiaire.getLibStatutBenef());
           
           
        }


       
    }
}
