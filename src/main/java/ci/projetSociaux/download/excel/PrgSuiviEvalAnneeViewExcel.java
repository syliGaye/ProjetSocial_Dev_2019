package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviEvalAnneeView;
import ci.projetSociaux.entity.PrgSuiviPlainteAnneeView;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;


public class PrgSuiviEvalAnneeViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviEvalAnneeView> suiviplaiements = (List<PrgSuiviEvalAnneeView>)map.get("lesuivipaiement");

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
        for(PrgSuiviEvalAnneeView suiviplaiement : suiviplaiements){
            Row virementRow =  sheet.createRow(currentRow++);
           
            
            virementRow.createCell(0).setCellValue(suiviplaiement.getAnneePeriode().intValue());
            
            virementRow.createCell(1).setCellValue(suiviplaiement.getNbTotalEmission().intValue());
            virementRow.createCell(2).setCellValue(suiviplaiement.getMtTotalEmission().intValue());
            virementRow.createCell(3).setCellValue(suiviplaiement.getNbTotalPaye().intValue());
            virementRow.createCell(4).setCellValue(suiviplaiement.getMtTotalPaye().intValue());
            virementRow.createCell(5).setCellValue(suiviplaiement.getNbTotalNonPaye().intValue());
            virementRow.createCell(6).setCellValue(suiviplaiement.getMtTotalNonPaye().intValue());
            
            virementRow.createCell(7).setCellValue(suiviplaiement.getNbTotalEmissionHomme().intValue());
            virementRow.createCell(8).setCellValue(suiviplaiement.getMtTotalEmissionHomme().intValue());
            virementRow.createCell(9).setCellValue(suiviplaiement.getNbTotalPayeHomme().intValue());
            virementRow.createCell(10).setCellValue(suiviplaiement.getMtTotalPayeHomme().intValue());
            virementRow.createCell(11).setCellValue(suiviplaiement.getNbTotalNonPayeHomme().intValue());
            virementRow.createCell(12).setCellValue(suiviplaiement.getMtTotalNonPayeHomme().intValue());
            
            virementRow.createCell(13).setCellValue(suiviplaiement.getNbTotalEmissionFemme().intValue());
            virementRow.createCell(14).setCellValue(suiviplaiement.getMtTotalEmissionFemme().intValue());
            virementRow.createCell(15).setCellValue(suiviplaiement.getNbTotalPayeFemme().intValue());
            
            virementRow.createCell(16).setCellValue(suiviplaiement.getMtTotalPayeFemme().intValue());
            virementRow.createCell(17).setCellValue(suiviplaiement.getNbTotalNonPayeFemme().intValue());
            virementRow.createCell(18).setCellValue(suiviplaiement.getMtTotalNonPayeFemme().intValue());
           
         
        }



       
    }
}
