package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;


import medlemmer.Leverandor;
import varelager.Fisk;

public class AddFish extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox<Object> comboBox;
	private JLabel lblSlektsnavn;
	private JTextField textField_3;
	private JLabel lblArtsnavn;
	private JTextField textField_4;
	//private String melding= "Fyll ut alle feltene";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		try {
			AddFish dialog = new AddFish();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddFish() {
	    
		setTitle("Add FIsh");
		setBounds(100, 100, 450, 300);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		{
			lblNewLabel = new JLabel("Produktnavn");
		}
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
	
				
				
			}
		});
		textField.setColumns(10);
		
		JLabel lblInkjpspris = new JLabel("inkjøpspris");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblPris = new JLabel("pris");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblLeverandor = new JLabel("leverandor");
		
		Leverandor[] liste = new Leverandor[MainFrame.getListe().size()];
		MainFrame.getListe().toArray(liste);
		
		comboBox = new JComboBox<Object>(liste);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		
		lblSlektsnavn = new JLabel("slektsnavn");
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_3.setColumns(10);
		
		lblArtsnavn = new JLabel("artsnavn");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{ 
				// ok lytter
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//
						//Lagrer den i en String produktnavn midlertidlig så henter den fra textField-som er navnet på første tekstfield
						String produktnavn=textField.getText();
						//System.out.println(produktnavn);
						// den andre variabelen når vi oppretter objektet er av type double som heter inkjPris og siden den er i textfield_1 så må vi
						//parseInt den fra String til tall , siden vi ikke kunne legge den til i if testen så måtte vi lagre den i en annen string
						// for å kunne hente lengden til den i if-en
						String IP= textField_1.getText();
						
						//samme gjentas her
						String Pr=textField_2.getText();
						double pris=0;
						 double inkjPris=0;
						 try{
								inkjPris=Integer.parseInt(IP);
								pris =Integer.parseInt(Pr);
								}
						 catch(Exception ex){
									JOptionPane.showMessageDialog(null, ex);
								}
						
						//den henter leverandor som er lagret og putter den i comboBox! 
						Leverandor lev = (Leverandor)comboBox.getSelectedItem();
						String slektsnavn=textField_3.getText();
						String artsnavn=textField_4.getText();
						
						
						// legger til sånn at alle felter må fylles ut for å legge til en fisk 
						if(produktnavn.length() != 0 && slektsnavn.length() != 0 && artsnavn.length() != 0 && IP.length() 
								!= 0 && Pr.length() != 0){
							
							
							Fisk fisken= new Fisk(produktnavn, inkjPris, pris, lev, slektsnavn, artsnavn);
							//get getter fra MainFrame legg den i fishen arrayen og lagre den som fisken 
							MainFrame.getFishen().add(fisken);
							dispose();
						}
						else{
							JOptionPane.showMessageDialog(null,"fyll ut alle feltene");
						}
						
						//String textF1=textField.getText(); 
						
						
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblInkjpspris)
								.addComponent(lblPris)
								.addComponent(lblLeverandor)
								.addComponent(lblSlektsnavn)
								.addComponent(lblArtsnavn))
							.addGap(24)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textField_2)
									.addComponent(textField_1)
									.addComponent(textField))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(48)
							.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(117, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInkjpspris)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPris)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLeverandor)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSlektsnavn)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblArtsnavn)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
		);
		contentPanel.setLayout(gl_contentPanel);
		getContentPane().setLayout(groupLayout);
	}
}
