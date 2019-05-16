package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeLocaliteView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviRsuMenageAnneeLocaliteViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviRsuMenageAnneeLocaliteView> menageAnneeLocalites = (List<PrgSuiviRsuMenageAnneeLocaliteView>)map.get("Suivi_Menage_A_Localite");

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
        for(PrgSuiviRsuMenageAnneeLocaliteView menageAnneeLocalite : menageAnneeLocalites){
            Row menageAnneeLocaliteRow =  sheet.createRow(currentRow++);
            menageAnneeLocaliteRow.createCell(0).setCellValue(menageAnneeLocalite.getAnnee().intValue());
			menageAnneeLocaliteRow.createCell(1).setCellValue(menageAnneeLocalite.getNomLocalite());
            menageAnneeLocaliteRow.createCell(2).setCellValue(menageAnneeLocalite.getNbMenage().intValue());
            menageAnneeLocaliteRow.createCell(3).setCellValue(menageAnneeLocalite.getEffTotal().intValue());
            menageAnneeLocaliteRow.createCell(4).setCellValue(menageAnneeLocalite.getEffHomme().intValue());
			menageAnneeLocaliteRow.createCell(5).setCellValue(menageAnneeLocalite.getEffFemme().intValue());
			
            menageAnneeLocaliteRow.createCell(6).setCellValue(menageAnneeLocalite.getNbMemageChefFemme().intValue());
			 menageAnneeLocaliteRow.createCell(7).setCellValue(menageAnneeLocalite.getEffMembreFemme().intValue());
            menageAnneeLocaliteRow.createCell(8).setCellValue(menageAnneeLocalite.getNbEffHommeFemme().intValue());
            menageAnneeLocaliteRow.createCell(9).setCellValue(menageAnneeLocalite.getNbEffFemmeFemme().intValue());
           
			
            menageAnneeLocaliteRow.createCell(10).setCellValue(menageAnneeLocalite.getNbMemageChefHomme().intValue());
		    menageAnneeLocaliteRow.createCell(11).setCellValue(menageAnneeLocalite.getEffMembreHomme().intValue());
            menageAnneeLocaliteRow.createCell(12).setCellValue(menageAnneeLocalite.getEffHommeHomme().intValue());
            menageAnneeLocaliteRow.createCell(13).setCellValue(menageAnneeLocalite.getEffHommeFemme().intValue());
        
			

			
            menageAnneeLocaliteRow.createCell(14).setCellValue(menageAnneeLocalite.getNbMenagePauvreModel1().intValue());
            menageAnneeLocaliteRow.createCell(15).setCellValue(menageAnneeLocalite.getNbMenageRicheModel1().intValue());
			
			 menageAnneeLocaliteRow.createCell(16).setCellValue(menageAnneeLocalite.getNbMenagePauvreModel2().intValue());
            menageAnneeLocaliteRow.createCell(17).setCellValue(menageAnneeLocalite.getNbMenageRicheModel2().intValue());
			
			 menageAnneeLocaliteRow.createCell(18).setCellValue(menageAnneeLocalite.getNbMenagePauvreModel3().intValue());
            menageAnneeLocaliteRow.createCell(19).setCellValue(menageAnneeLocalite.getNbMenageRicheModel3().intValue());
			
			 menageAnneeLocaliteRow.createCell(20).setCellValue(menageAnneeLocalite.getNbMenagePauvreModel4().intValue());
            menageAnneeLocaliteRow.createCell(21).setCellValue(menageAnneeLocalite.getNbMenageRicheModel4().intValue());
			
			 menageAnneeLocaliteRow.createCell(22).setCellValue(menageAnneeLocalite.getNbMenagePauvreModel5().intValue());
            menageAnneeLocaliteRow.createCell(23).setCellValue(menageAnneeLocalite.getNbMenageRicheModel5().intValue());
			
 
        }

    }
}
