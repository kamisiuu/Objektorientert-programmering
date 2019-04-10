package guiPets;

import varelager.Fisk;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import medlemmer.Leverandor;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

public class AddFisker extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8334409974103114516L;
	private final JPanel contentPanel = new JPanel();
	private JTextField ProduktnavnTF;
	private JTextField InnkjopsprisTF;
	private JTextField PrisTF;
	private JTextField SlektsnavnTF;
	private JTextField ArtsnavnTF;
	private JComboBox<Object> LeverandorCB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddFisker dialog = new AddFisker();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddFisker() {
		setTitle("Add Fisker");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblSkrivInnHvor = new JLabel("Legg til en fisk");
		lblSkrivInnHvor.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		ProduktnavnTF = new JTextField();
		ProduktnavnTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Produktnavn:");
		
		InnkjopsprisTF = new JTextField();
		InnkjopsprisTF.setColumns(10);
		
		PrisTF = new JTextField();
		PrisTF.setColumns(10);
		
		SlektsnavnTF = new JTextField();
		SlektsnavnTF.setColumns(10);
		
		ArtsnavnTF = new JTextField();
		ArtsnavnTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Innkj\u00F8pspris:");
		
		JLabel lblNewLabel_2 = new JLabel("Pris:");
		
		JLabel lblLeverandr = new JLabel("Leverand\u00F8r:");
		
		JLabel lblSlektsnavn = new JLabel("Slektsnavn:");
		
		JLabel lblArtsnavn = new JLabel("Artsnavn:");
		
		// Legger til en funksjon for ComboBox LeverandorCB
		
		// Lage array for leverandor
		
		Leverandor[] leverandorArray = new Leverandor[PetFrame.getLeverandorList().size()];
		
		// kopierer objektreferanser fra lister til Arrays
		PetFrame.getLeverandorList().toArray(leverandorArray);
		
		LeverandorCB = new JComboBox<Object>(leverandorArray);
		
		LeverandorCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
			}			
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(127, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblSkrivInnHvor, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSlektsnavn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addComponent(lblLeverandr, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblArtsnavn))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(ProduktnavnTF)
								.addComponent(InnkjopsprisTF)
								.addComponent(PrisTF)
								.addComponent(SlektsnavnTF)
								.addComponent(ArtsnavnTF)
								.addComponent(LeverandorCB, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(6)))
					.addGap(115))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSkrivInnHvor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(ProduktnavnTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(InnkjopsprisTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(PrisTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLeverandr)
								.addComponent(LeverandorCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(SlektsnavnTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSlektsnavn))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ArtsnavnTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblArtsnavn))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Legg Til");
				okButton.addActionListener(new ActionListener() {
					// Legger til en lytter til knappen Legg Til
					public void actionPerformed(ActionEvent e) {
						
						// Gjør om disse slik at vi de kan leses som en String.
						String IP = InnkjopsprisTF.getText();
						String P = PrisTF.getText();
						double inkjPris = 0;
						double pris = 0;
						
						try{
							inkjPris = Integer.parseInt(IP);
							pris = Integer.parseInt(P);
						}
						
						catch(Exception ex){
							JOptionPane.showMessageDialog(null, ex);
						}
						
						String produktnavn = ProduktnavnTF.getText();
						Leverandor leverandor = (Leverandor) LeverandorCB.getSelectedItem();
						String slektsnavn = SlektsnavnTF.getText();
						String artsnavn = ArtsnavnTF.getText();
						
						if(produktnavn.length() != 0 && IP.length()  != 0 && P.length()  != 0 &&
								slektsnavn.length() != 0 && artsnavn.length() != 0){							
						
							Fisk fisk = new Fisk(produktnavn, inkjPris, pris, leverandor, slektsnavn, artsnavn);	
							
							//legg til i LeverandorList
							PetFrame.getFiskList().add(fisk);
							
							// Lukker vinduet
							dispose();
							}
							else{
							JOptionPane.showMessageDialog(null,"No Vaule");
							}
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
	}
}
