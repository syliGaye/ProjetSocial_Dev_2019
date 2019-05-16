package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviEvalPeriodeDepartementView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviEvalPeriodeDepartementViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviEvalPeriodeDepartementView> paiementDepPeriodes = (List<PrgSuiviEvalPeriodeDepartementView>)map.get("lesPaiementsDepPeriodes");

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
        for(PrgSuiviEvalPeriodeDepartementView paiementDepPeriode : paiementDepPeriodes){
            Row paiementDepPeriodeRow =  sheet.createRow(currentRow++);
            paiementDepPeriodeRow.createCell(0).setCellValue(paiementDepPeriode.getLibellePeriode());
			 paiementDepPeriodeRow.createCell(1).setCellValue(paiementDepPeriode.getNomDepartement());
			 
            paiementDepPeriodeRow.createCell(2).setCellValue(paiementDepPeriode.getNbTotalEmission().intValue());
            paiementDepPeriodeRow.createCell(3).setCellValue(paiementDepPeriode.getMtTotalEmission().doubleValue());
            paiementDepPeriodeRow.createCell(4).setCellValue(paiementDepPeriode.getNbTotalPaye().intValue());
			 paiementDepPeriodeRow.createCell(5).setCellValue(paiementDepPeriode.getMtTotalPaye().doubleValue());
            paiementDepPeriodeRow.createCell(6).setCellValue(paiementDepPeriode.getNbTotalNonPaye().intValue());
            paiementDepPeriodeRow.createCell(7).setCellValue(paiementDepPeriode.getMtTotalNonPaye().doubleValue());
			
            paiementDepPeriodeRow.createCell(8).setCellValue(paiementDepPeriode.getNbTotalEmissionFemme().intValue());
            paiementDepPeriodeRow.createCell(9).setCellValue(paiementDepPeriode.getMtTotalEmissionFemme().doubleValue());
            paiementDepPeriodeRow.createCell(10).setCellValue(paiementDepPeriode.getNbTotalPayeFemme().intValue());
            paiementDepPeriodeRow.createCell(11).setCellValue(paiementDepPeriode.getMtTotalPayeFemme().doubleValue());
            paiementDepPeriodeRow.createCell(12).setCellValue(paiementDepPeriode.getNbTotalNonPayeFemme().intValue());
            paiementDepPeriodeRow.createCell(13).setCellValue(paiementDepPeriode.getMtTotalNonPayeFemme().doubleValue());
			
            paiementDepPeriodeRow.createCell(14).setCellValue(paiementDepPeriode.getNbTotalEmissionHomme().intValue());
            paiementDepPeriodeRow.createCell(15).setCellValue(paiementDepPeriode.getMtTotalEmissionHomme().doubleValue());
			 paiementDepPeriodeRow.createCell(16).setCellValue(paiementDepPeriode.getNbTotalPayeHomme().intValue());
			 paiementDepPeriodeRow.createCell(17).setCellValue(paiementDepPeriode.getMtTotalPayeHomme().doubleValue());
            paiementDepPeriodeRow.createCell(18).setCellValue(paiementDepPeriode.getNbTotalNonPayeHomme().intValue());
			 paiementDepPeriodeRow.createCell(19).setCellValue(paiementDepPeriode.getMtTotalNonPayeHomme().doubleValue());
            
           
  
        }


       
    }
}
