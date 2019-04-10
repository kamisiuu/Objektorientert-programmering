package guiPets;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.LayoutStyle.ComponentPlacement;

import main.LargeProdukter;
import main.LesFraFil;
import medlemmer.Leverandor;
import varelager.Fisk;
import varelager.Pattedyr;
import varelager.Produkt;
import varelager.Reptil;

public class PetFrame extends JFrame  {

	// Liste over enheter / objekter i programmet
	static ArrayList<Fisk> fiskList = new ArrayList<>();
	private static ArrayList<Reptil> reptilList = new ArrayList<>();
	private static ArrayList<Pattedyr> pattedyrList = new ArrayList<>();
	private static ArrayList<Leverandor> leverandorList = new ArrayList<>();
	private static LinkedList<Produkt> ProduktList = new LinkedList<Produkt>();
	private static JLabel antProdukterLb;
	
	final JLabel antFiskerLb;
	final JLabel antPattedyrLb;
	final JLabel antReptilerLb;
	private JList<Object> list;
	

	
	
	private static DefaultListModel<Object> ListModel = new DefaultListModel<Object>();
	
	
	// Getters
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
	 * 
	 */
	private static final long serialVersionUID = 1203095203645431680L;

	static RevSortStreng reversortering= new RevSortStreng();
	
	public static void main(String[] args) {
	
		
		new LesFraFil("C:\\Users\\Kamil\\Documents\\Leverandor.ser");
		
		
		new LesFraFil("C:\\Users\\Kamil\\Documents\\fisk.ser");
		
		new LesFraFil("C:\\Users\\Kamil\\Documents\\reptil.ser");
		
		new LesFraFil("C:\\Users\\Kamil\\Documents\\pattedyr.ser");
		
		ListModel.clear();
		ProduktList.addAll(fiskList);
		ProduktList.addAll(pattedyrList);
		ProduktList.addAll(reptilList);
		for(int i = 0; i < ProduktList.size();i ++){
		ListModel.addElement(ProduktList.get(i));
		
		//ListModel.addElement(reptilList);
		}
		
		
		
	
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
	JLabel lblFisker = new JLabel("Fisker:");
		
		
		JLabel lblReptiler = new JLabel("Reptiler");
		
		JLabel lblPattedyr = new JLabel("Pattedyr");
		
		
		
	

		JLabel lblAntallProdukter = new JLabel("Antall Produkter:");

		int R = getReptilList().size();
		int F = getFiskList().size();
		int P = getPattedyrList().size();
		final int summen = R + F + P;
		
		antFiskerLb = new JLabel(F+ "");
		
		antPattedyrLb = new JLabel(P + "");
		antReptilerLb = new JLabel(R + "");
		antProdukterLb = new JLabel(summen + "");
		
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {

				antProdukterLb.setText(getFiskList().size() + getReptilList().size() + getPattedyrList().size() +"");
				antFiskerLb.setText(getFiskList().size() + "");
				antReptilerLb.setText(getReptilList().size()+ "");
				antPattedyrLb.setText(getPattedyrList().size() + "");
				ListModel.clear();
				list.setModel(ListModel);
			}

			public void windowLostFocus(WindowEvent arg0) {
				ListModel.clear();
				for(int i = 0; i < PetFrame.getProduktList().size();i ++){
					ListModel.addElement(PetFrame.getProduktList().get(i));
					System.out.println(PetFrame.getProduktList().get(i));
				}
				//setter DefaultListModellen inn i JListen list 
				list.setModel(ListModel);
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
				
				
				
			}
		});
		mnFil.add(mntmOpen);

		// Knappen Save under kategorien Add
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			// Lytter til Save
			public void actionPerformed(ActionEvent arg0) {
			
				
				//skriver fiskobjekt til fil
				ArrayList<Object> objLeverandor= new ArrayList<>();
				ArrayList<Object> objFiskliste= new ArrayList<>();
				ArrayList<Object> objReptilliste= new ArrayList<>();
				ArrayList<Object> objPattedyrliste= new ArrayList<>();
				
				for (Leverandor l : leverandorList){
					objLeverandor.add(l);
				}
				
				
				
					for (Fisk f: fiskList){
						objFiskliste.add(f);	
				}
					
			//skriver Reptilobjekter til fil
				
					for (Reptil r: reptilList){
						objReptilliste.add(r);
					}
					
			//skrive Pattedyrobjekter til fil 
				
					
					for (Pattedyr p: pattedyrList){
						objPattedyrliste.add(p);
					}
					new LargeProdukter("C:\\Users\\Kamil\\Documents\\Leverandor.ser",objLeverandor);
					new LargeProdukter("C:\\Users\\Kamil\\Documents\\pattedyr.ser", objPattedyrliste);
					new LargeProdukter("C:\\Users\\Kamil\\Documents\\reptil.ser",objReptilliste);
					new LargeProdukter("C:\\Users\\Kamil\\Documents\\fisk.ser",objFiskliste);
			//skrive Leverandorobjekter til fil
				
			 
			 for (Fisk f: fiskList){
					System.out.println(f.getProduktnavn());
				}
				for (Leverandor l: leverandorList){
					System.out.println(l.getNavn());
					
					
					
					
				}
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
		
		JMenu mnVis = new JMenu("Vis");
		menuBar.add(mnVis);
		
		JMenuItem mntmSorteringAvProdukter = new JMenuItem("sortering av produkter");
		mntmSorteringAvProdukter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SorteringAvProdukter sap= new SorteringAvProdukter();
				sap.setVisible(true);
			}
		});
		mnVis.add(mntmSorteringAvProdukter);
		
		 list = new JList<Object>(ListModel);
		
	
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAntallProdukter, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFisker, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblReptiler)
								.addComponent(lblPattedyr))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(antPattedyrLb)
									.addGap(225))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(antReptilerLb)
										.addGap(225))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(antProdukterLb, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
											.addGap(225))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(antFiskerLb, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
											.addContainerGap())))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(antProdukterLb)
						.addComponent(lblAntallProdukter, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFisker)
						.addComponent(antFiskerLb))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReptiler)
						.addComponent(antReptilerLb))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPattedyr)
						.addComponent(antPattedyrLb))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		getContentPane().setLayout(groupLayout);
	}

	public static LinkedList<Produkt> getProduktList() {
		return ProduktList;
	}

	
}
