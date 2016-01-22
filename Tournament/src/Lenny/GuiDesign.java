package Lenny;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * 
 * @author Lenny
 * @since Jan 15 2016
 * 
 *        This is the user interface design. When I built this GUI class, I was
 *        using the environment 1.8. Then I notice the I need to change to 1.7,
 *        so I change some code here. I have tested that GUI can work without
 *        bugs and I hope it can work well in the future.
 * 
 */
public class GuiDesign {

	private JFrame frame;

	ArrayList<Sporter> single_sporters = null;
	ArrayList<Sporter> team_sporters = null;

	Sporter add_sporter;
	Supporter supporter_one;
	Supporter supporter_two;
	// boolean find = false;

	Tournament tournament = null;
	boolean check = false;

	Strategy strategy = null;
	Sport sport = null;
	int sport_select;
	int strategy_select;

	private JTextField txtSinglePlayers;
	private JTextField txtTeamPlayers;
	private JTextField txtSport_1;
	private JTextField txtChoosePlayers;
	private JTextField txtMainchoose;
	private JTextField txtCChooseStrategy;
	private JTextField txtCheckStrategy;
	private JTextField txtSupportChoose;
	private JTextField txtSupportPlayer;
	private JTextField txtSupportId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SporterAllSingleton singleton = new SporterAllSingleton();
					singleton.loadSingles();
					singleton.loadTeams();
					GuiDesign window = new GuiDesign(singleton);
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
	public GuiDesign(SporterAllSingleton singleton) {
		initialize(singleton);
	}
	/******************************************************/

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(SporterAllSingleton singleton) {

		single_sporters = singleton.getSporters_single();
		team_sporters = singleton.getSporters_team();
		final ArrayList<Sporter> now_sporters = new ArrayList<>();

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.getContentPane().setEnabled(false);
		frame.setResizable(false);
		frame.setBounds(100, 100, 1031, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtSinglePlayers = new JTextField();
		txtSinglePlayers.setHorizontalAlignment(SwingConstants.CENTER);
		txtSinglePlayers.setEditable(false);
		txtSinglePlayers.setEnabled(false);
		txtSinglePlayers.setText("Single Players");
		txtSinglePlayers.setBounds(16, 6, 130, 26);
		frame.getContentPane().add(txtSinglePlayers);
		txtSinglePlayers.setColumns(10);

		txtTeamPlayers = new JTextField();
		txtTeamPlayers.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeamPlayers.setEnabled(false);
		txtTeamPlayers.setEditable(false);
		txtTeamPlayers.setText("Team Players");
		txtTeamPlayers.setBounds(164, 6, 130, 26);
		frame.getContentPane().add(txtTeamPlayers);
		txtTeamPlayers.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 44, 130, 162);
		frame.getContentPane().add(scrollPane);

		JTextArea txtrSingle = new JTextArea();
		txtrSingle.setText("Singles: " + '\n' + "-----------" + '\n' + single_sporters.toString());

		txtrSingle.setEditable(false);
		txtrSingle.setEnabled(false);
		scrollPane.setViewportView(txtrSingle);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(164, 44, 130, 162);
		frame.getContentPane().add(scrollPane_1);

		JTextArea txtrTeam = new JTextArea();
		txtrTeam.setEditable(false);
		txtrTeam.setEnabled(false);
		txtrTeam.setText("Teams: " + '\n' + "-----------" + '\n' + team_sporters.toString());

		scrollPane_1.setViewportView(txtrTeam);

		/******************************************************/

		txtSport_1 = new JTextField();
		txtSport_1.setBackground(new Color(255, 255, 224));
		txtSport_1.setEditable(false);
		txtSport_1.setText("");
		txtSport_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSport_1.setBounds(407, 41, 110, 26);
		frame.getContentPane().add(txtSport_1);
		txtSport_1.setColumns(10);

		String[] sport_selections = { "Soccer", "Basketball", "Tennis" };
		final JList list = new JList(sport_selections);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.setBounds(324, 11, 61, 51);
		frame.getContentPane().add(list);

		JButton btnSportbtn = new JButton("A. Sport Check");
		btnSportbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() != -1) {
					String spt = list.getSelectedValue().toString();
					txtSport_1.setText(spt);
					now_sporters.clear();

					if (spt.equals("Soccer")) {
						sport = new SportSoccer();
						sport_select = 1;
					} else if (spt.equals("Basketball")) {
						sport = new SportBasketball();
						sport_select = 2;
					} else if (spt.equals("Tennis")) {
						sport = new SportTennis();
						sport_select = 3;
					} else {
						sport_select = 0;
					}
				}
			}
		});
		btnSportbtn.setBounds(397, 6, 130, 29);
		frame.getContentPane().add(btnSportbtn);

		String[] strategy_selections = { "1. RoundKickOut", "2. RoundRobin", "3. RoundRound", "4. RoundTeamKickOut",
				"5. RoundTeamRobin" };
		final JList list_1 = new JList(strategy_selections);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBounds(324, 268, 195, 85);
		list_1.setSelectedIndex(0);
		frame.getContentPane().add(list_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(324, 74, 195, 135);
		frame.getContentPane().add(scrollPane_2);

		JTextArea txtrTips = new JTextArea();
		txtrTips.setForeground(Color.ORANGE);
		txtrTips.setEnabled(false);
		txtrTips.setEditable(false);
		scrollPane_2.setViewportView(txtrTips);
		txtrTips.setText("Welcome \n" + "1. Select Sport First\n"
				+ "2. If you select Soccer or Basketball, Please only add teams to Game and use Strategy 123.\n"
				+ "3. If you select Tennis, you can decide:\n"
				+ " Single game: Add single players and choose stragety 123 \n"
				+ " Team game: Add teams to game and choose 45\n"
				+ "4. Press Start button after add players and choose strategy");

		txtChoosePlayers = new JTextField();
		txtChoosePlayers.setBackground(new Color(255, 255, 240));
		txtChoosePlayers.setForeground(Color.ORANGE);
		txtChoosePlayers.setText("B. Choose Players ");
		txtChoosePlayers.setHorizontalAlignment(SwingConstants.CENTER);
		txtChoosePlayers.setEditable(false);
		txtChoosePlayers.setEnabled(false);
		txtChoosePlayers.setBounds(16, 233, 278, 26);
		frame.getContentPane().add(txtChoosePlayers);
		txtChoosePlayers.setColumns(10);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(Color.DARK_GRAY);
		textArea_1.setEnabled(false);
		textArea_1.setEditable(false);
		textArea_1.setBounds(324, 215, 195, 6);
		frame.getContentPane().add(textArea_1);

		txtMainchoose = new JTextField();
		txtMainchoose.setBounds(16, 263, 130, 26);
		frame.getContentPane().add(txtMainchoose);
		txtMainchoose.setColumns(10);

		JButton btnNewButton = new JButton("Add Player");
		btnNewButton.setBounds(158, 263, 143, 29);
		frame.getContentPane().add(btnNewButton);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(16, 300, 278, 131);
		frame.getContentPane().add(scrollPane_3);

		final JTextArea txtrNowPlayer = new JTextArea();
		scrollPane_3.setViewportView(txtrNowPlayer);
		txtrNowPlayer.setBackground(new Color(255, 255, 224));
		txtrNowPlayer.setEnabled(false);
		txtrNowPlayer.setEditable(false);
		txtrNowPlayer.setText("Now Players");

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setEnabled(false);
		textArea_2.setEditable(false);
		textArea_2.setBackground(Color.DARK_GRAY);
		textArea_2.setBounds(16, 215, 277, 6);
		frame.getContentPane().add(textArea_2);

		/******************************************************/

		txtCheckStrategy = new JTextField();
		txtCheckStrategy.setHorizontalAlignment(SwingConstants.CENTER);
		txtCheckStrategy.setEnabled(false);
		txtCheckStrategy.setEditable(false);
		txtCheckStrategy.setBackground(new Color(255, 255, 224));
		txtCheckStrategy.setBounds(324, 405, 193, 26);
		frame.getContentPane().add(txtCheckStrategy);
		txtCheckStrategy.setColumns(10);

		txtCChooseStrategy = new JTextField();
		txtCChooseStrategy.setHorizontalAlignment(SwingConstants.CENTER);
		txtCChooseStrategy.setBackground(new Color(255, 255, 240));
		txtCChooseStrategy.setText("C. Choose Strategy");
		txtCChooseStrategy.setEditable(false);
		txtCChooseStrategy.setEnabled(false);
		txtCChooseStrategy.setBounds(324, 233, 195, 26);
		frame.getContentPane().add(txtCChooseStrategy);
		txtCChooseStrategy.setColumns(10);

		JButton btnNewButton_1 = new JButton("Check Strategy");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() != -1) {
					String str = list_1.getSelectedValue().toString();
					check = false;
					txtCheckStrategy.setText(str);

					if (str.equals("1. RoundKickOut")) {
						strategy_select = 1;
					} else if (str.equals("2. RoundRobin")) {
						strategy_select = 2;
					} else if (str.equals("3. RoundRound")) {
						strategy_select = 3;
					} else if (str.equals("4. RoundTeamKickOut")) {
						strategy_select = 4;

					} else if (str.equals("5. RoundTeamRobin")) {
						strategy_select = 5;
					} else {
						strategy_select = 0;
					}
				}

				if (sport_select == 0) {
					txtCheckStrategy.setText("Check Sport");
				} else if (sport_select == 1 || sport_select == 2) {
					if (strategy_select == 1)
						strategy = new RoundKickOut(now_sporters, sport);
					else if (strategy_select == 2)
						strategy = new RoundRobin(now_sporters, sport);
					else if (strategy_select == 3)
						strategy = new RoundRound(now_sporters, sport);
					else
						txtCheckStrategy.setText("Invalid Strategy");
					tournament = new Tournament(strategy);
					check = true;

				} else if (sport_select == 3) {
					if (now_sporters.size() == 0) {
						txtCheckStrategy.setText("Add Players");
					} else {
						if (now_sporters.get(0) instanceof Player) {
							if (strategy_select == 1) {
								strategy = new RoundKickOut(now_sporters, sport);
								check = true;
							} else if (strategy_select == 2) {
								strategy = new RoundRobin(now_sporters, sport);
								check = true;
							} else if (strategy_select == 3) {
								strategy = new RoundRound(now_sporters, sport);
								check = true;
							} else
								txtCheckStrategy.setText("Invalid Strategy");
							tournament = new Tournament(strategy);

						} else if (now_sporters.get(0) instanceof PlayersTeam) {
							if (strategy_select == 4) {
								check = true;
								strategy = new RoundTeamKickOut(now_sporters, sport);
							} else if (strategy_select == 5) {
								strategy = new RoundTeamRobin(now_sporters, sport);
								check = true;
							} else
								txtCheckStrategy.setText("Invalid Strategy");
							tournament = new Tournament(strategy);

						} else {
							txtCheckStrategy.setText("Invalid Strategy");
						}

					}
				}

			}
		});
		btnNewButton_1.setBounds(324, 365, 193, 29);
		frame.getContentPane().add(btnNewButton_1);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(0, 0, 0));
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(306, 6, 6, 429);
		frame.getContentPane().add(textArea);

		JTextArea textArea_3 = new JTextArea();
		textArea_3.setEnabled(false);
		textArea_3.setEditable(false);
		textArea_3.setBackground(Color.BLACK);
		textArea_3.setBounds(529, -120, 6, 551);
		frame.getContentPane().add(textArea_3);

		JTextArea textArea_4 = new JTextArea();
		textArea_4.setEnabled(false);
		textArea_4.setEditable(false);
		textArea_4.setBackground(Color.DARK_GRAY);
		textArea_4.setBounds(547, 152, 478, 6);
		frame.getContentPane().add(textArea_4);

		/******************************************************/
		/******************************************************/

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(547, 196, 478, 114);
		frame.getContentPane().add(scrollPane_4);

		final JTextArea txtrAllscore = new JTextArea();
		scrollPane_4.setViewportView(txtrAllscore);
		txtrAllscore.setEnabled(false);
		txtrAllscore.setEditable(false);
		txtrAllscore.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		txtrAllscore.setText("All Score");

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(547, 322, 478, 109);
		frame.getContentPane().add(scrollPane_5);

		final JTextArea txtrAllRank = new JTextArea();
		scrollPane_5.setViewportView(txtrAllRank);
		txtrAllRank.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		txtrAllRank.setEditable(false);
		txtrAllRank.setEnabled(false);
		txtrAllRank.setText("All Rank");

		JButton btnStart = new JButton("Start Tournament - All Matches and Final Ranks Show Below");
		btnStart.setForeground(new Color(255, 0, 0));
		btnStart.setBackground(new Color(255, 165, 0));
		btnStart.setBounds(547, 163, 478, 26);
		frame.getContentPane().add(btnStart);

		/******************************************************/
		/******************************************************/

		txtSupportChoose = new JTextField();
		txtSupportChoose.setBackground(Color.CYAN);
		txtSupportChoose.setForeground(Color.WHITE);
		txtSupportChoose.setHorizontalAlignment(SwingConstants.CENTER);
		txtSupportChoose.setEnabled(false);
		txtSupportChoose.setEditable(false);
		txtSupportChoose.setText("Support - Choose Player from Now Players and Result will Show Below");
		txtSupportChoose.setBounds(547, 6, 478, 26);
		frame.getContentPane().add(txtSupportChoose);
		txtSupportChoose.setColumns(10);

		txtSupportPlayer = new JTextField();
		txtSupportPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		txtSupportPlayer.setBounds(547, 36, 93, 26);
		frame.getContentPane().add(txtSupportPlayer);
		txtSupportPlayer.setColumns(10);

		JButton btnNewButton_2 = new JButton("Check Player");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = supporterInput();
				if ((sport_select == 3 && strategy_select == 4) || (sport_select == 3 && strategy_select == 5)) {
					for (Sporter spt : now_sporters) {
						PlayersTeam playersTeam = (PlayersTeam) spt;
						for (Sporter sporter : playersTeam.getPlayers()) {
							if (id == sporter.getId() && check == true) {
								supporter_one = new Supporter(1, tournament.getResult());
								supporter_one.setSporter(sporter);
								txtSupportPlayer.setText("ID: " + String.valueOf(id));
							}
						}
					}
				} else {
					for (Sporter sporter : now_sporters) {
						if (id == sporter.getId() && check == true) {
							supporter_one = new Supporter(0, tournament.getResult());
							supporter_one.setSporter(sporter);
							txtSupportPlayer.setText("ID: " + String.valueOf(id));
						}
					}
				}
			}
		});
		btnNewButton_2.setBounds(633, 36, 149, 29);
		frame.getContentPane().add(btnNewButton_2);

		txtSupportId = new JTextField();
		txtSupportId.setHorizontalAlignment(SwingConstants.CENTER);
		txtSupportId.setColumns(10);
		txtSupportId.setBounds(788, 36, 93, 26);
		frame.getContentPane().add(txtSupportId);

		JButton btnCheckPlayer = new JButton("Check Player");
		btnCheckPlayer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int id = supInput();
				id = supInput();
				if ((sport_select == 3 && strategy_select == 4) || (sport_select == 3 && strategy_select == 5)) {
					for (Sporter spt : now_sporters) {
						PlayersTeam playersTeam = (PlayersTeam) spt;
						for (Sporter sporter : playersTeam.getPlayers()) {
							if (id == sporter.getId() && check == true) {
								supporter_two = new Supporter(1, tournament.getResult());
								supporter_two.setSporter(sporter);
								txtSupportId.setText("ID: " + String.valueOf(id));
							}
						}
					}
				} else {
					for (Sporter sporter : now_sporters) {
						if (id == sporter.getId() && check == true) {
							supporter_two = new Supporter(1, tournament.getResult());
							supporter_two.setSporter(sporter);
							txtSupportId.setText("ID: " + String.valueOf(id));
						}
					}
				}

			}
		});
		btnCheckPlayer.setBounds(876, 36, 149, 29);
		frame.getContentPane().add(btnCheckPlayer);

		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBackground(Color.DARK_GRAY);
		textArea_5.setBounds(781, 36, 1, 120);
		frame.getContentPane().add(textArea_5);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setEnabled(false);
		scrollPane_6.setBounds(547, 62, 230, 85);
		frame.getContentPane().add(scrollPane_6);

		final JTextArea txtrPlayerResult = new JTextArea();
		txtrPlayerResult.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtrPlayerResult.setEditable(false);
		txtrPlayerResult.setEnabled(false);
		txtrPlayerResult.setText("Player's Result");
		scrollPane_6.setViewportView(txtrPlayerResult);

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setEnabled(false);
		scrollPane_7.setBounds(788, 62, 230, 85);
		frame.getContentPane().add(scrollPane_7);

		final JTextArea txtrPlayersResult = new JTextArea();
		txtrPlayersResult.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtrPlayersResult.setEditable(false);
		txtrPlayersResult.setEnabled(false);
		txtrPlayersResult.setText("Player's Result");
		scrollPane_7.setViewportView(txtrPlayersResult);

		btnStart.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (check == true) {
					tournament.Start();
					txtrAllscore.setText(tournament.getStrategy().getScores().toString());
					String rank = "";
					if (sport_select == 3 && (strategy_select == 4 || strategy_select == 5)) {
						for (Sporter spt : now_sporters) {
							String ply = "";
							for (Sporter sporter : ((PlayersTeam) spt).getPlayers()) {
								ply = ply + sporter.toResString();
							}
							rank = rank + spt.toResString() + " ---Member---[" + ply + "]";
						}
					} else {
						for (Sporter spt : now_sporters) {
							rank = rank + spt.toResString();
						}
					}
					txtrAllRank.setText(rank);
					tournament.getResult().setMeasurements(tournament.getStrategy().getScores());

					if (supporter_one != null) {
						txtrPlayerResult.setText(supporter_one.showResult());
					}
					if (supporter_two != null) {
						txtrPlayersResult.setText(supporter_two.showResult());
					}

					now_sporters.clear();
					strategy = null;
					sport = null;
					check = false;
				} else {
					txtrAllscore.setText("Please Finish Step A. B. C.");
					txtrAllRank.setText("Please Finish Step A. B. C.");
					txtrPlayerResult.setText("Players' Result");
					txtrPlayersResult.setText("Players' Result");
					txtrNowPlayer.setText("Please Add Players");
					txtSport_1.setText("Choose Sport");
					txtCheckStrategy.setText("Choose Strategy");

				}
			}
		});

		/******************************************************/

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = txtIntMainInput();
				txtrNowPlayer.setText(now_sporters.toString());
				if (sport_select == 1 || sport_select == 2) {
					for (Sporter spt : team_sporters) {
						if (spt.getId() == id) {
							boolean find = false;
							for (Sporter sptc : now_sporters) {
								if (sptc.getId() == id) {
									find = true;
								}
							}
							if (find == false)
								now_sporters.add(spt);
							txtrNowPlayer.setText(now_sporters.toString());
						}
					}
				} else if (sport_select == 3) {
					for (Sporter spt : team_sporters) {
						if (spt.getId() == id) {
							add_sporter = spt;
						}

					}

					for (Sporter spt : single_sporters) {
						if (spt.getId() == id) {
							add_sporter = spt;
						}
					}
					if (now_sporters.size() == 0) {
						now_sporters.add(add_sporter);
					} else {
						if ((now_sporters.get(0) instanceof Player && add_sporter instanceof Player)

								|| (now_sporters.get(0) instanceof PlayersTeam && add_sporter instanceof PlayersTeam)) {
							boolean find = false;
							for (Sporter sporter : now_sporters) {
								if (sporter.getId() == add_sporter.getId()) {
									find = true;
								}
							}
							if (find == false)
								now_sporters.add(add_sporter);
						}
					}
				}
				add_sporter = null;
				txtMainchoose.setText("");
				txtrNowPlayer.setText(now_sporters.toString());
			}

		});

	}

	protected int supInput() {
		int id;
		try {
			id = Integer.parseInt(txtSupportId.getText());

		} catch (Exception exception) {
			id = 8023;
		}
		return id;
	}

	public int supporterInput() {
		int id;
		try {
			id = Integer.parseInt(txtSupportPlayer.getText());

		} catch (Exception exception) {
			id = 8023;
		}
		return id;
	}

	public int txtIntMainInput() {
		int input;
		try {
			input = Integer.parseInt(txtMainchoose.getText());
		} catch (Exception e) {
			input = 8023;
		}
		return input;
	}
}
