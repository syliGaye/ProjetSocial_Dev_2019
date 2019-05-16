package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeDepartementView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviRsuMenageAnneeDepartementViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviRsuMenageAnneeDepartementView> menageDepAnnees = (List<PrgSuiviRsuMenageAnneeDepartementView>)map.get("lesMenageDepAnnees");

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
        for(PrgSuiviRsuMenageAnneeDepartementView menageDepAnnee : menageDepAnnees){
            Row menageDepAnneeRow =  sheet.createRow(currentRow++);
            menageDepAnneeRow.createCell(0).setCellValue(menageDepAnnee.getAnnee().intValue());
			 menageDepAnneeRow.createCell(1).setCellValue(menageDepAnnee.getNomDepartement());
			 
            menageDepAnneeRow.createCell(2).setCellValue(menageDepAnnee.getNbMenage().intValue());
            menageDepAnneeRow.createCell(3).setCellValue(menageDepAnnee.getEffTotal().intValue());
            menageDepAnneeRow.createCell(4).setCellValue(menageDepAnnee.getEffHomme().intValue());
			 menageDepAnneeRow.createCell(5).setCellValue(menageDepAnnee.getEffFemme().intValue());
			 
            menageDepAnneeRow.createCell(6).setCellValue(menageDepAnnee.getNbMemageChefHomme().intValue());
			 menageDepAnneeRow.createCell(7).setCellValue(menageDepAnnee.getEffMembreHomme().intValue());
            menageDepAnneeRow.createCell(8).setCellValue(menageDepAnnee.getEffHommeHomme().intValue());
            menageDepAnneeRow.createCell(9).setCellValue(menageDepAnnee.getEffHommeFemme().intValue());
           
			
            menageDepAnneeRow.createCell(10).setCellValue(menageDepAnnee.getNbMemageChefFemme().intValue());
			 menageDepAnneeRow.createCell(11).setCellValue(menageDepAnnee.getEffMembreFemme().intValue());
            menageDepAnneeRow.createCell(12).setCellValue(menageDepAnnee.getNbEffHommeFemme().intValue());
            menageDepAnneeRow.createCell(13).setCellValue(menageDepAnnee.getNbEffFemmeFemme().intValue());
           
			
            menageDepAnneeRow.createCell(14).setCellValue(menageDepAnnee.getNbMenagePauvreModel1().intValue());
            menageDepAnneeRow.createCell(15).setCellValue(menageDepAnnee.getNbMenageRicheModel1().intValue());
			
			 menageDepAnneeRow.createCell(16).setCellValue(menageDepAnnee.getNbMenagePauvreModel2().intValue());
            menageDepAnneeRow.createCell(17).setCellValue(menageDepAnnee.getNbMenageRicheModel2().intValue());
			
			 menageDepAnneeRow.createCell(18).setCellValue(menageDepAnnee.getNbMenagePauvreModel3().intValue());
            menageDepAnneeRow.createCell(19).setCellValue(menageDepAnnee.getNbMenageRicheModel3().intValue());
			
			 menageDepAnneeRow.createCell(20).setCellValue(menageDepAnnee.getNbMenagePauvreModel4().intValue());
            menageDepAnneeRow.createCell(21).setCellValue(menageDepAnnee.getNbMenageRicheModel4().intValue());
			
			 menageDepAnneeRow.createCell(22).setCellValue(menageDepAnnee.getNbMenagePauvreModel5().intValue());
            menageDepAnneeRow.createCell(23).setCellValue(menageDepAnnee.getNbMenageRicheModel5().intValue());
			
           
			
           
           
           
        }


       
    }
}
