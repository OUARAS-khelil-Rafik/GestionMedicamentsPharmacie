package Test;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class FrameDashboard extends JFrame{
	
	/* Partie Declaration Globale */
	private JPanel pM, pMDL, pListe, pF;
	private JTextField tfRecherche ;
	private JLabel lmed, lRecherche_QT, lCodeNew, lNomNew, lDateNew, lQuantiteNew, lPrixNew;
	private JButton bRecherche, bDashboard, bNouveau, bQuitter;
	private JTable table;
	private IconImage icon;
	BaseD bdd = new BaseD();
	
	/**************************************************************************************************************************/
	public FrameDashboard(){
        this.setSize(900,600);
        this.setTitle("Gestion d’Acquisition de Médicaments pour une Pharmacie");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        icon = new ImageIcon(".\\src\\image\\icon.png");
        this.setIconImage(icon.getImage());
        
        
        pMDL = new JPanel();
        this.add(pMDL, BorderLayout.CENTER);
        pMDL.setLayout(new BorderLayout());
        pM = new JPanel();
		lmed = new JLabel("Médicament");
		lmed.setFont(new Font("Stencil", Font.PLAIN, 25));
        pM.setPreferredSize(new Dimension(900,30));
        pM.add(lmed);        
        pMDL.add(pM, BorderLayout.NORTH);
        
        
        pListe = new JPanel();
        pListe.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, null), "Liste Médicament", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
        pListe.setPreferredSize(new Dimension(900,530));
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1,3,5,1));
        
        /*Label Recherche a partir de quantité*/
        lRecherche_QT = new JLabel(" Entrer la quantité :");
        lRecherche_QT.setForeground(Color.BLACK);
        lRecherche_QT.setFont(new Font("Time new roman",Font.PLAIN,12));
        p1.add(lRecherche_QT);
        
        /*Text Field "Recherche"*/
        tfRecherche = new JTextField("Rechercher");
        tfRecherche.setBorder(new LineBorder(Color.BLUE, 2));
        tfRecherche.setBackground(Color.YELLOW);
        p1.add(tfRecherche);
        
        /*Button Recherche*/
        bRecherche = new JButton("Recherche");
        bRecherche.setFocusable(false);
        bRecherche.setBorder(new LineBorder(Color.BLUE, 2));
        bRecherche.setBackground(Color.YELLOW);
        bRecherche.setMnemonic('r');
        bRecherche.addActionListener(e-> {
        	bdd.searchMedDash(table, tfRecherche.getText());
			tfRecherche.setText("");
		});
        p1.add(bRecherche);
        
        
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEADING,120,5));
        /*Label de Tableau medicament "Code"*/
        lCodeNew = new JLabel("Code");
		p2.add(lCodeNew);
		
		/*Label de Tableau medicament "Nom"*/
		lNomNew = new JLabel("Nom");
		p2.add(lNomNew);
		
		/*Label de Tableau medicament "Prix"*/
		lPrixNew = new JLabel("Prix");
		p2.add(lPrixNew);
		
		/*Label de Tableau medicament "Date"*/
		lDateNew = new JLabel("Date");
		p2.add(lDateNew);
		
		/*Label de Tableau medicament "Quantité"*/
		lQuantiteNew = new JLabel("Quantite");
		p2.add(lQuantiteNew);
        
		
		JPanel p3 = new JPanel();
		/*Tableau des medicaments*/
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		
		
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		
		
		table.setBackground(Color.YELLOW);
		table.setFont(new Font("Segoe UI", Font.BOLD, 13));
		table.setBorder(new LineBorder(Color.BLACK, 2));
		table.setOpaque(false);
		
		
		BaseD bdd = new BaseD();
		
		bdd.tableLoad(table);
		table.setPreferredSize(new Dimension(750,370));
		p3.add(table);
		
		
		pListe.add(p1);
		pListe.add(p2);
		pListe.add(p3);
        pMDL.add(pListe, BorderLayout.CENTER);
        
        
        pF = new JPanel(new GridLayout());
        /*Button Dashboard*/
        bDashboard = new JButton("Dashboard");
        bDashboard.setFocusable(false);
        bDashboard.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        bDashboard.setBackground(Color.YELLOW);
        pF.add(bDashboard);
        
        /*Button Nouveau medicament*/
        bNouveau = new JButton("Nouveau");
        bNouveau.setFocusable(false);
        bNouveau.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        bNouveau.setBackground(Color.YELLOW);
        bNouveau.addActionListener(e-> {
			FrameAjouterMedicament fn = new FrameAjouterMedicament();
			fn.setVisible(true);
			this.setVisible(false);
			
		});
        
        pF.add(bNouveau);
        
        /*Button Quitter*/
        bQuitter = new JButton("Quitter");
        bQuitter.setFocusable(false);
        bQuitter.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        bQuitter.setBackground(Color.YELLOW);
        bQuitter.addActionListener(e->{
        	if(e.getSource() == bQuitter) {
        		System.exit(0);
        	}
        });
        pF.add(bQuitter);
        
        
        pF.setPreferredSize(new Dimension(900,40));
        this.add(pF, BorderLayout.SOUTH);
        
        this.setVisible(true);
	}
	/***********************************************************************************************************************/
}
