package application;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controllers.OrderingProcess;

public class Window {

	protected JPanel basePane;

	public Window(JPanel basePane) {
		setBasePane(basePane);
		setNewPane(window(), basePane);
	}

	public JPanel window() {

		JPanel contentPane = new JPanel();

		contentPane.setBackground(new Color(50, 53, 58));

		JLabel lbGreetings = new JLabel("Insira os dados no formulário");
		lbGreetings.setBounds(385, 50, 400, 40);
		lbGreetings.setForeground(new Color(56, 48, 48));
		lbGreetings.setFont(new Font(lbGreetings.getFont().getName(), lbGreetings.getFont().getStyle(), 15));
		contentPane.add(lbGreetings);

		JLabel lbFileName = new JLabel("Digite o nome do arquivo:");
		//170
                lbFileName.setBounds(385, 120, 250, 30);
		lbFileName.setForeground(new Color(56, 48, 48));
		contentPane.add(lbFileName);

		final JTextField fileNameField = new JTextField(20);
		//120+30
                fileNameField.setBounds(385, 150, 275, 30);
		fileNameField.setEditable(true);
		fileNameField.setForeground(new Color(56, 48, 48));
                fileNameField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(56, 48, 48))); 
                fileNameField.setOpaque(false);
		//fileNameField.setBackground(new Color(48, 48, 48));
                
		fileNameField
				.setFont(new Font(fileNameField.getFont().getName(), fileNameField.getFont().getStyle(), 15));
		contentPane.add(fileNameField);

		JLabel lbQtCoord = new JLabel("Digite a quantidade de coordenadas:");
		lbQtCoord.setBounds(385, 190, 300, 30);
		lbQtCoord.setForeground(new Color(56, 48, 48));
		contentPane.add(lbQtCoord);

		final JTextField qtCoordField = new JTextField(20);
		qtCoordField.setBounds(385, 220, 275, 30);
		qtCoordField.setEditable(true);
		qtCoordField.setForeground(new Color(56, 48, 48));
		qtCoordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0,new Color(56, 48, 48)));
                qtCoordField.setOpaque(false);
                //qtCoordField.setBackground(new Color(48, 48, 48));
		qtCoordField.setFont(
				new Font(qtCoordField.getFont().getName(), qtCoordField.getFont().getStyle(), 15));
		contentPane.add(qtCoordField);

		JLabel lbRuntime = new JLabel("Tempo decorrido:");
		lbRuntime.setBounds(385, 260, 100, 30);
		lbRuntime.setForeground(new Color(56, 48, 48));
		contentPane.add(lbRuntime);

		final JTextArea runtimeArea = new JTextArea(1, 2);
		runtimeArea.setBounds(385, 290, 275, 80);
		runtimeArea.setEditable(false);
		runtimeArea.setLineWrap(true);
		runtimeArea.setForeground(new Color(56, 48, 48));
		runtimeArea.setFont(new Font(runtimeArea.getFont().getName(), runtimeArea.getFont().getStyle(), 12));
		runtimeArea.setWrapStyleWord(true);
		runtimeArea.setBackground(new Color(239, 239, 239));
		contentPane.add(runtimeArea);

		JButton btnGenerate = new JButton("Ordenar");
		btnGenerate.setBounds(385, 390, 100, 30);
		btnGenerate.setBackground(new Color(77, 230, 250));
		btnGenerate.setForeground(new Color(56, 48, 48));
		btnGenerate.setOpaque(true);
		btnGenerate.setBorderPainted(false);
		contentPane.add(btnGenerate);
                
                
                
		JButton btnClean = new JButton("Limpar");
		btnClean.setBounds(560, 390, 100, 30);
		btnClean.setBackground(new Color(77, 230, 250));
		btnClean.setForeground(new Color(56, 48, 48));
		btnClean.setOpaque(true);
		btnClean.setBorderPainted(false);
		contentPane.add(btnClean);

		btnGenerate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String fileNameInput = fileNameField.getText();
				int fileLengthInput = Integer.parseInt(qtCoordField.getText());
				OrderingProcess process = new OrderingProcess(fileNameInput, fileLengthInput);
				String results = process.start();
				runtimeArea.setText(results);
			}
		});
		
		btnClean.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fileNameField.setText("");	
				qtCoordField.setText("");
				runtimeArea.setText("");
			}
		});
		
		qtCoordField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			    char c = e.getKeyChar();
			    if (!((c >= '0') && (c <= '9') ||
			       (c == KeyEvent.VK_BACK_SPACE) ||
			       (c == KeyEvent.VK_DELETE))) {
			      e.consume();
			    }
				
			}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			
		});;

		return contentPane;

	}

	public void setNewPane(JPanel contentPane, JPanel basePane) {

		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(null);
		contentPane.setBounds(0, 0, 695, 472);
		
		JLabel background = new JLabel();
		background.setSize(contentPane.getWidth(), contentPane.getHeight());
		Image bg = new ImageIcon("back2.jpg").getImage().getScaledInstance(contentPane.getWidth(), contentPane.getHeight(),
				Image.SCALE_FAST);
		background.setIcon(new ImageIcon(bg));
		contentPane.add(background);
		
		basePane.add(contentPane);

	}

	public void setBasePane(JPanel basePane) {
		this.basePane = basePane;
	};

}
