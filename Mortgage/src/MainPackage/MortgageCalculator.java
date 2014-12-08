package MainPackage;

import org.apache.poi.ss.formula.functions.FinanceLib;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MortgageCalculator {

	private JFrame frame;
	private JTextField income;
	private JTextField monthly;
	private JTextField rate;
	private JTextField downPayment;
	String[] list = {"10","15","30"};
	private JTextField Obl;
	private JTextField MPayment;
	private JTextField Mortgage;
	double anual;
	double monthPayment;
	double r;
	int period;
	double down_payment;
	double HPayment;
	double OPayment;
	double Lower;
	double Final;
	private JTextField House;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MortgageCalculator window = new MortgageCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MortgageCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 694, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total Income");
		lblNewLabel.setBounds(23, 39, 87, 16);
		panel.add(lblNewLabel);
		
		JLabel lblMonthlyDebt = new JLabel("Monthly debt");
		lblMonthlyDebt.setBounds(23, 81, 103, 16);
		panel.add(lblMonthlyDebt);
		
		JLabel lblInterestRate = new JLabel("Interest Rate");
		lblInterestRate.setBounds(23, 128, 87, 16);
		panel.add(lblInterestRate);
		
		JLabel lblTerm = new JLabel("Term");
		lblTerm.setBounds(23, 170, 103, 16);
		panel.add(lblTerm);
		
		JLabel lblNewLabel_1 = new JLabel("Down payment ");
		lblNewLabel_1.setBounds(24, 215, 102, 16);
		panel.add(lblNewLabel_1);
		
		income = new JTextField();
		income.setBounds(148, 33, 134, 28);
		panel.add(income);
		income.setColumns(10);
		
		monthly = new JTextField();
		monthly.setColumns(10);
		monthly.setBounds(148, 75, 134, 28);
		panel.add(monthly);
		
		rate = new JTextField();
		rate.setColumns(10);
		rate.setBounds(148, 122, 134, 28);
		panel.add(rate);
		
		downPayment = new JTextField();
		downPayment.setColumns(10);
		downPayment.setBounds(148, 209, 134, 28);
		downPayment.setText("0.00");
		panel.add(downPayment);
		
		final JComboBox comboBox = new JComboBox(list);
		comboBox.setBounds(147, 166, 135, 27);
		panel.add(comboBox);
		comboBox.setSelectedIndex(2);
		
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				HPayment = (Double.parseDouble(income.getText())/12) * 0.18;
				OPayment = ((Double.parseDouble(income.getText())/12) * 0.36) - (Double.parseDouble(monthly.getText()));
				Obl.setText(Double.toString(OPayment));
				period = Integer.valueOf((String)comboBox.getSelectedItem()) * 12;
			
				r = (Double.parseDouble(rate.getText())/100) /12;
				down_payment = Double.parseDouble(downPayment.getText());
				
				if(HPayment < OPayment){
					Lower = HPayment;
				}else{
					Lower = OPayment;
				}
				MPayment.setText(Double.toString(Lower));
				
				
				Final = - FinanceLib.pv(r,period ,Lower, down_payment,false);
				
				Mortgage.setText(Double.toString(Final));
				House.setText(Double.toString(HPayment));
				
				
			}
		});
		btnCalculate.setBounds(401, 216, 215, 45);
		panel.add(btnCalculate);
		
		Obl = new JTextField();
		Obl.setEditable(false);
		Obl.setColumns(10);
		Obl.setBounds(447, 81, 134, 28);
		panel.add(Obl);
		
		JLabel label36 = new JLabel("Obligation Payment");
		label36.setBounds(447, 61, 134, 16);
		panel.add(label36);
		
		JLabel lblMaximumPayment = new JLabel("Maximum payment ");
		lblMaximumPayment.setBounds(447, 107, 140, 16);
		panel.add(lblMaximumPayment);
		
		MPayment = new JTextField();
		MPayment.setEditable(false);
		MPayment.setColumns(10);
		MPayment.setBounds(447, 122, 134, 28);
		panel.add(MPayment);
		
		JLabel mortgage = new JLabel("Mortgage");
		mortgage.setBounds(477, 151, 65, 16);
		panel.add(mortgage);
		
		Mortgage = new JTextField();
		Mortgage.setEditable(false);
		Mortgage.setColumns(10);
		Mortgage.setBounds(441, 170, 140, 23);
		panel.add(Mortgage);
		
		House = new JTextField();
		House.setEditable(false);
		House.setBounds(447, 33, 134, 28);
		panel.add(House);
		House.setColumns(10);
		
		JLabel lblHousingPayment = new JLabel("Housing Payment");
		lblHousingPayment.setBounds(457, 16, 134, 16);
		panel.add(lblHousingPayment);
		
		
	}
}
