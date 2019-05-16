package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviRsuMenageAnneeRegionView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviRsuMenageAnneeRegionViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviRsuMenageAnneeRegionView> menageAnneeRegions = (List<PrgSuiviRsuMenageAnneeRegionView>)map.get("Suivi_Menage_A_Region");

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
        for(PrgSuiviRsuMenageAnneeRegionView menageAnneeRegion : menageAnneeRegions){
            Row menageAnneeRegionRow =  sheet.createRow(currentRow++);
            menageAnneeRegionRow.createCell(0).setCellValue(menageAnneeRegion.getAnnee().intValue());
			menageAnneeRegionRow.createCell(1).setCellValue(menageAnneeRegion.getNomRegion());
			
            menageAnneeRegionRow.createCell(2).setCellValue(menageAnneeRegion.getNbMenage().intValue());
            menageAnneeRegionRow.createCell(3).setCellValue(menageAnneeRegion.getEffTotal().intValue());
            menageAnneeRegionRow.createCell(4).setCellValue(menageAnneeRegion.getEffHomme().intValue());
			menageAnneeRegionRow.createCell(5).setCellValue(menageAnneeRegion.getEffFemme().intValue());
			
            menageAnneeRegionRow.createCell(6).setCellValue(menageAnneeRegion.getNbMemageChefFemme().intValue());
			 menageAnneeRegionRow.createCell(7).setCellValue(menageAnneeRegion.getEffMembreFemme().intValue());
            menageAnneeRegionRow.createCell(8).setCellValue(menageAnneeRegion.getNbEffHommeFemme().intValue());
            menageAnneeRegionRow.createCell(9).setCellValue(menageAnneeRegion.getNbEffFemmeFemme().intValue());
           
			
            menageAnneeRegionRow.createCell(10).setCellValue(menageAnneeRegion.getNbMemageChefHomme().intValue());
			 menageAnneeRegionRow.createCell(11).setCellValue(menageAnneeRegion.getEffMembreHomme().intValue());
            menageAnneeRegionRow.createCell(12).setCellValue(menageAnneeRegion.getEffHommeHomme().intValue());
            menageAnneeRegionRow.createCell(13).setCellValue(menageAnneeRegion.getEffHommeFemme().intValue());
           
			

			
            menageAnneeRegionRow.createCell(14).setCellValue(menageAnneeRegion.getNbMenagePauvreModel1().intValue());
            menageAnneeRegionRow.createCell(15).setCellValue(menageAnneeRegion.getNbMenageRicheModel1().intValue());
			
			 menageAnneeRegionRow.createCell(16).setCellValue(menageAnneeRegion.getNbMenagePauvreModel2().intValue());
            menageAnneeRegionRow.createCell(17).setCellValue(menageAnneeRegion.getNbMenageRicheModel2().intValue());
			
			 menageAnneeRegionRow.createCell(18).setCellValue(menageAnneeRegion.getNbMenagePauvreModel3().intValue());
            menageAnneeRegionRow.createCell(19).setCellValue(menageAnneeRegion.getNbMenageRicheModel3().intValue());
			
			 menageAnneeRegionRow.createCell(20).setCellValue(menageAnneeRegion.getNbMenagePauvreModel4().intValue());
            menageAnneeRegionRow.createCell(21).setCellValue(menageAnneeRegion.getNbMenageRicheModel4().intValue());
			
			 menageAnneeRegionRow.createCell(22).setCellValue(menageAnneeRegion.getNbMenagePauvreModel5().intValue());
            menageAnneeRegionRow.createCell(23).setCellValue(menageAnneeRegion.getNbMenageRicheModel5().intValue());
			
 
        }

    }
}
