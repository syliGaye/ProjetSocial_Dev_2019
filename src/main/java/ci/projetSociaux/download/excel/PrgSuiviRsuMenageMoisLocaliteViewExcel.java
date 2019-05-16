package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisLocaliteView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviRsuMenageMoisLocaliteViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviRsuMenageMoisLocaliteView> menageMoisLocalites = (List<PrgSuiviRsuMenageMoisLocaliteView>)map.get("Suivi_Menage_M_Localite");

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
        for(PrgSuiviRsuMenageMoisLocaliteView menageMoisLocalite : menageMoisLocalites){
            Row menageMoisLocaliteRow =  sheet.createRow(currentRow++);
            menageMoisLocaliteRow.createCell(0).setCellValue(menageMoisLocalite.getAnnee().intValue());
			menageMoisLocaliteRow.createCell(1).setCellValue(menageMoisLocalite.getLibelleMois());
			menageMoisLocaliteRow.createCell(2).setCellValue(menageMoisLocalite.getNomLocalite());

            menageMoisLocaliteRow.createCell(3).setCellValue(menageMoisLocalite.getNbMenage().intValue());
            menageMoisLocaliteRow.createCell(4).setCellValue(menageMoisLocalite.getEffTotal().intValue());
            menageMoisLocaliteRow.createCell(5).setCellValue(menageMoisLocalite.getEffHomme().intValue());
			menageMoisLocaliteRow.createCell(6).setCellValue(menageMoisLocalite.getEffFemme().intValue());
			
            menageMoisLocaliteRow.createCell(7).setCellValue(menageMoisLocalite.getNbMemageChefFemme().intValue());
			menageMoisLocaliteRow.createCell(8).setCellValue(menageMoisLocalite.getEffMembreFemme().intValue());
            menageMoisLocaliteRow.createCell(9).setCellValue(menageMoisLocalite.getNbEffHommeFemme().intValue());
            menageMoisLocaliteRow.createCell(10).setCellValue(menageMoisLocalite.getNbEffFemmeFemme().intValue());
            
			
            menageMoisLocaliteRow.createCell(11).setCellValue(menageMoisLocalite.getNbMemageChefHomme().intValue());
			menageMoisLocaliteRow.createCell(12).setCellValue(menageMoisLocalite.getEffMembreHomme().intValue());
            menageMoisLocaliteRow.createCell(13).setCellValue(menageMoisLocalite.getEffHommeHomme().intValue());
            menageMoisLocaliteRow.createCell(14).setCellValue(menageMoisLocalite.getEffHommeFemme().intValue());
            
			

			
            menageMoisLocaliteRow.createCell(15).setCellValue(menageMoisLocalite.getNbMenagePauvreModel1().intValue());
            menageMoisLocaliteRow.createCell(16).setCellValue(menageMoisLocalite.getNbMenageRicheModel1().intValue());
			
			 menageMoisLocaliteRow.createCell(17).setCellValue(menageMoisLocalite.getNbMenagePauvreModel2().intValue());
            menageMoisLocaliteRow.createCell(18).setCellValue(menageMoisLocalite.getNbMenageRicheModel2().intValue());
			
			 menageMoisLocaliteRow.createCell(19).setCellValue(menageMoisLocalite.getNbMenagePauvreModel3().intValue());
            menageMoisLocaliteRow.createCell(20).setCellValue(menageMoisLocalite.getNbMenageRicheModel3().intValue());
			
			 menageMoisLocaliteRow.createCell(21).setCellValue(menageMoisLocalite.getNbMenagePauvreModel4().intValue());
            menageMoisLocaliteRow.createCell(22).setCellValue(menageMoisLocalite.getNbMenageRicheModel4().intValue());
			
			 menageMoisLocaliteRow.createCell(23).setCellValue(menageMoisLocalite.getNbMenagePauvreModel5().intValue());
            menageMoisLocaliteRow.createCell(24).setCellValue(menageMoisLocalite.getNbMenageRicheModel5().intValue());
			
 
        }

    }
}
