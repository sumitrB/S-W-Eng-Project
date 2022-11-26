public class Room extends RoomType
{
	private int roomNumber;
	private RoomType type;
	private int cost;
	private String roomDescription;
	
	public Room(int roomNumberIn; RoomType typeIn; int costIn; String roomDescriptionIn)
	{
		roomNumber = roomNumberIn;
		type = typeIn;
		cost = costIn;
		roomDescription = roomDescriptionIn;
	}
	
	//Methods
	
	public int getRoomNumber()
	{
		return roomNumber;
	}
	
	public RoomType getType()
	{
		return type;
	}
	
	public int getCost()
	{
		return cost;
	}
	
	public String getRoomDescription()
	{
		return roomDescription;
	}
	
	//Other Methods
	
	public void addRoom(int roomNumberIn; RoomType typeIn; int costIn; String roomDescriptionIn)
	{
		roomNumber = roomNumberIn;
		type = typeIn;
		cost = costIn;
		roomDescription = roomDescriptionIn;
	}
	
	public void editRoom(int roomNumberIn; RoomType typeIn; int costIn; String roomDescriptionIn)
	{
		roomNumber = roomNumberIn;
		type = typeIn;
		cost = costIn;
		roomDescription = roomDescriptionIn;
	}
	
	public void deleteRoom(int roomNumberIn; RoomType typeIn; int costIn; String roomDescriptionIn)
	{
		roomNumber = null;
		type = null;
		cost = null;
		roomDescription = null;
	}
	
	
}