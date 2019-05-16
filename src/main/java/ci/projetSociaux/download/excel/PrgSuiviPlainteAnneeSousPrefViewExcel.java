package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviPlainteAnneeSousPrefView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviPlainteAnneeSousPrefViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviPlainteAnneeSousPrefView> plainteAnneeSousPrefs = (List<PrgSuiviPlainteAnneeSousPrefView>)map.get("Suivi_Plainte_A_SousPref");

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
        for(PrgSuiviPlainteAnneeSousPrefView plainteAnneeSousPref : plainteAnneeSousPrefs){
		            Row plainteAnneeSousPrefRow =  sheet.createRow(currentRow++);
		plainteAnneeSousPrefRow.createCell(0).setCellValue(plainteAnneeSousPref.getAnnee().intValue());
		plainteAnneeSousPrefRow.createCell(1).setCellValue(plainteAnneeSousPref.getNomSPref());
		plainteAnneeSousPrefRow.createCell(2).setCellValue(plainteAnneeSousPref.getNbPlainte().intValue());
		plainteAnneeSousPrefRow.createCell(3).setCellValue(plainteAnneeSousPref.getNbPlaintePaiement().intValue());
		plainteAnneeSousPrefRow.createCell(4).setCellValue(plainteAnneeSousPref.getNbPlainteNonPaiement().intValue());
		plainteAnneeSousPrefRow.createCell(5).setCellValue(plainteAnneeSousPref.getNbPlainteCiblage().intValue());
		plainteAnneeSousPrefRow.createCell(6).setCellValue(plainteAnneeSousPref.getNbPlainteTransfertMonetaire().intValue());
		plainteAnneeSousPrefRow.createCell(7).setCellValue(plainteAnneeSousPref.getNbPlainteMesureAccompagnement().intValue());
		
		plainteAnneeSousPrefRow.createCell(8).setCellValue(plainteAnneeSousPref.getNbPlainteMajeur().intValue());
		plainteAnneeSousPrefRow.createCell(9).setCellValue(plainteAnneeSousPref.getNbPlainteMineur().intValue());
		plainteAnneeSousPrefRow.createCell(10).setCellValue(plainteAnneeSousPref.getNbPlainteEffFemme().intValue());
		plainteAnneeSousPrefRow.createCell(11).setCellValue(plainteAnneeSousPref.getNbPlainteEffHomme().intValue());
		
		plainteAnneeSousPrefRow.createCell(12).setCellValue(plainteAnneeSousPref.getNbPlainteResolue().intValue());
		plainteAnneeSousPrefRow.createCell(13).setCellValue(plainteAnneeSousPref.getTauxResolutionPlainte().intValue());
		plainteAnneeSousPrefRow.createCell(14).setCellValue(plainteAnneeSousPref.getNbPlainteCloture().intValue());
		plainteAnneeSousPrefRow.createCell(15).setCellValue(plainteAnneeSousPref.getNbPlainteEnCours().intValue());
		
		plainteAnneeSousPrefRow.createCell(16).setCellValue(plainteAnneeSousPref.getNbPlainteTraitN1().intValue());
		plainteAnneeSousPrefRow.createCell(17).setCellValue(plainteAnneeSousPref.getNbPlainteTraitN2().intValue());
		plainteAnneeSousPrefRow.createCell(18).setCellValue(plainteAnneeSousPref.getNbPlainteNTraitN3().intValue());
		           	
 
        }

    }
}
