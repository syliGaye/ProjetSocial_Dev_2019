package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviEvalPeriodeLocaliteView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviEvalPeriodeLocaliteViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviEvalPeriodeLocaliteView> paiements = (List<PrgSuiviEvalPeriodeLocaliteView>)map.get("lesPaiements");

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
        for(PrgSuiviEvalPeriodeLocaliteView paiement : paiements){
            Row paiementRow =  sheet.createRow(currentRow++);
            paiementRow.createCell(0).setCellValue(paiement.getLibellePeriode());
            paiementRow.createCell(1).setCellValue(paiement.getNomLocalite());
            paiementRow.createCell(2).setCellValue(paiement.getNbTotalEmission().intValue());
            paiementRow.createCell(3).setCellValue(paiement.getMtTotalEmission().doubleValue());
            paiementRow.createCell(4).setCellValue(paiement.getNbTotalPaye().intValue());
            paiementRow.createCell(5).setCellValue(paiement.getMtTotalPaye().intValue());
            paiementRow.createCell(6).setCellValue(paiement.getNbTotalNonPaye().intValue());
            paiementRow.createCell(7).setCellValue(paiement.getMtTotalNonPaye().doubleValue());
            paiementRow.createCell(8).setCellValue(paiement.getNbTotalEmissionFemme().intValue());
            paiementRow.createCell(9).setCellValue(paiement.getMtTotalEmissionFemme().doubleValue());
            paiementRow.createCell(10).setCellValue(paiement.getNbTotalPayeFemme().intValue());
            paiementRow.createCell(11).setCellValue(paiement.getMtTotalPayeFemme().doubleValue());
            paiementRow.createCell(12).setCellValue(paiement.getNbTotalNonPayeFemme().intValue());
            paiementRow.createCell(13).setCellValue(paiement.getMtTotalNonPayeFemme().doubleValue());
            paiementRow.createCell(14).setCellValue(paiement.getNbTotalEmissionHomme().intValue());
            paiementRow.createCell(15).setCellValue(paiement.getMtTotalEmissionHomme().doubleValue());
            paiementRow.createCell(16).setCellValue(paiement.getNbTotalPayeHomme().intValue());
            paiementRow.createCell(17).setCellValue(paiement.getMtTotalPayeHomme().doubleValue());
            paiementRow.createCell(18).setCellValue(paiement.getNbTotalNonPayeHomme().intValue());
            paiementRow.createCell(19).setCellValue(paiement.getMtTotalNonPayeHomme().doubleValue());
           
        }


       
    }
}
