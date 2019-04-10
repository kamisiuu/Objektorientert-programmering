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
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.LastProdukter;
import medlemmer.Leverandor;
import varelager.Fisk;
import varelager.Pattedyr;
import varelager.Produkt;
import varelager.Reptil;

import javax.swing.JTextField;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PetFrame extends JFrame {

	// Liste over enheter / objekter i programmet
	private static ArrayList<Fisk> fiskList = new ArrayList<>();
	private static ArrayList<Reptil> reptilList = new ArrayList<>();
	private static ArrayList<Pattedyr> pattedyrList = new ArrayList<>();
	private static ArrayList<Leverandor> leverandorList = new ArrayList<>();
	private static JLabel antallProdukterN;
	
	
	
	// Henter fra fil
	
	

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

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1203095203645431680L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Leverandor lev = new Leverandor("Lasse", "lasseandrefloien@gmail.com", "Prestegårdsveien 12", 1791,
				"Halden", 99250071);
		
		
	// Laste produkter
		String fpath = "C:\\Users\\Lasse\\Dropbox\\school\\OOP\\Oving5\\Fisk.txt";
		new LastProdukter(fpath);
		
		String rpath = "C:\\Users\\Lasse\\Dropbox\\school\\OOP\\Oving5\\Reptil.txt";
		new LastProdukter(rpath);
		
		String ppath = "C:\\Users\\Lasse\\Dropbox\\school\\OOP\\Oving5\\Pattedyr.txt";
		new LastProdukter(ppath);
		
		String lpath = "C:\\Users\\Lasse\\Dropbox\\school\\OOP\\Oving5\\Leverandor.txt";
		new LastProdukter(lpath);
		
		
		
		
	//  Fisk Torsk = new Fisk("Torsk", 100, 150, lev, "saltvannsfisk", "torsk");
	//	Reptil slange = new Reptil("Pyton", "Pyton", 99, 149, lev);
	//	Pattedyr p = new Pattedyr("Pattedyr", 122, 112, lev, "asd", "asd");
		
	//	pattedyrList.add(p);
		leverandorList.add(lev);
	//	fiskList.add(Torsk);
	//	reptilList.add(slange); 
		


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

		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {

				antallProdukterN.setText(Produkt.getAntProdukter() + "");

			}

			public void windowLostFocus(WindowEvent arg0) {
			}
		});
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
				
				// Fisk
				String Fpath = "C:\\Users\\Lasse\\Dropbox\\school\\OOP\\Oving5\\Fisk.txt";
				String Fcmd = "Fisk";
				new LargeProdukter(Fpath, Fcmd);
				
				// Reptil
				String Rpath = "C:\\Users\\Lasse\\Dropbox\\school\\OOP\\Oving5\\Reptil.txt";
				String Rcmd = "Reptil";
				new LargeProdukter(Rpath, Rcmd);
				
				// Pattedyr
				String Ppath = "C:\\Users\\Lasse\\Dropbox\\school\\OOP\\Oving5\\Pattedyr.txt";
				String Pcmd = "Pattedyr";
				new LargeProdukter(Ppath, Pcmd);
				
				// Leverandor
				String Lpath = "C:\\Users\\Lasse\\Dropbox\\school\\OOP\\Oving5\\Leverandor.txt";
				String Lcmd = "Leverandor";
				new LargeProdukter(Lpath, Lcmd);
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
		
		final JLabel antFiskerLb = new JLabel("0");
		antFiskerLb.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				// Legg inn funksjonalitet for antall fisker
				antFiskerLb.setText(Fisk.getAntFisker() + "");
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAntallProdukter, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFisker, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(antallProdukterN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(225))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(antFiskerLb, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
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
						.addComponent(antFiskerLb))
					.addGap(200))
		);
		getContentPane().setLayout(groupLayout);
	}
}
