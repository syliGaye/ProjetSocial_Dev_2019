package ci.projetSociaux.download.pdf;

import ci.projetSociaux.entity.PrgHistoRecipiendaireView;
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

public class PrgHistoRecipiendaireViewPdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	
        
    	List<PrgHistoRecipiendaireView> historiques = (List<PrgHistoRecipiendaireView>) model.get("Histo_Recipiendaire");
    	
     
        Paragraph tit =new Paragraph("Liste Des Historiques Des Récipiendaires");
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
        cell.setPhrase(new Phrase("N°Récipiendaire", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Nom Récipiendaire", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Téléphone", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Agence", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Nom Chef Menage", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Genre", font));
        table.addCell(cell);

         cell.setPhrase(new Phrase("Région", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Département", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Sous Préfecture", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Localité", font));
        table.addCell(cell);

        //  cell.setPhrase(new Phrase("MODEL  5", font));
       // table.addCell(cell);
        
       

        for(PrgHistoRecipiendaireView historique : historiques){
            table.addCell(historique.getIdHistoRecipiendaire());
            table.addCell(historique.getNomRecipiendaire());
            table.addCell(historique.getTelRecipiendaire());
            table.addCell(historique.getRaisonSocialAp());
            
            table.addCell(historique.getNomChefMenage());
            table.addCell(historique.getGenre());
            table.addCell(historique.getNomRegion());
            table.addCell(historique.getNomDepartement());
            table.addCell(historique.getNomSPref());
            table.addCell(historique.getNomLocalite());
            
            /*
            table.addCell(String.valueOf(historique.getNomChefMenage()));
            table.addCell(String.valueOf(historique.getGenre()));
            table.addCell(String.valueOf(historique.getNomRegion()));
            table.addCell(String.valueOf(historique.getNomDepartement()));
            table.addCell(String.valueOf(historique.getNomSPref()));
           // table.addCell(String.valueOf(historique.getModifierLe()));
            //table.addCell(String.valueOf(historique.getCreerLe()));
            table.addCell(String.valueOf(historique.getNomLocalite()));
            */
        }

        
        document.add(table);
    }
}
