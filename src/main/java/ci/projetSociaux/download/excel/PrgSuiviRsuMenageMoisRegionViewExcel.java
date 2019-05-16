package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisRegionView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviRsuMenageMoisRegionViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviRsuMenageMoisRegionView> menageMoisRegions = (List<PrgSuiviRsuMenageMoisRegionView>)map.get("Suivi_Menage_Mois_Region");

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
        for(PrgSuiviRsuMenageMoisRegionView menageMoisRegion : menageMoisRegions){
            Row menageMoisRegionRow =  sheet.createRow(currentRow++);
            menageMoisRegionRow.createCell(0).setCellValue(menageMoisRegion.getAnnee().intValue());
			 menageMoisRegionRow.createCell(1).setCellValue(menageMoisRegion.getLibelleMois());
			menageMoisRegionRow.createCell(2).setCellValue(menageMoisRegion.getNomRegion());
			
            menageMoisRegionRow.createCell(3).setCellValue(menageMoisRegion.getNbMenage().intValue());
            menageMoisRegionRow.createCell(4).setCellValue(menageMoisRegion.getEffTotal().intValue());
            menageMoisRegionRow.createCell(5).setCellValue(menageMoisRegion.getEffHomme().intValue());
			menageMoisRegionRow.createCell(6).setCellValue(menageMoisRegion.getEffFemme().intValue());
			
			menageMoisRegionRow.createCell(7).setCellValue(menageMoisRegion.getNbMemageChefFemme().intValue());
			 menageMoisRegionRow.createCell(8).setCellValue(menageMoisRegion.getEffMembreFemme().intValue());
            menageMoisRegionRow.createCell(9).setCellValue(menageMoisRegion.getNbEffHommeFemme().intValue());
            menageMoisRegionRow.createCell(10).setCellValue(menageMoisRegion.getNbEffFemmeFemme().intValue());
           
			
            menageMoisRegionRow.createCell(11).setCellValue(menageMoisRegion.getNbMemageChefHomme().intValue());
			menageMoisRegionRow.createCell(12).setCellValue(menageMoisRegion.getEffMembreHomme().intValue());
            menageMoisRegionRow.createCell(13).setCellValue(menageMoisRegion.getEffHommeHomme().intValue());
            menageMoisRegionRow.createCell(14).setCellValue(menageMoisRegion.getEffHommeFemme().intValue());
            
			

			
            menageMoisRegionRow.createCell(15).setCellValue(menageMoisRegion.getNbMenagePauvreModel1().intValue());
            menageMoisRegionRow.createCell(16).setCellValue(menageMoisRegion.getNbMenageRicheModel1().intValue());
			
			 menageMoisRegionRow.createCell(17).setCellValue(menageMoisRegion.getNbMenagePauvreModel2().intValue());
            menageMoisRegionRow.createCell(18).setCellValue(menageMoisRegion.getNbMenageRicheModel2().intValue());
			
			 menageMoisRegionRow.createCell(19).setCellValue(menageMoisRegion.getNbMenagePauvreModel3().intValue());
            menageMoisRegionRow.createCell(20).setCellValue(menageMoisRegion.getNbMenageRicheModel3().intValue());
			
			 menageMoisRegionRow.createCell(21).setCellValue(menageMoisRegion.getNbMenagePauvreModel4().intValue());
            menageMoisRegionRow.createCell(22).setCellValue(menageMoisRegion.getNbMenageRicheModel4().intValue());
			
			 menageMoisRegionRow.createCell(23).setCellValue(menageMoisRegion.getNbMenagePauvreModel5().intValue());
            menageMoisRegionRow.createCell(24).setCellValue(menageMoisRegion.getNbMenageRicheModel5().intValue());
			
 
        }

    }
}
