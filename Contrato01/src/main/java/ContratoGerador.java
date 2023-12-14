import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.File;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ContratoGerador extends JFrame {
    private JTextArea txtAreaContrato;
    private boolean contratoGerado = false;
    private String conteudoContrato;

    public ContratoGerador() {
        setTitle("Gerar Contrato");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel lblData = new JLabel("Data:");
        JTextField txtData = new JTextField(10);
        JLabel lblHorario = new JLabel("Horário:");
        JTextField txtHorario = new JTextField(10);
        // Adicione mais campos conforme necessário

        JButton btnGerarContrato = new JButton("Gerar Contrato");
        btnGerarContrato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para obter informações do formulário e criar o contrato
                // Por exemplo:
                String data = txtData.getText();
                String horario = txtHorario.getText();
                conteudoContrato = "Contrato gerado com data: " + data + ", horário: " + horario; // Adapte conforme suas necessidades
                contratoGerado = true;
                txtAreaContrato.setText(conteudoContrato);
            }
        });

        JButton btnDownloadPDF = new JButton("Download PDF");
        btnDownloadPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contratoGerado) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Salvar PDF");
                    int userSelection = fileChooser.showSaveDialog(null);

                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        File fileToSave = fileChooser.getSelectedFile();
                        String filePath = fileToSave.getAbsolutePath();

                        if (!filePath.toLowerCase().endsWith(".pdf")) {
                            filePath += ".pdf";
                        }

                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                            Document document = new Document();
                            PdfWriter.getInstance(document, fileOutputStream);
                            document.open();
                            document.add(new Paragraph(conteudoContrato));
                            document.close();
                            fileOutputStream.close();
                            JOptionPane.showMessageDialog(null, "PDF salvo com sucesso!");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Erro ao salvar o PDF.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, gere o contrato antes de fazer o download do PDF.");
                }
            }
        });

        txtAreaContrato = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(txtAreaContrato);

        panel.add(lblData);
        panel.add(txtData);
        panel.add(lblHorario);
        panel.add(txtHorario);
        panel.add(btnGerarContrato);
        panel.add(scrollPane);
        panel.add(btnDownloadPDF);
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ContratoGerador contratoGerador = new ContratoGerador();
                contratoGerador.setVisible(true);
            }
        });
    }
}