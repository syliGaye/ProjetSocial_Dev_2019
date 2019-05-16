package ci.projetSociaux.download.pdf;

import ci.projetSociaux.entity.PrgVirementApPeriodeView;
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

public class PrgVirementApPeriodeViewPdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	
        
    	List<PrgVirementApPeriodeView>  virements = (List<PrgVirementApPeriodeView> ) model.get("lesVirementAp");
    	
     
        Paragraph tit =new Paragraph("Liste des virements UGP");
     	tit.setAlignment(Element.ALIGN_CENTER);
    	 
    	document.add(tit);
    	//mettre le nombre de colonne
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
        cell.setPhrase(new Phrase("Id Virement", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Libelle Periode", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Nom Agence", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date Virement", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Montant Virement", font));
        table.addCell(cell);

         cell.setPhrase(new Phrase("Recu Virement", font));
        table.addCell(cell);


        for(PrgVirementApPeriodeView virement : virements){
            table.addCell(virement.getIdVirementAp());
            table.addCell(virement.getCodPeriode());
            table.addCell(virement.getRaisonSocialAp());
            table.addCell(String.valueOf(virement.getDateEnvoi()));
            table.addCell(String.valueOf(virement.getMontVir()));
            table.addCell(virement.getRecuVir());
   
        }

        
        document.add(table);
    }
}
