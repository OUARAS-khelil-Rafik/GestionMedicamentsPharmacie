package Test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class FrameAjouterMedicament extends JFrame {
	private JPanel pM, pMDL, pDescription, pListe, p1, p2, p3, pF;
	private JTextField tfCode, tfNom, tfDate, tfQuantite, tfPrix, tfRecherche ;
	private JLabel lmed, lCode, lNom, lDate, lQuantite, lPrix, lCodeNew, lNomNew, lDateNew, lQuantiteNew, lPrixNew;
	private JButton bAjouter, bModifier, bSupprimer, bRecherche, bDashboard, bNouveau, bQuitter;
	private JTable table;
	private ImageIcon icon;
	BaseD bdd = new BaseD();
	
	public FrameAjouterMedicament(){
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
        //pM.setLayout(null);
		lmed = new JLabel("Médicament");
		lmed.setFont(new Font("Stencil", Font.PLAIN, 25));
		//lmed.setBounds(370, 11, 200, 40);
        pM.setPreferredSize(new Dimension(900,30));
        pM.add(lmed);        
        pMDL.add(pM, BorderLayout.NORTH);
        
        pDescription = new JPanel();
        pDescription.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, null), "Description", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
        pDescription.setPreferredSize(new Dimension(900,370));
        pDescription.setLayout(new GridLayout(11,4));
        
        lCode = new JLabel("Code");
        lCode.setForeground(Color.BLACK);
        lCode.setFont(new Font("Time new roman",Font.BOLD,15));
        tfCode = new JTextField(20);
        pDescription.add(lCode);
        pDescription.add(tfCode);
        
        lDate = new JLabel("Date");
        tfDate = new JTextField(20);
        lDate.setForeground(Color.BLACK);
        lDate.setFont(new Font("Time new roman",Font.BOLD,15));
        pDescription.add(lDate);
        pDescription.add(tfDate);
        
        lNom = new JLabel("Nom");
        lNom.setForeground(Color.BLACK);
        lNom.setFont(new Font("Time new roman",Font.BOLD,15));
        tfNom = new JTextField(20);
        pDescription.add(lNom);
        pDescription.add(tfNom);
        
        lQuantite = new JLabel("Qantité");
        lQuantite.setForeground(Color.BLACK);
        lQuantite.setFont(new Font("Time new roman",Font.BOLD,15));
        tfQuantite = new JTextField(20);
        pDescription.add(lQuantite);
        pDescription.add(tfQuantite);
        
        lPrix = new JLabel("Prix");
        lPrix.setForeground(Color.BLACK);
        lPrix.setFont(new Font("Time new roman",Font.BOLD,15));
        tfPrix = new JTextField("en dzd");
        pDescription.add(lPrix);
        pDescription.add(tfPrix);
        bAjouter = new JButton("Ajouter");
        bAjouter.setFocusable(false);
        bAjouter.setBorder(new LineBorder(Color.BLUE, 2));
        bAjouter.setBackground(Color.YELLOW);
        bAjouter.setMnemonic('q');
        bAjouter.addActionListener(e-> {
				bdd.ajouterMed(tfCode.getText(),tfNom.getText(),tfPrix.getText(),tfDate.getText(),tfQuantite.getText());
				bdd.tableLoad(table);
				JOptionPane.showMessageDialog(null, "Medicament ajouter avec succés");
				tfCode.setText("");tfNom.setText("");tfPrix.setText("");tfDate.setText("");tfQuantite.setText("");
		});
        pDescription.add(bAjouter);
        pMDL.add(pDescription, BorderLayout.CENTER);
        
        pListe = new JPanel();
        pListe.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLUE, null), "Liste Médicament", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
        pListe.setPreferredSize(new Dimension(900,230));
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,4,30,20));
        
        bModifier = new JButton(" Modifier");
        bModifier.setFocusable(false);
        bModifier.setBorder(new LineBorder(Color.BLUE, 2));
        bModifier.setBackground(Color.YELLOW);
        bModifier.setMnemonic('m');
        bModifier.addActionListener(e-> {
				bdd.modifierMed(tfCode.getText(),tfNom.getText(),tfPrix.getText(),tfDate.getText(),tfQuantite.getText(),tfRecherche.getText());
				bdd.tableLoad(table);
				JOptionPane.showMessageDialog(null, "Medicament Modifier !!");
				tfRecherche.setText("");tfCode.setText("");tfNom.setText("");tfPrix.setText("");tfDate.setText("");tfQuantite.setText("");
		});
        p1.add(bModifier);
        
        bSupprimer = new JButton(" Supprimer");
        bSupprimer.setFocusable(false);
        bSupprimer.setBorder(new LineBorder(Color.BLUE, 2));
        bSupprimer.setBackground(Color.YELLOW);
        bSupprimer.setBounds(260,0,200,35);
        bSupprimer.setMnemonic(KeyEvent.VK_DELETE);
        bSupprimer.addActionListener(e-> {
				bdd.supprimerMed(tfRecherche.getText());
				bdd.tableLoad(table);
				JOptionPane.showMessageDialog(null, "Medicament supprimer !!");
				tfRecherche.setText("");
		});
        p1.add(bSupprimer);
        
        tfRecherche = new JTextField("Rechercher...... ");
        tfRecherche.setBorder(new LineBorder(Color.BLUE, 2));
        tfRecherche.setBackground(Color.YELLOW);
        tfRecherche.setBounds(470,0,200,35);
        p1.add(tfRecherche);
        
        bRecherche = new JButton(" Recherche");
        bRecherche.setFocusable(false);
        bRecherche.setBorder(new LineBorder(Color.BLUE, 2));
        bRecherche.setBackground(Color.YELLOW);
        bRecherche.setBounds(680,0,150,35);
        bRecherche.setMnemonic('r');
        bRecherche.addActionListener(e-> {
			bdd.searchMed(table,tfRecherche.getText());
			tfRecherche.setText("");
		});
        p1.add(bRecherche);
        
        p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEADING,120,5));
		lCodeNew = new JLabel("Code");
		p2.add(lCodeNew);
		
		lNomNew = new JLabel("Nom");
		p2.add(lNomNew);
		
		lPrixNew = new JLabel("Prix");
		p2.add(lPrixNew);
		
		lDateNew = new JLabel("Date");
		p2.add(lDateNew);
		
		lQuantiteNew = new JLabel("Quantite");
		p2.add(lQuantiteNew);
       
		p3 = new JPanel();
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
		table.setPreferredSize(new Dimension(750,120));
		p3.add(table);
		
		pListe.add(p1);
		pListe.add(p2);
		pListe.add(p3);
        pMDL.add(pListe, BorderLayout.SOUTH);
        
        pF = new JPanel(new GridLayout());
        bDashboard = new JButton("Dashboard");
        bDashboard.setFocusable(false);
        bDashboard.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        bDashboard.setBackground(Color.YELLOW);
        bDashboard.setMnemonic('d');
        bDashboard.addActionListener(e-> {
				FrameDashboard fd = new FrameDashboard();
				fd.setVisible(true);
				this.setVisible(false);
				
			});
        pF.add(bDashboard);
        
        bNouveau = new JButton("Nouveau");
        bNouveau.setFocusable(false);
        bNouveau.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        bNouveau.setBackground(Color.YELLOW);
        pF.add(bNouveau);
        
        bQuitter = new JButton("Quitter");
        bQuitter.setFocusable(false);
        bQuitter.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        bQuitter.setBackground(Color.YELLOW);
        bQuitter.setMnemonic('q');
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
}
