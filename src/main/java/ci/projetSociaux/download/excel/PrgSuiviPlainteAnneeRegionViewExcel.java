package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviPlainteAnneeRegionView;

import org.apache.poi.hssf.util.HSSFColor;
//import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviPlainteAnneeRegionViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviPlainteAnneeRegionView> plaintes = (List<PrgSuiviPlainteAnneeRegionView>)map.get("lesPlaintes");

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
        for(PrgSuiviPlainteAnneeRegionView plainte : plaintes){
            Row plainteRow =  sheet.createRow(currentRow++);
           
            plainteRow.createCell(0).setCellValue(plainte.getAnnee().intValue());
            plainteRow.createCell(1).setCellValue(plainte.getNomRegion());
            plainteRow.createCell(2).setCellValue(plainte.getNbPlainte().intValue());
            plainteRow.createCell(3).setCellValue(plainte.getNbPlaintePaiement().intValue());
            plainteRow.createCell(4).setCellValue(plainte.getNbPlainteNonPaiement().intValue());
            plainteRow.createCell(5).setCellValue(plainte.getNbPlainteCiblage().intValue());
            plainteRow.createCell(6).setCellValue(plainte.getNbPlainteTransfertMonetaire().intValue());
            plainteRow.createCell(7).setCellValue(plainte.getNbPlainteMesureAccompagnement().intValue());

            plainteRow.createCell(8).setCellValue(plainte.getNbPlainteMajeur().intValue());
            plainteRow.createCell(9).setCellValue(plainte.getNbPlainteMineur().intValue());
            plainteRow.createCell(10).setCellValue(plainte.getNbPlainteEffFemme().intValue());
            plainteRow.createCell(11).setCellValue(plainte.getNbPlainteEffHomme().intValue());

            plainteRow.createCell(12).setCellValue(plainte.getNbPlainteResolue().intValue());
            plainteRow.createCell(13).setCellValue(plainte.getTauxResolutionPlainte().intValue());
            plainteRow.createCell(14).setCellValue(plainte.getNbPlainteCloture().intValue());
            plainteRow.createCell(15).setCellValue(plainte.getNbPlainteEnCours().intValue());

            plainteRow.createCell(16).setCellValue(plainte.getNbPlainteTraitN1().intValue());
            plainteRow.createCell(17).setCellValue(plainte.getNbPlainteTraitN2().intValue());
            plainteRow.createCell(18).setCellValue(plainte.getNbPlainteNTraitN3().intValue());
           
        }


       
    }
}
