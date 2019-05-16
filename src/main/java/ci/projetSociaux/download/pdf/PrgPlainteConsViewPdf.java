package ci.projetSociaux.download.pdf;

import ci.projetSociaux.entity.PrgPlainteConsView;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.List;
import java.util.Map;

public class PrgPlainteConsViewPdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

    	
        
    	List<PrgPlainteConsView> plaintes = (List<PrgPlainteConsView>) model.get("lesplaintes");
    	
     
        Paragraph tit =new Paragraph("Liste des plaintes UGP");
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
        cell.setPhrase(new Phrase("Numéro Plainte", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Plaignant", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Lieu", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Moment", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Localité", font));
        table.addCell(cell);

         cell.setPhrase(new Phrase("date signalement", font));
        table.addCell(cell);


        for(PrgPlainteConsView plainte : plaintes){
            table.addCell(plainte.getNumPlainte());
            table.addCell(plainte.getNomPlaingnant());
            table.addCell(plainte.getLibelleLieu());
            table.addCell(plainte.getLibelleMoment());
            table.addCell(plainte.getNomLocalite());
            table.addCell(String.valueOf(plainte.getDateSignal()));
   
        }

        
        document.add(table);
    }
}
