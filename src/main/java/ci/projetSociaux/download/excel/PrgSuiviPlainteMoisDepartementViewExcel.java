package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviPlainteMoisDepartementView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviPlainteMoisDepartementViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviPlainteMoisDepartementView> plainteMoiDeps = (List<PrgSuiviPlainteMoisDepartementView>)map.get("lesPlaintesMoiDeps");

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
        for(PrgSuiviPlainteMoisDepartementView plainteMoiDep : plainteMoiDeps){
            Row plainteMoiDepRow =  sheet.createRow(currentRow++);
            plainteMoiDepRow.createCell(0).setCellValue(plainteMoiDep.getAnnee().intValue());
			plainteMoiDepRow.createCell(1).setCellValue(plainteMoiDep.getLibelleMois());
		    plainteMoiDepRow.createCell(2).setCellValue(plainteMoiDep.getNomDepartement());
            plainteMoiDepRow.createCell(3).setCellValue(plainteMoiDep.getNbPlainte().intValue());
            plainteMoiDepRow.createCell(4).setCellValue(plainteMoiDep.getNbPlainteCiblage().intValue());
            plainteMoiDepRow.createCell(5).setCellValue(plainteMoiDep.getNbPlainteTransfertMonetaire().intValue());
			 plainteMoiDepRow.createCell(6).setCellValue(plainteMoiDep.getNbPlainteMesureAccompagnement().intValue());
			 
            plainteMoiDepRow.createCell(7).setCellValue(plainteMoiDep.getNbPlainteMajeur().intValue());
            plainteMoiDepRow.createCell(8).setCellValue(plainteMoiDep.getNbPlainteMineur().intValue());
            plainteMoiDepRow.createCell(9).setCellValue(plainteMoiDep.getNbPlainteEffFemme().intValue());
            plainteMoiDepRow.createCell(10).setCellValue(plainteMoiDep.getNbPlainteEffHomme().intValue());
			
            plainteMoiDepRow.createCell(11).setCellValue(plainteMoiDep.getNbPlainteResolue().intValue());
            plainteMoiDepRow.createCell(12).setCellValue(plainteMoiDep.getTauxResolutionPlainte().intValue());
            plainteMoiDepRow.createCell(13).setCellValue(plainteMoiDep.getNbPlainteCloture().intValue());
            plainteMoiDepRow.createCell(14).setCellValue(plainteMoiDep.getNbPlainteEnCours().intValue());
			
            plainteMoiDepRow.createCell(15).setCellValue(plainteMoiDep.getNbPlainteTraitN1().intValue());
            plainteMoiDepRow.createCell(16).setCellValue(plainteMoiDep.getNbPlainteTraitN2().intValue());
			 plainteMoiDepRow.createCell(17).setCellValue(plainteMoiDep.getNbPlainteNTraitN3().intValue());
			
           
			
           
           
           
        }


       
    }
}

