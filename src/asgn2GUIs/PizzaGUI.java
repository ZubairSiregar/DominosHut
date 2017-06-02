package asgn2GUIs;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import asgn2Exceptions.*;
import asgn2Restaurant.*;
import java.awt.*;
import javax.swing.table.*;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a ¡®dummy¡¯ class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature ¨C as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Lei Wang
 *
 */

public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener{
	
	String col1 = "Customer Name";
	String col2 = "Customer Code";
	String col3 = "Customer Phone Number";
	String col4 = "Customer X";
	String col5 = "Customer Y";
	String col6 = "Customer Distance";
	String col7 = "Pizza Code";
	String col8 = "Pizza Quantity";
	String col9 = "Order Price";
	String col10 = "Order Cost";
	String col11 = "Order Profit";
	String col12 = "Time of Order";
	String col13 = "Time of Delivery";
	
	private PizzaRestaurant hotel = new PizzaRestaurant();

	public enum DeliveryType {
		PICKUP, DELIVERY, DRONE
	}

	public DeliveryType DT;

	
	Object[][] orders;
	JTable table;
	
	private JFrame fra;	
	public File selectedFile;

	private static final long serialVersionUID = 1L;


	public PizzaGUI(String title) {
		initUI(title);
	}

	public void initUI(String title) {

		DefaultTableModel model = new DefaultTableModel(); 
		table = new JTable(model); 
		
		model.addColumn(col1); 
		model.addColumn(col2);
		model.addColumn(col3); 
		model.addColumn(col4);
		model.addColumn(col5);
		model.addColumn(col6);
		model.addColumn(col7); 
		model.addColumn(col8);		
		model.addColumn(col9);
		model.addColumn(col10);
		model.addColumn(col11);
		model.addColumn(col12); 
		model.addColumn(col13); 

		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);

		add(scrollPane);
		int x =1200;
		int y =800;
		createMenuBar();
		setTitle(title);
		setSize(x, y);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void AddDataToTable() throws PizzaException, CustomerException{
DefaultTableModel yourModel = (DefaultTableModel) table.getModel();
		
		for(int cnt = 0; cnt < hotel.getNumCustomerOrders(); cnt++)	{
			yourModel.addRow(new Object[]{hotel.getCustomerByIndex(cnt).getName(),
			hotel.getCustomerByIndex(cnt).getCustomerType(),
			hotel.getCustomerByIndex(cnt).getMobileNumber(),
			Integer.toString(hotel.getCustomerByIndex(cnt).getLocationX()),
			Integer.toString(hotel.getCustomerByIndex(cnt).getLocationY()),
			Double.toString(hotel.getCustomerByIndex(cnt).getDeliveryDistance()),
			hotel.getPizzaByIndex(cnt).getPizzaType(),
			Integer.toString(hotel.getPizzaByIndex(cnt).getQuantity()),
			Double.toString(hotel.getPizzaByIndex(cnt).getOrderPrice()),
			Double.toString(hotel.getPizzaByIndex(cnt).getOrderCost()),
			Double.toString(hotel.getPizzaByIndex(cnt).getOrderProfit()),
			hotel.getPizzaByIndex(cnt).deliveryTime.toString()});
		}
	}
	
	public double CalculateProfit() throws PizzaException, CustomerException{	
		double totalProfit = hotel.getTotalProfit();
		return totalProfit;
	}
	
	public double CalculateDistance() throws PizzaException, CustomerException{
		double totalDistance = hotel.getTotalDeliveryDistance();
		return totalDistance;
	}

	private void createMenuBar(){
	
		JMenu file = new JMenu("File");
		JMenuBar menubar = new JMenuBar();
		JMenuItem openOrderMenuItem = new JMenuItem("Open An Order");
		openOrderMenuItem.setToolTipText("Open an existing order.");
		openOrderMenuItem.addActionListener((ActionEvent event) -> {
			OpenFile();
			JOptionPane.showMessageDialog(null, "File Loaded");
		});
		
		JMenuItem calcProfitMenuItem = new JMenuItem("Calculate Profit and Distance");
		calcProfitMenuItem.setToolTipText("Calculate the days profit.");
		calcProfitMenuItem.addActionListener((ActionEvent event) -> {
			    if(selectedFile != null) {
						try {
							JOptionPane.showMessageDialog(null, "Total Profit: " + Double.toString(CalculateProfit())
							+ System.getProperty("line.separator") + " Total Distance: " + Double.toString(CalculateDistance()));
						} catch (Exception e) {
							e.printStackTrace();
						}
			    }
		});
		
		JMenuItem resetMenuItem = new JMenuItem("Reset Data");
		resetMenuItem.setToolTipText("Reset Data");
		resetMenuItem.addActionListener((ActionEvent event) -> {
			if(selectedFile != null){
				hotel.resetDetails();
				DefaultTableModel yourModel = (DefaultTableModel) table.getModel();
				yourModel.setRowCount(0);
			}
		});

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setToolTipText("Exit");
		exitMenuItem.addActionListener((ActionEvent event) -> {
			System.exit(0);
		});

		file.add(openOrderMenuItem);
		file.add(calcProfitMenuItem);
		file.add(resetMenuItem);
		file.add(exitMenuItem);

		menubar.add(file);

		setJMenuBar(menubar);
	}
	
	private void OpenFile(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(fra);
		if (result == JFileChooser.APPROVE_OPTION) {
		    selectedFile = fileChooser.getSelectedFile();
		    try {
		    	hotel.processLog(selectedFile.getAbsolutePath());
				AddDataToTable();
			} catch (CustomerException e) {
				e.printStackTrace();
			} catch (PizzaException e) {
				e.printStackTrace();
			} catch (LogHandlerException e) {
				e.printStackTrace();
			}
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		}
	}
	
	public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            PizzaGUI ex = new PizzaGUI("");
            ex.setVisible(true);
        });
    }

	@Override
	public void run() {
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {


	}
}
