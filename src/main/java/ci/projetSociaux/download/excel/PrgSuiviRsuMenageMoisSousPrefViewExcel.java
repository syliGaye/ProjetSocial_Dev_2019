package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgSuiviRsuMenageMoisSousPrefView;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrgSuiviRsuMenageMoisSousPrefViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgSuiviRsuMenageMoisSousPrefView> menageMoiSps = (List<PrgSuiviRsuMenageMoisSousPrefView>)map.get("lesMenageMoiSps");

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
        for(PrgSuiviRsuMenageMoisSousPrefView menageMoiSp : menageMoiSps){
            Row menageMoiSpRow =  sheet.createRow(currentRow++);
            menageMoiSpRow.createCell(0).setCellValue(menageMoiSp.getAnnee().intValue());
			menageMoiSpRow.createCell(1).setCellValue(menageMoiSp.getLibelleMois());
			 menageMoiSpRow.createCell(2).setCellValue(menageMoiSp.getNomSPref());
			 
            menageMoiSpRow.createCell(3).setCellValue(menageMoiSp.getNbMenage().intValue());
            menageMoiSpRow.createCell(4).setCellValue(menageMoiSp.getEffTotal().intValue());
            menageMoiSpRow.createCell(5).setCellValue(menageMoiSp.getEffHomme().intValue());
			 menageMoiSpRow.createCell(6).setCellValue(menageMoiSp.getEffFemme().intValue());
			 
			 
			menageMoiSpRow.createCell(7).setCellValue(menageMoiSp.getNbMemageChefFemme().intValue());
            menageMoiSpRow.createCell(8).setCellValue(menageMoiSp.getEffMembreFemme().intValue());
            menageMoiSpRow.createCell(9).setCellValue(menageMoiSp.getNbEffHommeFemme().intValue());
            menageMoiSpRow.createCell(10).setCellValue(menageMoiSp.getNbEffFemmeFemme().intValue());
			 
            menageMoiSpRow.createCell(11).setCellValue(menageMoiSp.getNbMemageChefHomme().intValue());
            menageMoiSpRow.createCell(14).setCellValue(menageMoiSp.getEffMembreHomme().intValue());
            menageMoiSpRow.createCell(12).setCellValue(menageMoiSp.getEffHommeHomme().intValue());
            menageMoiSpRow.createCell(13).setCellValue(menageMoiSp.getEffHommeFemme().intValue());
			
          
			
            menageMoiSpRow.createCell(15).setCellValue(menageMoiSp.getNbMenagePauvreModel1().intValue());
            menageMoiSpRow.createCell(16).setCellValue(menageMoiSp.getNbMenageRicheModel1().intValue());
			
			 menageMoiSpRow.createCell(17).setCellValue(menageMoiSp.getNbMenagePauvreModel2().intValue());
            menageMoiSpRow.createCell(18).setCellValue(menageMoiSp.getNbMenageRicheModel2().intValue());
			
			 menageMoiSpRow.createCell(19).setCellValue(menageMoiSp.getNbMenagePauvreModel3().intValue());
            menageMoiSpRow.createCell(20).setCellValue(menageMoiSp.getNbMenageRicheModel3().intValue());
			
			 menageMoiSpRow.createCell(21).setCellValue(menageMoiSp.getNbMenagePauvreModel4().intValue());
            menageMoiSpRow.createCell(22).setCellValue(menageMoiSp.getNbMenageRicheModel4().intValue());
			
			 menageMoiSpRow.createCell(23).setCellValue(menageMoiSp.getNbMenagePauvreModel5().intValue());
            menageMoiSpRow.createCell(24).setCellValue(menageMoiSp.getNbMenageRicheModel5().intValue());
			
           
			
           
           
           
        }


       
    }
}

