package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviEvalAnneeLocaliteView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviEvalAnneeLocaliteViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviEvalAnneeLocaliteView> paiementsPeriode = (List<PrgSuiviEvalAnneeLocaliteView>)map.get("lesPaiementsPeriode");

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
        for(PrgSuiviEvalAnneeLocaliteView paiementPeriode : paiementsPeriode){
            Row paiementPeriodeRow =  sheet.createRow(currentRow++);
            paiementPeriodeRow.createCell(0).setCellValue(paiementPeriode.getAnneePeriode().intValue());
            paiementPeriodeRow.createCell(1).setCellValue(paiementPeriode.getNomLocalite());
            paiementPeriodeRow.createCell(2).setCellValue(paiementPeriode.getNbTotalEmission().intValue());
            paiementPeriodeRow.createCell(3).setCellValue(paiementPeriode.getMtTotalEmission().doubleValue());
            paiementPeriodeRow.createCell(4).setCellValue(paiementPeriode.getNbTotalPaye().intValue());
            paiementPeriodeRow.createCell(5).setCellValue(paiementPeriode.getMtTotalPaye().intValue());
            paiementPeriodeRow.createCell(6).setCellValue(paiementPeriode.getNbTotalNonPaye().intValue());
            paiementPeriodeRow.createCell(7).setCellValue(paiementPeriode.getMtTotalNonPaye().doubleValue());
            paiementPeriodeRow.createCell(8).setCellValue(paiementPeriode.getNbTotalEmissionFemme().intValue());
            paiementPeriodeRow.createCell(9).setCellValue(paiementPeriode.getMtTotalEmissionFemme().doubleValue());
            paiementPeriodeRow.createCell(10).setCellValue(paiementPeriode.getNbTotalPayeFemme().intValue());
            paiementPeriodeRow.createCell(11).setCellValue(paiementPeriode.getMtTotalPayeFemme().doubleValue());
            paiementPeriodeRow.createCell(12).setCellValue(paiementPeriode.getNbTotalNonPayeFemme().intValue());
            paiementPeriodeRow.createCell(13).setCellValue(paiementPeriode.getMtTotalNonPayeFemme().doubleValue());
            paiementPeriodeRow.createCell(14).setCellValue(paiementPeriode.getNbTotalEmissionHomme().intValue());
            paiementPeriodeRow.createCell(15).setCellValue(paiementPeriode.getMtTotalEmissionHomme().doubleValue());
            paiementPeriodeRow.createCell(16).setCellValue(paiementPeriode.getNbTotalPayeHomme().intValue());
            paiementPeriodeRow.createCell(17).setCellValue(paiementPeriode.getMtTotalPayeHomme().doubleValue());
            paiementPeriodeRow.createCell(18).setCellValue(paiementPeriode.getNbTotalNonPayeHomme().intValue());
            paiementPeriodeRow.createCell(19).setCellValue(paiementPeriode.getMtTotalNonPayeHomme().doubleValue());
           
        }


       
    }
}
