import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.image.*;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.SwingConstants;



public class GUI {

	private JFrame frame;
	private JLabel [] [] labels = new JLabel [8] [8];
	private Board board = new Board();
	private Calculator calc = new Calculator(board);
	private JTextField customTimeTxt;
	
	private int oldRow=-1;
	private int oldColumn=-1;
	
	
	private JRadioButton btnWhite = new JRadioButton("White");


 	
	private Image pawn = new ImageIcon(this.getClass().getResource("/Pawn.png")).getImage();
	private Image night = new ImageIcon(this.getClass().getResource("/Knight.png")).getImage();
	private Image bishop = new ImageIcon(this.getClass().getResource("/Bishop.png")).getImage();
	private Image rook = new ImageIcon(this.getClass().getResource("/Rook.png")).getImage();
	private Image queen = new ImageIcon(this.getClass().getResource("/Queen.png")).getImage();
	private Image king = new ImageIcon(this.getClass().getResource("/King.png")).getImage();

	private Image bPawn = new ImageIcon(this.getClass().getResource("/blackPawn.png")).getImage();
	private Image bNight = new ImageIcon(this.getClass().getResource("/blackKnight.png")).getImage();
	private Image bBishop = new ImageIcon(this.getClass().getResource("/blackBishop.png")).getImage();
	private Image bRook = new ImageIcon(this.getClass().getResource("/blackRook.png")).getImage();
	private Image bQueen = new ImageIcon(this.getClass().getResource("/blackQueen.png")).getImage();
	private Image bKing = new ImageIcon(this.getClass().getResource("/blackKing.png")).getImage();
	
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txtEnterFence;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {		
					GUI window = new GUI();
					System.out.println(window.frame.getSize());
					
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0,1360, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(295, 302, 1, 1);
		frame.getContentPane().add(verticalBox);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(254, 511, 168, -145);
		frame.getContentPane().add(horizontalBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 311, 773);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("  Start  ");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				board.setCalc(calc);
				if(txtEnterFence.getText().equals(null)||txtEnterFence.getText().equals("")){
					board.restart();
						
				}else {
					board.restart(txtEnterFence.getText());
				}
				syncData();
				labelsColor();
				}
			
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 50));
		
		JLabel lblNewLabel_1 = new JLabel("enter Fen String here :");
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		
		txtEnterFence = new JTextField();
		panel_1.add(txtEnterFence);
		txtEnterFence.setColumns(28);
		
		JLabel lblColor = new JLabel("Color :");
		panel_1.add(lblColor);
		lblColor.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		
		
		buttonGroup.add(btnWhite);
		panel_1.add(btnWhite);
		btnWhite.setSelected(true);
		btnWhite.setFont(new Font("Arial Black", Font.BOLD, 18));
		
		JRadioButton btnBlack = new JRadioButton("Black");
		panel_1.add(btnBlack);
		buttonGroup.add(btnBlack);
		btnBlack.setFont(new Font("Arial Black", Font.BOLD, 18));
		
		JLabel lblTime = new JLabel("Time:");
		panel_1.add(lblTime);
		lblTime.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Custom:");
		panel_1.add(rdbtnNewRadioButton_5);
		rdbtnNewRadioButton_5.setSelected(true);
		buttonGroup_1.add(rdbtnNewRadioButton_5);
		rdbtnNewRadioButton_5.setFont(new Font("Arial Black", Font.BOLD, 14));
		
		customTimeTxt = new JTextField();
		panel_1.add(customTimeTxt);
		customTimeTxt.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("1 min");
		panel_1.add(rdbtnNewRadioButton);
		buttonGroup_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Arial Black", Font.BOLD, 14));
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("5 min ");
		panel_1.add(rdbtnNewRadioButton_2);
		buttonGroup_1.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setFont(new Font("Arial Black", Font.BOLD, 14));
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("15 min");
		panel_1.add(rdbtnNewRadioButton_3);
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setFont(new Font("Arial Black", Font.BOLD, 14));
		
		JLabel lblPlayerComputer = new JLabel("Player / Computer");
		panel_1.add(lblPlayerComputer);
		lblPlayerComputer.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox);
		comboBox.setFont(new Font("Arial Black", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"PLAYER", "beginner Engine (400)", "easy Engine (800)", "intermidiate Engine (1000)", "normal Engine (1200)", "advanced Engine (1400)", "further advanced Engine (1800)", "professional Engine (2000)", "grand Master Engine (2800)"}));
		comboBox.setSelectedIndex(0);
		
		JLabel lblLastGames = new JLabel("Last Games:");
		panel_1.add(lblLastGames);
		lblLastGames.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		panel_1.add(horizontalBox_1);
		
		
		
		
		
		
		for(int j=0;j<8;j++) {
		for(int i=0;i<8;i++) {
			labels[i][j]= new JLabel();
			labels[i][j].setBounds(350+(i*90),j*90,90,90);
			frame.getContentPane().add(labels[i][j]);
			// labels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			labels[i][j].setOpaque(true);
			//int index = i+j*8;
			int I =i;
			int J =j;
			labels[i][j].addMouseListener(new MouseAdapter()  
			{  
			    public void mouseClicked(MouseEvent e)  
			    {  
			    	clicked(I,J);
			    	labelsColor();
			    	syncData();
			    	
			    				    } 
			}); 
						
			
		}
		}
		labelsColor();
		
		
		
	}
	
	
	 

	private void labelsColor() {
		for(int j=0;j<8;j++) {
			for(int i=0;i<8;i++) {
				if((i%2)==0&&(j%2)==0) {
					labels[i][j].setBackground(new Color(238, 238, 210));
					if(board.getSquares()[i][j].isMarked()) {
						labels[i][j].setBackground(new Color(0, 238, 0));
					}
				}else {
					if(i%2==1&&(j%2)==1) {
						labels[i][j].setBackground(new Color(238, 238, 210));
						if(board.getSquares()[i][j].isMarked()) {
							labels[i][j].setBackground(new Color(0, 238, 0));
						}
					}else {
					labels[i][j].setBackground(new Color(118, 150, 86));
					if(board.getSquares()[i][j].isMarked()) {
						labels[i][j].setBackground(new Color(0, 238, 0));
					}
					}
				}

			}
		}
			
		
	}

	private void clicked(int pieceRow, int pieceColumn) {
		;
		try {
			if(board.getSquares()[pieceRow][pieceColumn].isMarked()) {
				System.out.println("moving piece "+board.getSquares()[oldRow][oldColumn].getType()+" from "+oldRow+oldColumn+" to "+pieceRow+pieceColumn);
				board.moving(oldRow, oldColumn, pieceRow, pieceColumn);	
				
			}else {
				board.markMoves(pieceRow, pieceColumn);
				oldRow= pieceRow;
				oldColumn =pieceColumn;
				
				System.out.println("marking for piece "+board.getSquares()[pieceRow][pieceColumn].getType()+" at "+oldRow+oldColumn );
			}
			syncData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
			
    	}
    	
	public void syncData() {
	
		for(int j=0;j<8;j++) {
			for(int i=0;i<8;i++) {
				switch(board.getSquares()[i][j].getType()){
                case "Pawn":
                	if(board.getSquares()[i][j].isColor()) {
                		labels[i][j].setIcon(new ImageIcon(pawn));
                	}else {
                		labels[i][j].setIcon(new ImageIcon(bPawn));
                	}
                    break;
                case "Night":
                	if(board.getSquares()[i][j].isColor()) {
                		labels[i][j].setIcon(new ImageIcon(night));
                	}else {
                		labels[i][j].setIcon(new ImageIcon(bNight));
                	}
                	break;
                case "Bishop":
                	if(board.getSquares()[i][j].isColor()) {
                		labels[i][j].setIcon(new ImageIcon(bishop));
                	}else {
                		labels[i][j].setIcon(new ImageIcon(bBishop));
                	}
                	break;
                case "Rook":
                	if(board.getSquares()[i][j].isColor()) {
                		labels[i][j].setIcon(new ImageIcon(rook));
                	}else {
                		labels[i][j].setIcon(new ImageIcon(bRook));
                	}
                	break;
                case "Queen":
                	if(board.getSquares()[i][j].isColor()) {
                		labels[i][j].setIcon(new ImageIcon(queen));
                	}else {
                		labels[i][j].setIcon(new ImageIcon(bQueen));
                	}
                	break;
                case "King":
                	if(board.getSquares()[i][j].isColor()) {
                		labels[i][j].setIcon(new ImageIcon(king));
                	}else {
                		labels[i][j].setIcon(new ImageIcon(bKing));
                	}
                	break;
                default:
                	labels[i][j].setIcon(null);
                	//labels[i][j].setText(board.getSquares()[i][j].getType());
                	
                	
        		}
				
				
	
				}
			}
	}
}
