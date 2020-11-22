package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel basePane;

	public View() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		basePane = new JPanel();
		basePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		basePane.setLayout(null);
		setContentPane(basePane);
		setResizable(false);
		setTitle("Ordenador de Coordenadas");
		new Window(basePane);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}