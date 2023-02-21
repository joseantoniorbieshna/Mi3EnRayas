package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.MyButton;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class UI extends JFrame {
	private MyButton[][] botones = new MyButton[3][3];
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblMensaje;
	private JLabel lblCurrentPlayer;

	
	public UI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("3 EN RAYA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(103, 11, 232, 14);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBounds(105, 65, 230, 128);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		lblMensaje = new JLabel("");
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMensaje.setForeground(new Color(0, 204, 0));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setBounds(10, 219, 390, 31);
		contentPane.add(lblMensaje);
		
		JPanel panel_turno = new JPanel();
		panel_turno.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_turno.setBounds(10, 65, 77, 128);
		contentPane.add(panel_turno);
		GridBagLayout gbl_panel_turno = new GridBagLayout();
		gbl_panel_turno.columnWidths = new int[]{77, 0};
		gbl_panel_turno.rowHeights = new int[]{64, 64, 0};
		gbl_panel_turno.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_turno.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_turno.setLayout(gbl_panel_turno);
		
		JLabel lblTurno = new JLabel("TURNO");
		lblTurno.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurno.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblTurno = new GridBagConstraints();
		gbc_lblTurno.anchor = GridBagConstraints.SOUTH;
		gbc_lblTurno.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTurno.insets = new Insets(0, 0, 5, 0);
		gbc_lblTurno.gridx = 0;
		gbc_lblTurno.gridy = 0;
		panel_turno.add(lblTurno, gbc_lblTurno);
		
		lblCurrentPlayer = new JLabel("x");
		lblCurrentPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentPlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblCurrentPlayer = new GridBagConstraints();
		gbc_lblCurrentPlayer.anchor = GridBagConstraints.NORTH;
		gbc_lblCurrentPlayer.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCurrentPlayer.gridx = 0;
		gbc_lblCurrentPlayer.gridy = 1;
		panel_turno.add(lblCurrentPlayer, gbc_lblCurrentPlayer);
		
		
		
		//CREAR BOTONES
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				getBotones()[i][j] = new MyButton("",i,j);
				getBotones()[i][j].setFocusable(false);
				getPanel().add(getBotones()[i][j]);
			}
		}

		
		
	}
	protected MyButton[][] getBotones() {
		return this.botones;
	}
	protected JPanel getPanel() {
		return panel;
	}
	public JLabel getLblMensaje() {
		return lblMensaje;
	}
	public JLabel getLblCurrentPlayer() {
		return lblCurrentPlayer;
	}
}
