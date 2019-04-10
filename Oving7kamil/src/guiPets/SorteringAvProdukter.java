package guiPets;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
public class SorteringAvProdukter extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JList<Object> list = null;
	private final JPanel contentPanel = new JPanel();
	
	private static DefaultListModel<Object> ListModel = new DefaultListModel<Object>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
			
		try {
			SorteringAvProdukter dialog = new SorteringAvProdukter();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Create the dialog.
	 */
	public SorteringAvProdukter() {
		System.out.println("runs");
		
		ListModel.clear();
		
		//Collections.sort((List)PetFrame.fiskList , new RevSortTall());
		for(int i = 0; i < PetFrame.getProduktList().size();i ++){
			ListModel.addElement(PetFrame.getProduktList().get(i));
			System.out.println(PetFrame.getProduktList().get(i));
			//ListModel.addElement(reptilList);
		}
		
		list = new JList<Object>(ListModel);
		
		JButton btnA = new JButton("A-\u00C5");
		
		JButton btna = new JButton("\u00C5-A");
		
		JButton btnLavhy = new JButton("Lav-H\u00F8y");
		
		JButton btnHylav = new JButton("H\u00F8y-Lav");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnA)
						.addComponent(btna)
						.addComponent(btnLavhy)
						.addComponent(btnHylav))
					.addContainerGap(155, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnA)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btna)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnLavhy)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnHylav))
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	

		
		JButton button = new JButton("New button");
		
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnA)
						.addComponent(button))
					.addContainerGap(150, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnA)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button))
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		
		JButton btnA_1 = new JButton("A-\u00C5");
		btnA_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnA_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Collections.sort((List)PetFrame.getProduktList(), new SortStrengPositiv());
				ListModel.clear();
				
				for(Object o : PetFrame.getProduktList()){
					ListModel.addElement(o);
				}
				//for(int i = 0; i < PetFrame.getProduktList().size();i ++){
					//ListModel.addElement(PetFrame.getProduktList().get(i));
					//System.out.println(PetFrame.getProduktList().get(i));
				//}
				list.setModel(ListModel);
			}
		});
		
		JButton btna_1 = new JButton("\u00C5-A");
		btna_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Collections.sort((List)PetFrame.getProduktList(), new RevSortStreng());
				ListModel.clear();
				for(int i = 0; i < PetFrame.getProduktList().size();i ++){
					ListModel.addElement(PetFrame.getProduktList().get(i));
					System.out.println(PetFrame.getProduktList().get(i));
				}
				list.setModel(ListModel);
			}
		});
		
		JButton btnLavhy_1 = new JButton("Lav-H\u00F8y");
		btnLavhy_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLavhy_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				
			}
			@Override
			public void focusGained(FocusEvent e) {
				Collections.sort((List)PetFrame.getProduktList() , new SortPris());
				ListModel.clear();
				for(int i = 0; i < PetFrame.getProduktList().size();i ++){
					ListModel.addElement(PetFrame.getProduktList().get(i));
					System.out.println(PetFrame.getProduktList().get(i));
				}
				list.setModel(ListModel);
				
			}
		});
		
		JButton btnHylav_1 = new JButton("H\u00F8y-Lav");
		btnHylav_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Collections.sort((List)PetFrame.getProduktList(), new SortPrisPositiv());
				ListModel.clear();
				for(int i = 0; i < PetFrame.getProduktList().size();i ++){
					ListModel.addElement(PetFrame.getProduktList().get(i));
					System.out.println(PetFrame.getProduktList().get(i));
				}
				list.setModel(ListModel);
			}
		});
		btnHylav_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				//Collections.sort((List)PetFrame.fiskList , new RevSortTall());
			}
		});
		
		JScrollBar scrollBar = new JScrollBar();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnA_1)
						.addComponent(btna_1)
						.addComponent(btnLavhy_1)
						.addComponent(btnHylav_1))
					.addContainerGap(131, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
						.addComponent(list, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
							.addComponent(btnA_1)
							.addGap(18)
							.addComponent(btna_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnLavhy_1)
							.addGap(18)
							.addComponent(btnHylav_1)))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
