public class Admin
{
	private int adminId;
	private String firstName;
	private String lastName;
	public String username;
	private String password;
	 
	public Admin(int adminIdIn, String firstNameIn, String lastNameIn, 
				 String usernameIn, String passwordIn)
	{
		adminId = adminIdIn;
		firstName = firstNameIn;
		lastName = lastNameIn;
		username = usernameIn;
		password = passwordIn;
	}
	
	
	
	// Accessor methods
	
	public int getAdminId()
	{
		return adminId;
	}	
	
	public String getFirstName()
	{
		return firstName;
	}	
	
	public String getLastName()
	{
		return lastName;
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
	
	public void setAdminId(int adminIdIn)
	{
		adminId = adminIdIn;
	}	
	
	public void setFirstName(String firstNameIn)
	{
		firstName = firstNameIn;
	}	
	
	public void setLastName(String lastNameIn)
	{
		lastName = lastNameIn;
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
	
	public String adminDetails() 
	{
		String s = "Admin Details:\n" 
					+ "Name: " + getFirstName() + " " + getLastName() + "\n" 
					+ "Username: " + getUsername(); 
					
		return s;
	}
	
	public void addAdmin(int adminIdIn, String firstNameIn, String lastNameIn, 
				 String usernameIn, String passwordIn)
	{
		adminId = adminIdIn;
		firstName = firstNameIn;
		lastName = lastNameIn;
		username = usernameIn;
		password = passwordIn;
	}
	
	public void deleteAdmin()
	{
		adminId = null;
		firstName = null;
		lastName = null;
		username = null;
		password = null;
	}
	
	public void editAdmin(int adminIdIn, String firstNameIn, String lastNameIn, 
				 String usernameIn, String passwordIn)
	{
		adminId = adminIdIn;
		firstName = firstNameIn;
		lastName = lastNameIn;
		username = usernameIn;
		password = passwordIn;
	}
}