package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviEvalPeriodeSPrefView;


import org.apache.poi.hssf.util.HSSFColor;
//import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviEvalPeriodeSPrefViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviEvalPeriodeSPrefView> paiement = (List<PrgSuiviEvalPeriodeSPrefView>)map.get("lesPaiement");

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
        for(PrgSuiviEvalPeriodeSPrefView paiements : paiement){
            Row paiementRow =  sheet.createRow(currentRow++);
           
            paiementRow.createCell(0).setCellValue(paiements.getLibellePeriode());
            paiementRow.createCell(1).setCellValue(paiements.getNomSPref());
            paiementRow.createCell(2).setCellValue(paiements.getNbTotalEmission().intValue());
            paiementRow.createCell(3).setCellValue(paiements.getMtTotalEmission().doubleValue());
            paiementRow.createCell(4).setCellValue(paiements.getNbTotalPaye().intValue());
            paiementRow.createCell(5).setCellValue(paiements.getMtTotalPaye().doubleValue());
            paiementRow.createCell(6).setCellValue(paiements.getNbTotalNonPaye().intValue());
/*           paiementRow.createCell(7).setCellValue(paiements.getMtTotalNonPaye().doubleValue());*/
            paiementRow.createCell(8).setCellValue(paiements.getNbTotalEmissionFemme().intValue());
              paiementRow.createCell(9).setCellValue(paiements.getMtTotalEmissionFemme().intValue());
            paiementRow.createCell(10).setCellValue(paiements.getNbTotalPayeFemme().intValue());
            paiementRow.createCell(11).setCellValue(paiements.getMtTotalPayeFemme().intValue());
            paiementRow.createCell(12).setCellValue(paiements.getNbTotalNonPayeFemme().intValue());
//            paiementRow.createCell(14).setCellValue(paiements.getNbTotalEmissionHomme().intValue());
               paiementRow.createCell(15).setCellValue(paiements.getMtTotalEmissionHomme().intValue());
            paiementRow.createCell(16).setCellValue(paiements.getNbTotalPayeHomme().intValue());
              paiementRow.createCell(17).setCellValue(paiements.getMtTotalPayeHomme().intValue());
            paiementRow.createCell(18).setCellValue(paiements.getNbTotalNonPayeHomme().intValue());
               paiementRow.createCell(19).setCellValue(paiements.getMtTotalNonPayeHomme().intValue());
            
           
           
        }


       
    }
}
