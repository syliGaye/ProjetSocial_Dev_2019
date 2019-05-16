
package ci.projetSociaux.download.pdf;

import ci.projetSociaux.entity.PrgEmmissionView;
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

public class PrgEmmissionViewPdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	
        
    	List<PrgEmmissionView> emmissionss = (List<PrgEmmissionView>) model.get("lesEmmissions");
    	
     
        Paragraph tit =new Paragraph("Liste des emissions");
     	tit.setAlignment(Element.ALIGN_CENTER);
    	 
    	document.add(tit);
        PdfPTable table = new PdfPTable(8);
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
        cell.setPhrase(new Phrase("Année", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Période", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Localité", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Village", font));
        table.addCell(cell);

         cell.setPhrase(new Phrase("Menage", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Chef Menage", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Montant", font));
        table.addCell(cell);
        

        for(PrgEmmissionView emmissions : emmissionss){
        	
        	table.addCell(emmissions.getAnneePeriode());
            table.addCell(emmissions.getLibellePeriode());
            table.addCell(String.valueOf(emmissions.getDateDebEmm()));
            table.addCell(emmissions.getNomLocalite());
            table.addCell(emmissions.getVillageQuartier());
            table.addCell(emmissions.getCodMenage());
            table.addCell(emmissions.getNomChefMenage());
            table.addCell(String.valueOf(emmissions.getMontantEmis()));
           
        }

        
        document.add(table);
    }
}
