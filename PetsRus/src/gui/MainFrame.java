package gui;

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
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import medlemmer.Leverandor;
import varelager.Fisk;
import varelager.Pattedyr;
import varelager.Produkt;
import varelager.Reptil;
import fileManagment.lesFraFil;
import fileManagment.skrivTilFil;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private static ArrayList<Leverandor> liste = new ArrayList<Leverandor>();
	//lister over enheter/objekter i programmet
	private static ArrayList<Fisk> fishen= new ArrayList<Fisk>();
	private static ArrayList<Pattedyr> pattedyrensen= new ArrayList<Pattedyr>();
	private static ArrayList<Reptil> reptilensen= new ArrayList<Reptil>();
	
	// getter for Reptilensen arraylist
	public static ArrayList<Reptil> getReptilensen() {
		return reptilensen;
	}


	//getter for Pattedyrensen
	public static ArrayList<Pattedyr> getPattedyrensen() {
		return pattedyrensen;
	}


	//getter for fishen
	public static ArrayList<Fisk> getFishen() {
		return fishen;
	}

		JLabel l1;
		JLabel l3;
		JLabel l2;
		JLabel l4;
	
	private JPanel contentPane;

	public static ArrayList<Leverandor> getListe() {
		return liste;
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		// legger til leverandører 
		Leverandor sad= new Leverandor("DAXI PAXI","asda","asdasd",1233,"asda","123124124");
		liste.add(sad);
		Leverandor sad2= new Leverandor("MAXI DAXI","asda","asdasd",1233,"asda","123124124");
		liste.add(sad2);
		Leverandor sad3= new Leverandor("hakunamatata","asas","asda",21212,"asdasd","123123123123123");
		liste.add(sad3);
		// henter fisker fra fil 
		String fpath="/home/kamil/Dokumenter/eclipse/savet filer/Fisker.txt";
		String fcmd="fisk";
		lesFraFil lesffil= new lesFraFil(fpath, fcmd);
		// sjekker fisk som har dukket opp i fishen-listen
		for(Fisk f: fishen){
			System.out.println(f.getProduktnavn());
		}
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		
		
	

		l1 = new JLabel("0");
		
		
		JLabel lblAntallFisk = new JLabel("antall fisk");
		
		JLabel lblAntallPattedyr = new JLabel("antall pattedyr");
		
		JLabel lblAntallReptiler = new JLabel("antall reptiler");
		
		l2 = new JLabel("0");
		
		
		
			
		
		
		l3 = new JLabel("0");
		l4 = new JLabel("0");
		
		addWindowFocusListener(new WindowFocusListener() {
			
			
			public void windowGainedFocus(WindowEvent arg0) {
				l4.setText(Produkt.getAntProdukter() + "");
				l1.setText(Fisk.getAntFisker() +"" );
				l2.setText(Pattedyr.getAntPatteDyr() + "");
				l3.setText(Reptil.getAntReptiler() + "");
				
	
				
				
			}
			public void windowLostFocus(WindowEvent arg0) {
				
			}
		});
		
		JLabel lblTotalAntallProdukter = new JLabel("total antall produkter");
		setTitle(" Pets R' US");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// saver fisker
				String path = "/home/kamil/Dokumenter/eclipse/savet filer/Fisker.txt";
				String cmd ="fisk";
				skrivTilFil skrivFisk = new skrivTilFil(path, cmd);
				// saver reptiler
				String rpath = "/home/kamil/Dokumenter/eclipse/savet filer/Reptiler.txt";
				String rcmd="reptil";
				skrivTilFil skrivReptil = new skrivTilFil(rpath, rcmd);
				String ppath= "/home/kamil/Dokumenter/eclipse/savet filer/Pattedyr.txt";
				String pcmd="pattedyr";
				skrivTilFil skrivPattedyr = new skrivTilFil(ppath, pcmd);
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		
			}});
		mnFile.add(mntmOpen);
		
		JMenu mnAdd = new JMenu("Add");
		menuBar.add(mnAdd);
		
		JMenuItem mntmFisk = new JMenuItem("Fisk");
		mntmFisk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddFish addFish = new AddFish();
				addFish.setVisible(true);
			}
		});
		mnAdd.add(mntmFisk);
		
		JMenuItem mntmReptil = new JMenuItem("Reptil");
		
		mntmReptil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddReptil addreptil= new AddReptil();
				addreptil.setVisible(true);
			}
		});
		mnAdd.add(mntmReptil);
		
		JMenuItem mntmPattedyr = new JMenuItem("Pattedyr");
		mntmPattedyr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPattedyr addpattedyr= new AddPattedyr();
				addpattedyr.setVisible(true);
			}
		});
		mnAdd.add(mntmPattedyr);
		
		JMenu mnSell = new JMenu("Sell");
		menuBar.add(mnSell);
		
		JMenuItem mntmSellFish = new JMenuItem("Sell Fish");
		mntmSellFish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FishSelling f= new FishSelling();
				f.setVisible(true);
				
			}
		});
		mnSell.add(mntmSellFish);
		// her lages det ny knapp der hvor det åpnes en klasse av ReptilSelling
		JMenuItem mntmSellReptil = new JMenuItem("Sell Reptil");
		mntmSellReptil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReptilSelling r= new ReptilSelling();
				r.setVisible(true);
			}
		});
		mnSell.add(mntmSellReptil);
		
		JMenuItem mntmSellPattedyr = new JMenuItem("Sell Pattedyr");
		mntmSellPattedyr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PattedyrSelling p= new PattedyrSelling();
				p.setVisible(true);
			}
		});
		mntmSellReptil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		mnSell.add(mntmSellPattedyr);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		//new Fisk(produktnavn, inkjPris, pris,new Leverandor(navn, epost, adr, pnr, psted, tlf),
				//slektsnavn, artsnavn, antFisker)
		
		//
		//layout contentpane
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAntallFisk)
								.addComponent(lblAntallPattedyr)
								.addComponent(lblAntallReptiler))
							.addGap(60)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(l1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(l2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(l3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTotalAntallProdukter)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(l4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(222, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAntallFisk)
						.addComponent(l1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAntallPattedyr)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAntallReptiler))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(l2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(l3)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalAntallProdukter)
						.addComponent(l4))
					.addContainerGap(150, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void update(){
		l1.setText(String.valueOf(fishen.size()));
		
	}
}
