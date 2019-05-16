package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgHistoRecipiendaireView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgHistoRecipiendaireViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgHistoRecipiendaireView> historiques = (List<PrgHistoRecipiendaireView>)map.get("Histo_Recipiendaire");

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
        for(PrgHistoRecipiendaireView historique : historiques){
            Row historiqueRow =  sheet.createRow(currentRow++);
            historiqueRow.createCell(0).setCellValue(historique.getIdHistoRecipiendaire());
			historiqueRow.createCell(1).setCellValue(historique.getNomRecipiendaire());
            historiqueRow.createCell(2).setCellValue(historique.getTelRecipiendaire());
            historiqueRow.createCell(3).setCellValue(historique.getRaisonSocialAp());
            historiqueRow.createCell(4).setCellValue(historique.getNomChefMenage());
         
            historiqueRow.createCell(5).setCellValue(historique.getGenre());
            historiqueRow.createCell(6).setCellValue(historique.getNomRegion());
            historiqueRow.createCell(7).setCellValue(historique.getNomDepartement());
            historiqueRow.createCell(8).setCellValue(historique.getNomSPref());
            historiqueRow.createCell(9).setCellValue(historique.getNomLocalite());
           
        }
    }
}
