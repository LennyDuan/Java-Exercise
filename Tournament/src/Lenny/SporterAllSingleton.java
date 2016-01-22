package Lenny;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author Lenny
 *
 *
 *         This is the singleton class for read/load single players and teams
 *         information from xml files. 
 */
public class SporterAllSingleton {

	private volatile static SporterAllSingleton uniqueInstance;

	private ArrayList<Sporter> sporters_single;
	private ArrayList<Sporter> sporters_team;

	public static synchronized SporterAllSingleton AllSporters() {
		if (uniqueInstance == null) {
			synchronized (SporterAllSingleton.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new SporterAllSingleton();
				}

			}
		}
		return uniqueInstance;
	}

	public ArrayList<Sporter> getSporters_team() {
		return this.sporters_team;
	}

	public ArrayList<Sporter> getSporters_single() {
		return this.sporters_single;
	}

	public void add(Sporter sporter) {
		this.sporters_single.add(sporter);
	}

	public void addTeam(Sporter sporter) {
		this.sporters_team.add(sporter);
	}

	/**
	 * Load single players from file
	 */
	public void loadSingles() throws SAXException, FileNotFoundException, IOException {
		File xmlFile = new File("/Users/Lenny/Documents/WorkspaceForEclipse/AssignmentThree/players.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		sporters_single = new ArrayList<>();

		try {
			DocumentBuilder dBuilder = documentBuilderFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("Player");

			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					Player player = new Player(Integer.parseInt(eElement.getAttribute("id")));
					add(player);
				}
			}
		} catch (ParserConfigurationException e) {

		}

	}

	/**
	 * Load team players from file
	 */
	public void loadTeams() throws SAXException, FileNotFoundException, IOException {
		File xmlFile = new File("/Users/Lenny/Documents/WorkspaceForEclipse/AssignmentThree/Teams.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		sporters_team = new ArrayList<>();

		try {
			DocumentBuilder dBuilder = documentBuilderFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("Team");

			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					PlayersTeam playersTeam = new PlayersTeam(Integer.parseInt(eElement.getAttribute("id")));
					playersTeam.addPlayers(new Player(
							Integer.parseInt(eElement.getElementsByTagName("one").item(0).getTextContent())));
					playersTeam.addPlayers(new Player(
							Integer.parseInt(eElement.getElementsByTagName("two").item(0).getTextContent())));
					playersTeam.addPlayers(new Player(
							Integer.parseInt(eElement.getElementsByTagName("three").item(0).getTextContent())));
					playersTeam.addPlayers(new Player(
							Integer.parseInt(eElement.getElementsByTagName("four").item(0).getTextContent())));
					playersTeam.addPlayers(new Player(
							Integer.parseInt(eElement.getElementsByTagName("five").item(0).getTextContent())));
					addTeam(playersTeam);
				}
			}

		} catch (ParserConfigurationException e) {

		}
	}

}
