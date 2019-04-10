package guiPets;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import medlemmer.Leverandor;
import varelager.Pattedyr;

import javax.swing.JComboBox;

public class AddPatteDyr extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2355759683088765816L;
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
			AddPatteDyr dialog = new AddPatteDyr();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddPatteDyr() {
		setTitle("Add PatteDyr");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblLeggTilEt = new JLabel("Legg til et Pattedyr:");
		lblLeggTilEt.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel label_1 = new JLabel("Innkj\u00F8pspris:");
		
		JLabel label_2 = new JLabel("Produktnavn:");
		
		JLabel label_3 = new JLabel("Pris:");
		
		JLabel label_4 = new JLabel("Slektsnavn:");
		
		JLabel label_5 = new JLabel("Leverand\u00F8r:");
		
		JLabel label_6 = new JLabel("Artsnavn:");
		
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(127, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLeggTilEt, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
										.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_6))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(LeverandorCB, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(ProduktnavnTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(InnkjopsprisTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(PrisTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(SlektsnavnTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(ArtsnavnTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(121))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addComponent(lblLeggTilEt)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(ProduktnavnTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(InnkjopsprisTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(PrisTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_5)
								.addComponent(LeverandorCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(SlektsnavnTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_4))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ArtsnavnTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				// Legger til en funksjon i Action
				JButton okButton = new JButton("Legg Til");
				okButton.addActionListener(new ActionListener() {
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
						
							Pattedyr pattedyr = new Pattedyr(produktnavn, inkjPris, pris, leverandor, slektsnavn, artsnavn);	
							
							//legg til i LeverandorList
							PetFrame.getPattedyrList().add(pattedyr);
							
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
				//Lukker vindet hvis man trykker på cancel
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
