package ci.projetSociaux.download.pdf;

import ci.projetSociaux.entity.PrgPaiementView;
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

public class PaiemenMenageViewPdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	
        
    	List<PrgPaiementView> paiements = (List<PrgPaiementView>) model.get("lesPaiementMenages");
    	
     
        Paragraph tit =new Paragraph("Liste des Paiements Ménages");
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
        cell.setPhrase(new Phrase("Période", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date Paiement", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Sous-Préfecture", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Localite", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Identifiant Récipiendaire", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Nom-Prénom Récipiendaire", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Numero Tel Récipiendaire", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Agence", font));
        table.addCell(cell);

         cell.setPhrase(new Phrase("Montant", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Statut", font));
        table.addCell(cell);
        

        for(PrgPaiementView menage : paiements){
            table.addCell(menage.getLibellePeriode());
            table.addCell(String.valueOf(menage.getDatePaiement()));
            table.addCell(menage.getNomSPref());
            table.addCell(menage.getNomLocalite());
            table.addCell(menage.getIdRecipiendaire());
            table.addCell(menage.getNomRecipiendaire());
            table.addCell(menage.getTelRecipiendaire());
            table.addCell(menage.getRaisonSocialAp());
            table.addCell(String.valueOf(menage.getMontantPaiement()));
            table.addCell(menage.getLibStatutPaiement());
            
        }

        
        document.add(table);
    }
}
