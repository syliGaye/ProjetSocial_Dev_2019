package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviPlainteAnneeDepartementView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviPlainteAnneeDepartementViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviPlainteAnneeDepartementView> plainteDepAnnees = (List<PrgSuiviPlainteAnneeDepartementView>)map.get("lesPlaintesDepAnnees");

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
        for(PrgSuiviPlainteAnneeDepartementView plainteDepAnnee : plainteDepAnnees){
            Row plainteDepAnneeRow =  sheet.createRow(currentRow++);
            plainteDepAnneeRow.createCell(0).setCellValue(plainteDepAnnee.getAnnee().intValue());
			 plainteDepAnneeRow.createCell(1).setCellValue(plainteDepAnnee.getNomDepartement());
            plainteDepAnneeRow.createCell(2).setCellValue(plainteDepAnnee.getNbPlainte().intValue());
            plainteDepAnneeRow.createCell(3).setCellValue(plainteDepAnnee.getNbPlaintePaiement().intValue());
            plainteDepAnneeRow.createCell(4).setCellValue(plainteDepAnnee.getNbPlainteNonPaiement().intValue());
            plainteDepAnneeRow.createCell(5).setCellValue(plainteDepAnnee.getNbPlainteCiblage().intValue());
            plainteDepAnneeRow.createCell(6).setCellValue(plainteDepAnnee.getNbPlainteTransfertMonetaire().intValue());
			 plainteDepAnneeRow.createCell(7).setCellValue(plainteDepAnnee.getNbPlainteMesureAccompagnement().intValue());
			 
            plainteDepAnneeRow.createCell(8).setCellValue(plainteDepAnnee.getNbPlainteMajeur().intValue());
            plainteDepAnneeRow.createCell(9).setCellValue(plainteDepAnnee.getNbPlainteMineur().intValue());
            plainteDepAnneeRow.createCell(10).setCellValue(plainteDepAnnee.getNbPlainteEffFemme().intValue());
            plainteDepAnneeRow.createCell(11).setCellValue(plainteDepAnnee.getNbPlainteEffHomme().intValue());
			
            plainteDepAnneeRow.createCell(12).setCellValue(plainteDepAnnee.getNbPlainteResolue().intValue());
            plainteDepAnneeRow.createCell(13).setCellValue(plainteDepAnnee.getTauxResolutionPlainte().intValue());
            plainteDepAnneeRow.createCell(14).setCellValue(plainteDepAnnee.getNbPlainteCloture().intValue());
            plainteDepAnneeRow.createCell(15).setCellValue(plainteDepAnnee.getNbPlainteEnCours().intValue());
			
            plainteDepAnneeRow.createCell(16).setCellValue(plainteDepAnnee.getNbPlainteTraitN1().intValue());
            plainteDepAnneeRow.createCell(17).setCellValue(plainteDepAnnee.getNbPlainteTraitN2().intValue());
			 plainteDepAnneeRow.createCell(18).setCellValue(plainteDepAnnee.getNbPlainteNTraitN3().intValue());
            
           
			
           
           
           
        }


       
    }
}
