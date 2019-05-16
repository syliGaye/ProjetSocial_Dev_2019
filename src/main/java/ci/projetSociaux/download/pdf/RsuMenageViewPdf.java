package ci.projetSociaux.download.pdf;

import ci.projetSociaux.entity.RsuMenageView;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class RsuMenageViewPdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	
        
    	List<RsuMenageView> menages = (List<RsuMenageView>) model.get("lesMenages");
    	
     
        Paragraph tit =new Paragraph("Liste des Ménages");
     	tit.setAlignment(Element.ALIGN_CENTER);
    	 
    	document.add(tit);
        PdfPTable table = new PdfPTable(10);
        table.setWidthPercentage(100.0f);
        table.setSpacingBefore(10);

        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.TIMES);
        font.setColor(BaseColor.WHITE);

        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.DARK_GRAY);
        cell.setPadding(5);

        
        // write table header
        cell.setPhrase(new Phrase("Région", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Localité", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Village", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Chef Ménage", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Effectif Total", font));
        table.addCell(cell);

         cell.setPhrase(new Phrase("MODEL  1", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("MODEL  2", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("MODEL  3", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("MODEL  4", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("MODEL  5", font));
        table.addCell(cell);
        
       

        for(RsuMenageView menage : menages){
            table.addCell(menage.getNomRegion());
            table.addCell(menage.getNomLocalite());
            table.addCell(menage.getVillageQuartier());
            table.addCell(menage.getNomChefMenage());
            table.addCell(String.valueOf(menage.getEffMenage()));
            table.addCell(String.valueOf(menage.getEffModel1()));
            table.addCell(String.valueOf(menage.getEffModel2()));
            table.addCell(String.valueOf(menage.getEffModel3()));
            table.addCell(String.valueOf(menage.getEffModel4()));
           // table.addCell(String.valueOf(menage.getModifierLe()));
            //table.addCell(String.valueOf(menage.getCreerLe()));
            table.addCell(String.valueOf(menage.getEffModel5()));
        }

        
        document.add(table);
    }
}
