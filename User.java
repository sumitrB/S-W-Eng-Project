public class User
{
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private int phNum;
	private String address;
	public String username;
	private String password;
	 
	public User(int userIdIn, String firstNameIn, String lastNameIn, String emailIn, 
				int phNumIn, String addressIn, String usernameIn, String passwordIn)
	{
		userId = userIdIn;
		firstName = firstNameIn;
		lastName = lastNameIn;
		email = emailIn;
		phNum = phNumIn;
		address = addressIn;
		username = usernameIn;
		password = passwordIn;
	}
	
	
	
	// Accessor methods
	
	public int getUserId()
	{
		return userId;
	}	
	
	public String getFirstName()
	{
		return firstName;
	}	
	
	public String getLastName()
	{
		return lastName;
	}	
	
	public String getEmail()
	{
		return email;
	}
	
	public int getPhNum()
	{
		return phNum;
	}	
	
	public String getAddress()
	{
		return address;
	}	
	
	public String getUsername()
	{
		return username;
	}	
	
	public String getPassword()
	{
		return password;
	}
	
	
	
	//Mutator methods
	
	public void setUserId(int userIdIn)
	{
		userId = userIdIn;
	}	
	
	public void setFirstName(String firstNameIn)
	{
		firstName = firstNameIn;
	}	
	
	public void setLastName(String lastNameIn)
	{
		lastName = lastNameIn;
	}	
	
	public void setEmail(String emailIn)
	{
		email = emailIn;
	}
	
	public void setPhNum(int phNumIn)
	{
		phNum = phNumIn;
	}	
	
	public void setAddress(String addressIn)
	{
		address = addressIn;
	}	
	
	public void setUsername(String usernameIn)
	{
		username = usernameIn;
	}	
	
	public void setPassword(String passwordIn)
	{
		password = passwordIn;
	}
	
	// Other
	
	public String userDetails() 
	{
		String s = "User Details:\n" 
					+ "Name: " + getFirstName() + " " + getLastName() + "\n" 
					+ "Username: " + getUsername() + "\n"
					+ "Email: " + getEmail(); 
					
		return s;
	}
	
	public void addUser(int userIdIn, String firstNameIn, String lastNameIn, String emailIn, 
				int phNumIn, String addressIn, String usernameIn, String passwordIn)
	{
		userId = userIdIn;
		firstName = firstNameIn;
		lastName = lastNameIn;
		email = emailIn;
		phNum = phNumIn;
		address = addressIn;
		username = usernameIn;
		password = passwordIn;
	}
	
	public void deleteUser()
	{
		userId = null;
		firstName = null;
		lastName = null;
		email = null;
		phNum = null;
		address = null;
		username = null;
		password = null;
	}
	
	public void editUser(int userIdIn, String firstNameIn, String lastNameIn, String emailIn, 
				int phNumIn, String addressIn, String usernameIn, String passwordIn)
	{
		userId = userIdIn;
		firstName = firstNameIn;
		lastName = lastNameIn;
		email = emailIn;
		phNum = phNumIn;
		address = addressIn;
		username = usernameIn;
		password = passwordIn;
	}
}