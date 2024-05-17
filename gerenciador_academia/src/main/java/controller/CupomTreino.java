
package controller;


import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.Leading;
import com.itextpdf.layout.properties.ListNumberingType;
import com.itextpdf.layout.properties.Property;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Cliente;
import models.Exercicio;
import models.Cliente;


public class CupomTreino implements impressaoCupom{
    
    private String destinoArquivo;
    private float alturaDocumento;
    private float larguraDocumento;
    private Cliente cliente;
    private Map<String, List<Exercicio>> mapExercicio = new HashMap<>();
    private String diaSemana;
    
    public CupomTreino(){
        this.destinoArquivo = "./cupom.pdf"; //raiz do projeto
        this.alturaDocumento = (float) 118.0;
        this.larguraDocumento = (float) 88.0;
    }

    /**
     * Realiza a configuracao de qual biblioteca geradora de PDF a ser utilizada
     * @return Object biblioteca padrao a ser utilizada para a geracao do PDF
     */
    public Object configurarGeradorPDF() {
        
        PdfWriter writer = null;
        try {
            writer = new PdfWriter(this.destinoArquivo);
            return writer;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CupomTreino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return writer;
    }
    /**
     * Faz a impressão do cupom de treino com os exercícios, conforme o dia da semana de hoje
     */
    public void imprimirPDF() {
        
        try {
            PdfWriter writer = (PdfWriter) configurarGeradorPDF(); //substituir o cast para outras libs de acordo
            
            PdfDocument pdf = new PdfDocument(writer);
            Rectangle retangulo = new Rectangle(this.larguraDocumento, this.alturaDocumento);
            PageSize pagesize = new PageSize(retangulo);
            Document documento = new Document(pdf,pagesize);
            documento.setMargins(01, 04, 01, 04);
            PdfFont textoPadrao = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
            PdfFont titulo = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);
            
            //configs padrao de texto, outroas configs serao informadas de acordo com cada secao do documento
            documento.setFont(textoPadrao);
            documento.setFontSize(5);
            documento.setProperty(Property.LEADING, new Leading(Leading.MULTIPLIED, 0.2f)); //leading = entrelinhas (espacamento)
            
            //linhas de separacao de secoes e de corte de impressora
            Paragraph linhaCabecalho = new Paragraph("__________________________")
                    .setFont(titulo)
                    .setFontSize(6);
            Paragraph linhaRodape = new Paragraph("------------------------------------------------------------")
                    .setFont(titulo)
                    .setFontSize(4);
            Paragraph linhaSeparador = new Paragraph("****************************************************")
                    .setFont(titulo)
                    .setFontSize(3);
            
            Paragraph dadosEmpresa = new Paragraph("Gym Faustino             " + this.diaSemana); //refatorar como objeto e realizar injecao de dependencia
            Paragraph dadosCliente = new Paragraph("Cliente: " + this.cliente.getNome());
            Paragraph musculatura = new Paragraph("Musculatura: " + this.mapExercicio.get(this.diaSemana).get(0).getMusculaturaAfetada());
            Paragraph footer = new Paragraph("Never give up!! " + "   No Pain, No Gain!!");
            
            List<Exercicio> exercicios = this.mapExercicio.get(this.diaSemana);
            com.itextpdf.layout.element.List pdfList = new com.itextpdf.layout.element.List();
            for (Exercicio exercicio : exercicios) {
                pdfList.add(new ListItem(exercicio.getNome())); 
            }
            
            //organizacao final das linhas de impressao
            //poderia ser refatorado para uma lista de paragrafos para melhor organizacao (metodo esta muito longo)
            //entretanto paragrafos sao estruturas intimas do objeto gerador de PDF, muito alto acoplamento para separacao
            documento.add(linhaCabecalho);
            documento.add(dadosEmpresa);
            documento.add(linhaSeparador);
            documento.add(dadosCliente);
            documento.add(linhaSeparador);
            documento.add(musculatura);
            documento.add(pdfList);
            documento.add(linhaSeparador);
            documento.add(footer);
            documento.add(linhaRodape);
            documento.close(); //documento impresso
            
        } catch (IOException ex) {
            Logger.getLogger(CupomTreino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizarMapAndClienteAndDia(Cliente cliente, Map map, String dia){
        this.cliente = cliente;
        this.mapExercicio = map;
        this.diaSemana = dia;
    }
}