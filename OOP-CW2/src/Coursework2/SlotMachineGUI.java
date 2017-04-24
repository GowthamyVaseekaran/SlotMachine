package Coursework2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.Buffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LongSummaryStatistics;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import javafx.scene.chart.PieChart;

public class SlotMachineGUI extends JFrame {
	Controller mainController = new Controller();

	boolean pressed = true;

	/**
	 * Default Constructor
	 * 
	 * @param title
	 */
	public SlotMachineGUI(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(950, 650);

	}

	/*
	 * Method to create Layout for reel interface
	 */

	public void createLayout() {
		// main panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 1));
		add(panel);
		// Panel 1
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(7, 1));
		// Creating Space pane
		JPanel innerSpacePane = new JPanel();
		innerSpacePane.setLayout(new GridLayout(3, 3));
		panel1.add(innerSpacePane);
		
		//labels for space

		JLabel welcomeLabel = new JLabel(" ");
		JLabel welcomeLabe2 = new JLabel(" ");
		JLabel welcomeLabe3 = new JLabel(" ");

		JLabel none1 = new JLabel("");
		//Heading
		JLabel slotMachineLabel = new JLabel("Welcome To Slot Machine");
		JLabel none3 = new JLabel("");
		JLabel welcomeLabe4 = new JLabel(" ");
		JLabel welcomeLabe5 = new JLabel(" ");
		JLabel welcomeLabe6 = new JLabel(" ");

		innerSpacePane.add(welcomeLabe4);
		innerSpacePane.add(welcomeLabe5);
		innerSpacePane.add(welcomeLabe6);

		innerSpacePane.add(none1);
		innerSpacePane.add(slotMachineLabel);
		innerSpacePane.add(none3);
		innerSpacePane.add(welcomeLabel);
		innerSpacePane.add(welcomeLabe2);
		innerSpacePane.add(welcomeLabe3);

		slotMachineLabel.setSize(55, 10);
		// create new Font
		Font font = new Font("Gotham", Font.BOLD, 20);

		slotMachineLabel.setFont(font);
		slotMachineLabel.setAlignmentX(CENTER_ALIGNMENT);
		slotMachineLabel.setForeground(new Color(0, 0, 128));

		// creating inner Panel1
		JPanel innerPanel1 = new JPanel();
		innerPanel1.setLayout(new GridLayout(1, 10));
		panel1.add(innerPanel1);

		JLabel none = new JLabel(" ");
		JLabel nonLabel1 = new JLabel(" ");
		JLabel noneLabel4 = new JLabel(" ");
		JLabel reelLabel1 = new JLabel();
		JLabel nonLabelImg = new JLabel(" ");
		JLabel reelLabel2 = new JLabel(" ");
		JLabel nonLabelImg1 = new JLabel(" ");
		JLabel reelLabel3 = new JLabel(" ");
		JLabel nonLabel2 = new JLabel(" ");

		/*
		 * To display random image when user starts the program
		 */

		BufferedImage img1 = null;
		BufferedImage img2 = null;
		BufferedImage img3 = null;
		try {
			img1 = ImageIO.read(new File(mainController.reel1.reelObj.getImage()));
			img2 = ImageIO.read(new File(mainController.reel2.reelObj.getImage()));
			img3 = ImageIO.read(new File(mainController.reel3.reelObj.getImage()));
		} catch (Exception i) {
			i.printStackTrace();
		}

		Image resizedImage = img1.getScaledInstance(90, 90, BufferedImage.SCALE_AREA_AVERAGING);
		ImageIcon icon1 = new ImageIcon(resizedImage);
		reelLabel1.setIcon(icon1);

		Image resizedImage2 = img2.getScaledInstance(90, 90, BufferedImage.SCALE_AREA_AVERAGING);
		ImageIcon icon2 = new ImageIcon(resizedImage2);
		reelLabel2.setIcon(icon2);

		Image resizedImage3 = img3.getScaledInstance(90, 90, BufferedImage.SCALE_AREA_AVERAGING);
		ImageIcon icon3 = new ImageIcon(resizedImage3);
		reelLabel3.setIcon(icon3);

		// Adding it into the inner Pane
		innerPanel1.add(nonLabel1);
		innerPanel1.add(noneLabel4);
		innerPanel1.add(reelLabel1);
		innerPanel1.add(nonLabelImg);
		innerPanel1.add(reelLabel2);
		innerPanel1.add(nonLabelImg1);
		innerPanel1.add(reelLabel3);
		innerPanel1.add(nonLabel2);
		innerPanel1.add(none);

		// create innerPane5
		JPanel innerPanel5 = new JPanel();
		innerPanel5.setLayout(new GridLayout(2, 3));
		panel1.add(innerPanel5);
		JLabel noneStatus1 = new JLabel(" ");
		JLabel noneStatus2 = new JLabel(" ");
		JLabel noneStatus3 = new JLabel(" ");
		JLabel statusNone1 = new JLabel(" ");
		JLabel winningLabel = new JLabel("Status");
		JLabel winningDisplayLabel = new JLabel("Welcome");
		winningDisplayLabel.setForeground(Color.BLUE);
		innerPanel5.add(noneStatus1);
		innerPanel5.add(noneStatus2);
		innerPanel5.add(noneStatus3);
		innerPanel5.add(statusNone1);
		innerPanel5.add(winningLabel);
		innerPanel5.add(winningDisplayLabel);

		/*
		 * credit Area and betting Area
		 */

		// inner panel 2
		JPanel panel1InnerPanel1 = new JPanel();
		panel1InnerPanel1.setLayout(new GridLayout(3, 4));
		panel1.add(panel1InnerPanel1);
		Font font1 = new Font("Arial", Font.BOLD, 25);

		JLabel freeSpace1 = new JLabel("");
		JLabel freeSpace2 = new JLabel("");
		JLabel freeSpace3 = new JLabel("");
		JLabel freeSpace4 = new JLabel("");
		JLabel panel1NoneLabel1 = new JLabel(" ");
		JLabel creditsDisplayLabel = new JLabel(String.valueOf(mainController.getTotalCredits()));
		creditsDisplayLabel.setForeground(Color.RED);
		creditsDisplayLabel.setOpaque(true);
		creditsDisplayLabel.setFont(font1);
		JLabel creditLabel = new JLabel("Credits");
		JLabel panel1NoneLabel2 = new JLabel("");

		JLabel panel1NoneLabel3 = new JLabel(" ");
		JLabel betAreaDisplayLabel = new JLabel(String.valueOf(mainController.getBetCredits()));
		betAreaDisplayLabel.setOpaque(true);

		betAreaDisplayLabel.setFont(font1);
		betAreaDisplayLabel.setForeground(Color.RED);
		JLabel betAreaLabel = new JLabel("Bet Area");
		JLabel panel1NoneLabel5 = new JLabel("");

		panel1InnerPanel1.add(freeSpace1);
		panel1InnerPanel1.add(freeSpace2);
		panel1InnerPanel1.add(freeSpace3);
		panel1InnerPanel1.add(freeSpace4);

		panel1InnerPanel1.add(panel1NoneLabel1);
		panel1InnerPanel1.add(creditsDisplayLabel);
		panel1InnerPanel1.add(panel1NoneLabel3);
		panel1InnerPanel1.add(betAreaDisplayLabel);

		panel1InnerPanel1.add(panel1NoneLabel2);
		panel1InnerPanel1.add(creditLabel);
		panel1InnerPanel1.add(panel1NoneLabel5);
		panel1InnerPanel1.add(betAreaLabel);

		// Creating innerpanel2
		JPanel innerPanel2 = new JPanel();
		innerPanel2.setLayout(new GridLayout(2, 3));
		panel1.add(innerPanel2);
		JLabel buttonSpace1 = new JLabel(" ");
		JLabel buttonSpace2 = new JLabel(" ");
		JLabel buttonSpace3 = new JLabel(" ");
		JLabel buttonSpace4 = new JLabel(" ");
		JButton spinButton = new JButton("Spin");
		JLabel buttonSpace5 = new JLabel(" ");

		innerPanel2.add(buttonSpace1);
		innerPanel2.add(buttonSpace2);
		innerPanel2.add(buttonSpace3);
		innerPanel2.add(buttonSpace4);
		innerPanel2.add(spinButton);
		innerPanel2.add(buttonSpace5);

		// Creating innerPanel4
		JPanel innerPanel3 = new JPanel();
		innerPanel3.setLayout(new GridLayout(1, 1));
		panel1.add(innerPanel3);
		JLabel noneLabel = new JLabel("");
		innerPanel3.add(noneLabel);

		// Creating innerPanel4
		JPanel innerPanel4 = new JPanel();
		innerPanel4.setLayout(new GridLayout(1, 11));
		panel1.add(innerPanel4);

		JLabel btnLabe1 = new JLabel("");
		JButton resetButton = new JButton("Reset");
		JLabel btnLabel2 = new JLabel(" ");
		JButton betOneBtn = new JButton("Bet One");
		JLabel btnLabel3 = new JLabel("");
		JButton betMaxBtn = new JButton("Bet Max");
		JLabel btnLabel4 = new JLabel("");
		JButton addCoinBtn = new JButton("Add Coin");
		JLabel btnLabel5 = new JLabel("");
		JButton statsBtn = new JButton("Statistic");
		JLabel btnLabel6 = new JLabel("");

		innerPanel4.add(btnLabe1);
		innerPanel4.add(resetButton);
		innerPanel4.add(btnLabel2);
		innerPanel4.add(betOneBtn);
		innerPanel4.add(btnLabel3);
		innerPanel4.add(betMaxBtn);
		innerPanel4.add(btnLabel4);
		innerPanel4.add(addCoinBtn);
		innerPanel4.add(btnLabel5);
		innerPanel4.add(statsBtn);
		innerPanel4.add(btnLabel6);

		panel.add(panel1);

		setVisible(true);

		/*
		 * Give Action to addcoin button
		 */

		addCoinBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainController.addCoin();
				creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));

			}
		});
		
		
		/*
		 * Give Action to bet one button
		 */

		betOneBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				winningDisplayLabel.setText("");

				if (mainController.getTotalCredits() > 0) {
					mainController.betOne();
					betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));
					creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));
				} else {
					JOptionPane.showMessageDialog(null, "You don't have enough credits to bet", "Error Message",
							JOptionPane.ERROR_MESSAGE);
					betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));
					creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));

				}

			}
		});

		/*
		 * Give action to bet max button
		 */

		betMaxBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				winningDisplayLabel.setText("");

				if (mainController.getTotalCredits() >= 3) {
					mainController.betMax();
					betMaxBtn.setEnabled(false);
					//JOptionPane.showMessageDialog(null, "You can bet only once");
					betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));
					creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));
					
					
				} else {
					JOptionPane.showMessageDialog(null, "You don't have enough credits to bet three credits",
							"Error Message", JOptionPane.ERROR_MESSAGE);
					betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));
					creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));

				}
				

			}
		});
		
		betMaxBtn.setEnabled(true);

		/*
		 * Give action to Reset button
		 */

		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				betMaxBtn.setEnabled(true);
				if (mainController.getBetCredits() > 0) {
					mainController.resetButton();
					betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));
					creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));
				} else {
					JOptionPane.showMessageDialog(null, "Please bet some credits", "Error Message",
							JOptionPane.ERROR_MESSAGE);
					betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));
					creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));
				}
			}
		});

		/*
		 * Give action to Spin Button
		 */

		spinButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				

				pressed = false;

				/*
				 * Reel won't spin if u haven't bet any credits
				 */

				if (mainController.getBetCredits() != 0) {
					winningDisplayLabel.setText("");
					/*
					 * Thread 1 : for reel 1
					 */
					Reel worker = new Reel() {
						public void run() {
							Symbol[] reelArray2 = spin();

							while (!pressed) {

								for (int i = 0; i < reelArray2.length; i++) {
									if (!pressed) {
										final int count = i;

										SwingUtilities.invokeLater(new Runnable() {
											public void run() {
												BufferedImage img1 = null;

												try {

													img1 = ImageIO.read(new File(reelArray2[count].getImage()));

												} catch (Exception i) {
													i.printStackTrace();
												}
												Image resizedImage = img1.getScaledInstance(90, 90,
														BufferedImage.SCALE_AREA_AVERAGING);
												ImageIcon icon1 = new ImageIcon(resizedImage);

												reelLabel1.setIcon(icon1);
												mainController.reel1.reelObj = reelArray2[count];

											}
										});

										try {
											Thread.sleep(100);
										} catch (InterruptedException e) {
										winningDisplayLabel.setText(e+"");
											

										}

									}
								}
							}

							SwingUtilities.invokeLater(new Runnable() {
								public void run() {

								}
							});

						}
					};

					/*
					 * Thread 2 :- For reel 2
					 */

					Reel worker2 = new Reel() {
						public void run() {
							Symbol[] reelArray3 = spin();
							while (!pressed) {

								for (int i = 0; i < reelArray3.length; i++) {
									if (!pressed) {
										final int count = i;

										SwingUtilities.invokeLater(new Runnable() {
											public void run() {
												BufferedImage img2 = null;

												try {

													img2 = ImageIO.read(new File(reelArray3[count].getImage()));

												} catch (Exception i) {
													i.printStackTrace();
												}
												Image resizedImage2 = img2.getScaledInstance(90, 90,
														BufferedImage.SCALE_AREA_AVERAGING);
												ImageIcon icon2 = new ImageIcon(resizedImage2);

												reelLabel2.setIcon(icon2);
												mainController.reel2.reelObj = reelArray3[count];

											}
										});

										try {

											Thread.sleep(100);
										} catch (InterruptedException e) {
											winningDisplayLabel.setText(e+"");

										}
									}

								}
							}

							SwingUtilities.invokeLater(new Runnable() {
								public void run() {

								}
							});

						}
					};

					/*
					 * Thread 3 :- for reel 3
					 */

					Reel worker3 = new Reel() {
						public void run() {
							Symbol[] reelArray4 = spin();
							while (!pressed) {

								for (int i = 0; i < reelArray4.length; i++) {
									if (!pressed) {
										final int count = i;

										SwingUtilities.invokeLater(new Runnable() {
											public void run() {
												BufferedImage img3 = null;

												try {

													img3 = ImageIO.read(new File(reelArray4[count].getImage()));

												} catch (Exception i) {
													i.printStackTrace();
												}
												Image resizedImage3 = img3.getScaledInstance(90, 90,
														BufferedImage.SCALE_AREA_AVERAGING);
												ImageIcon icon3 = new ImageIcon(resizedImage3);

												reelLabel3.setIcon(icon3);
												mainController.reel3.reelObj = reelArray4[count];

											}
										});

										try {
											Thread.sleep(100);
										} catch (InterruptedException e) {
											winningDisplayLabel.setText(e+"");

										}
									}

								}
							}

							SwingUtilities.invokeLater(new Runnable() {
								public void run() {

								}
							});

						}
					};

					/*
					 * Start method for threads
					 */

					worker.start();
					worker2.start();
					worker3.start();

					/*
					 * Error pop up window if the users haven't bet any credits
					 */

				} else {
					JOptionPane.showMessageDialog(null, "Please Bet Some Credits", "Error Message",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		/*
		 * Give Action to the reel labels to stop reels
		 */

		reelLabel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				winningDisplayLabel.setText("");
				pressed = true;
				mainController.calculateCredits();
				// mainController.calculateStats();
				creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));
				betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));

				if (mainController.getTotalCredits() == 0 && mainController.getBetCredits() == 0) {
					creditsDisplayLabel.setText(String.valueOf(0));

					betAreaDisplayLabel.setText(String.valueOf(0));
					winningDisplayLabel.setForeground(Color.red);
					winningDisplayLabel.setText("Game Over");
					JOptionPane.showMessageDialog(null, "Game Over you can't play with zero credits");
					spinButton.setEnabled(false);
					addCoinBtn.setEnabled(false);
					betOneBtn.setEnabled(false);
					betMaxBtn.setEnabled(false);
					resetButton.setEnabled(false);

				} else {

					if ((mainController.reel1.reelObj.equalTo(mainController.reel2.reelObj))
							&& (mainController.reel2.reelObj.equalTo(mainController.reel3.reelObj))) {
						// 3 reels are equal
						creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));
						betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));
						winningDisplayLabel.setText(mainController.getStatus());

						addCoinBtn.setEnabled(true);
						betOneBtn.setEnabled(true);
						betMaxBtn.setEnabled(true);
						resetButton.setEnabled(true);
					} else {
						// 2 reels are equal or all are different
						if ((mainController.reel1.reelObj.equalTo(mainController.reel2.reelObj))
								|| (mainController.reel2.reelObj.equalTo(mainController.reel3.reelObj))
								|| (mainController.reel1.reelObj.equalTo(mainController.reel3.reelObj))) {
							// 2 reels are equal
							creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));
							betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));
							winningDisplayLabel.setText(mainController.getStatus());
							addCoinBtn.setEnabled(false);
							betOneBtn.setEnabled(false);
							betMaxBtn.setEnabled(false);
							resetButton.setEnabled(false);

						} else {
							// all reels are different
							creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));
							betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));
							winningDisplayLabel.setText(mainController.getStatus());
							addCoinBtn.setEnabled(true);
							betOneBtn.setEnabled(true);
							betMaxBtn.setEnabled(true);
							resetButton.setEnabled(true);

						}

					}
				}

			}

		});

		/*
		 * Give Action to the reel labels to stop reels
		 */

		reelLabel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				pressed = true;
				mainController.calculateCredits();

				creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));
				betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));

				if (mainController.getTotalCredits() == 0 && mainController.getBetCredits() == 0) {
					creditsDisplayLabel.setText(String.valueOf(0));

					betAreaDisplayLabel.setText(String.valueOf(0));
					winningDisplayLabel.setForeground(Color.red);
					winningDisplayLabel.setText("Game Over");
					JOptionPane.showMessageDialog(null, "Game Over you can't play with zero credits");
					spinButton.setEnabled(false);
					addCoinBtn.setEnabled(false);
					betOneBtn.setEnabled(false);
					betMaxBtn.setEnabled(false);
					resetButton.setEnabled(false);

				} else {

					if ((mainController.reel1.reelObj.equalTo(mainController.reel2.reelObj))
							&& (mainController.reel2.reelObj.equalTo(mainController.reel3.reelObj))) {
						// 3 reels are equal
						creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));
						betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));
						winningDisplayLabel.setText(mainController.getStatus());
						addCoinBtn.setEnabled(true);
						betOneBtn.setEnabled(true);
						betMaxBtn.setEnabled(true);
						resetButton.setEnabled(true);
					} else {
						// 2 reels are equal or all are different
						if ((mainController.reel1.reelObj.equalTo(mainController.reel2.reelObj))
								|| (mainController.reel2.reelObj.equalTo(mainController.reel3.reelObj))
								|| (mainController.reel1.reelObj.equalTo(mainController.reel3.reelObj))) {
							// 2 reels are equal
							creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));
							betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));
							winningDisplayLabel.setText(mainController.getStatus());
							addCoinBtn.setEnabled(false);
							betOneBtn.setEnabled(false);
							betMaxBtn.setEnabled(false);
							resetButton.setEnabled(false);

						} else {
							// all reels are different
							creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));
							betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));
							winningDisplayLabel.setText(mainController.getStatus());
							addCoinBtn.setEnabled(true);
							betOneBtn.setEnabled(true);
							betMaxBtn.setEnabled(true);
							resetButton.setEnabled(true);

						}

					}
				}

			}

		});

		/*
		 * Give Action to the reel labels to stop reels
		 */

		reelLabel3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				pressed = true;
				mainController.calculateCredits();
				// mainController.calculateStats();
				creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));
				betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));

				if (mainController.getTotalCredits() == 0 && mainController.getBetCredits() == 0) {
					creditsDisplayLabel.setText(String.valueOf(0));

					betAreaDisplayLabel.setText(String.valueOf(0));
					winningDisplayLabel.setForeground(Color.red);
					winningDisplayLabel.setText("Game Over");
					JOptionPane.showMessageDialog(null, "Game Over you can't play with zero credits");
					spinButton.setEnabled(false);
					addCoinBtn.setEnabled(false);
					betOneBtn.setEnabled(false);
					betMaxBtn.setEnabled(false);
					resetButton.setEnabled(false);

				} else {

					if ((mainController.reel1.reelObj.equalTo(mainController.reel2.reelObj))
							&& (mainController.reel2.reelObj.equalTo(mainController.reel3.reelObj))) {
						// 3 reels are equal
						creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));
						betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));
						winningDisplayLabel.setText(mainController.getStatus());
						addCoinBtn.setEnabled(true);
						betOneBtn.setEnabled(true);
						betMaxBtn.setEnabled(true);
						resetButton.setEnabled(true);
					} else {
						// 2 reels are equal or all are different
						if ((mainController.reel1.reelObj.equalTo(mainController.reel2.reelObj))
								|| (mainController.reel2.reelObj.equalTo(mainController.reel3.reelObj))
								|| (mainController.reel1.reelObj.equalTo(mainController.reel3.reelObj))) {
							// 2 reels are equal
							creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));
							betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));
							winningDisplayLabel.setText(mainController.getStatus());
							addCoinBtn.setEnabled(false);
							betOneBtn.setEnabled(false);
							betMaxBtn.setEnabled(false);
							resetButton.setEnabled(false);

						} else {
							// all reels are different
							creditsDisplayLabel.setText(String.valueOf(mainController.getTotalCredits()));
							betAreaDisplayLabel.setText(String.valueOf(mainController.getBetCredits()));
							winningDisplayLabel.setText(mainController.getStatus());
							addCoinBtn.setEnabled(true);
							betOneBtn.setEnabled(true);
							betMaxBtn.setEnabled(true);
							resetButton.setEnabled(true);

						}

					}
				}

			}

		});

		/*
		 * Give Action to stats button
		 */

		statsBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SlotMachineGUI stats = new SlotMachineGUI("Statistics");
				stats.createStatsLayout(mainController.getWinCount(), mainController.getLossCount(),
						mainController.getNoOfGames(), mainController.getNetCredits());
			}
		});

	}

	/*
	 * Method to create statistics window
	 */
	public void createStatsLayout(int win, int loss, int noOfGames, double netCredits) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(450, 450);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));
		add(panel);

		JPanel statsPanel = new JPanel();
		statsPanel.setLayout(new GridLayout(1, 5));
		JLabel statsBlank = new JLabel("");
		JLabel statsBlank3 = new JLabel(" ");
		JLabel statsHeadingLbl = new JLabel("STATISTICS");
		JLabel statsBlank1 = new JLabel("");
		JLabel statsBlank4 = new JLabel("");
		statsPanel.add(statsBlank);
		statsPanel.add(statsBlank3);
		statsPanel.add(statsHeadingLbl);
		statsPanel.add(statsBlank1);
		statsPanel.add(statsBlank4);
		// Inner Panel
		JPanel statsDataPanel = new JPanel();
		statsDataPanel.setLayout(new GridLayout(5, 3));
		JLabel winBlank = new JLabel(" ");
		JLabel winlabel = new JLabel("Wins");
		JLabel winDisplayLabel = new JLabel();
		JLabel lossBlank = new JLabel(" ");
		JLabel lostLabel = new JLabel("Losses");
		JLabel lostDisplayLabel = new JLabel();
		JLabel noOfGamesBlank = new JLabel(" ");
		JLabel noOfGameLabel = new JLabel("No of Games");
		JLabel noOfGameDisplayLabel = new JLabel();
		JLabel netCreditsBlank = new JLabel(" ");
		JLabel netCreditsLabel = new JLabel("Net Credits Per Game");
		JLabel netCreditsDisplayLabel = new JLabel();

		statsDataPanel.add(winBlank);
		statsDataPanel.add(winlabel);
		statsDataPanel.add(winDisplayLabel);
		statsDataPanel.add(lossBlank);
		statsDataPanel.add(lostLabel);
		statsDataPanel.add(lostDisplayLabel);
		statsDataPanel.add(noOfGamesBlank);
		statsDataPanel.add(noOfGameLabel);
		statsDataPanel.add(noOfGameDisplayLabel);
		statsDataPanel.add(netCreditsBlank);
		statsDataPanel.add(netCreditsLabel);
		statsDataPanel.add(netCreditsDisplayLabel);
		// winPanel.add(saveStatsbtn);

		JPanel statsPanel2 = new JPanel();
		statsPanel2.setLayout(new GridLayout(3, 3));
		JLabel buttonBlank3 = new JLabel(" ");
		JLabel buttonBlank4 = new JLabel(" ");
		JLabel buttonBlank5 = new JLabel(" ");

		JLabel buttonBlank = new JLabel(" ");
		JButton saveStats = new JButton("Save Statistics");
		JLabel buttonBlank1 = new JLabel("");

		JLabel buttonBlank6 = new JLabel(" ");
		JLabel buttonBlank7 = new JLabel(" ");
		JLabel buttonBlank8 = new JLabel(" ");
		
		//Progress Bar
		
		JPanel progressPanel = new JPanel();
		progressPanel.setLayout(new GridLayout(1, 1));
		JProgressBar lossBar=new JProgressBar();
		lossBar.setValue(loss*10);
		lossBar.setStringPainted(true);
		lossBar.setForeground(Color.RED);
		//lossBar.setSize(25, 50);
		
		Border border = BorderFactory.createTitledBorder("Lost Status");
	    lossBar.setBorder(border);
	    progressPanel.add(lossBar, BorderLayout.NORTH);
		
	    JPanel progressPanel2 = new JPanel();
		progressPanel2.setLayout(new GridLayout(1, 1));
		JProgressBar winBar=new JProgressBar();
		winBar.setValue(win*10);
		winBar.setStringPainted(true);
		winBar.setForeground(Color.GREEN);
		//lossBar.setSize(25, 50);
		
		Border border1 = BorderFactory.createTitledBorder("Win Status");
	    winBar.setBorder(border1);
	    progressPanel.add(winBar, BorderLayout.NORTH);

		statsPanel2.add(buttonBlank3);
		statsPanel2.add(buttonBlank4);
		statsPanel2.add(buttonBlank5);
		statsPanel2.add(buttonBlank);
		statsPanel2.add(saveStats);
		statsPanel2.add(buttonBlank1);
		statsPanel2.add(buttonBlank6);
		statsPanel2.add(buttonBlank7);
		statsPanel2.add(buttonBlank8);
		panel.add(statsPanel);
		panel.add(statsDataPanel);
		panel.add(statsPanel2);
		panel.add(progressPanel);
		setVisible(true);

		winDisplayLabel.setText(win + "");
		lostDisplayLabel.setText(loss + "");
		noOfGameDisplayLabel.setText(noOfGames + "");
		double netCreditsPerGame = (double) Math.round(netCredits / noOfGames);
		netCreditsDisplayLabel.setText(netCreditsPerGame + "");
		
		
		
		
		
		/*
		 * Visualize the user's current status whether he/she is in winning
		 * sector or not Green Color :- Winning sector Red Color :- Losing
		 * Sector Yellow :- Balanced sector which means no of wins = no of
		 * losses Grey :- Normal window color
		 */
		
		if (win > loss) {
			statsPanel.setBackground(new Color(34, 119, 62));
			statsDataPanel.setBackground(new Color(34, 119, 62));
			statsPanel2.setBackground(new Color(34, 119, 62));
			winlabel.setForeground(Color.WHITE);
			winDisplayLabel.setForeground(Color.WHITE);
			lostLabel.setForeground(Color.WHITE);
			lostDisplayLabel.setForeground(Color.WHITE);
			statsHeadingLbl.setForeground(Color.WHITE);
			noOfGameLabel.setForeground(Color.WHITE);
			noOfGameDisplayLabel.setForeground(Color.WHITE);
			netCreditsLabel.setForeground(Color.WHITE);
			netCreditsDisplayLabel.setForeground(Color.WHITE);
		} else if (win < loss) {
			statsDataPanel.setBackground(new Color(190, 48, 40));
			statsPanel.setBackground(new Color(190, 48, 40));
			statsPanel2.setBackground(new Color(190, 48, 40));
			winlabel.setForeground(Color.WHITE);
			winDisplayLabel.setForeground(Color.WHITE);
			lostLabel.setForeground(Color.WHITE);
			lostDisplayLabel.setForeground(Color.WHITE);
			statsHeadingLbl.setForeground(Color.WHITE);
			noOfGameLabel.setForeground(Color.WHITE);
			noOfGameDisplayLabel.setForeground(Color.WHITE);
			netCreditsLabel.setForeground(Color.WHITE);
			netCreditsDisplayLabel.setForeground(Color.WHITE);
		} else {

		}

		/*
		 * Give action to saveStats Button
		 */

		saveStats.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					String fileName = new SimpleDateFormat("yyyyMMddhhmm'.txt'").format(new Date());
					File file = new File(fileName);
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);

					bw.write("Wins" + " " + win + " ");

					bw.write("Losses" + " " + loss + " ");
					bw.write("No of games" + " " + noOfGames + " ");
					bw.write("Net credits per game" + " " + netCreditsPerGame + " ");
					bw.close();
					JOptionPane.showMessageDialog(null, "File writing successful");
				} catch (Exception ex) {
					System.err.println(ex);
					JOptionPane.showMessageDialog(null, "File is not found", "Error Message",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}

	public static void main(String[] args) {
		// create object
		SlotMachineGUI controller = new SlotMachineGUI("Slot Machine");
		// calling create layout method
		controller.createLayout();

	}

}
