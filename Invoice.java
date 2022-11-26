public class Invoice
{
	private int invoiceId;
	private int reservationId;
	private int totalAmount;
	private int uesrId;
	private DATE paymentDate;
	
	public Invoice(int invoiceIdIn, int reservationIdIn, int totalAmountIn, int userIDIn, DATE paymentDateIn)
	{
		invoiceId = invoiceIdIn;
		reservationId = reservationIdIn;
		totalAmount = totalAmountIn;
		uesrId = userIDIn;
		paymentDate = paymentDateIn;
	}
	
	//Methods
	
	public int getInvoiceId()
	{
		return invoiceId;
	}
	
	public int getReservationId()
	{
		return reservationId;
	}
	
	public int getTotalAmount()
	{
		return totalAmount;
	}
	
	public int getUserId()
	{
		return uesrId;
	}
	
	public DATE getPaymentDate()
	{
		return paymentDate;
	}
	
	// Other Methods
	
	public void addInvoice(int invoiceIdIn, int reservationIdIn, int totalAmountIn, int userIDIn, DATE paymentDateIn)
	{
		invoiceId = invoiceIdIn;
		reservationId = reservationIdIn;
		totalAmount = totalAmountIn;
		uesrId = userIDIn;
		paymentDate = paymentDateIn;
	}
	
	public void editInvoice(int invoiceIdIn, int reservationIdIn, int totalAmountIn, int userIDIn, DATE paymentDateIn)
	{
		invoiceId = invoiceIdIn;
		reservationId = reservationIdIn;
		totalAmount = totalAmountIn;
		uesrId = userIDIn;
		paymentDate = paymentDateIn;
	}
	
	public void deleteInvoice(int invoiceIdIn, int reservationIdIn, int totalAmountIn, int userIDIn, DATE paymentDateIn)
	{
		invoiceId = null;
		reservationId = null;
		totalAmount = null;
		uesrId = null;
		paymentDate = null;
	}
}