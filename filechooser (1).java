

package Homework5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

class demonstrations extends JFrame implements ActionListener {
	
	  static JLabel label;
	  static JTextField pathway = null;
	  static JCheckBox JPG = null;
	  static JCheckBox BMP = null;
	  static JCheckBox TXT = null;
	  static JCheckBox DOC = null;
	
	public static void main(String[] agrs) {
		
		JFrame frame = new JFrame("File Chooser");
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pathway = new JTextField(30);
		
		JButton button = new JButton("open");
		
		JPG = new JCheckBox("JPG");
		BMP = new JCheckBox("BMP");
		TXT = new JCheckBox("TXT");
		DOC = new JCheckBox("DOC");
		
		demonstrations f1 = new demonstrations();
		
		button.addActionListener(f1);
		
		JPanel panel = new JPanel();
		
		panel.add(pathway);
		panel.add(button);
		panel.add(JPG);
		panel.add(BMP);
		panel.add(TXT);
		panel.add(DOC);
		
		label = new JLabel("no file selected");
		
		panel.add(label);
		frame.add(panel);
		
		frame.show();
		
	}
		public void actionPerformed(ActionEvent e) {
			
			JFileChooser t = new JFileChooser(pathway.getText());
			FileFilter docFilter = new FileTypeFilter(".doc", "Microsoft Word");
			FileFilter jpgFilter = new FileTypeFilter(".jpg", "JPG File");
			FileFilter bmpFilter = new FileTypeFilter(".bmp", "BMP File");
			FileFilter txtFilter = new FileTypeFilter(".txt", "Text File");
			
			if(JPG.isSelected()) {
				t.addChoosableFileFilter((javax.swing.filechooser.FileFilter) jpgFilter);
			}
			if(BMP.isSelected()) {
				t.addChoosableFileFilter((javax.swing.filechooser.FileFilter) bmpFilter);
			}
			if(TXT.isSelected()) {
				t.addChoosableFileFilter((javax.swing.filechooser.FileFilter) txtFilter);
			}
			if(DOC.isSelected()) {
				t.addChoosableFileFilter((javax.swing.filechooser.FileFilter) docFilter);
			}
			
			int u = t.showOpenDialog(null);
			
			if(u == JFileChooser.APPROVE_OPTION) {
				label.setText(t.getSelectedFile().getAbsolutePath());
			}
			
			else {
				label.setText("User cancelled the operation");
			}
		}
	}