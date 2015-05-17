package prototypes;


import java.awt.*;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import domain.*;
import logic.*;

public class MainWindow extends JFrame
{
  private CustomTableModel model;
  private CustomTableRenderer table;
  private JPanel contentPane;
  private JTextField searchField;
  private String comboString[];
  private String combochoise;
  private JComboBox comboBox;
  private String[] columnNames;
//  private List searchlist;
  private JButton redigerButton = new JButton( "Rediger" );
//  private JComboBox<String> comboBox = new JComboBox<String>();

  
  public MainWindow()
  {
    setBackground( Color.BLACK );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setBounds( 100, 100, 815, 329 );
    contentPane = new JPanel();
    contentPane.setBorder( new EmptyBorder( 10, 10, 10, 10 ) );
    setContentPane( contentPane );
    contentPane.setLayout( new BorderLayout( 0, 0 ) );
    contentPane.setBackground( Color.BLACK );
    
//    JPanel logopanel = LogoPanel();
//    contentPane.add( logopanel, BorderLayout.NORTH );
    
    JPanel logopanel2 = LogoPanel2();
    contentPane.add( logopanel2, BorderLayout.EAST );
    
//    JPanel sælgermainpanel = SælgerMainPanel();
//    contentPane.add( sælgermainpanel, BorderLayout.CENTER );
    
//     JPanel findkundepanel = FindKundePanel();
//     contentPane.add(findkundepanel, BorderLayout.CENTER);
    
    // JPanel findbilpanel = FindBilPanel();
    // contentPane.add(findbilpanel, BorderLayout.CENTER);
    
    // JPanel findaftalepanel = FindLåneaftalePanel();
    // contentPane.add(findaftalepanel, BorderLayout.CENTER);
    
    this.setVisible( true );
    
  }
  
//  private JPanel LogoPanel()
//  {
//    JPanel logopanel = new JPanel();
//    FlowLayout flowLayout = (FlowLayout) logopanel.getLayout();
//    flowLayout.setAlignment( FlowLayout.LEFT );
//    logopanel.setBackground( Color.RED );
//    JLabel label = new JLabel( new ImageIcon( "C:\\Users\\Dennis\\Documents\\GitHub\\1YearProject-Gruppe-3\\04-Implemetation\\Ferrari Finansiering\\Yellow logo on red background.png" ) );
//    label.setLabelFor( label );
//    label.setSize( new Dimension( 300, 100 ) );
//    label.setBackground( new Color( 200, 50, 50 ) );
//    label.setIconTextGap( 0 );
//    label.setPreferredSize( new Dimension( 300, 100 ) );
//    label.setMinimumSize( new Dimension( 100, 50 ) );
//    label.setMaximumSize( new Dimension( 1000, 500 ) );
//    logopanel.add( label );
//    
//    return logopanel;
//  }
  
  private JPanel LogoPanel2()
  {
    JPanel logopanel2 = new JPanel();
    
    FlowLayout flowLayout = (FlowLayout) logopanel2.getLayout();
    flowLayout.setAlignment( FlowLayout.LEFT );
    logopanel2.setBackground( Color.BLACK );
    JLabel label2 = new JLabel( new ImageIcon( "C:\\Users\\Dennis\\Documents\\GitHub\\1YearProject-Gruppe-3\\04-Implemetation\\Ferrari Finansiering\\Capture.png" ) );
    label2.setLabelFor( label2 );
    label2.setSize( new Dimension( 300, 100 ) );
    label2.setBackground( new Color( 200, 50, 50 ) );
    label2.setIconTextGap( 0 );
    label2.setMinimumSize( new Dimension(50, 300) );
    label2.setMaximumSize( new Dimension( 1000, 500 ) );
    logopanel2.add( label2 );
    
    return logopanel2;
  }
  
  
  public JPanel SælgerMainPanel()
  {
    JPanel sælgerpanel = new JPanel();
    sælgerpanel.setBackground( Color.BLACK );
    sælgerpanel.setBorder( new EmptyBorder( 10, 10, 10, 10 ) );
    sælgerpanel.setLayout( new BoxLayout( sælgerpanel, BoxLayout.Y_AXIS ) );
    contentPane.add( sælgerpanel, BorderLayout.CENTER );
    this.setTitle( "Ferrari Finance Solutions" );
    JLabel label0 = new JLabel();
    label0.setText( " " );
    sælgerpanel.add( label0 );
    JButton btnOpretLåneanmodning = new JButton( "Opret låneanmodning" );
    btnOpretLåneanmodning.setForeground(Color.BLACK);
    btnOpretLåneanmodning.setBackground(new Color(153, 0, 0));
    sælgerpanel.add( btnOpretLåneanmodning );
    btnOpretLåneanmodning.addActionListener( event ->
    {
      
    } );
    JLabel label1 = new JLabel();
    label1.setText( " " );
    sælgerpanel.add( label1 );
    JButton btnFindKunde = new JButton( "Find kunde" );
    btnFindKunde.setBackground(new Color(153, 0, 0));
    sælgerpanel.add( btnFindKunde );
    btnFindKunde.addActionListener( event ->
    {
      
      sælgerpanel.setVisible( false );
      contentPane.add( FindKundePanel(), BorderLayout.CENTER );
//      contentPane.repaint();
      
    } );
    JLabel label2 = new JLabel();
    label2.setText( " " );
    sælgerpanel.add( label2 );
    JButton btnFindBil = new JButton( "Find bil" );
    btnFindBil.setBackground(new Color(153, 0, 0));
    sælgerpanel.add( btnFindBil );
    btnFindBil.addActionListener( event ->
    {
      sælgerpanel.setVisible( false );
      contentPane.add( FindBilPanel(), BorderLayout.CENTER );
//      contentPane.repaint();
    } );
    JLabel label3 = new JLabel();
    label3.setText( " " );
    sælgerpanel.add( label3 );
    JButton btnFindLåneaftale = new JButton( "Find låneaftale" );
    btnFindLåneaftale.setBackground(new Color(153, 0, 0));
    sælgerpanel.add( btnFindLåneaftale );
    btnFindLåneaftale.addActionListener( event ->
    {
      sælgerpanel.setVisible( false );
      contentPane.add( FindLåneaftalePanel(), BorderLayout.CENTER );
//      contentPane.repaint();
    } );
    
    this.setSize( 350, 340 );
    return sælgerpanel;
  }
  
  
  private JPanel FindKundePanel()
  {
    JPanel findkundepanel = new JPanel();
    findkundepanel.setBackground( Color.RED );
    findkundepanel.setLayout( new BorderLayout( 0, 0 ) );
    contentPane.add( findkundepanel, BorderLayout.CENTER );
    this.setTitle( "Kunde" );
    
    comboString = new String[] { "Cprnummer", "Navn", "Telefonnummer.", "Chassisnummer" };
    
    JPanel searchpanel = SearchPanel();
    findkundepanel.add( searchpanel, BorderLayout.NORTH );
    
    JPanel resultpanel = ResultPanel();
    findkundepanel.add( resultpanel, BorderLayout.CENTER );
    
    JPanel buttonpanel = ButtonPanel();
    findkundepanel.add( buttonpanel, BorderLayout.SOUTH );
    
    this.setSize( 800, 350 );
    return findkundepanel;
  }
  
  
  private JPanel FindBilPanel()
  {
    JPanel findbilpanel = new JPanel();
    findbilpanel.setBackground( Color.RED );
    findbilpanel.setLayout( new BorderLayout( 0, 0 ) );
    contentPane.add( findbilpanel, BorderLayout.CENTER );
    this.setTitle( "Bil" );
    
    comboString = new String[] { "Chassisnummer", "Registreringsnummer", "Model" };
    
    JPanel searchpanel = SearchPanel();
    findbilpanel.add( searchpanel, BorderLayout.NORTH );
    
    JPanel resultpanel = ResultPanel();
    findbilpanel.add( resultpanel, BorderLayout.CENTER );
    
    JPanel buttonpanel = ButtonPanel();
    findbilpanel.add( buttonpanel, BorderLayout.SOUTH );
    
    this.setSize( 800, 550 );
    return findbilpanel;
  }
  
  
  private JPanel FindLåneaftalePanel()
  {
    JPanel findaftalepanel = new JPanel();
    findaftalepanel.setBackground( Color.RED );
    findaftalepanel.setLayout( new BorderLayout( 0, 0 ) );
    contentPane.add( findaftalepanel, BorderLayout.CENTER );
    this.setTitle( "LåneAftale" );
    
    comboString = new String[] { "AftaleID", "CprID", "Cprnummer", "Chassisnummer", "Registreringsnummer", "SælgerID" };

    
    JPanel searchpanel = SearchPanel();
    findaftalepanel.add( searchpanel, BorderLayout.NORTH );
    
    JPanel resultpanel = ResultPanel();
    findaftalepanel.add( resultpanel, BorderLayout.CENTER );
    
    JPanel buttonpanel = ButtonPanel();
    findaftalepanel.add( buttonpanel, BorderLayout.SOUTH );
    
    this.setSize( 800, 550 );
    return findaftalepanel;
  }
  
  
  private JPanel SearchPanel()
  {
    JPanel searchpanel = new JPanel();
    searchpanel.setBackground( Color.BLACK );
    comboBox = new JComboBox();
    comboBox.setModel( new DefaultComboBoxModel( comboString ) );
    searchpanel.add( comboBox );

    searchField = new JTextField();
    searchpanel.add( searchField );
    searchField.setColumns( 10 );
    JButton searchButton = new JButton( "Søg" );
    searchpanel.add( searchButton );
    searchButton.addActionListener( event -> searchButtonPressed());
    
    this.getRootPane().setDefaultButton(searchButton);
    return searchpanel;
  }
  
 
  private JPanel ResultPanel()
  {
    JPanel resultpanel = new JPanel();
    resultpanel.setForeground(Color.RED);
    resultpanel.setBackground( Color.BLACK );
    
    model = new CustomTableModel();
    table = new CustomTableRenderer(model);
    table.setGridColor(Color.GRAY);
    table.setForeground(Color.RED);
    table.setBackground(Color.BLACK);
    table.getTableHeader().setReorderingAllowed(false);
    table.setRowSorter(new TableRowSorter<>(model));
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    model.setColumnIdentifiers(columnNames);
    int width = 0;
    int frameHeight = 550;
    for (int i = 0; i < table.getColumnCount() ; i++) 
    {
        width += table.getColumnModel().getColumn(i).getWidth();
    }
    ListSelectionModel listSelectionModel = table.getSelectionModel();
    listSelectionModel.addListSelectionListener(e -> 
    {
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
        redigerButton.setEnabled(!lsm.isSelectionEmpty());
    });
    this.setPreferredSize(new Dimension(width, frameHeight));
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setOpaque(true);
    scrollPane.setMinimumSize(new Dimension(200, 25));
    scrollPane.setPreferredSize(new Dimension(600, 200));
    scrollPane.setBackground(Color.BLACK);
    resultpanel.add(scrollPane, BorderLayout.CENTER);
//    this.pack();
    resultpanel.setVisible(true);
    
    return resultpanel;
  }
  
 /*
  * STADIG IKKE FÆRDIG!!!
  * 
  *  Kundepanelet kan vise kundeoplysninger i tabellen, hvis man vælger "Kunde" i combobox.
  */
  public void searchButtonPressed()
  {
    try
    {
System.out.println( "1" );
    KundeLogik kl = new KundeLogik();
    BilLogik bl = new BilLogik();
    FinansieringsaftaleLogik fl = new FinansieringsaftaleLogik();
    List<Kunde> kundesearchlist = null;
    List<Bil> bilsearchlist = null;
    List<Finansieringsaftale> aftalesearchlist = null;
//    List searchlist;
    if(this.getTitle() == "Kunde")
    {
System.out.println( "2" );
      columnNames = new String[] { "Cpr-ID", "Navn", "Adresse", "Postnummer", "Telefon", "Email", "Kommentar"};
      model.setRowCount(0);
//      if(comboBox.getSelectedItem().toString() == "Cpr-nummer")
//      {
//        try
//        {
//          kundesearchlist = kl.listKunder( "Cprnummer", searchField.getText() );
//        }
//        catch ( SQLException e )
//        {
//          // TODO Auto-generated catch block
//          e.printStackTrace();
//        }
//      }
//      else
//      {
System.out.println( "3" );
System.out.println( comboBox.getSelectedItem().toString() );
System.out.println( searchField.getText() );
          kundesearchlist = kl.listKunder( comboBox.getSelectedItem().toString(), searchField.getText() );
//          System.out.println(kl.listKunder( comboBox.getSelectedItem().toString(), searchField.getText() ) );
          

        for(int i= 0; i<kundesearchlist.size(); i++)
        {
          System.out.println(i+ " " + kundesearchlist.get( i ).toString());
        }
          
System.out.println( "3,1" );

//      }
//      searchlist = kundesearchlist;
      if(kundesearchlist.isEmpty()) 
      {
        JOptionPane.showMessageDialog(this, "Søgningen gav intet resultat");
      }
      else
      {
        System.out.println( "4" );
        model.setColumnIdentifiers(columnNames);
        for (Kunde k : kundesearchlist) 
        {
          Object[] o = new Object[7];
          o[0] = k.getCprid();
//          o[1] = k.getCprnummer();
          o[1] = k.getNavn();
          o[2] = k.getAdresse();
          o[3] = k.getPostnummer();
          o[4] = k.getTelefonnummer();
          o[5] = k.getEmail();
          o[6] = k.getKommentar();
          model.addRow(o);
          System.out.println( "5" );
        }
      }
    }
    
    else if(this.getTitle() == "Bil")
    {
      columnNames = new String[] { "Chassisnummer", "Reg-nummer", "Pris", "Model", "Årgang", "Bemærkninger"};
      try
      {
        bilsearchlist = bl.listBiler( comboBox.getSelectedItem().toString(), searchField.getText() );
      }
      catch ( SQLException e )
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
//      searchlist = bilsearchlist;
      if(bilsearchlist.isEmpty()) 
      {
        JOptionPane.showMessageDialog(this, "Søgningen gav intet resultat");
      }
      else
      {
        model.setColumnIdentifiers(columnNames);
        for (Bil b : bilsearchlist) 
        {
          Object[] o = new Object[6];
          o[0] = b.getChassisnummer();
          o[1] = b.getRegistreringsnummer();
          o[2] = b.getPris();
          o[3] = b.getModel();
          o[4] = b.getÅrgang();
          o[5] = b.getBemærkninger();
          model.addRow(o);
        }
      }
    }
    
    else if(this.getTitle() == "LåneAftale")
    {
      columnNames = new String[] { "Aftale-ID", "Oprettelsesdato", "Cpr-ID", "Beløb", "Udbetaling", "Rente", "Afviklingsperiode", "Bil-Chassisnummer", "SælgerID"};

      if(comboBox.getSelectedItem().toString() == "Cpr-nummer")
      {
        
      }
      else if(comboBox.getSelectedItem().toString() == "Reg.-nummer")
      {
        
      }
      else
      {
        try
        {
          aftalesearchlist = fl.listFinansieringsaftaler( comboBox.getSelectedItem().toString(), searchField.getText() );
        }
        catch ( SQLException e )
        {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
//      searchlist = aftalesearchlist;
      if(aftalesearchlist.isEmpty()) 
      {
        JOptionPane.showMessageDialog(this, "Søgningen gav intet resultat");
      }
      else
      {
        model.setColumnIdentifiers(columnNames);
        for (Finansieringsaftale fa : aftalesearchlist) 
        {
          Object[] o = new Object[9];
          o[0] = fa.getAftaleid();
          o[1] = fa.getOprettelsesdato();
          o[2] = fa.getCprid();
          o[3] = fa.getBeløb();
          o[4] = fa.getUdbetaling();
          o[5] = fa.getRente();
          o[6] = fa.getAfviklingsperiode();
          o[7] = fa.getChassisnummer();
          o[8] = fa.getSælgerid();
          model.addRow(o);
        }
      }
    } 
    }
    catch (SQLException e) 
    {
      JOptionPane.showMessageDialog(this, "[-] SQL Error\nNo connection to database." ,"Error!", JOptionPane.ERROR_MESSAGE);
    }

    
    
//    TableModel TabelModel = new AbstractTableModel()
//    {
//      // String[] columnNames = { "Album titel", "Bandnavn", "Genre", "#", "Sangtitel", "år"};
//      
//      public String getColumnName( int col )
//      {
//        return columnNames[col].toString();
//      }
//      
//      public int getColumnCount()
//      {
//        return columnNames.length;
//      }
//      
//      public int getRowCount()
//      {
//        return searchlist.size();
//      }
//      
//      public Object getValueAt( int row, int col )
//      {
//        if ( col == 0 )
//        {
//          return searchlist.get( row ).getAlbumtitel();
//        }
//        else if ( col == 1 )
//        {
//          return searchlist.get( row ).getBandnavn();
//        }
//        else if ( col == 2 )
//        {
//          return searchlist.get( row ).getGenretype();
//        }
//        else if ( col == 3 )
//        {
//          return searchlist.get( row ).getSangnummer();
//        }
//        else if ( col == 4 )
//        {
//          return searchlist.get( row ).getSangtitel();
//        }
//        else
//        {
//          return searchlist.get( row ).getUdgivelse();
//        }
//      }
//    };
//    liste.setModel( TabelModel );
//    liste.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
//    liste.getColumnModel().getColumn( 3 ).setPreferredWidth( 1 );
//    liste.getColumnModel().getColumn( 5 ).setPreferredWidth( 4 );
//    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
//    rightRenderer.setHorizontalAlignment( SwingConstants.RIGHT );
//    liste.getColumnModel().getColumn( 0 ).setCellRenderer( rightRenderer );
//    liste.getColumnModel().getColumn( 1 ).setCellRenderer( rightRenderer );
//    liste.getColumnModel().getColumn( 2 ).setCellRenderer( rightRenderer );
//    liste.getColumnModel().getColumn( 3 ).setCellRenderer( rightRenderer );
//    liste.getColumnModel().getColumn( 4 ).setCellRenderer( rightRenderer );
//    liste.getColumnModel().getColumn( 5 ).setCellRenderer( rightRenderer );
//    scrollListe.setViewportView( liste );
    System.out.println( "6" );
    this.setVisible( true );
  }

  
  
  private JPanel ButtonPanel()
  {
    JPanel buttonpanel = new JPanel();
    FlowLayout flowLayout = (FlowLayout) buttonpanel.getLayout();
    flowLayout.setAlignment( FlowLayout.RIGHT );
    buttonpanel.setBackground( Color.BLACK );
    JButton tilbageButton = new JButton( "Tilbage" );
    buttonpanel.add( tilbageButton );
    tilbageButton.addActionListener( event ->
    {
      
    });
    redigerButton = new JButton();
    redigerButton.setEnabled( false );
    buttonpanel.add( redigerButton );
    redigerButton.addActionListener( event ->
    {
      
    });
    
    return buttonpanel;
  }
  
  
  
}
