package guiPets;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.LastProdukter;
import medlemmer.Leverandor;
import varelager.Fisk;
import varelager.Pattedyr;
import varelager.Reptil;

public class PetFrame extends JFrame {

	// Liste over enheter / objekter i programmet
	private static ArrayList<Fisk> fiskList = new ArrayList<>();
	private static ArrayList<Reptil> reptilList = new ArrayList<>();
	private static ArrayList<Pattedyr> pattedyrList = new ArrayList<>();
	
	private static ArrayList<Leverandor> leverandorList = new ArrayList<>();
	private static JLabel antallProdukterN;
	
	

	// Getter og Setter
	public static ArrayList<Fisk> getFiskList() {
		return fiskList;
	}

	public static ArrayList<Reptil> getReptilList() {
		return reptilList;
	}

	public static ArrayList<Pattedyr> getPattedyrList() {
		return pattedyrList;
	}

	public static ArrayList<Leverandor> getLeverandorList() {
		return leverandorList;
	}


	private static final long serialVersionUID = 1203095203645431680L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// Laster inn fr fil når programmet starter
		new LastProdukter("C:\\Users\\Lasse\\Documents\\Skole\\OOP\\Oving7\\leverandor.ser");
		new LastProdukter("C:\\Users\\Lasse\\Documents\\Skole\\OOP\\Oving7\\fisk.ser");
		new LastProdukter("C:\\Users\\Lasse\\Documents\\Skole\\OOP\\Oving7\\pattedyr.ser");
		new LastProdukter("C:\\Users\\Lasse\\Documents\\Skole\\OOP\\Oving7\\reptil.ser");
		

		// Setter frame sånn at det blir synlig
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					PetFrame frame = new PetFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	// SKaper en tittel med Pets R Us
	public PetFrame() {

		JLabel lblAntallProdukter = new JLabel("Antall Produkter:");

		int R = getReptilList().size();
		int F = getFiskList().size();
		int P = getPattedyrList().size();
		final int summen = R + F + P;

		antallProdukterN = new JLabel(summen + "");
		final JLabel antFiskerLb = new JLabel(F + "");
		final JLabel antReptilerLB = new JLabel(R + "");
		final JLabel antPattedyrLB = new JLabel(P + "");

		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {

				antallProdukterN.setText(fiskList.size() + pattedyrList.size() + reptilList.size() + "");
				antFiskerLb.setText(fiskList.size() + "");
				antReptilerLB.setText(reptilList.size() + "");
				antPattedyrLB.setText(pattedyrList.size() + "");
			}
 
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		
		// Setter title på boksen
		setTitle("Pets 'R Us");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 305);

		// Lager en JMenuBar som ligger overst i JFrame
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		//
		JMenu mnFil = new JMenu("File");
		menuBar.add(mnFil);

		// Knappen Open under kategorien Add
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Legg in kode for at at fil skal kunne åpnes
			}
		});
		mnFil.add(mntmOpen);

		// Knappen Save under kategorien Add
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			// Lytter til Save
			public void actionPerformed(ActionEvent arg0) {
				
				
				ArrayList<Object> objLeverandorListe = new ArrayList<>();
				ArrayList<Object> objFiskListe = new ArrayList<>();
				ArrayList<Object> objPattedyrListe = new ArrayList<>();
				ArrayList<Object> objReptilListe = new ArrayList<>();
				
				
				for(Leverandor l  : leverandorList){
					objLeverandorListe.add(l);
				}
				
				for(Fisk f : fiskList){
					objFiskListe.add(f);
				}
				
				for(Pattedyr p : pattedyrList){
					objPattedyrListe.add(p);
				}
				
				for(Reptil r : reptilList){
					objReptilListe.add(r);
				}
				
				// hvor skal filen lagres
				new LargeProdukter("C:\\Users\\Lasse\\Documents\\Skole\\OOP\\Oving7\\leverandor.ser",objLeverandorListe);
				new LargeProdukter("C:\\Users\\Lasse\\Documents\\Skole\\OOP\\Oving7\\fisk.ser",objFiskListe);
				new LargeProdukter("C:\\Users\\Lasse\\Documents\\Skole\\OOP\\Oving7\\pattedyr.ser",objPattedyrListe);
				new LargeProdukter("C:\\Users\\Lasse\\Documents\\Skole\\OOP\\Oving7\\reptil.ser",objReptilListe);
				
			}
		});
		mnFil.add(mntmSave);

		// Legger til Add til en MenuBar
		JMenu mnAdd = new JMenu("Add");
		menuBar.add(mnAdd);

		// Boksen AddFisker og hva som skjer hvis vi klikker på denne boksen
		JMenuItem mntmFisker = new JMenuItem("Fisker");
		mntmFisker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFisker addFisker = new AddFisker();
				addFisker.setVisible(true);
			}
		});
		mnAdd.add(mntmFisker);

		// Legger til add Reptiler og at den åpner Dialog for Reptiler
		JMenuItem mntmReptiler = new JMenuItem("Reptiler");
		mntmReptiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddReptiler addReptiler = new AddReptiler();
				addReptiler.setVisible(true);
			}
		});
		mnAdd.add(mntmReptiler);

		// Legger til add Pattedyr og at den åpner Dialog for Pattedyr
		JMenuItem mntmPattedyr = new JMenuItem("Pattedyr");
		mntmPattedyr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPatteDyr addPatteDyr = new AddPatteDyr();
				addPatteDyr.setVisible(true);
			}
		});
		mnAdd.add(mntmPattedyr);

		JMenuItem mntmLeverandr = new JMenuItem("Leverand\u00F8r");
		mntmLeverandr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLeverandor addLeverandor = new AddLeverandor();
				addLeverandor.setVisible(true);
			}
		});
		mnAdd.add(mntmLeverandr);

		JMenu mnSell = new JMenu("Sell");
		menuBar.add(mnSell);

		// Legger til at man kan selg fisker og at dialogen kommer opp
		JMenuItem mntmFisker_1 = new JMenuItem("Fisker");
		mntmFisker_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelgFisker selgFisker = new SelgFisker();
				selgFisker.setVisible(true);
			}
		});
		mnSell.add(mntmFisker_1);

		// Legger til en funksjon som åpner boksen Selg Reptiler
		JMenuItem mntmReptiler_1 = new JMenuItem("Reptiler");
		mntmReptiler_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelgReptiler selgReptiler = new SelgReptiler();
				selgReptiler.setVisible(true);
			}
		});
		mnSell.add(mntmReptiler_1);

		// Legger til en funksjon som åpner boksen Selg PatteDyr
		JMenuItem mntmPattedyr_1 = new JMenuItem("Pattedyr");
		mntmPattedyr_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelgPatteDyr selgPatteDyr = new SelgPatteDyr();
				selgPatteDyr.setVisible(true);
			}
		});
		mnSell.add(mntmPattedyr_1);
		

		JLabel lblFisker = new JLabel("Fisker:");
		
		//final JLabel antFiskerLb = new JLabel(F + "");
		/*
		antFiskerLb.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				// Legg inn funksjonalitet for antall fisker
				antFiskerLb.setText(Fisk.getAntFisker() + "");
			}
		});
		*/
		
		JLabel lblReptiler = new JLabel("Reptiler:");
		
		//JLabel antReptilerLB = new JLabel(R + "");
		
		JLabel lblPattedyr = new JLabel("Pattedyr:");
		
		//JLabel antPattedyrLB = new JLabel(P + "");
		
		
		// setter layout
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAntallProdukter, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFisker, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblPattedyr, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblReptiler, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(antPattedyrLB, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
						.addComponent(antFiskerLb, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
						.addComponent(antallProdukterN, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
						.addComponent(antReptilerLB, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
					.addGap(225))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(antallProdukterN)
						.addComponent(lblAntallProdukter, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFisker)
						.addComponent(antFiskerLb, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReptiler, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(antReptilerLB, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPattedyr)
						.addComponent(antPattedyrLB, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addGap(159))
		);
		getContentPane().setLayout(groupLayout);
	}
}
