package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeSousPrefView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviRsuMenageAnneeSousPrefViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviRsuMenageAnneeSousPrefView> menageSpAnnees = (List<PrgSuiviRsuMenageAnneeSousPrefView>)map.get("lesMenageSpAnnees");

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
        for(PrgSuiviRsuMenageAnneeSousPrefView menageSpAnnee : menageSpAnnees){
            Row menageSpAnneeRow =  sheet.createRow(currentRow++);
            menageSpAnneeRow.createCell(0).setCellValue(menageSpAnnee.getAnnee().intValue());
			 menageSpAnneeRow.createCell(1).setCellValue(menageSpAnnee.getNomSPref());
			 
            menageSpAnneeRow.createCell(2).setCellValue(menageSpAnnee.getNbMenage().intValue());
            menageSpAnneeRow.createCell(3).setCellValue(menageSpAnnee.getEffTotal().intValue());
            menageSpAnneeRow.createCell(4).setCellValue(menageSpAnnee.getEffHomme().intValue());
			 menageSpAnneeRow.createCell(5).setCellValue(menageSpAnnee.getEffFemme().intValue());
			 
			 
            menageSpAnneeRow.createCell(6).setCellValue(menageSpAnnee.getNbMemageChefFemme().intValue());
            menageSpAnneeRow.createCell(7).setCellValue(menageSpAnnee.getEffMembreFemme().intValue());
            menageSpAnneeRow.createCell(8).setCellValue(menageSpAnnee.getNbEffHommeFemme().intValue());
            menageSpAnneeRow.createCell(9).setCellValue(menageSpAnnee.getNbEffFemmeFemme().intValue());
			 
            menageSpAnneeRow.createCell(10).setCellValue(menageSpAnnee.getNbMemageChefHomme().intValue());
            menageSpAnneeRow.createCell(11).setCellValue(menageSpAnnee.getEffMembreHomme().intValue());
            menageSpAnneeRow.createCell(12).setCellValue(menageSpAnnee.getEffHommeHomme().intValue());
            menageSpAnneeRow.createCell(13).setCellValue(menageSpAnnee.getEffHommeFemme().intValue());
			
			
            menageSpAnneeRow.createCell(14).setCellValue(menageSpAnnee.getNbMenagePauvreModel1().intValue());
            menageSpAnneeRow.createCell(15).setCellValue(menageSpAnnee.getNbMenageRicheModel1().intValue());
			
			 menageSpAnneeRow.createCell(16).setCellValue(menageSpAnnee.getNbMenagePauvreModel2().intValue());
            menageSpAnneeRow.createCell(17).setCellValue(menageSpAnnee.getNbMenageRicheModel2().intValue());
			
			 menageSpAnneeRow.createCell(18).setCellValue(menageSpAnnee.getNbMenagePauvreModel3().intValue());
            menageSpAnneeRow.createCell(19).setCellValue(menageSpAnnee.getNbMenageRicheModel3().intValue());
			
			 menageSpAnneeRow.createCell(20).setCellValue(menageSpAnnee.getNbMenagePauvreModel4().intValue());
            menageSpAnneeRow.createCell(21).setCellValue(menageSpAnnee.getNbMenageRicheModel4().intValue());
			
			 menageSpAnneeRow.createCell(22).setCellValue(menageSpAnnee.getNbMenagePauvreModel5().intValue());
            menageSpAnneeRow.createCell(23).setCellValue(menageSpAnnee.getNbMenageRicheModel5().intValue());
			
           
			
           
           
           
        }


       
    }
}
