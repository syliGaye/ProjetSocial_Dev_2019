package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviPlainteMoisLocaliteView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviPlainteMoisLocaliteViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviPlainteMoisLocaliteView> prgSuiviPlainteMoisLocaliteView = (List<PrgSuiviPlainteMoisLocaliteView>)map.get("lesPrgSuiviPlainteMoisLocaliteView");

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
        for(PrgSuiviPlainteMoisLocaliteView menage : prgSuiviPlainteMoisLocaliteView){
            Row menageRow =  sheet.createRow(currentRow++);
            menageRow.createCell(0).setCellValue(menage.getAnnee().intValue());
            menageRow.createCell(1).setCellValue(menage.getLibelleMois());
            menageRow.createCell(2).setCellValue(menage.getNomLocalite());
            menageRow.createCell(3).setCellValue(menage.getNbPlainte().intValue());
            menageRow.createCell(4).setCellValue(menage.getNbPlainteCiblage().intValue());
            menageRow.createCell(5).setCellValue(menage.getNbPlainteTransfertMonetaire().intValue());
            menageRow.createCell(6).setCellValue(menage.getNbPlainteMesureAccompagnement().intValue());
            menageRow.createCell(7).setCellValue(menage.getNbPlainteMajeur().intValue());
            menageRow.createCell(8).setCellValue(menage.getNbPlainteMineur().intValue());
            menageRow.createCell(9).setCellValue(menage.getNbPlainteEffFemme().intValue());
            menageRow.createCell(10).setCellValue(menage.getNbPlainteEffHomme().intValue());
            menageRow.createCell(11).setCellValue(menage.getNbPlainteResolue().intValue());
            menageRow.createCell(12).setCellValue(menage.getTauxResolutionPlainte().intValue());
            menageRow.createCell(13).setCellValue(menage.getNbPlainteCloture().intValue());
            menageRow.createCell(14).setCellValue(menage.getNbPlainteEnCours().intValue());
            menageRow.createCell(15).setCellValue(menage.getNbPlainteTraitN1().intValue());
            menageRow.createCell(16).setCellValue(menage.getNbPlainteTraitN2().intValue());
            menageRow.createCell(17).setCellValue(menage.getNbPlainteNTraitN3().intValue());
  
        }


       
    }
}
