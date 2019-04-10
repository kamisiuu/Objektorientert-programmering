package guiPets;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
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
import varelager.Reptil;

public class AddReptiler extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3276490998828130694L;
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
			AddReptiler dialog = new AddReptiler();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddReptiler() {
		setTitle("Add Reptiler");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Artsnavn:");
		
		JLabel label_1 = new JLabel("Leverand\u00F8r:");
		
		JLabel label_2 = new JLabel("Slektsnavn:");
		
		JLabel label_3 = new JLabel("Pris:");
		
		JLabel label_4 = new JLabel("Innkj\u00F8pspris:");
		
		JLabel label_5 = new JLabel("Produktnavn:");
		
		ProduktnavnTF = new JTextField();
		ProduktnavnTF.setColumns(10);
		
		InnkjopsprisTF = new JTextField();
		InnkjopsprisTF.setColumns(10);
		
		PrisTF = new JTextField();
		PrisTF.setColumns(10);
		
		SlektsnavnTF = new JTextField();
		SlektsnavnTF.setColumns(10);
		
		ArtsnavnTF = new JTextField();
		ArtsnavnTF.setColumns(10);
		
		JLabel lblLeggTilEt = new JLabel("Legg til et Reptil:");
		lblLeggTilEt.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		// Legger til en funksjon for ComboBox LeverandorCB
		
		// Lage array for leverandor
		
		Leverandor[] leverandorArray = new Leverandor[PetFrame.getLeverandorList().size()];
		
		// kopierer objektreferanser fra lister til Arrays
		PetFrame.getLeverandorList().toArray(leverandorArray);
		
		LeverandorCB = new JComboBox<Object>(leverandorArray);
		
		
		// Lytter for Combobox
		LeverandorCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(98, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLeggTilEt, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(ProduktnavnTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(InnkjopsprisTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(PrisTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LeverandorCB, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(SlektsnavnTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(ArtsnavnTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(131, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLeggTilEt, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_5)
						.addComponent(ProduktnavnTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_4))
						.addComponent(InnkjopsprisTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_3))
						.addComponent(PrisTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(LeverandorCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(label_2))
						.addComponent(SlektsnavnTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(ArtsnavnTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(label)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				// Legger til en funksjonalitet til LEGG TIL
				JButton okButton = new JButton("Legg Til");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						// Gj�r om disse slik at vi de kan leses som en String.
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
						
							Reptil reptil = new Reptil(produktnavn, inkjPris, pris,leverandor, slektsnavn, artsnavn); 
							 
							
							//legg til i LeverandorList
							PetFrame.getReptilList().add(reptil);
							
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
