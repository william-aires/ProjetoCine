package Sistema;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.ImageIcon;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GerarBoleto {
	public void gerarDoc(Float valor, String nome) {
		Document doc = new Document(PageSize.A4, 72, 72, 72, 72);
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();

		try {
			PdfWriter.getInstance(doc, new FileOutputStream("BOLETO.pdf"));
			doc.open();
			Paragraph pa = new Paragraph("BOLETO \n" + "Nome: " + nome + "\nPreço: " + valor);
			
			doc.add(pa);
	
			doc.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();

		}
	}
}
