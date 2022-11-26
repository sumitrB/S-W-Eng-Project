public class Reservation
{
	private int userId;
    private int roomId;
    private int roomNumber;
    private DATE dateIn;
    private DATE dateOut;
    private int invoiceId;
    
    public Reservation(int useridIn, int roomIdIn, int roomNumberIn, DATE dateInIn, DATE dateInIn, int invoiceIdIn)
    {
		userId = useridIn;
        roomId = roomIdIn;
        roomNumber = roomNumberIn;
        dateIn = dateInIn;
        dateOut = dateOutIn;
        invoiceId = invoiceIdIn;
    }
	
	//  Methods
	
	public int getUserId()
	{
		return userId;
	}
	
	public int getRoomId()
	{
		return roomId;
	}
	
	public int getRoomNumber()
	{
		return roomNumber;
	}
	
	public DATE getDateIn()
	{
		return dateIn;
	}
    
	public DATE getDateOut()
	{
		return dateOut;
	}
	
	public int getInvoiceId()
	{
		return invoiceId;
	}
	
	// Other Methods
	
    public void addReservation(int useridIn, int roomIdIn, int roomNumberIn, DATE dateInIn, DATE dateInIn, int invoiceIdIn)
	{
		userId = useridIn;
        roomId = roomIdIn;
        roomNumber = roomNumberIn;
        dateIn = dateInIn;
        dateOut = dateOutIn;
        invoiceId = invoiceIdIn;
	}
	
    public void editReservation(int useridIn, int roomIdIn, int roomNumberIn, DATE dateInIn, DATE dateInIn, int invoiceIdIn)
	{
		userId = useridIn;
        roomId = roomIdIn;
        roomNumber = roomNumberIn;
        dateIn = dateInIn;
        dateOut = dateOutIn;
        invoiceId = invoiceIdIn;
	}
	
	public void deleteReservation(int useridIn, int roomIdIn, int roomNumberIn, DATE dateInIn, DATE dateInIn, int invoiceIdIn)
	{
		userId = null;
        roomId = null;
        roomNumber = null;
        dateIn = null;
        dateOut = null;
        invoiceId = null;
	}

}