public class RoomType
{
	private String roomType;
	private int beds;
	
	public RoomType(String roomTypeIn; int bedsIn)
	{
		roomType = roomTypeIn;
		beds = bedsIn;
	}
	
	//Methods
	
	public String getRoomType()
	{
		return roomType;
	}
	
	public int getBeds()
	{
		return beds;
	}
	
	//Other Methods
	
	public void addRoomType(String roomTypeIn; int bedsIn)
	{
		roomType = roomTypeIn;
		beds = bedsIn;
	}
	
	public void editRoomType(String roomTypeIn; int bedsIn)
	{
		roomType = roomTypeIn;
		beds = bedsIn;
	}
	
	public void deleteRoomType(String roomTypeIn; int bedsIn)
	{
		roomTypeIn = null;
		beds = null;
	}
}