package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviPlainteAnneeView;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;


public class PrgSuiviPlainteAnneeViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviPlainteAnneeView> suiviplaintes = (List<PrgSuiviPlainteAnneeView>)map.get("lesuiviplaintes");

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
        for(PrgSuiviPlainteAnneeView suiviplainte : suiviplaintes){
            Row virementRow =  sheet.createRow(currentRow++);
            virementRow.createCell(0).setCellValue(suiviplainte.getAnnee().intValue());
            virementRow.createCell(1).setCellValue(suiviplainte.getNbPlainte().intValue());
            virementRow.createCell(2).setCellValue(suiviplainte.getNbPlaintePaiement().intValue());
            virementRow.createCell(3).setCellValue(suiviplainte.getNbPlainteNonPaiement().intValue());
            virementRow.createCell(4).setCellValue(suiviplainte.getNbPlainteCiblage().intValue());
            virementRow.createCell(5).setCellValue(suiviplainte.getNbPlainteTransfertMonetaire().intValue());
            virementRow.createCell(6).setCellValue(suiviplainte.getNbPlainteMesureAccompagnement().intValue());

            virementRow.createCell(7).setCellValue(suiviplainte.getNbPlainteMajeur().intValue());
            virementRow.createCell(8).setCellValue(suiviplainte.getNbPlainteMineur().intValue());
            virementRow.createCell(9).setCellValue(suiviplainte.getNbPlainteEffFemme().intValue());
            virementRow.createCell(10).setCellValue(suiviplainte.getNbPlainteEffHomme().intValue());

            virementRow.createCell(11).setCellValue(suiviplainte.getNbPlainteResolue().intValue());
            virementRow.createCell(12).setCellValue(suiviplainte.getTauxResolutionPlainte().intValue());
            virementRow.createCell(13).setCellValue(suiviplainte.getNbPlainteCloture().intValue());
            virementRow.createCell(14).setCellValue(suiviplainte.getNbPlainteEnCours().intValue());

            virementRow.createCell(15).setCellValue(suiviplainte.getNbPlainteTraitN1().intValue());
            virementRow.createCell(16).setCellValue(suiviplainte.getNbPlainteTraitN2().intValue());
            virementRow.createCell(17).setCellValue(suiviplainte.getNbPlainteNTraitN3().intValue());  
         
        }



       
    }
}
