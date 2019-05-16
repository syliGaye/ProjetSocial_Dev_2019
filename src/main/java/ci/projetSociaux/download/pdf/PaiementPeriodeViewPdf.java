package ci.projetSociaux.download.pdf;

import ci.projetSociaux.entity.PrgPaiementPeriodeView;
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

public class PaiementPeriodeViewPdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	
        
    	List<PrgPaiementPeriodeView> PaiementPeriode = (List<PrgPaiementPeriodeView>) model.get("lesPaiementPeriodeView");
    	
     
        Paragraph tit =new Paragraph("Consultation Des Paiements Par Periode");
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

        cell.setPhrase(new Phrase("Libelle Periode", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date Emission", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date Fin Emission", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Total", font));
        table.addCell(cell);

         cell.setPhrase(new Phrase("Effectif", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Statut Periode", font));
        table.addCell(cell);
        
       

        for(PrgPaiementPeriodeView menage : PaiementPeriode){
            table.addCell(menage.getCodPeriode());
            table.addCell(menage.getLibellePeriode());
            table.addCell(String.valueOf(menage.getDateDebEmm()));
            table.addCell(String.valueOf(menage.getDateFinEmm()));
            table.addCell(String.valueOf(menage.getTotPaiementBenef()));
            table.addCell(String.valueOf(menage.getNbPaiementBenef()));
            table.addCell(menage.getStatutPeriode());
            
            
        }

        
        document.add(table);
    }
}
