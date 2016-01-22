
public class FacadeTest {

	public static void main(String[] args) {
		HomeDvd dvd = new HomeDvd();
		HighLight highLight = new HighLight();
		TV4000K tv4000k = new TV4000K();
		
		HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(dvd, tv4000k, highLight);
		homeTheaterFacade.MovieOn();
		homeTheaterFacade.MovieOff();
	}
}
