package ci.projetSociaux.download.pdf;

import ci.projetSociaux.entity.PrgBeneficiaireView;
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

public class PrgBeneficiaireViewPdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	
        
    	List<PrgBeneficiaireView> beneficiaires = (List<PrgBeneficiaireView>) model.get("lesBeneficiaires");
    	
     
        Paragraph tit =new Paragraph("Liste des Bénéficiaires");
     	tit.setAlignment(Element.ALIGN_CENTER);
    	 
    	document.add(tit);
        PdfPTable table = new PdfPTable(6);
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
        cell.setPhrase(new Phrase("Code Ménage", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Chef Ménage", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date Affectation", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Score", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Recipiendaire", font));
        table.addCell(cell);

         cell.setPhrase(new Phrase("Statut", font));
        table.addCell(cell);

       
        
       

        for(PrgBeneficiaireView beneficiaire : beneficiaires){
            table.addCell(beneficiaire.getCodMenage());
            table.addCell(beneficiaire.getNomChefMenage());
            table.addCell(String.valueOf(beneficiaire.getDateAffect()));
            table.addCell(String.valueOf(beneficiaire.getScorePrg()));
            table.addCell(beneficiaire.getNomRecipiendaire());
            table.addCell(beneficiaire.getLibStatutBenef());
           
        }

        
        document.add(table);
    }
}
