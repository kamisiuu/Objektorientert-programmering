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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import varelager.Reptil;

public class SelgReptiler extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8334409974103114516L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<Object> selgReptilCB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SelgReptiler dialog = new SelgReptiler();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SelgReptiler() {
		setTitle("Selg Reptiler");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblSkrivInnHvor = new JLabel("Velg hvilken Reptil du vil selge fra listen");
		lblSkrivInnHvor.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		

		Reptil[] ReptilArray = new Reptil[PetFrame.getReptilList().size()];
		
		// kopierer objektreferanser fra lister til Arrays
		PetFrame.getReptilList().toArray(ReptilArray);
		
		 selgReptilCB = new JComboBox<Object>(ReptilArray);
		
		
		selgReptilCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// Lytter for selgReptilCB
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(86, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(selgReptilCB, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(lblSkrivInnHvor, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
							.addGap(55))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(27)
					.addComponent(lblSkrivInnHvor, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(selgReptilCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(138, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				// Legger inn en for løkke som skal kjøre når man trykker på
				// Selg;
				JButton selgButton = new JButton("Selg");
				selgButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Reptil reptil = (Reptil) selgReptilCB.getSelectedItem();
						reptil.solgt();
						dispose();
					}
				});
				selgButton.setActionCommand("OK");
				buttonPane.add(selgButton);
				getRootPane().setDefaultButton(selgButton);
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
