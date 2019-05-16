package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgPaiementView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PaiementMenageViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgPaiementView> paiements = (List<PrgPaiementView>)map.get("lesPaiementMenages");

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
        for(PrgPaiementView menage : paiements){
            Row menageRow =  sheet.createRow(currentRow++);
            menageRow.createCell(0).setCellValue(menage.getLibellePeriode());
            menageRow.createCell(1).setCellValue(menage.getDatePaiement().toString());
            menageRow.createCell(2).setCellValue(menage.getNomSPref());
            menageRow.createCell(3).setCellValue(menage.getNomLocalite());
            menageRow.createCell(4).setCellValue(menage.getIdRecipiendaire());
            menageRow.createCell(5).setCellValue(menage.getNomRecipiendaire());
            menageRow.createCell(6).setCellValue(menage.getTelRecipiendaire());
            menageRow.createCell(7).setCellValue(menage.getRaisonSocialAp());
            menageRow.createCell(8).setCellValue(menage.getMontantPaiement().intValue());
            menageRow.createCell(9).setCellValue(menage.getLibStatutPaiement());
            
          /*   menageRow.createCell(7).setCellValue(menage.getEffModel4());
            menageRow.createCell(8).setCellValue(menage.getEffModel5());
            menageRow.createCell(4).setCellValue(menage.getEffMenage());
            menageRow.createCell(5).setCellValue(menage.getEffHomme());
            menageRow.createCell(6).setCellValue(menage.getEffFemme());
            menageRow.createCell(7).setCellValue(menage.getEffMineur());
            menageRow.createCell(8).setCellValue(menage.getEffEnceinte());*/
           
        }


       
    }
}
