package com.app;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.app.dao.TeamDAO;
import com.app.dao.impl.TeamDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Player;
import com.app.model.Team;
import com.app.search.service.PlayerSearchService;
import com.app.search.service.impl.PlayerSearchServiceImpl;

public class Main {

	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		log.info("Welcome to Vinay's Player App V1.0");
		log.info("==========================================");

		int ch = 0;
		do {
			log.info("\nWhat you wish to do today?");
			log.info("1)Create A Player");
			log.info("2)Update A Player");
			log.info("3)Delete A Player");
			log.info("4)List All Players");
			log.info("5)Search Player with various filters");
			log.info("6)EXIT");
			log.info("Please enter your choice(1-6)");

			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
			}

			switch (ch) {
			case 1:
				try {
					log.info("Enter id : ");
					int id = Integer.parseInt(scanner.nextLine());
					log.info("Enter name : ");
					String name = scanner.nextLine();
					log.info("Enter Age : ");
					int age = Integer.parseInt(scanner.nextLine());
					log.info("Enter city : ");
					String city = scanner.nextLine();
					log.info("Enter gender : ");
					String gender = scanner.nextLine();
					log.info("Enter Sports Name : ");
					String sportsName = scanner.nextLine();
					log.info("Enter contact : ");
					long contact = Long.parseLong(scanner.nextLine());
					log.info("Enter team name : ");
					String team = scanner.nextLine();
//					TeamDAO teamDAO = new TeamDAOImpl();
//					int teamId = teamDAO.getTeamByName(team);
//					System.out.println(teamId);
					Team teamobj = new Team(team);
					Player player = new Player(id, name, age, city, gender, sportsName, contact, teamobj);
					PlayerSearchService playerSearchService = new PlayerSearchServiceImpl();

					if (playerSearchService.createPlayer(player) == 1) {
						log.info("Player created with below details successfully");
						log.info(player);
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}

				break;
			case 2:
				log.info("Enter id to update");
				try {
					PlayerSearchService playerSearchService = new PlayerSearchServiceImpl();

					int id = Integer.parseInt(scanner.nextLine());
					log.info("Enter new contact no. : ");
					long contact = Long.parseLong(scanner.nextLine());
					int check = playerSearchService.updatePlayer(id, contact);
					if (check != 0) {
						log.info("Player with id : " + id + " updated successfully.");
					}
				} catch (NumberFormatException e) {
					log.warn("Player Id and Contact No. should be numeric digit only... Try Again");
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}
				break;
			case 3:
				log.info("Enter id to delete");
				try {
					PlayerSearchService playerSearchService = new PlayerSearchServiceImpl();

					int id = Integer.parseInt(scanner.nextLine());
					int check = playerSearchService.deletePlayers(id);
					if (check != 0) {
						log.info("Player with id : " + id + " deleted successfully.");
					}
				} catch (NumberFormatException e) {
					log.warn("Player Id should be numeric digit only... Try Again");
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}
				break;
			case 4:
				try {
					PlayerSearchService playerSearchService = new PlayerSearchServiceImpl();

					List<Player> playerList = playerSearchService.getAllPlayers();
					if (playerList != null && playerList.size() > 0) {
						log.info("Total there are " + playerList.size() + " number of players, printing the players");
						for (Player player : playerList) {
							log.info(player);
						}
					}
				} catch (BusinessException e) {
					log.warn(e.getMessage());
				}

				break;
			case 5:
				int option = 0;

				do {
					log.info(
							"\n\nWelcome to Player Search Menu... Search Your Players By various Filters from below Menu option");
					log.info("1. By Player ID");
					log.info("2. By Player Name");
					log.info("3. By Player Age");
					log.info("4. By Player Gender");
					log.info("5. By Player City");
					log.info("6. By TeamName");
					log.info("7. By SportsName");
					log.info("8. By Player Contact");
					log.info("9. Go back to Main Menu");
					log.info("Please enter your choice(1-9)");

					try {
						option = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
					}
					switch (option) {
					case 1:
						log.info("Enter player id to get player details");
						try {
							int id = Integer.parseInt(scanner.nextLine());
							PlayerSearchService playerSearchService = new PlayerSearchServiceImpl();

							Player player = playerSearchService.getPlayerById(id);
							if (player != null) {
								log.info("Player with id " + id + " found successfully... Below is the details");
								log.info(player);
							}
						} catch (NumberFormatException e) {
							log.warn("Player Id should be digit only... Try Again");
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}
						break;
					case 2:
						log.info("Enter player name to get details");
						String name = scanner.nextLine();
						try {
							PlayerSearchService playerSearchService = new PlayerSearchServiceImpl();

							List<Player> playerList = playerSearchService.getPlayersByName(name);
							if (playerList != null && playerList.size() > 0) {
								log.info("Total there are " + playerList.size()
										+ " number of players playing for the team " + name.toUpperCase()
										+ " printing the players");
								for (Player player : playerList) {
									log.info(player);
								}
							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}
						break;
					case 3:
						log.info("Enter age to get details");
						int age = Integer.parseInt(scanner.nextLine());
						try {
							PlayerSearchService playerSearchService = new PlayerSearchServiceImpl();

							List<Player> playerList = playerSearchService.getPlayersByAge(age);
							if (playerList != null && playerList.size() > 0) {
								log.info("Total there are " + playerList.size()
										+ " number of players, printing the players");
								for (Player player : playerList) {
									log.info(player);
								}
							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}
						break;
					case 4:
						log.info("Enter the gender to get the Players");
						String gender = scanner.nextLine();
						try {
							PlayerSearchService playerSearchService = new PlayerSearchServiceImpl();

							List<Player> playerList = playerSearchService.getPlayersByGender(gender);
							if (playerList != null && playerList.size() > 0) {
								log.info("Total there are " + playerList.size()
										+ " number of players playing with the gender " + gender.toUpperCase()
										+ " printing the players");
								for (Player player : playerList) {
									log.info(player);
								}
							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}

						break;
					case 5:
						log.info("Enter the city name to get the Players");
						String city = scanner.nextLine();
						try {
							PlayerSearchService playerSearchService = new PlayerSearchServiceImpl();

							List<Player> playerList = playerSearchService.getPlayersByCity(city);
							if (playerList != null && playerList.size() > 0) {
								log.info("Total there are " + playerList.size()
										+ " number of players playing from the city " + city.toUpperCase()
										+ " printing the players");
								for (Player player : playerList) {
									log.info(player);
								}
							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}
						break;
					case 6:
						log.info("Enter the TeamName to get the Players for that Team");
						String teamName = scanner.nextLine();
						try {
							PlayerSearchService playerSearchService = new PlayerSearchServiceImpl();

							List<Player> playerList = playerSearchService.getPlayersByTeamName(teamName);
							if (playerList != null && playerList.size() > 0) {
								log.info("Total there are " + playerList.size()
										+ " number of players playing for the team " + teamName.toUpperCase()
										+ " printing the players");
								for (Player player : playerList) {
									log.info(player);
								}
							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}

						break;
					case 7:
						log.info("Enter the sportsName to get the Players");
						String sportsName = scanner.nextLine();
						try {
							PlayerSearchService playerSearchService = new PlayerSearchServiceImpl();

							List<Player> playerList = playerSearchService.getPlayersByTeamName(sportsName);
							if (playerList != null && playerList.size() > 0) {
								log.info("Total there are " + playerList.size()
										+ " number of players playing in the sport " + sportsName.toUpperCase()
										+ ". Printing the players");
								for (Player player : playerList) {
									log.info(player);
								}
							}
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}

						break;
					case 8:
						log.info("Enter player contact to get player details");
						try {
							PlayerSearchService playerSearchService = new PlayerSearchServiceImpl();

							long contact = Long.parseLong(scanner.nextLine());
							Player player = playerSearchService.getPlayerByContact(contact);
							if (player != null) {
								log.info("Player with contact " + contact
										+ " found successfully... Below is the details");
								log.info(player);
							}
						} catch (NumberFormatException e) {
							log.warn("Player Id should be digit only... Try Again");
						} catch (BusinessException e) {
							log.warn(e.getMessage());
						}
						break;
					case 9:
						log.info("\n\nGOING BACK TO MAIN MENU......\n\n");

						break;

					default:
						log.warn(
								"Invalid Search Option... Choice should be only number between 1-9 only. Kindly Retry ");
						break;
					}
				} while (option != 9);

				break;
			case 6:
				log.info("Thanks for using this APP we will see you soon :) ");

				break;

			default:
				log.warn("Invalid choice... Choice should be only number between 1-6 only ");
				break;
			}

		} while (ch != 6);

	}

}
