package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviPlainteMoisView;
import ci.projetSociaux.entity.PrgVirementApPeriodeView;
import ci.projetSociaux.entity.PrgVirementUgpPeriodeView;
import ci.projetSociaux.utils.excelCsvUtils.StringUtils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class PrgSuiviPlainteMoisViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviPlainteMoisView> plaintesmois = (List<PrgSuiviPlainteMoisView>)map.get("lesuiviplaintesmois");

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
        for(PrgSuiviPlainteMoisView plaintemois : plaintesmois){
            Row virementRow =  sheet.createRow(currentRow++);
           
            
            virementRow.createCell(0).setCellValue(plaintemois.getAnnee().toString());
            virementRow.createCell(1).setCellValue(plaintemois.getLibelleMois());
            virementRow.createCell(2).setCellValue(plaintemois.getNbPlainte());
            virementRow.createCell(3).setCellValue(plaintemois.getNbPlainteCiblage());
            virementRow.createCell(4).setCellValue(plaintemois.getNbPlainteTransfertMonetaire());
            virementRow.createCell(5).setCellValue(plaintemois.getNbPlainteMesureAccompagnement());
            virementRow.createCell(6).setCellValue(plaintemois.getNbPlainteMajeur());
            virementRow.createCell(7).setCellValue(plaintemois.getNbPlainteMineur());
            virementRow.createCell(8).setCellValue(plaintemois.getNbPlainteEffHomme());
            virementRow.createCell(9).setCellValue(plaintemois.getNbPlainteEffFemme());
            virementRow.createCell(10).setCellValue(plaintemois.getNbPlainteResolue());
            virementRow.createCell(11).setCellValue(plaintemois.getTauxResolutionPlainte());
            virementRow.createCell(12).setCellValue(plaintemois.getNbPlainteCloture());
            virementRow.createCell(13).setCellValue(plaintemois.getNbPlainteEnCours());
            virementRow.createCell(14).setCellValue(plaintemois.getNbPlainteTraitN1());
            virementRow.createCell(15).setCellValue(plaintemois.getNbPlainteTraitN2());
            virementRow.createCell(16).setCellValue(plaintemois.getNbPlainteNTraitN3());
  
        }


       
    }
}
