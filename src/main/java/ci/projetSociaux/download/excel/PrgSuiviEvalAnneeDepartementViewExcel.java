package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviEvalAnneeDepartementView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviEvalAnneeDepartementViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviEvalAnneeDepartementView> paiementDepAnnees = (List<PrgSuiviEvalAnneeDepartementView>)map.get("lesPaiementsDepAnnees");

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
        for(PrgSuiviEvalAnneeDepartementView paiementDepAnnee : paiementDepAnnees){
            Row paiementDepAnneeRow =  sheet.createRow(currentRow++);
            paiementDepAnneeRow.createCell(0).setCellValue(paiementDepAnnee.getAnneePeriode().intValue());
			 paiementDepAnneeRow.createCell(1).setCellValue(paiementDepAnnee.getNomDepartement());
			 
            paiementDepAnneeRow.createCell(2).setCellValue(paiementDepAnnee.getNbTotalEmission().intValue());
            paiementDepAnneeRow.createCell(3).setCellValue(paiementDepAnnee.getMtTotalEmission().doubleValue());
            paiementDepAnneeRow.createCell(4).setCellValue(paiementDepAnnee.getNbTotalPaye().intValue());
			 paiementDepAnneeRow.createCell(5).setCellValue(paiementDepAnnee.getMtTotalPaye().doubleValue());
            paiementDepAnneeRow.createCell(6).setCellValue(paiementDepAnnee.getNbTotalNonPaye().intValue());
            paiementDepAnneeRow.createCell(7).setCellValue(paiementDepAnnee.getMtTotalNonPaye().doubleValue());
			
            paiementDepAnneeRow.createCell(8).setCellValue(paiementDepAnnee.getNbTotalEmissionFemme().intValue());
            paiementDepAnneeRow.createCell(9).setCellValue(paiementDepAnnee.getMtTotalEmissionFemme().doubleValue());
            paiementDepAnneeRow.createCell(10).setCellValue(paiementDepAnnee.getNbTotalPayeFemme().intValue());
            paiementDepAnneeRow.createCell(11).setCellValue(paiementDepAnnee.getMtTotalPayeFemme().doubleValue());
            paiementDepAnneeRow.createCell(12).setCellValue(paiementDepAnnee.getNbTotalNonPayeFemme().intValue());
            paiementDepAnneeRow.createCell(13).setCellValue(paiementDepAnnee.getMtTotalNonPayeFemme().doubleValue());
			
            paiementDepAnneeRow.createCell(14).setCellValue(paiementDepAnnee.getNbTotalEmissionHomme().intValue());
            paiementDepAnneeRow.createCell(15).setCellValue(paiementDepAnnee.getMtTotalEmissionHomme().doubleValue());
			 paiementDepAnneeRow.createCell(16).setCellValue(paiementDepAnnee.getNbTotalPayeHomme().intValue());
			 paiementDepAnneeRow.createCell(17).setCellValue(paiementDepAnnee.getMtTotalPayeHomme().doubleValue());
            paiementDepAnneeRow.createCell(18).setCellValue(paiementDepAnnee.getNbTotalNonPayeHomme().intValue());
			 paiementDepAnneeRow.createCell(19).setCellValue(paiementDepAnnee.getMtTotalNonPayeHomme().doubleValue());
            
           
			
           
           
           
        }


       
    }
}
