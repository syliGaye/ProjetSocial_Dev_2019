package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviPlainteMoisSousPrefView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviPlainteMoisSousPrefViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviPlainteMoisSousPrefView> plainteMoisSousPrefs = (List<PrgSuiviPlainteMoisSousPrefView>)map.get("Suivi_Plainte_Mois_SousPref");

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
        for(PrgSuiviPlainteMoisSousPrefView plainteMoisSousPref : plainteMoisSousPrefs){
            Row plainteMoisSousPrefRow =  sheet.createRow(currentRow++);
            plainteMoisSousPrefRow.createCell(0).setCellValue(plainteMoisSousPref.getAnnee().intValue());
			plainteMoisSousPrefRow.createCell(1).setCellValue(plainteMoisSousPref.getLibelleMois());
			plainteMoisSousPrefRow.createCell(2).setCellValue(plainteMoisSousPref.getNomSPref());
            plainteMoisSousPrefRow.createCell(3).setCellValue(plainteMoisSousPref.getNbPlainte().intValue());
            plainteMoisSousPrefRow.createCell(4).setCellValue(plainteMoisSousPref.getNbPlaintePaiement().intValue());
            
            plainteMoisSousPrefRow.createCell(5).setCellValue(plainteMoisSousPref.getNbPlainteNonPaiement().intValue());
            plainteMoisSousPrefRow.createCell(6).setCellValue(plainteMoisSousPref.getNbPlainteCiblage().intValue());
            plainteMoisSousPrefRow.createCell(7).setCellValue(plainteMoisSousPref.getNbPlainteTransfertMonetaire().intValue());
			plainteMoisSousPrefRow.createCell(8).setCellValue(plainteMoisSousPref.getNbPlainteMesureAccompagnement().intValue());
			
            plainteMoisSousPrefRow.createCell(9).setCellValue(plainteMoisSousPref.getNbPlainteMajeur().intValue());
            plainteMoisSousPrefRow.createCell(10).setCellValue(plainteMoisSousPref.getNbPlainteMineur().intValue());
            plainteMoisSousPrefRow.createCell(11).setCellValue(plainteMoisSousPref.getNbPlainteEffHomme().intValue());
            plainteMoisSousPrefRow.createCell(12).setCellValue(plainteMoisSousPref.getNbPlainteEffFemme().intValue());
			
            plainteMoisSousPrefRow.createCell(13).setCellValue(plainteMoisSousPref.getNbPlainteResolue().intValue());
            plainteMoisSousPrefRow.createCell(14).setCellValue(plainteMoisSousPref.getTauxResolutionPlainte().intValue());
            plainteMoisSousPrefRow.createCell(15).setCellValue(plainteMoisSousPref.getNbPlainteCloture().intValue());
            plainteMoisSousPrefRow.createCell(16).setCellValue(plainteMoisSousPref.getNbPlainteEnCours().intValue());

            plainteMoisSousPrefRow.createCell(17).setCellValue(plainteMoisSousPref.getNbPlainteTraitN1().intValue());
            plainteMoisSousPrefRow.createCell(18).setCellValue(plainteMoisSousPref.getNbPlainteTraitN2().intValue());
			
			plainteMoisSousPrefRow.createCell(19).setCellValue(plainteMoisSousPref.getNbPlainteNTraitN3().intValue());
			
 
        }

    }
}
