package ci.projetSociaux.download.pdf;

import ci.projetSociaux.entity.PrgEmmissionPeriodeView;
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

public class PrgEmmissionPeriodeViewPdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	
        
    	List<PrgEmmissionPeriodeView> emmissions = (List<PrgEmmissionPeriodeView>) model.get("lesEmmissions");
    	
     
        Paragraph tit =new Paragraph("Liste des emmissions par periode");
     	tit.setAlignment(Element.ALIGN_CENTER);
    	 
    	document.add(tit);
        PdfPTable table = new PdfPTable(7);
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
        cell.setPhrase(new Phrase("Code Periode", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Libéllé Periode", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date Debut", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date Fin", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Statut Periode", font));
        table.addCell(cell);

         cell.setPhrase(new Phrase("Nbre Emissions", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Total Emission", font));
        table.addCell(cell);

        
        
       
        
        

        for(PrgEmmissionPeriodeView emmission : emmissions){
            table.addCell(emmission.getCodPeriode());
            table.addCell(emmission.getLibellePeriode());
            table.addCell(String.valueOf(emmission.getDateDebEmm()));
            table.addCell(String.valueOf(emmission.getDateFinEmm()));
            table.addCell(emmission.getStatutPeriode());
            table.addCell(String.valueOf(emmission.getNbEmmissionBenef()));
            table.addCell(String.valueOf(emmission.getTotEmmissionBenef()));
           
        }

        
        document.add(table);
    }
}
