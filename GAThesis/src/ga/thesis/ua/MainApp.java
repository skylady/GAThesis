package ga.thesis.ua;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class MainApp {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
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
	public MainApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 785, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u0424\u0430\u0439\u043B");
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u0420\u043E\u0431\u043E\u0442\u0430 \u0437 \u0411\u0414");
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem menuItem = new JMenuItem("\u0414\u043E\u043F\u043E\u043C\u043E\u0433\u0430");
		menuBar.add(menuItem);
		
		JSeparator separator = new JSeparator();
		menuBar.add(separator);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		table = new JTable();
		frame.getContentPane().add(table, "name_1401662698253734000");
	}

}
