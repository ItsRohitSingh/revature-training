package task2trainstation;

public class TrainSchedule {

	private int sNo ;
	private String stationCode ;
	private String stationName ;
	private String arrivalTime ;
	private String departureTime ;
	
	public TrainSchedule(int sNo, String stationCode, String stationName, String arrivalTime,
			String departureTime) {
		super();
		this.sNo = sNo;
		this.stationCode = stationCode;
		this.stationName = stationName;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	
	public void displayTrainSchedule() {
		System.out.println(sNo + "\t" + stationCode + "\t" + stationName + "\t" + arrivalTime + "\t\t" + departureTime);
	}
	
	public static void main(String[] args) {
		System.out.println("Yasvantpur - Delhi Sarai Rohilla AC Duronto Express (12213)");
		System.out.println("---------------------------------------------------------------");
		System.out.println("#\tCode\tStation\t\t\tArrival\t\tDeparture");
		System.out.println("---------------------------------------------------------------");
		TrainSchedule train = new TrainSchedule(1, "YPR", "Yasvantpur Jn\t", "  -", "23:40");
		train.displayTrainSchedule();
		train = new TrainSchedule(2, "GTL", "Guntakal Jn\t", "03:45", "03:50");
		train.displayTrainSchedule();
		train = new TrainSchedule(3, "SC", "Secundarabad Jn\t", "08:55", "09:10");
		train.displayTrainSchedule();
		train = new TrainSchedule(4, "BPQ", "Balharshah\t", "13:30", "13:35");
		train.displayTrainSchedule();
		train = new TrainSchedule(5, "HBJ", "Habibganj\t", "21:20", "21:25");
		train.displayTrainSchedule();
		train = new TrainSchedule(6, "JHS", "Jhansi Jn\t", "01:15", "01:20");
		train.displayTrainSchedule();
		train = new TrainSchedule(7, "DEE", "Delhi Sarai Rohilla", "07:00", "  -");
		train.displayTrainSchedule();
		System.out.println("---------------------------------------------------------------");
	}
	
	
}
