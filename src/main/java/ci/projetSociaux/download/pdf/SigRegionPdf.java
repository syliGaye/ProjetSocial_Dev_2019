package ci.projetSociaux.download.pdf;

import ci.projetSociaux.entity.SigRegion;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class SigRegionPdf extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<SigRegion> regions = (List<SigRegion>) model.get("lesRegions");
        document.add(new Paragraph("Liste des Régions " + LocalDate.now()));

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
        cell.setPhrase(new Phrase("Code de la Région", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Nom de la Région", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Créer le", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Créer par", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Modifier le", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Modifier par", font));
        table.addCell(cell);

        for(SigRegion region : regions){
            table.addCell(region.getCodRegion());
            table.addCell(region.getNomRegion());
            table.addCell(String.valueOf(region.getCreerLe()));
            table.addCell(region.getCreerPar());
            table.addCell(String.valueOf(region.getModifierLe()));
            table.addCell(region.getModifierPar());
        }

        document.add(table);
    }
}
