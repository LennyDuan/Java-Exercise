
public class HomeTheaterFacade {

	HomeDvd dvd;
	TV4000K tv4000k;
	HighLight highLight;
	
	public HomeTheaterFacade(HomeDvd dvd, TV4000K tv4000k, HighLight highLight) {
		// TODO Auto-generated constructor stub
	
		this.dvd = dvd;
		this.tv4000k = tv4000k;
		this.highLight = highLight;
		
	}
	
	public void MovieOn() {
		System.out.println("Movie starts...........");
		dvd.on();
		highLight.off();
		tv4000k.on();
	}
	
	public void MovieOff() {
		System.out.println("Movie has finished.............");

		dvd.off();
		highLight.on();
		tv4000k.off();
	}
}
