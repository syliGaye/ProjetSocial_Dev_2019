package ci.projetSociaux.download.excel;

import ci.projetSociaux.entity.PrgPlainteConsView;
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


public class PrgPlainteConsViewExcel extends AbstractXlsView {

    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //VARIABLES REQUIRED IN MODEL
        String sheetName = (String)map.get("sheetname");
        List<String> headers = (List<String>)map.get("headers");
        List<PrgPlainteConsView> plaintes = (List<PrgPlainteConsView>)map.get("lesplaintes");

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
        for(PrgPlainteConsView plainte : plaintes){
            Row plainteRow =  sheet.createRow(currentRow++);
           
            plainteRow.createCell(0).setCellValue(plainte.getNumPlainte());
            plainteRow.createCell(1).setCellValue(plainte.getNomPlaingnant());
            plainteRow.createCell(2).setCellValue(plainte.getLibelleLieu());
            plainteRow.createCell(3).setCellValue(plainte.getLibelleMoment());
            plainteRow.createCell(4).setCellValue(plainte.getNomLocalite());
            plainteRow.createCell(5).setCellValue(StringUtils.formatDate2(plainte.getDateSignal()));
  
           
        }


       
    }
}
