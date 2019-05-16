package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviRsuMenageAnneeViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviRsuMenageAnneeView> menageAnnees = (List<PrgSuiviRsuMenageAnneeView>)map.get("lesMenageAnnees");

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
        for(PrgSuiviRsuMenageAnneeView menageAnnee : menageAnnees){
            Row menageAnneeRow =  sheet.createRow(currentRow++);
            menageAnneeRow.createCell(0).setCellValue(menageAnnee.getAnnee().intValue());
			
            menageAnneeRow.createCell(1).setCellValue(menageAnnee.getNbMenage().intValue());
            menageAnneeRow.createCell(2).setCellValue(menageAnnee.getEffTotal());
            menageAnneeRow.createCell(3).setCellValue(menageAnnee.getEffHomme());
			menageAnneeRow.createCell(4).setCellValue(menageAnnee.getEffFemme());
			 
            menageAnneeRow.createCell(5).setCellValue(menageAnnee.getNbMemageChefHomme());
            menageAnneeRow.createCell(6).setCellValue(menageAnnee.getEffMembreHomme());
            menageAnneeRow.createCell(7).setCellValue(menageAnnee.getEffHommeHomme());
            menageAnneeRow.createCell(8).setCellValue(menageAnnee.getEffHommeFemme());
			
            menageAnneeRow.createCell(9).setCellValue(menageAnnee.getNbMemageChefFemme());
            menageAnneeRow.createCell(12).setCellValue(menageAnnee.getEffMembreFemme());
            menageAnneeRow.createCell(10).setCellValue(menageAnnee.getNbEffHommeFemme());
            menageAnneeRow.createCell(11).setCellValue(menageAnnee.getNbEffFemmeFemme());
			
            menageAnneeRow.createCell(13).setCellValue(menageAnnee.getNbMenagePauvreModel1());
            menageAnneeRow.createCell(14).setCellValue(menageAnnee.getNbMenageRicheModel1());
			
			menageAnneeRow.createCell(15).setCellValue(menageAnnee.getNbMenagePauvreModel2());
            menageAnneeRow.createCell(16).setCellValue(menageAnnee.getNbMenageRicheModel2());
			
			menageAnneeRow.createCell(17).setCellValue(menageAnnee.getNbMenagePauvreModel3());
            menageAnneeRow.createCell(18).setCellValue(menageAnnee.getNbMenageRicheModel3());
			
			menageAnneeRow.createCell(19).setCellValue(menageAnnee.getNbMenagePauvreModel4());
            menageAnneeRow.createCell(20).setCellValue(menageAnnee.getNbMenageRicheModel4());
			
			menageAnneeRow.createCell(21).setCellValue(menageAnnee.getNbMenagePauvreModel5());
            menageAnneeRow.createCell(22).setCellValue(menageAnnee.getNbMenageRicheModel5());
			
           
			
           
           
           
        }


       
    }
}
