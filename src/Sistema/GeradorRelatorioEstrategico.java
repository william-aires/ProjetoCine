package Sistema;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeradorRelatorioEstrategico {
	private float arrecadacaoPorSessao = 0;
	private float arrecadacaoPorSala = 0;
	
	
	public void gerarDoc() {
		Document doc = new Document(PageSize.A4, 72, 72, 72, 72);
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();

		try {
			PdfWriter.getInstance(doc, new FileOutputStream("relatorio_estrategico.pdf"));
			doc.open();
			Paragraph pgh1 = new Paragraph("RELATÓRIO ESTRATÉGICO \n");
			doc.add(pgh1);
			for (Sala sala : central.recuperarArrayDeSalas()) {
				Paragraph pgh2 = new Paragraph("Nome Da SALA: " + sala.getNomeDaSala() + "\n------------------------------------------------\nArrecadação Da sala:" + sala.getArrecadacao());
				doc.add(pgh2);
				for (Sessao sessao : sala.getSessoes()) {
					Paragraph pg = new Paragraph("Id da Sessão: " + sessao.getId() +
							"\nArrecadação por sessao:" + sessao.getArrecadacao() + "\nIngressos Vendidos: " + sessao.getIngressosVendidos() + 
							"\nIngressos não vendidos: " + sessao.getVagas() + "\n  ");
					doc.add(pg);
				}		
			}
			doc.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();

		}

	}

}
